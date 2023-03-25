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
---# 段落

* 前或后有空行即不为一段(空格和\t也视为)
* 普通段落不用空格和\t来缩进
- 多个空行只算一行
- 符号所管辖域,可在前加空格,用空行隔开

# 字体

- 用*或_包围变斜,**或__变黑 3加粗斜 两~包为删除线
- 可插文本中,不可有空格

# 标题

* 最高阶标题=（任意数量)      二阶-（同上）符号在字下！（若是---，且前后有空行，为分隔线）
* 行首加#（1-6阶----1-6个）后有无空格并不必要

# 列表:

- 无序：-后加空格或（*，+）
- 有序：数字加英文点+空格(数字具体值不重要,系统自定)
>
- 符号可缩进,最多3空格，无影响 
- 每个符号可有多段,每段第一行必缩对齐,其它随意(即都做为此符号下一段，不同行)

????????????? 符号屏闭           ( 避免行首出现”数+.+ “)
????????????? 定义:一行写定义,下一行:后缩4

- 有序后加无序为有序

# 表格

- 第一行为表头,第二行分隔表头和主体,后为表格行
- 列之间用管道符|隔开,原生方式每一行的两边也要|
- 第二行可为不同列定对齐方向,默认为左对齐,在-右边加上:为右

```
内\|外
-\|-:
1|2
```
# 区块引用:

* 每行（支持每段）前加>+空格
* 能嵌套:加量
* 加其它markdown语法ok

# 代码块

- 接上面再缩4空格(段后空行+缩4，而列表+8),代码至无缩进或文末
- 内容无语法,符号本身
- 标记行内代码\`printf()\`

        如需插入可用多个`包围,在一处时`两边需加空格
        代码区内&和<>等都是本体

# 分隔线

- 一行中用三个以上的*或-或_建立,行内无其它,中可加空格

# 链接

1. 行内式：[]+(http), “title”?????????????
    - 同样主机资源\[About](/about/) 使用相对路径

2. 参考式：[name]+[id],之间可有空格,再在文章任意处写`[id]: http..... "title...."` (“可换成’或（）)
    - 网址也可用<\>,无大小写
    - title可放下一行,也可缩进
    - id可不写,然后定义(任意处)[name]: http

3. 锚点(页内超链接)…用HTML吧

# 图片

- 行内式:\!\[photo](地址)
- 参考式:![][id]

- 加宽高`<img>`

---

# 补充

- 用<\>包围都识别为链接

支持加\\: \ ` * + - _ {} [ ( ! . #

YAMLException: end of the stream or a document separator is expected at line x, column y:
— ===出问题 但哪不明…..不能有`\<img>`

# xie

> jia
>
> jia

- jgla:
    - jgl:
        - jgl:
            > 
