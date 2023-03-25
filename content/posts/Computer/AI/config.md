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
---# install pytorch

- 有两个版本，一个 CPU，一个 cuda

- in ArchLinux: sudo python-pytorch (python-pytorch-cuda) 即可
- 可阅读官方文档：`https://pytorch.org/get-started/locally/`

# gpu + cuda + cudnn

- sudo pacman -S nvidia nvidia-settings opencl-nvidia cuda cudnn
- 可选：cuda-gdb (需要 ncurses5-compat-libs)

- 安装参见：https://wiki.archlinux.org/title/GPGPU#CUDA

- 可以看出 GPU 加速是通过大量线程并行实现的，因此对于不能高度并行化的工作而言，GPU 就没什么效果了。而 CPU 则是串行操作，需要很强的通用性，主要起到统管和分配任务的作用。

- CUDA 的官方文档（参考资料 1）是这么介绍 CUDA 的：a general purpose parallel computing platform and programming model that leverages the parallel compute engine in NVIDIA GPUs to solve many complex computational problems in a more efficient way than on a CPU.

- 换句话说 CUDA 是 NVIDIA 推出的用于自家 GPU 的并行计算框架，也就是说 CUDA 只能在 NVIDIA 的 GPU 上运行，而且只有当要解决的计算问题是可以大量并行计算的时候才能发挥 CUDA 的作用。

- 在 CUDA 的架构下，一个程序分为两个部份：host 端和 device 端。Host 端是指在 CPU 上执行的部份，而 device 端则是在显示芯片上执行的部份。Device 端的程序又称为 “kernel”。通常 host 端程序会将数据准备好后，复制到显卡的内存中，再由显示芯片执行 device 端程序，完成后再由 host 端程序将结果从显卡的内存中取回。

- 在 CUDA 架构下，显示芯片执行时的最小单位是 thread。数个 thread 可以组成一个 block。一个 block 中的 thread 能存取同一块共享的内存，而且可以快速进行同步的动作。每一个 block 所能包含的 thread 数目是有限的。不过，执行相同程序的 block，可以组成 grid。不同 block 中的 thread 无法存取同一个共享的内存，因此无法直接互通或进行同步。因此，不同 block 中的 thread 能合作的程度是比较低的。不过，利用这个模式，可以让程序不用担心显示芯片实际上能同时执行的 thread 数目限制。例如，一个具有很少量执行单元的显示芯片，可能会把各个 block 中的 thread 顺序执行，而非同时执行。不同的 grid 则可以执行不同的程序（即 kernel）。

- cuDNN（CUDA Deep Neural Network library）：是 NVIDIA 打造的针对深度神经网络的加速库，是一个用于深层神经网络的 GPU 加速库。如果你要用 GPU 训练模型，cuDNN 不是必须的，但是一般会采用这个加速库。
- NVIDIA CUDA® 深度神经网络库(cuDNN) 是经 GPU 加速的深度神经网络基元库。 cuDNN 可大幅优化标准例程（例如用于前向传播和反向传播的卷积层、池化层、归一化层和激活层）的实施。 世界各地的深度学习研究人员和框架开发者都依赖 cuDNN 实现高性能 GPU 加速。--https://developer.nvidia.com/zh-cn/cudnn

# matplotlib

- pip install matplotlib

# torchvision

- pip install torchvision
