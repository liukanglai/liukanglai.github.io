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
---# CRC

- 模 2 除法 (异或)
- G 首必一(n + 1 bit) （生成 G 的方法）
- R 前补 0(n bit) (CRC)

# when bits wrongs.

- G = 1001(能检测出奇数比特差错?)

- D = A + B
- if(D mod G) == if(A mod G + B mod G)

- 1 bit: 加减 2^i -> 1 个 1
- 2 bits: 加减 2^i and 2^j (i != j) 2 个 1
- ...

- 1,2,4,8... 对 9 mod

- is XOR, not mod !!!

- so ??? ???
