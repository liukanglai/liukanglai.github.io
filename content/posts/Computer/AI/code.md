---
title: ""
draft: false
tags: ["first"]
author: "liukanglai"
# author: ["Me", "You"] # multiple authors
showToc: true
TocOpen: false
hidemeta: false
comments: false
description: "Desc Text."
canonicalURL: "https://canonical.url/to/page"
disableHLJS: true # to disable highlightjs
disableShare: false
disableHLJS: false
hideSummary: false
searchHidden: true
ShowReadingTime: true
ShowBreadCrumbs: true
ShowPostNavLinks: true
ShowWordCount: true
ShowRssButtonInSectionTermList: true
UseHugoToc: true
cover:
    image: "<image path/url>" # image path/url
    alt: "<alt text>" # alt text
    caption: "<text>" # display caption under cover
    relative: false # when using page bundles set this to true
    hidden: true # only hide on current single page
editPost:
    URL: "https://github.com/<path_to_repo>/content"
    Text: "Suggest Changes" # edit text
    appendFilePath: true # to append file path to Edit link
---#

关于神经网络优化的一些思考
2016-11-25 academic 359 words 1 min read 226 times read
CONTENTS
优化的方法有很多种，在深度学习中，占有绝对主导地位的还是 stochastic gradient optimization (简称 SGD) 以及它的一些变种，如 SGD with momentum，Adam 等。 SGD 是一种基于一阶梯度信息的优化方法，仅从优化的速度上来讲，效率不是最高的，一些利 用二阶信息的优化方法，理论上优化速度更快，但是，SGD 反而是在深度学习的优化中使 用的最多的优化方法，为什么其他类型的优化方法在深度学习中不经常使用呢？它们相比 SGD 有什么缺点？或者说 SGD 有什么优点呢？ 这篇文章试图对这个问题给出自己的思考 与总结。

本文基于大量参考资料，对其中的要点进行提炼，主要介绍三种常见的优化方法：基于启 发式搜索的方法，基于一阶梯度信息的方法以及基于二阶梯度信息的方法。同时对实际使 用中一些论文中常用的术语以及它们的区别进行了说明。由于文章有一部分公式，所以我 采用了 LaTeX 书写本文，生成的 PDF 请点击这里下载。

## 一. 加载数据

- Pytorch 的数据加载一般是用 torch.utils.data.Dataset 与 torch.utils.data.Dataloader 两个类联合进行。我们需要继承 Dataset 来定义自己的数据集类，然后在训练时用 Dataloader 加载自定义的数据集类。

1. 继承 Dataset 类并重写关键方法

- pytorch 的 dataset 类有两种：Map-style datasets 和 Iterable-style datasets。前者是我们常用的结构，而后者是当数据集难以（或不可能）进行随机读取时使用。在这里我们实现 Map-style dataset。

- 继承 torch.utils.data.Dataset 后，需要重写的方法有：**len**与**getitem**方法，其中**len**方法需要返回所有数据的数量，而**getitem**则是要依照给出的数据索引获取对应的 tensor 类型的 Sample，除了这两个方法以外，一般还需要实现**init**方法来初始化一些变量。话不多说，直接上代码。

```
'''
包括了各种数据集的读取处理，以及图像相关处理方法
'''
from torch.utils.data import Dataset
import torch
import os
import cv2
from Config import mycfg
import random
import numpy as np


class ImageClassifyDataset(Dataset):
    def __init__(self, imagedir, labelfile, classify_num, train=True):
    	'''
    	这里进行一些初始化操作。
    	'''
        self.imagedir = imagedir
        self.labelfile = labelfile
        self.classify_num = classify_num
        self.img_list = []
        # 读取标签
        with open(self.labelfile, 'r') as fp:
            lines = fp.readlines()
            for line in lines:
                filepath = os.path.join(self.imagedir, line.split(";")[0].replace('\\', '/'))
                label = line.split(";")[1].strip('\n')
                self.img_list.append((filepath, label))
        if not train:
            self.img_list = random.sample(self.img_list, 50)

    def __len__(self):
        return len(self.img_list)

    def __getitem__(self, item):
	    '''
	    这个函数是关键，通过item(索引)来取数据集中的数据，
	    一般来说在这里才将图像数据加载入内存，之前存的是图像的保存路径
	    '''
        _int_label = int(self.img_list[item][1])	# label直接用0,1,2,3,4...表示不同类别
        label = torch.tensor(_int_label,dtype=torch.long)
        img = self.ProcessImgResize(self.img_list[item][0])
        return img, label

    def ProcessImgResize(self, filename):
    	'''
    	对图像进行一些预处理
    	'''
        _img = cv2.imread(filename)
        _img = cv2.resize(_img, (mycfg.IMG_WIDTH, mycfg.IMG_HEIGHT), interpolation=cv2.INTER_CUBIC)
        _img = _img.transpose((2, 0, 1))
        _img = _img / 255
        _img = torch.from_numpy(_img)
        _img = _img.to(torch.float32)
        return _img
```

