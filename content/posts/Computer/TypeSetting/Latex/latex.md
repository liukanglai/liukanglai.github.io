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
---- xelatex compiler it, The recommended approach is to use the XƎLATEX or LuaLATEX compilers, as they support UTF-8 directly 

> 大小写敏感

# Package

- \usepackage

# escape

- \j

# Multilingual usage

- \usepackage[T5]{fontenc}
- \usepackage[utf8]{inputenc}

## Chinese

1. ctex

- \documentclass[UTF8]{ctexart(ctexrep, ctexbook and ctexbeamer.)}
- \usepackage[UTF8]{ctex}
- 使用 ctexart documentclass 时候，最好加上 \usepackage[T1]{fontenc}，否则某些符号显示不正确。

2. CJK

- 可以使用两个宏包：CJK 或 CJKutf8

        usepackage{CJKutf8}  
        \begin{CJK}{UTF8}{gbsn( gbsn（宋体）和 gkai（楷体）)}
        \documentclass{article}
        CJK是处理中文最为无奈的选择。此法现在已经过时，不提倡大家使用。
        \end{CJK}

3. XeCJK(XELaTex)

        \documentclass{article}
        \usepackage{xeCJK}
        \begin{document}
        中文 \LaTeX 示例。
        \end{document}

# Fonts

-  For instance, if the BabelStone Han font is already installed on your system, you can use it in your document with

\setCJKmainfont{BabelStone Han}

- fc-list :lang=zh

# comment

1. %
2. iffalse{} ... fi
3. \begin{comment} ... \end{comment}


