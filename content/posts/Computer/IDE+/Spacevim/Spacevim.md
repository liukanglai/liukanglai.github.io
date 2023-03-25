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
---# install
- curl -sLf https://spacevim.org/cn/install.sh | bash
- curl -sLf https://spacevim.org/cn/install.sh | bash -- -h(u:uninstall)

# .vim/vimrc

# config

- .vim/autoload: spacevim.vim: relativenumber 
SpaceVim 的默认配置文件为 ~/.SpaceVim.d/init.toml。

# 添加自定义插件

[[custom_plugins]]
    repo = "lilydjwg/colorizer"
    merged = false

neocomplete: let g:neocomplete#enable_at_startup = 0(disable)

# use


基本使用
首先，需要了解下 SpaceVim 启动后几个界面元素：顶部标签栏、底部状态栏。 可以看到，顶部标签栏通常只有一个，主要用来列出已经打开的文件或者是标签页，并以序号标记。 可以通过快捷键 Leader + 序号 来跳转到对应的标签页或者是文件。

状态栏则是每一个窗口都会有一个状态栏，在状态栏上通常显示着模式、文件名、文件类型等等信息。

文件及窗口操作
SpaceVim 会在状态栏展示各个窗口的编号，可以使用快捷键 SPC + 数字 快速跳到对应的窗口，在顶部标签栏，会列出当前已经打开的文件或者标签裂变， 可以使用快捷键 Leader + 数字 快速跳到对应的文件。在这里默认的 Leader 是 \ 键。

代码格式化
代码格式化这一功能由 format 模块提供，默认该模块已启用，手动格式化快捷键为 SPC b f。


# c

[[layers]]
  name = "lang#c"
  enable_clang_syntax_highlight = true
   [layer.clang_std]
    cpp = "c11"

  [[layers]]
  name = "format"

- run: spc l r

    [[layers]]
  name = "debug"
need vimproc
Plugin 'Shougo/vimproc.vim'

> 好像不需要装插件， 直接【【layers】】 https://spacevim.org/cn/layers/

