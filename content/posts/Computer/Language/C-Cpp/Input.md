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
---# buffer

- 输入分两种，一种为无缓冲输入（或直接输入），即你每输入一个字符，程序就读一个字符，并可立即使用这个字符；
- 另一种为缓冲输入，将你一次性输入的所有字符存到缓冲区（buffer），

- 全缓冲
在这种情况下，填满标准I/O缓存后才进行实际I/O操作。全缓冲的典型代表是: 对磁盘文件的读写

- 行缓冲
- 典型代表是 标准输入(stdin) 和 标准输出(stdout)
- Enter 之后全部给程序，\n 也在其中

## fflush(stdout)

# scanf

- return: assigned number, if is EOF: end
- 只要有一个没有匹配上，scanf停止
- 输入空白符（“ ” “\t”）相当于没有输入
- 在百分号(%)与格式码之间添加一个整数可以限制读入的最大字符数，超出字符串的部份将留在缓冲区等待下次读取

- 空白符:：(" ")、("\t"),("\n"), 输入流中忽略一个或多个空白符, 只要存在一个就可以忽略多个
- 控制串中的空白符使 scanf() 在输入流中读，但不保存结果，直到发现非空白字符为止

- 非空白符：除格式说明符和空白符, 逗号，分号，于空白符相同，scanf()在输入流中读，但不保存结果。

1. %d %c %s

## %\*
        scanf("%*d"); 读入一个字符，但不存储，更好的跳过. (vs getchar)
        fscanf(fd,"%*[^/n]/n"); // %*是虚读，没有存，只是让指针跳过了这个变量！

        scanf("%s",str);  meet " " or other will stop!!!

        scanf("%s %s",stra,strb);
        scanf("%s%s",stra,strb);
        // 两行scanf()方法是等价的, %s 忽略前空白符, 遇到空白符结束, 但空白符仍留在缓冲区
        // 会加一个'\0'


## %n

- %n: 输出有效字符数量，在scanf和printf中都可
- 与%n相对应的形参是一个int类型的指针，%n不影响scanf和printf的返回值

        scanf("%d %d%n", &i, &j, &k);
        输入434 6434，则k等于8，而scanf的返回值仍然为2。又如：

        scanf("%c%n", &ch, &k);
        输入“sbcdefdg”后，k等于1，而不是8，因为%c只取一个字符，%n输出的是有效字符数量。

- %n用在printf函数里，表示输出的字符数量，例如：

        printf("i=%d, j=%d/n%n", i, j, &k);
        在i=343, j=123的情况下，k=12，同时%n不影响printf的返回值，其返回值仍然为12，而不是14。

## %[]

- scanf以空白字符为定界符，但如果输入的字符串是以其它字符为定界符: so []
- 是扫描满足集合条件是所有字符直到碰到第一个不满足的，以字符串形式返回（和%s相同）
- 如果第一个[字符右边没有抑扬符（^），那么处于[]之间的字符就是结果字符集，不在其中的可输入字符都作为定界符；
- 如果左边[符号紧靠一个抑扬符（^），那么意义相反，^和]之间的字符是定界符，其余可输入字符是结果字符集。

- 包含在[和]两个字符之间除紧靠左边[字符的抑扬符之外的字符，例如：

        scanf("%[abcd]", ptr);

        scanf("%[^abcd]", ptr);

        scanf("%10[^abcd]", ptr);
        这样结果字符串最多只能包含10个字符（除'/0'字符外）。

- [ 符号可以作为扫描列表中的一个成员，
- 但 ] 字符除紧贴最左边的 [ 字符或抑扬符两种情况外，其余情况下都不会被看作扫描列表的成员
- 例如 “%[]abcd]” 或者 “%[^]abcd]”，上述两种情况下]字符属于扫描列表的成员
- 但如果是“%[ab]cd]”，中间的]字符不会被看作扫描列表的成员，而且输入输出的结果会是乱七八糟的。

