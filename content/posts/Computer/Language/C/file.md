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

指程序与数据的交互是以流的形式进行的。进行C语言文件的存取时，都会先进行“打开文件”操作，这个操作就是在打开数据流，而“关闭文件”操作就是关闭数据流。

1.2 缓冲区(Buffer)：



1.3 文件类型：

分为文本文件和二进制文件两种。

文本文件是以字符编码的方式进行保存的。二进制文件将内存中数据原封不至文件中，适用于非字符为主的数据。如果以记事本打开，只会看到一堆乱码。

其实，除了文本文件外，所有的数据都可以算是二进制文件。二进制文件的优点在于存取速度快，占用空间小，以及可随机存取数据。


1.4 文件存取方式：

包括顺序存取方式和随机存取方式两种。

顺序读取也就是从上往下，一笔一笔读取文件的内容。保存数据时，将数据附加在文件的末尾。这种存取方式常用于文本文件，而被存取的文件则称为顺序文件。

随机存取方式多半以二进制文件为主。它会以一个完整的单位来进行数据的读取和写入，通常以结构为单位。


# fopen()

- fopen返回一个结构指针地址，否则返回一个NULL。如果没有指定文件路径，则默认为当前工作目录。
- FILE *fp = fopen("c:\\temp\\test.txt", "r") //由于反斜杠\是控制字符，所以必须再加一个反斜杠 ("/home/liukanglai/")

        "r"：只能从文件中读数据，该文件必须先存在，否则打开失败
        "w"：只能向文件写数据，若指定的文件不存在则创建它，如果存在则先删除它再重建一个新文件
        "a"：向文件增加新数据(不删除原有数据)，若文件不存在则打开失败，打开时位置指针移到文件末尾
        "r+"：可读/写数据，该文件必须先存在，否则打开失败
        "w+"：可读/写数据，用该模式打开新建一个文件，先向该文件写数据，然后可读取该文件中的数据
        "a+"：可读/写数据，原来的文件不被删去，位置指针移到文件末尾

打开二进制文件的模式与打开文本文件的含义是一样的，不同的是模式名称里面多一个字母'b’，以表示以二进制形式打开文件。

# fclose()

- fclose(fp)
- 关闭成功返回值0，否则返回非零值。
- 虽然程序在结束前会自动关闭所有的打开文件，但文件打开过多会导致系统运行缓慢，这时就要自行手动关闭不再使用的文件，来提高系统整体的执行效率。

# fgetc() 

- 一次读取一个字符，然后读取光标移动到下一个字符
- 如果字符读取成功，则返回所读取的字符，否则返回EOF(end of file)。EOF是表示数据结尾的常量，真值为-1
- 要判断文件是否读取完毕，可利用feof()进行检查。未完返回0，已完返回非零值。
- fgetc(fp)
- feof(fp)

# fputc() 

-  fputc(ch, fp);

# fgets() 

- fgets函数的作用是从指定文件读入一个字符串，如：fgets(str, n, fp);

- 参数n为要求得到的字符个数，但只从fp指向的文件输入n-1个字符，然后在最后加一个'\0'字符，因此得到的字符串共有n个字符，把它们放在字符数组str中。如果在读完n-1个字符之前遇到换行符或EOF，读入结束。

# fputs()

- fputs函数的作用是向指定文件输出一个字符串，如：fputs("Hey", fp);

- 把字符串"Hey"输出到fp指向的文件。fputs函数的第一个参数可以是字符串常量、字符数组名或字符型指针。若输出成功，则返回0，否则返回EOF。

# fprintf()  // same as the printf

- fprintf(FILE *, const char *, ...);

# fscanf()

_- fscanf(FILE *, const char *, ...);


# 

- rewind(FILE *);

rewind函数的作用是使位置指针重返回文件的开头，属于文件的定位。


# 

- 当要求一次存取一组数据（如，一个数组、一个结构体变量的值），fread和fwrite函数可以解决该类问题。它们的调用形式一般为：
 
- fread(buffer, size, count, fp);
- fwrite(buffer, size, count, fp);
- buffer：对于fread来说，指的是读入数据的存放地址；对于fwrite来说，是要输出数据的地址。
- size：读写数据时，每笔数据的大小
- count：读写数据的笔数
- fp：文件指针

# 

- 对流式文件可以进行顺序读写，也可以进行随机读写。关键在于控制文件的位置指针，如果位置指针是按字节位置顺序移动的，就是顺序读写。如果能将位置指针按需要移动到任意位置，就可以实现随机读写。所谓随机读写，是指读完上一个字符(字节)后，并不一定要读写其后续的字符(字节)，而可以读写文件中任意位置上所需要的字符(字节)
- 
- fseek(fp, offset, start);
- start：起始点。用0、1、2代替。0代表文件开始，名字为SEEK_SET，1代表当前位置，名字为SEEK_CUR，2代表文件末尾，名字为SEEK_END。
- fseek()函数一般用于二进制文件，因为文本文件要发生字符转换，计算位置时往往会发生混乱。
- 调用实例如：
- fseek(fp, i*sizeof(Person), 0);
