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
---# gcc 相关

- use: gcc \*.c or g++ \*.cpp, then create a \*.out, ./\*.out will execute it.
- multifiles: gcc 1.c 2.c 3.c ... -o main or: (-o: rename a.out)
- gcc -c 1.c, gcc -c 2.c ... then: gcc \*.o -o main

> .c+.h(预编译'#'内容)->.i (汇编)->.s (二进制)->.obj(win)/.o(linux)+printf.o(链接)->.exe/.out

- gcc -o filename file.c -lm(libm.a/.so 库) or -L /usr/lib/..

## 预编译

1. #include copy paste
2. #define 字符串替换

loop up:

> gcc -E 1.c

- no create file

## 汇编

> gcc -S 1.c

- create XXX.s

## 编译

> gcc -c XXX.s also: gcc -c 1.c

- create XXX.o

## 链接(无编译器的事)

> gcc XXX.o XXX.o

## j

- do gcc 1.c, file(.s, .o) is in: ls /tmp/cc\* 2>/dev/null
- but you can't see it, too fast!
- use bash:

        #!/bin/bash
        g++ main.cpp &
        sleep 0.05
        ls --color=auto /tmp/cc*

## 优化编译加速

1. use pipe ( | )
   - 将临时文件直接在内存中传输，而不是磁盘！

> gcc -pipe 1.c

1. -O
   - gcc 每次调用一个函数之后,先压栈,然后又转到寄存器中
   - use gcc -O 1.c: 移除栈操作
   - -O 选项还可以加数字,表示优化的级别。 没有数字默认是 1,最大可以加到 3，
   - 不加-O，级别是 0。 优化级别越高,产生的代码的执行效率就越高。 g++ -O2 -s main.cpp -o main.O2.s
   - 原因是,优化的级别越高, 虽然最后生成的代码的执行效率就会越高, 但是编译的过程花费的时间 会越长。 在执行效率和编译时间之间, 需要做出一个权衡

## 输出 wrong

gcc -Wreturn-type 1.c return-type 只是检查返回值类型。
gcc -Wuninitialized 1.c
gcc -Wall 1.c
gcc 有个选项,叫-Werror。 它会把所有的警告当成错误进行处理

## -I

- 这个-I 是 gcc 的一个选项, 它的作用是把一个路径加入到系统路径, 这样当使用 include 指令时, 就可以用尖括号来指定文件
- 可以用绝对路径、相对路径。 甚至可以把当前路径加入到系统路径中, 这样就可以用尖括号来指定当 目录下的一个文件了
- ps: -I/usr/include/qt4/QtCore

## -D

一般我们在开发项目时,都会做两个版本,一个 debug 版,一个 release 版。
通常我们在 debug 版本中会加入调试输出,方便查找 BUG。
而在 release 版本中,删除这些输出,以提高执行速度并减少可执行文件的大小。
实现的方式是通过宏。

- 我们用 g++ main.cpp -D**DEBUG**编译出来的就是 debug 版本,用 g++ main.cpp 编译出来的 是 release 版本。

## the version problem

- error: argument list for class template "std::pair" is missing
- error: template parameter "\_t1" may not be redeclared in this scope
- /usr/include/c++/11.1.0/bits/stl_pair.h(460): error: expected a ")"
