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
---

#

## 进制算法

- A 和 B 两人摇骰子，一人摇 5 次。要我找出他们俩谁赢了。获胜规则是这样的：相同数字出现最多的获胜，次数相同则数字大的获胜。例如：A 出了 6 个 1，B 出了 5 个 6 和 1 个 5，则 A 获胜。楼主的思路是先统计每人每个数字出现次数，然后按照出现次数和数字本身降序排列。排序规则是这样的，出现次数多的大，次数相同则比较数字。这样就能比较出胜负了。

> 66654 < 66611, 66643 < 66651

- 没想到的是，面试官突然把题目升级了：假设有 5000 个人，每个骰子有 5000 个面，每个人摇 5000 次，还是一样的规则，让我找出获胜者 😢。原来的算法肯定是不行的，面试官给的提示是如何遍历一遍就给每个人打个分，然后比较分数，我只想到了权重，出现次数越多权重越大。

- 5000 进制...

  665555: 6 出现 2 次，放在第 2 位； 5 出现 4 次，放在第 4 位
  5*4*6^3 + 6*2*6^1

  666555: 6 出现 3 次，放在第 3 位； 5 出现 3 次，放在第 3 位
  (6*3 + 5*3) \* 6^2

  66641: (6+6+6) _ 6^5 + (4+1) _ 6^0
  66632: (6+6+6) _ 6^5 + (3+2) _ 6^0
  这两个相等了，应该是 66641 赢才对
