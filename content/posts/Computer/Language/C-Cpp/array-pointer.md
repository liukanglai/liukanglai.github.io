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

- 二维数组： int (\*a)[4];
- return *(*a+2);
- function(int a[][4]) 4 不能省；

#

    int a[2][2] = {1, 2, 3, 4};
    *(a[0] + 1) vs **(a + 1) (is 2, 3)，类推更高维数组

#

- p1 – p2 = ( 地址 p1 – 地址 p2 ) / sizeof( T)
- 所有指针变量,不论它是什么类型的,其占用的空间都是 4 个字节。

# 初始化

> `https://www.freesion.com/article/37471412731/`

1.  直接赋值

        int[2][3] arr1 = { {5, 2, 4}, {10, 2, 1} };

2.  循环对每个元素赋值

        int[2][3] arr2;
        int i, j;
        for (i = 0; i < 2; i++) {
          for (j = 0; j < 3; j++) {
            arr2[i][j] = 2; /_ 本例为了简单都赋值成相同值 _/
          }
        }

3.  借用 MEMSET/MEMSET_S 初始化为 0 或-1，注意：memset/memset_s 只能将变量初始化为 0 或-1，

        int[10][10] arr3;
        memset(arr3, 0, sizeof(arr3); /_ 正常，arr3 中的每个元素都为 0 _/
        memset(arr3, -1, sizeof(arr3); /_ 正常，arr3 中的每个元素都为-1 _/
        memset(arr3, 2, sizeof(arr3); /_ 异常，arr3 中的每个元素都为异常值 33686018 _/

4、数组所有元素初始化为相同值
只要值为相同的，特别是数组元素比较多的情况，推荐用此方法：
{ [0 … LENA-1][0 … lenb-1] = num };
这种初始化方法比较少见，但特别省事，所以共享给大家。

        #define ARR_LEN 100
        int arr4[ARR_LEN][ARR_LEN] = { [0 ... (ARR_LEN-1)][0 ... (ARR_LEN-1)] = 10 }; /* 100*100个元素都初始化为10 */

# 函数指针

        #include <stdio.h>
        void PrintMin(int a, int b) {
            if( a<b )
                printf("%d", a);
                else
            printf("%d", b);
        }
        int main(){
            void (* pf)(int , int);
            //定义函数指针 pf
            int x = 4, y = 5;
            pf = PrintMin;
            //用 PrintMin 函数对指针 pf 进行赋值
            pf(x, y);
            //调用 pf 指向的函数,即 PrintMin
            return 0;
        }
