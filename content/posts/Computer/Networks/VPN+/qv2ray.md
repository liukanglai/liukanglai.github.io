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

在浏览器中访问 https://github.com/v2ray/v2ray-core/releases 并下载 v2ray-linux-64.zip
解压到 ~/ 下并重命名为 .v2ray

-  配置 Qv2ray
 
打开 Qv2ray 并选择 首选项 找到 内核 并把 核心可执行文件路径 改为 那个文件夹路径/v2ray ，把 V2ray资源目录 改成 那个文件夹路径 （文件夹路径应该是 /home/用户名/.v2ray ）
回到 常规设置 ，把 Qv2ray代理 改成 使用系统代理
退出 首选项，进入 订阅， 添加订阅地址，并点击 更新订阅数据
进入 首选项 ，找到 自动连接分组 选为你的分组，把 配置 选为你想要的线路

        /usr/bin/v2ray
        /usr/share/v2ray