- 有一些的数据集类一般还会传入一个 transforms 函数来构造一个图像预处理序列，传入 transforms 函数的一个好处是作为参数传入的话可以对一些非本地数据集中的数据进行操作（比如直接通过 torchvision 获取的一些预存数据集 CIFAR10 等等），除此之外就是 torchvision.transforms 里面有一些预定义的图像操作函数，可以直接像拼积木一样拼成一个图像处理序列，很方便。我这里因为是用我自己下载到本地的数据集，而且比较简单就直接用自己的函数来操作了。

2. 使用 Dataloader 加载数据

- 实例化自定义的数据集类 ImageClassifyDataset 后，将其传给 DataLoader 作为参数，得到一个可遍历的数据加载器。可以通过参数 batch_size 控制批处理大小，shuffle 控制是否乱序读取，num_workers 控制用于读取数据的线程数量。

```
from torch.utils.data import DataLoader
from MyDataset import ImageClassifyDataset

dataset = ImageClassifyDataset(imagedir, labelfile, 10)
dataloader = DataLoader(dataset, batch_size=5, shuffle=True,num_workers=5)
for index, data in enumerate(dataloader):
  print(index)	# batch索引
  print(data)		# 一个batch的{img,label}
```

## 二. 模型设计

- 在这里只讨论深度学习模型的设计，pytorch 中的网络结构是一层一层叠出来的，pytorch 中预定义了许多可以通过参数控制的网络层结构，比如 Linear、CNN、RNN、Transformer 等等具体可以查阅官方文档中的 torch.nn 部分。
  设计自己的模型结构需要继承 torch.nn.Module 这个类，然后实现其中的 forward 方法，一般在**init**中设定好网络模型的一些组件，然后在 forward 方法中依据输入输出顺序拼装组件

```
'''
包括了各种模型、自定义的loss计算方法、optimizer
'''
import torch.nn as nn


class Simple_CNN(nn.Module):
    def __init__(self, class_num):
        super(Simple_CNN, self).__init__()
        self.class_num = class_num
        self.conv1 = nn.Sequential(
            nn.Conv2d(		# input: 3,400,600
                in_channels=3,
                out_channels=8,
                kernel_size=5,
                stride=1,
                padding=2
            ),
            nn.Conv2d(
                in_channels=8,
                out_channels=16,
                kernel_size=5,
                stride=1,
                padding=2
            ),
            nn.AvgPool2d(2),  # 16,400,600 --> 16,200,300
            nn.BatchNorm2d(16),
            nn.LeakyReLU(),
            nn.Conv2d(
                in_channels=16,
                out_channels=16,
                kernel_size=5,
                stride=1,
                padding=2
            ),
            nn.Conv2d(
                in_channels=16,
                out_channels=8,
                kernel_size=5,
                stride=1,
                padding=2
            ),
            nn.AvgPool2d(2),  # 8,200,300 --> 8,100,150
            nn.BatchNorm2d(8),
            nn.LeakyReLU(),
            nn.Conv2d(
                in_channels=8,
                out_channels=8,
                kernel_size=3,
                stride=1,
                padding=1
            ),
            nn.Conv2d(
                in_channels=8,
                out_channels=1,
                kernel_size=3,
                stride=1,
                padding=1
            ),
            nn.AvgPool2d(2),  # 1,100,150 --> 1,50,75
            nn.BatchNorm2d(1),
            nn.LeakyReLU()
        )
        self.line = nn.Sequential(
            nn.Linear(
                in_features=50 * 75,
                out_features=self.class_num
            ),
            nn.Softmax()
        )

    def forward(self, x):
        x = self.conv1(x)
        x = x.view(-1, 50 * 75)
        y = self.line(x)
        return y
```

