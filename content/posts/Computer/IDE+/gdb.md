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
---# gdb 相关

> 插桩。。。

- file bin 加载名为 bin 的二进制文件
- CTRL-C 中断程序
- run/r 运行
- next/n 执行当前行，停在下一行 （step over）
- step/s 执行当前行，进入下一层函数 （step in）
- finish 执行直至离开当前函数
- continue/c 继续执行
- break/b N 在第 N 行加断点
- break/b f 在函数 f 处加断点
- delete 删除所有断点

- where 显示在哪

## create file

- gcc -g -o hello hello.c

## run

- gdb hello

## cat file

- list
- l

## breakpoints

- info breakpoints
- b line or b test.c line
- b function
- disable
- enable
- auto display: display name

## Start

- b
- run(now you can input)
- n 2(do 2)
- s 2(enter function)
- u 行号

## set args

- 8000 ../HTML

起源
最近在编写代码时遇到一个很诡异的问题，简单的多线程，但是却 core 在了“printf”语句和 atomic 语句，这个明显是不合理的。所以试图用 gdb 进行多线程调试，找出问题所在。

简单介绍
先介绍一下 GDB 多线程调试的基本命令。

info threads 显示当前可调试的所有线程，每个线程会有一个 GDB 为其分配的 ID，后面操作线程的时候会用到这个 ID。 前面有\*的是当前调试的线程。

thread ID 切换当前调试的线程为指定 ID 的线程。
注意：切换到不同的线程 id，使用 bt 可以打印该 id 的堆栈信息。

break thread_test.c:123 thread all 在所有线程中相应的行上设置断点

thread apply ID1 ID2 command 让一个或者多个线程执行 GDB 命令 command。

thread apply all command 让所有被调试线程执行 GDB 命令 command。
如：thread apply all bt 打印所有线程的堆栈信息。

- set scheduler-locking
- off|on|step：估计是实际使用过多线程调试的人都可以发现，在使用 step 或者 continue

-命令调试当前被调试线程的时候，其他线程也是同时执行的，怎么只让被调试程序执行呢？通过这个命令就可以实现这个需求。off

- 不锁定任何线程，也就是所有线程都执行，这是默认值。 on

- 只有当前被调试程序会执行。 step 在单步的时候，除了 next
- 过一个函数的情况(熟悉情况的人可能知道，这其实是一个设置断点然后 continue

- 的行为)以外，只有当前线程会执行。

使用 gdb 运行带参数的二进制：例如一个程序名为 prog 参数为 -l a -C abc，使用 gdb prog 之后，在 gdb 界面输入 set args -l a -C abc，后面就可以 r 了。

查看汇编指令 disassemble，往往需要配合查看寄存器信息 info register 和栈信息 info frame 0

修改输出 core 的位置：
/proc/sys/kernel/core_pattern，可以修改为 echo "/corefile/core-%e-%p-%t" > /proc/sys/kernel/core_pattern
`https://startheap.com/2019/03/02/GDB-debugging-multi-threaded-core-summary/`

- `https://zhuanlan.zhihu.com/p/61352887`

# cat variable

- p name
- examine(简写为 x)可以用来查看内存地址中的值。语法如下：
- auto display: display name

x/[n][f][u] addr
其中：

n 表示要显示的内存单元数，默认值为 1
f 表示要打印的格式，前面已经提到了格式控制字符
u 要打印的单元长度
addr 内存地址
单元类型常见有如下：

b 字节
h 半字，即双字节
w 字，即四字节
g 八字节
