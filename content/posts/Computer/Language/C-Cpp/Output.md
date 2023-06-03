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
---# printf
> `https://zhuanlan.zhihu.com/p/78302619`

-return: which is the total number of printed characters

- 按特定精度输出的很多题的要求，主要是在输出的数字前面或者后面加0，实现方法如下：

        double d = 123.45678;
        printf("%*.*f",20,10,d);

        //输出:
              123.4567800000
两个星号分别用来指定宽度和精度，由后面的两个数指定，其中： - 精度指小数点后（不算小数点）部份的长度，不够补零，多余则是四舍五入（好像有的标准不一样^ff，使用时可以具体测试一下） - 宽度指整个数字部份（包括小数点）的长度，如果不够则右对齐，在左侧补空格

如果要在前面补0（只能补零），则使用如下的代码：

double d = 123.45678;
printf("%0*.*f",20,10,d);
//输出:
000000123.456780000

    char *p = "h\n"; 
    printf(p);

# puts

- puts()方法用于输出字符串, 整行
- 格式必须是 char 型指针或数组
- 会自动在行尾添加换行符!

# putchar


# sprintf

- 和sscanf()对应的是sprintf()，将各种变量类型格式化成字符串，
- sprintf() 方法和 printf() 也几乎完全相同，只是在前面加了一个参数用来放置存放输出的字符串变量

        int a,b,d;
        char str[80];
        sprintf(str,"%d+%d=%d",a,b,c);

