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
---# j

## open 函数的 flag 详解 1

3.1.4.1、

## 读写权限：O_RDONLY O_WRONLY O_RDWR

(1)linux 中文件有读写权限，我们在 open 打开文件时也可以附带一定的权限说明（譬如 O_RDONLY 就表示以只读方式打开，O_WRONLY 表示以只写方式打开，O_RDWR 表示以可读可写方式打开）
(2)当我们附带了权限后，打开的文件就只能按照这种权限来操作。

## 打开存在并有内容的文件时：O_APPEND、O_TRUNC

(1)思考一个问题：当我们打开一个已经存在并且内部有内容的文件时会怎么样？
可能结果 1：新内容会替代原来的内容（原来的内容就不见了，丢了）
可能结果 2：新内容添加在前面，原来的内容继续在后面
可能结果 3：新内容附加在后面，原来的内容还在前面
可能结果 4：不读不写的时候，原来的文件中的内容保持不变
(2)O_TRUNC 属性去打开文件时，如果这个文件中本来是有内容的，则原来的内容会被丢弃。这就对应上面的结果 1
(3)O_APPEND 属性去打开文件时，如果这个文件中本来是有内容的，则新写入的内容会接续到原来内容的后面，对应结果 3
(4)默认不使用 O_APPEND 和 O_TRUNC 属性时就是结果 4
(5)如果 O_APPEND 和 O_TRUNC 同时出现会怎么样？

3.1.4.3、exit、\_exit、\_Exit 退出进程
(1)当我们程序在前面步骤操作失败导致后面的操作都没有可能进行下去时，应该在前面的错误监测中结束整个程序，不应该继续让程序运行下去了。
(2)我们如何退出程序？
第一种；在 main 用 return，一般原则是程序正常终止 return 0，如果程序异常终止则 return -1。
第一种：正式终止进程（程序）应该使用 exit 或者\_exit 或者\_Exit 之一。

3.1.5.open 函数的 flag 详解 2
3.1.5.1、打开不存在的文件时：O_CREAT、O_EXCL
(1)思考：当我们去打开一个并不存在的文件时会怎样？当我们 open 打开一个文件时如果这个文件名不存在则会打开文件错误。
(2)vi 或者 windows 下的 notepad++，都可以直接打开一个尚未存在的文件。
(3)open 的 flag O_CREAT 就是为了应对这种打开一个并不存在的文件的。O_CREAT 就表示我们当前打开的文件并不存在，我们是要去创建并且打开它。
(4)思考：当我们 open 使用了 O_CREAT，但是文件已经存在的情况下会怎样？结果是报错吗？
(5)结论：open 中加入 O_CREAT 后，不管原来这个文件存在与否都能打开成功，如果原来这个文件不存在则创建一个空的新文件，如果原来这个文件存在则会重新创建这个文件，原来的内容会被消除掉（有点类似于先删除原来的文件再创建一个新的）
(6)这样可能带来一个问题？我们本来是想去创建一个新文件的，但是把文件名搞错了弄成了一个老文件名，结果老文件就被意外修改了。我们希望的效果是：如果我 CREAT 要创建的是一个已经存在的名字的文件，则给我报错，不要去创建。
(7)这个效果就要靠 O_EXCL 标志和 O_CREAT 标志来结合使用。当这连个标志一起的时候，则没有文件时创建文件，有这个文件时会报错提醒我们。
(8)open 函数在使用 O_CREAT 标志去创建文件时，可以使用第三个参数 mode 来指定要创建的文件的权限。mode 使用 4 个数字来指定权限的，其中后面三个很重要，对应我们要创建的这个文件的权限标志。譬如一般创建一个可读可写不可执行的文件就用 0666

3.1.5.2、O_NONBLOCK
(1)阻塞与非阻塞。如果一个函数是阻塞式的，则我们调用这个函数时当前进程有可能被卡住（阻塞住，实质是这个函数内部要完成的事情条件不具备，当前没法做，要等待条件成熟），函数被阻塞住了就不能立刻返回；如果一个函数是非阻塞式的那么我们调用这个函数后一定会立即返回，但是函数有没有完成任务不一定。
(2)阻塞和非阻塞是两种不同的设计思路，并没有好坏。总的来说，阻塞式的结果有保障但是时间没保障；非阻塞式的时间有保障但是结果没保障。
(3)操作系统提供的 API 和由 API 封装而成的库函数，有很多本身就是被设计为阻塞式或者非阻塞式的，所以我们应用程度调用这些函数的时候心里得非常清楚。
(4)我们打开一个文件默认就是阻塞式的，如果你希望以非阻塞的方式打开文件，则 flag 中要加 O_NONBLOCK 标志。
(2)只用于设备文件，而不用于普通文件。比如说串口、IIC 等都是通过文件来访问的，就存在阻塞式和非阻塞式区别。

## O_SYNC

(1)write 阻塞等待底层完成写入才返回到应用层。
(2)无 O_SYNC 时 write 只是将内容写入底层缓冲区即可返回，然后底层（操作系统中负责实现 open、write 这些操作的那些代码，也包含 OS 中读写硬盘等底层硬件的代码）在合适的时候会将 buf 中的内容一次性的同步到硬盘中。这种设计是为了提升硬件操作的性能和销量，提升硬件寿命；但是有时候我们希望硬件不要等待，直接将我们的内容写入硬盘中，这时候就可以用 O_SYNC 标志。
(2)无 O_SYNC 时 write 只是将内容写入底层缓冲区即可返回，然后底层（操作系统中负责实现 open、write 这些操作的那些代码，也包含 OS 中读写硬盘等底层硬件的代码）在合适的时候会将 buf 中的内容一次性的同步到硬盘中。这种设计是为了提升硬件操作的性能和销量，提升硬件寿命；但是有时候我们希望硬件不要等待，直接将我们的内容写入硬盘中，这时候就可以用 O_SYNC 标志。
