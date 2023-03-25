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
---# fork


- 1, 2, 4, 8, 16, 32... seems 2^(n-1)?
- n's fork(), n>2, have process: `1+n+(n-1)+2(n-2)+4(n-3)+8(n-4)+...+2^(n-2)`, it equals to 2^(n-1)?
- for 2^(n-1), think: father + (n-1) sons look as (n-1) fork(), and the biggest son will have sons just like (n-1) fork(). So the n fork() equal to 2 * (n-1) fork().

# about the memory

- the sons just copy the values in father.
- I discover the values in different processes have the same address, ?