- 对于减号-，只有在紧贴 [ 字符或抑扬字符以及作为最后一个成员时，才会被视为扫描列表的成员。c标准把其余情况规定为编译器相关的。大多数编译器把这种情况的减号定义为连字符

- 扫描字符集合其实有点像简化的正则表达式，实际上是对单个字符的条件界定，比如，匹配全部字母是%[a-zA-Z]，匹配全部数字是%[0-9]，支持取反操作，括号内添加^，如要匹配非数字，为%[^0-9]；
要读取一整行： 

        char k[80]; 
        scanf("%[^\n]",k);

# sscanf
        char str[80];
        gets(str);
        int len = strlen(str);//需要引入cstring库或string.c
        int sum = 0;
        for(int i = 0;i<len/2;i++)
        {
            int num;
            sscanf(str+i*2,"%2d",&num);
            sum += num;
        }

# getchar

# getch

# gets??? getline(c++)

- 读入一整行，%[^\n], stops when either the newline character is read or when the end-of-file is reached
- can't use in c11 由于gets()不检查字符串string的大小，必须遇到换行符或文件结尾才会结束输入，因此容易造成缓存溢出的安全性问题，导致程序崩溃，可以使用fgets()代替。

# fgets

- 对gets()方法的扩展，gets()是从标准输入流中读取，而fgets()是从文件输入流中读取，但是文件输入流并不局限于普通的文件，只要是流都可以用来输入，使用方法：

        char str[80];
        fgets(str,79,stdin);

- 方法与gets()相比，多添加了两个参数，第二个参数限定读取的最大长度，最终读取的长度不超过还未读取的剩余行长度；
- 第三个参数说明从哪个流读取输入，通过定义stdin，我们就可以定义从标准输入中读取。

> 注意： fgets()方法接受到行尾时会接收换行符！，这一点非常特殊，一定要注意。
> fgets() 和 gets 都会接受换行符,
> fgets() 还有一个 EOF !!!





1.scanf
charstr[15];

scanf("%s",str);

abc 123

1)      不读入空格和回车,从空格处结束

2)      输入字符串长度超过字符数组元素个数不报错

3)      当输入项为字符指针时，指针必须已指向确定的有足够空间的连续存储单元

4)      当为数组元素地址时，从此元素地址开始存放

printf("%s",地址值)

输出时遇到第一个'\0'为止

2.gets和puts函数
开头必须stdio.h;

Gets输入时包括空格符，遇到回车结束

Puts遇到第一个‘\0’结束，自动加入换行符

3.fgets
而使用fgets函数时，只要第二个参数正好等于第一个参数传给它的数组的字节个数，那么fgets函数不会写出数组边界。所以，fgets函数是最好的选择。

fgets(...)读入文本行时的两种情况。

1).如果n大于一行的字符串长度，那么当读到字符串末尾的换行符时，fgets(..)会返回。并且在s的最后插入字符串结束标志'\0'。而s缓冲区剩余的位置不会再填充。

          example：

              123abc

              fgets(s,10,fp);

              此时，读入七个字符，123abc\n,实际上还有最后的'\0',所以，strlen(s)=7;如果要去除末尾的\n，s[strlen(s)-1]='\0';便可。

2).    如果n小于等于一行的字符串的长度，那么读入n-1个字符，此时并没有读入\n因为并没有到行尾，同样在最后会插入'\0'.

         example:

           123abc

           char  s[5];

           fgets(s,5,fp);

           这时读入4个字符，123a,并没有换行符，所以strlen(s)=4.

4.cin
使用空白（空格，制表符和换行符）来定字符串的界的

5.getline()
读入整行数据，它使用回车键输入的换行符来确定输入结尾。

调用方法: cin.getline(str, len);

第一个参数str是用来存储输入行的数组名称，第二个参数len是要读取的字符数。

6.get()
调用方法：cin.get(str, len);

getline将丢弃换行符，而get()将换行符保留在输入序列里，但是字符串中并没有换行符。

使用cin.get()输入多行数据时，中间可以使用get()消除换行符。



int main()

{
   char str1[30], str2[30];

   cin.get(str1, 30);

   cin.get();

   cin.get(str2, 30);

   cout << "str1: " << str1 << endl;

   cout << "str2: " << str2 << endl;

   return 0;

}

