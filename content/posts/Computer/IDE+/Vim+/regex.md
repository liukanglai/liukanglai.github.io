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

> need \ to escape, except . and *
- `\(c\|p\)`arrot match carrot or parrot
- `\warrot\?` match all+arro(t) \w is all, t\? means optional
- `pa.\+ot` .\ means one or more character


# 
> :help ordinary-atom . 任意字符，不包括行尾
    ^ 行首
    $ 行尾
    \_ 任意字符，包含行尾
    \< 单词开始
    \> 单词结尾

    \s 一个空白符（space，tab）S
    \d 一个数字 D（非...）
    \w 一个单词字符（数字，字母，下划线） W
    \l 一个小写字符 L(除小写字母外的所有字符)
    \u 一个大写字符 U
    \a 一个字母字符 A

> :help character-classes

    [A-Z0-9]
    [,4abc] 只匹配, 4 a b c
    [^0-9A-Za-z] 所有非字符数字

    \| 或
    \(...\) grouping

- cat hunting mice to mice hunting cat: s/\(cat\) hunting \(mice\)/\2 hunting \1/

- 字符或字符区间后面接一个量词(quantifier，称为重数(multi)
- 贪婪匹配模式(greedy)：尽可能多地匹配字符
- 非贪婪匹配模式(non-greedy)：尽可能少的
        
        * 0个或多个, 贪婪
        \+ 1个或多个, 贪婪
        \{-} 0或多个，非贪婪
        \? \= 0或1个，贪婪
        \{n,m} n~m个，贪婪
        \{-n,m} n~m个，非贪婪

- \w\+ : 一个或多个字符
- a\{2,4} : 2~4个连续的a
- 对于foo2bar2, 使用\w\+2将匹配foo2bar2，而\w\{-1,}2匹配foo2

> :help multi

# magic

1. magic
- 大部分字符都要转义（. *除外），可\m set, ps: s/\mfoo/bar
2. nomagic (set nomagic, 可能会影响插件)
- 都需要转义, add \M
- /^.\*$查找任意行, nomagic:

        /\^\.\*\$

3. very magic
- 数字，字母，下划线以外都是特殊字符, add \v

# use

1. renanem
- :argdo %s/\<[Ctrl+r,Ctrl+w\>/Pitbull/gec | update
- c-r, c-w: 将光标下的单词插入当前命令中
2. 函数的重排列

        :argdo %s/\v<act>\((\w{-1,}),([^,]{-1,})\)/act(\2,\1)/gec | update

# 宏录制

- q键, 按一个a(随意寄存器), than do operation, 最后按下q键完成
- do again: @a  (n@a)  @@最后的宏
- :set nowrapscan "不回到开头，到达文件末尾即止
- :reg 查看存储的宏(:echo @a) here: ^[ means esc, ^M means enter
- "ap is same as @a, but only print the content(details), than can edit it, copy it to register a:

        _"ay$

- clear: qaq
- recursion: 在a宏录制时使用@a（此时为空, 也可递归调用其他的寄存器），后面使用@a将会不停地递归调用

- multifile: :argdo execute ":normal @a" | update

