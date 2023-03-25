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
---##页边距

将纸张的长度设置为 20cm、宽度设置为 15cm、左边距 1cm、右边距 2cm、上边距 3cm、下边距 4cm，导言区

        \usepackage{geometry}
        \geometry{papersize={20cm,15cm}}
        \geometry{left=1cm,right=2cm,top=3cm,bottom=4cm}

##页眉页脚

在页眉左边写上我的名字，中间写上今天的日期，右边写上我的电话；页脚的正中写上页码；页眉和正文之间有一道宽为 0.4pt 的横线分割，可以在导言区加上如下几行：

        \usepackage{fancyhdr}
        \pagestyle{fancy}
        \lhead{\author}
        \chead{\date}
        \rhead{152xxxxxxxx}
        \lfoot{}
        \cfoot{\thepage}
        \rfoot{}
        \renewcommand{\headrulewidth}{0.4pt}
        \renewcommand{\headwidth}{\textwidth}
        \renewcommand{\footrulewidth}{0pt}


## 行间距

- 我们可以通过 setspace 宏包提供的命令来调整行间距。比如在导言区添加如下内容，可以将行距设置为字号的 1.5 倍：

        \usepackage{setspace}
        \onehalfspacing

## 段间距
我们可以通过修改长度 \parskip 的值来调整段间距。例如在导言区添加以下内容

\addtolength{\parskip}{.4em}
则可以在原有的基础上，增加段间距 0.4em。如果需要减小段间距，只需将该数值改为负值即可。
