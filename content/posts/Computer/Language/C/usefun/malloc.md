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
`https://zhuanlan.zhihu.com/p/111776504`

- malloc 函数的函数原型为：void\* malloc（unsigned int size），它根据参数指定的尺寸来分配内存块，并且返回一个 void 型指针，指向新分配的内存块的初始位置。如果内存分配失败（内存不足），则函数返回 NULL。

- malloc 的返回值为 void\*。我们在使用的时候，习惯对返回值进行强制类型转换：

char _ p = NULL;
p = (char _)malloc(sizeof(char));

> 在 ANSI C 中，malloc 函数的返回值为 void*。void*类型是可以直接赋值给其他任何类型的指针。所以，上面的强制类型转换操作现在已经不需要了。
> 然而在 c++中，任何类型的指针都可以赋给 void*，而 void*却不可以赋给其他类型的指针，所以在 c++中使用 malloc 函数的时候，强制类型转换是必须的。另一方面，在 c++中应该使用 new 来分配内存。

# need

# free

`http://www.4k8k.xyz/article/handsome_926/8233744`

- 结构体中成员变量中存在指针的，其内存释放遵循从里向外的原则，即先释放成员变量的内存，然后在释放结构体指针。


- free()释放的是指针指向的内存！注意！释放的是内存，不是指针！指针并没有被释放，指针仍然指向原来的存储空间。指针是一个变量，只有程序结束时才被销毁。释放了内存空间后，原来指向这块空间的指针还是存在！只不过现在指针指向的内容的垃圾，是未定义的，所以说是垃圾。因此，释放内存后把指针指向NULL，防止指针在后面不小心又被解引用了。
