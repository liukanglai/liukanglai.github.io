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
---# 错排问题 

- $D_n$=n$D_{n-1}$ + $(-1)^{n}$。

1. 枚举法
    - n从一开始: 0, 1, 2, 9, 44, 265, 1854, 14833, 133496, 1334961, 14684570, 176214841, 2290792932, ...

2. 递推数列法
    - 对于排列数较多的情况，难以采用枚举法。这时可以用递归思想推导错排数的递回关系式。

        显然D1=0，D2=1。当n≥3时，不妨设n排在了第k位，其中k≠n，也就是1≤k≤n-1。那么我们现在考虑k的情况。

        当k排在第n位时，除了n和k以外还有n-2个数，其错排数为Dn-2。

        当k不排在第n位时，那么将第n位重新考虑成一个新的“第k位”，这时的包括k在内的剩下n-1个数的每一种错排，都等价于只有n-1个数时的错排（只是其中的第k位会换成第n位）。其错排数为Dn-1。

        所以当n排在第k位时共有Dn-2+Dn-1种错排方法，又k有从1到n-1共n-1种取法，我们可以得到：

        $D_n$=(n-1)($D_{n-1}$ + $D_{n-2}$)
