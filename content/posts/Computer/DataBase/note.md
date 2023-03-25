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
---# 1

# 10 data-recovery

> log: 记录 or 数据库

1. 事务故障

- 逆向扫描，全 undo

2. 系统故障（错误写入，未写入）

- 撤销 + 重做

```
1. 正向扫描，建立 Redo，Undo 事务队列，以 commit 为标准
2. 反向扫描，Undo undo
3. 正向扫描，Redo do
```

3. 介质故障

- 先回转储（静态的直接，动态的需加上动态时的 log），再现在的 log 进行 Redo，无 Undo

4. 病毒

#
