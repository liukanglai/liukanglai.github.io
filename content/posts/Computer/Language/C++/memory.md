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


int * pn;
pn = new int; //(1)
* pn = 5;

int * pn;
int i = 5;
pn = new int[i * 20];
pn[0] = 20;

too big:
int * pn = new int[200000];
if( pn == NULL )
printf( “内存分配失败”);
else
printf( “内存分配成功”);

- delete必须是指向动态分配的内存空间的

int * p = new int;
* p = 5;
delete p;
delete p;
 //本句会导致程序异常

 int * p = new int[20];
p[0] = 1;
delete [] p;

