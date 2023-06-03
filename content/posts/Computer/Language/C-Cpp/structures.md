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

1. NULL problem
2. the head(attention: head can't change, because if head changed, then you need define a head again!)


- struct mystruct *ptr = (struct test *)malloc(n*sizeof(struct test));
- struct mystruct **ptr = (struct test *)malloc(n*sizeof(struct test *));
- 第一个分配struct数组，另一个分配struct指针数组。在第一种情况下，可以通过立即分配ptr[0].field1 = value;来写入字段，而在第二种情况下，必须在实际写入之前分配struct本身。
在c中去掉malloc结果的cast是可以的，这样您就可以编写

struct mystruct **ptr = malloc(n*sizeof(struct test *));
for (int i = 0; i != n ; i++) {
    ptr[i] = malloc(sizeof(struct test));
}
ptr[0]->field1 = value;
...
// Do not forget to free the memory when you are done:
for (int i = 0; i != n ; i++) {
    free(ptr[i]);
}
free(ptr);


- node *head; use head->next will wrong!, need malloc!
const struct name *head;-----------------------不会改变。
- 不可重复复，。。 需要研究。。。



> attention: when you use the loop to p = p->next, must judge whethe the p is NULL!!!!!!!!!!!!!!!!!!!

# define a struct:

struct name(name can ommit, if you use it only once)
{
    ....
}time;

typedef struct name NAME;

typedef struct (name)
{
    ...
}NAME;


# call
赋值time={};

time.data=;
*head->data=;
(*head).data
赋初值使若无，则为0
内存对齐-提高内寻址效率 添加补位或前后统一
支持 time1=time2; // be different from array!!!


# 结构体指针

struct name *pt=&time;



# enumeration-枚举

> 有限个int型数据

enum weeks {sun,mon,tue....};  sun=0,mon=1....by default 
若赋值，则后递增1
enum weeks time;

time=sun;  // 赋值！
time1=(enum weeks) (time +1); //为数字需强转

是整型常量，不是字符串


## 作用

增加程序的可读性----定义bool类型，用来定义标志变量

# 共用体
## define
union name
{
    /* data */
};
##
共用同一内存空间，(首地址）只有最后一个起作用。
基本同struct
## 作用
- 节省存储空间
- 构造混合类型


# Linked list:

struct node
{
    int data;
    struct node *next;  // must use struct node * to define, can't use typedef...
};

struct node *head;
struct node *end;
end->next=NULL;


struct node *pt,*prept;    ------pre is the most important.

## 动态内存分配形式

1. 
void *malloc(unsigned int size);
void *calloc(unsigned int num,unsigned size); // 能将初始值为0
(int*)malloc(10*sizeof(int));
void *realloc(void *p,unsigned int size); 
void free(void *p);

返回首地址
