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
---# cmake

- generate a Makefile to make
- cross-plantform!!!

- cmake .(东西太多) mkdir & cd build, then cmake ..

## CMakeLists.txt(学名：组态档)

- write it yourself
- can generate Makefile or projects/workspaces in Windows Visual C++

1. write CmakeLists.txt
2. run: cmake PATH or ccmake PATH to Makefile (PATH is the fold of CMakeLists.txt)
3. make to compile

```cmake
PROJECT(main)
CMAKE_MINIMUM_REQUIRED(VERSION 3.20)
AUX_SOURCE_DIRECTORY(. DIR_SRCS)
ADD_EXECUTABLE(main ${DIR_SRCS})
```

- 不区分大小写，# to comment
- 命令由名称、小括号和参数组成，参数之间使用空格进行间隔
- 第一行是一条命令，名称是 PROJECT，参数是 main，该命令表示项目的名称是 main
- 第二行的命令限定了 CMake 的版本
- 第三行使用命令 `AUX_SOURCE_DIRECTORY` 将当前目录中的源文件名称赋值给变量 `DIR_SRCS`

        aux_source_directory(<dir> <variable>)

- 该命令会把参数 `<dir>` 中所有的源文件名称赋值给参数 `<variable>`
- 第四行使用命令 `ADD_EXECUTABLE` 指示变量 `DIR_SRCS` 中的源文件需要编译成一个名称为 main 的可执行文件

- 完成了文件 CMakeLists.txt 的编写后，使用 cmake 或 ccmake 命令生成 Makefile（ccmake 提供了一个图形化的操作界面）

        cmake [options] <path-to-source>
        ps: cmake .
        get Makefile

## multisoure

- in src to compile a link-library

- in main directory:
  PROJECT(main)
  CMAKE_MINIMUM_REQUIRED(VERSION 3.20)
  ADD_SUBDIRECTORY( src ) # will enter the src to find CMakeLists.txt
  AUX_SOURCE_DIRECTORY(. DIR_SRCS)
  ADD_EXECUTABLE(main ${DIR_SRCS} )
  TARGET_LINK_LIBRARIES( main Test ) # need a Test library for main

  - in src:
    AUX_SOURCE_DIRECTORY(. DIR_TEST1_SRCS)
    ADD_LIBRARY (Test ${DIR_TEST1_SRCS}) # compile src to Test

- cmake .

## find head

- 头文件 `db_cxx.h` 和链接库 `libdb_cxx.so`
- 在项目的根目录中创建目录 cmake/modules/ ，在 cmake/modules/ 下创建文件 `Findlibdb_cxx.cmake` :

        MESSAGE(STATUS "Using bundled Findlibdb.cmake...")
        FIND_PATH(
          LIBDB_CXX_INCLUDE_DIR
          db_cxx.h
          /usr/include/
          /usr/local/include/
          )

        FIND_LIBRARY(
          LIBDB_CXX_LIBRARIES NAMES db_cxx
          PATHS /usr/lib/ /usr/local/lib/
          )

- 文件命名要符合规范: FindlibNAME.cmake，其中 NAME 是函数库的名称。`Findlibdb_cxx.cmake` 的语法与 CMakeLists.txt 相同

- 命令 MESSAGE 会将参数的内容输出到终端。
- `find_path(<VAR> name1 [path1 path2 ...])` 该命令在参数目录中查找文件 name1 并将查找到的路径保存在变量 VAR 中。
- 项目的根目录中的 CmakeList.txt:

        PROJECT(main)
        CMAKE_MINIMUM_REQUIRED(VERSION 2.6)

        SET(CMAKE_SOURCE_DIR .)
        SET(CMAKE_MODULE_PATH ${
           CMAKE_ROOT}/Modules ${
           CMAKE_SOURCE_DIR}/cmake/modules)

        AUX_SOURCE_DIRECTORY(. DIR_SRCS)
        ADD_EXECUTABLE(main ${DIR_SRCS})

        FIND_PACKAGE( libdb_cxx REQUIRED)

        MARK_AS_ADVANCED(
        LIBDB_CXX_INCLUDE_DIR
        LIBDB_CXX_LIBRARIES
        )

        IF (LIBDB_CXX_INCLUDE_DIR AND LIBDB_CXX_LIBRARIES)
        MESSAGE(STATUS "Found libdb libraries")
           INCLUDE_DIRECTORIES(${
           LIBDB_CXX_INCLUDE_DIR})
            MESSAGE( ${
           LIBDB_CXX_LIBRARIES} )
            TARGET_LINK_LIBRARIES(main ${
           LIBDB_CXX_LIBRARIES}18 )
        ENDIF (LIBDB_CXX_INCLUDE_DIR AND LIBDB_CXX_LIBRARIES)