- 上面我定义的模型中包括卷积组件 conv1 和全连接组件 line，卷积组件中包括了一些卷积层，一般是按照{卷积层、池化层、激活函数}的顺序拼接，其中我还在激活函数之前添加了一个 BatchNorm2d 层对上层的输出进行正则化以免传入激活函数的值过小（梯度消失）或过大（梯度爆炸）。
- 在拼接组件时，由于我全连接层的输入是一个一维向量，所以需要将卷积组件中最后的 50 × 75 50\times 7550×75 大小的矩阵展平成一维的再传入全连接层(x.view(-1,50\*75))

## 三. 训练(在验证集上)

- 实例化模型后，网络模型的训练需要定义损失函数与优化器，损失函数定义了网络输出与标签的差距，依据不同的任务需要定义不同的合适的损失函数，而优化器则定义了神经网络中的参数如何基于损失来更新，目前神经网络最常用的优化器就是 SGD（随机梯度下降算法） 及其变种。

- 在我这个简单的分类器模型中，直接用的多分类任务最常用的损失函数 CrossEntropyLoss()以及优化器 SGD。

```
self.cnnmodel = Simple_CNN(mycfg.CLASS_NUM)
self.criterion = nn.CrossEntropyLoss()	# 交叉熵，标签应该是0,1,2,3...的形式而不是独热的
self.optimizer = optim.SGD(self.cnnmodel.parameters(), lr=mycfg.LEARNING_RATE, momentum=0.9)
```

- 训练过程其实很简单，使用 dataloader 依照 batch 读出数据后，将 input 放入网络模型中计算得到网络的输出，然后基于标签通过损失函数计算 Loss，并将 Loss 反向传播回神经网络（在此之前需要清理上一次循环时的梯度），最后通过优化器更新权重。训练部分代码如下：

```
for each_epoch in range(mycfg.MAX_EPOCH):
            running_loss = 0.0
            self.cnnmodel.train()
            for index, data in enumerate(self.dataloader):
                inputs, labels = data
                outputs = self.cnnmodel(inputs)
                loss = self.criterion(outputs, labels)

                self.optimizer.zero_grad()	# 清理上一次循环的梯度
                loss.backward()	# 反向传播
                self.optimizer.step()	# 更新参数
                running_loss += loss.item()
                if index % 200 == 199:
                    print("[{}] loss: {:.4f}".format(each_epoch, running_loss/200))
                    running_loss = 0.0
            # 保存每一轮的模型
            model_name = 'classify-{}-{}.pth'.format(each_epoch,round(all_loss/all_index,3))
            torch.save(self.cnnmodel,model_name)	# 保存全部模型
```

## 四. 测试

- 测试和训练的步骤差不多，也就是读取模型后通过 dataloader 获取数据然后将其输入网络获得输出，但是不需要进行反向传播的等操作了。比较值得注意的可能就是准确率计算方面有一些小技巧。

```
acc = 0.0
count = 0
self.cnnmodel = torch.load('mymodel.pth')
self.cnnmodel.eval()
for index, data in enumerate(dataloader_eval):
	inputs, labels = data   # 5,3,400,600  5,10
	count += len(labels)
	outputs = cnnmodel(inputs)
	_,predict = torch.max(outputs, 1)
	acc += (labels == predict).sum().item()
print("[{}] accurancy: {:.4f}".format(each_epoch, acc / count))
```

- 我这里采用的是保存全部模型并加载全部模型的方法，这种方法的好处是在使用模型时可以完全将其看作一个黑盒，但是在模型比较大时这种方法会很费事。此时可以采用只保存参数不保存网络结构的方法，在每一次使用模型时需要读取参数赋值给已经实例化的模型：

```
torch.save(cnnmodel.state_dict(), "my_resnet.pth")
cnnmodel = Simple_CNN()
cnnmodel.load_state_dict(torch.load("my_resnet.pth"))
```
