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

- PyTorch 生成的运算图是动态的，可以一边生成动态运算图，一边进行运算

## PyTorch 基本数学形式

- 神经网络最核心的部分就是数学运算，在 PyTorch 中最基本的数学形式有三个：

- 向量(Vector): 一列数
- 矩阵(Matrix): “二维向量”
- 张量(Tensor): “三维向量”或者“三维矩阵”

- 神经网络的核心部分是向量、矩阵、张量之间的相乘与相加。

- 在 PyTorch 中生成三种数学形式的代码如下所示：

```
# 导入torch包
import torch

#定义向量
vector = torch.tensor([1,2,3,4])

#定义矩阵
matrix = torch.tensor([[1,2],[3,4]])

#定义张量
tensor = torch.tensor([[[1,2],[3,4]],[[1,2],[3,4]]])
```

## Tensor

- Tensor 是 PyTorch 中重要的数据结构，可认为是一个高维数组。Tensor 和 numpy 的 ndarrays 类似，但是 Tensor 可以使用 GPU 加速。需要注意的是，Tensor 和 numpy 对象共享内存，所以他们之间的转换很快，而且几乎不会消耗资源。这意味着，如果其中一个变了，另外一个也会随之改变。

- 其有很多方法：新建，归并...

## 实现简单的神经网络

1. 神经网络基本介绍

- 神经网络包括输入层(Input)、隐藏层(Hidden)以及输出层(Output)。设计神经网络时，输入和输出的神经元数量是固定的，中间层的层数以及神经元数量可以自由指定。
- 在神经网络中输入层的数据经过每一个神经元的计算后就变成了了输出值。神经网络的中间层(Conv)越多，神经元数量越多，功能越强大，同时所需要的的计算资源越大。比如下图是经典的 AlexNet 模型有 8 个中间层、65 万个神经元、6000 万个参数。

2. Autograd 包

- PyTorch 的核心部分就是 Autograd 的包，它完成了所有的梯度计算与反向传递的过程。在 Autograd 下，反向传递(backprop)代码是自动定义的。有以下几点需要注意：

.requires_grad: 在 Tensor 上设定.requires_grad = true 后，Autograd 会自动追踪与该 tensor 有关的运算。
.backward()：所有运算完成后，执行.backward()，Autograd 会自动计算梯度并执行反向传递。
.grad: 用来访问梯度
.with torch.no_grad(): 自动忽略梯度。

3. 实现神经网络

- 神经网络的训练过程分为以下几个部分：定义神经网络、迭代输入数据、神经网络计算输出、计算损失、反向传递回到网络的参数以及更新网络的权重。
- Autograd 实现了反向传播功能，但是直接用来写深度学习的代码在很多情况下是比较复杂的。torch.nn 是专门为神经网络设计的模块接口。nn 构建于 Autograd 之上，可以用来定义和运行神经网络。nn.Module 是 nn 中最重要的类，可以把它看做一个网络的封装，包含网络各层定义以及 forward 方法，调用 forward 方法，可以返回前向传播的结果。

  3.1 定义神经网络与训练流程

- 定义神经网络和训练流程的代码如下所示：

```
# 导入torch包
import torch
import torch.nn as nn
import torch.nn.functional as F

# 定义神经网络类
class Net(nn.Module):
	#定义神经网络结构, 输入数据 1x32x32
    def __init__(self):
        super(Net, self).__init__()
        # 第一层（卷积层）
        # 输入频道1， 输出频道6， 卷积3x3
        self.conv1 = nn.Conv2d(1,6,3)
        # 第二层（卷积层）
        # 输入频道6， 输出频道16， 卷积3x3
        self.conv2 = nn.Conv2d(6,16,3)
        # 第三层（全连接层）
        # 输入维度16x28x28=12544，输出维度 512
        self.fc1 = nn.Linear(16*28*28, 512)
        # 第四层（全连接层）
        # 输入维度512， 输出维度64
        self.fc2 = nn.Linear(512, 64)
        # 第五层（全连接层）
        # 输入维度64， 输出维度2
        self.fc3 = nn.Linear(64, 2)

    # 定义数据流向
    def forward(self, x):
    	# 数据先经过第一层卷积层
        x = self.conv1(x)
        # 经过激活函数
        x = F.relu(x)

        # 数据经过第二层卷积层
        x = self.conv2(x)
        # 经过激活函数
        x = F.relu(x)

        # 调整数据维度，‘-1’表示自动计算维度
        x = x.view(-1, 16*28*28)
        # 数据经过第三层全连接层
        x = self.fc1(x)
        # 数据经过激活函数
        x = F.relu(x)

         # 数据经过第四层全连接层
        x = self.fc2(x)
        # 数据经过激活函数
        x = F.relu(x)

        # 数据经过第五层全连接层，输出结果
        x = self.fc3(x)

        return x
```

3.2 运行神经网络与计算损失

- 运行神经网络与计算损失的代码为：

```
# 新建新的网络net
net = Net()

#生成随机输入
input_data = torch.randn(1,1,32,32)

# 随机生成真实值(标签)
target = torch.randn(2)
target = target.view(1,-1)

# 运行神经网络，out为输出结果
out = net(input_data)

# 定义损失函数，绝对误差平均值
criterion = nn.L1Loss()
# 计算损失
loss = criterion(out, target)
```

3.3 反向传递与权值更新

```
# 反向传递
net.zero_grad() #清零梯度
loss.backward() #自动计算梯度、反向传递

# 权值优化与更新
import torch.optim as optim

# 优化器为SGD，随机梯度下降，学习率lr=0.01
optimizer = optim.SGD(net.parameters(), lr=0.01)
# 更新权重
optimizer.step()

# 再次运行网络（这次是权重更新之后的网络参数）
out = net(input_data)
```

3.4 神经网络中损失函数的用途
损失函数代表了预测值与真实值的差，最简单的损失函数就是|真实值-预测值|。常用的损失函数为：

mean absolute loss(L1)
mean squared loss(MSE)
cross entropy loss
KL-divergence

损失函数的用途：
用于计算梯度、反向传递、更新网络权重
判断模型是否训练好了
判断过拟合与欠拟合