- 在该文件中第 4 行表示到目录 ./cmake/modules 中查找 `Findlibdb_cxx.cmake`
- 查找链接库和头文件的过程。`FIND_PACKAGE` 进行查找,这条命令执行后 CMake 会到变量 `CMAKE_MODULE_PATH` 指示的目录中查找文件 `Findlibdb_cxx.cmake` 并执行。
- 条件判断语句, 如果 `LIBDB_CXX_INCLUDE_DIR` 和 `LIBDB_CXX_LIBRARIES` 都已经被赋值,则设置编译时到 `LIBDB_CXX_INCLUDE_DIR` 寻找头文件并且设置可执行文件 main 需要与链接库 `LIBDB_CXX_LIBRARIES` 进行连接。

- cmake .

# 使用 cmake 生成 debug 版和 release 版的程序

- debug 版的项目生成的可执行文件需要有调试信息并且不需要进行优化,而 release 版的不需要调试信息但需要优化。
- 这些特性在 gcc/g++ 中是通过编译时的参数来决定的,如果将优化程度调到最高需要设置参数-O3,最低是 -O0 即不做优化;
- 添加调试信息的参数是 -g -ggdb ,如果不添加这个参数,调试信息就不会被包含在生成的二进制文件中。

- CMake 中有一个变量 `CMAKE_BUILD_TYPE`, 可以的取值是 Debug Release RelWithDebInfo 和 MinSizeRel。
- 当这个变量值为 Debug 的时候, CMake 会使用变量 `CMAKE_CXX_FLAGS_DEBUG` 和 `CMAKE_C_FLAGS_DEBUG` 中的字符串作为编译选项生成 Makefile
- 当这个变量值为 Release 的时候,工程会使用变量 `CMAKE_CXX_FLAGS_RELEASE` 和 `CMAKE_C_FLAGS_RELEASE` 选项生成 Makefile。

        PROJECT(main)
        CMAKE_MINIMUM_REQUIRED(VERSION 2.6)
        SET(CMAKE_SOURCE_DIR .)
        SET(CMAKE_CXX_FLAGS_DEBUG "$ENV{CXXFLAGS} -O0 -Wall -g -ggdb")
        SET(CMAKE_CXX_FLAGS_RELEASE "$ENV{CXXFLAGS} -O3 -Wall")
        AUX_SOURCE_DIRECTORY(. DIR_SRCS)
        ADD_EXECUTABLE(main ${DIR_SRCS})

- 第 5 和 6 行设置了两个变量 `CMAKE_CXX_FLAGS_DEBUG` 和 `CMAKE_CXX_FLAGS_RELEASE`, 这两个变量是分别用于 debug 和 release 的编译选项。
- 编辑 CMakeList.txt 后需要执行 ccmake 命令生成 Makefile 。在进入项目的根目录,输入 "ccmake ." 进入一个图形化界面

## ccmake 的界面

- 按照界面中的提示进行操作,按 "c" 进行 configure ,这时界面中显示出了配置变量 `CMAKE_BUILD_TYPE` 的条目

- 下面我们首先生成 Debug 版的 Makefile ：将变量 CMAKE_BUILD_TYPE 设置为 Debug ,按 "c" 进行 configure ，按 "g" 生成 Makefile 并退出。这时执行命令 find \* | xargs grep "O0" 后结果如下:

        CMakeFiles/main.dir/flags.make:CXX_FLAGS = -O0 -Wall -g -ggdb
        CMakeFiles/main.dir/link.txt:/usr/bin/c++ -O0 -Wall -g -ggdb
        CMakeFiles/main.dir/main.cpp.o -o main -rdynamic
        CMakeLists.txt:SET(CMAKE_CXX_FLAGS_DEBUG "$ENV{CXXFLAGS} -O0 -Wall -g -ggdb")

- 这个结果说明生成的 Makefile 中使用了变量 CMAKE_CXX_FLAGS_DEBUG 作为编译时的参数。

- 下面我们将生成 Release 版的 Makefile ：再次执行命令 "ccmake ." 将变量 CMAKE_BUILD_TYPE 设置为 Release ,生成 Makefile 并退出。执行命令 find \* | xargs grep "O0" 后结果如下：

        清单 9 find * | xargs grep "O0"的执行结果
        CMakeLists.txt:SET(CMAKE_CXX_FLAGS_DEBUG "$ENV{CXXFLAGS} -O0 -Wall -g -ggdb")

        清单 10. find * | xargs grep "O3"的执行结果
        CMakeCache.txt:CMAKE_CXX_FLAGS_RELEASE:STRING=-O3 -DNDEBUG
        CMakeCache.txt:CMAKE_C_FLAGS_RELEASE:STRING=-O3 -DNDEBUG
        CMakeFiles/main.dir/flags.make:CXX_FLAGS = -O3 -Wall
        CMakeFiles/main.dir/link.txt:/usr/bin/c++ -O3 -Wall
        CMakeFiles/main.dir/main.cpp.o -o main -rdynamic
        CMakeLists.txt:SET(CMAKE_CXX_FLAGS_RELEASE "$ENV{CXXFLAGS} -O3 -Wall")

- 这两个结果说明生成的 Makefile 中使用了变量 CMAKE_CXX_FLAGS_RELEASE 作为编译时的参数

# nmake

- use in Microsoft Visual Studio，need to install VS，just like make in linux.
