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
---# introduction

- 内linux系统

> Openwrt 官网 https://openwrt.org/
> 恩山 http://www.right.com.cn/forum/forum.php


# install

## breed

- windows 开启Telent，tftp。
- ssh登录。

    > linux: ssh -l root 192.168.1.1
    >
    > win: xshell

- transport files(.bin)  to/tmp

    > linux: scp 
    >> upload: scp /home/liukanglai/Downloads/luci-app-ssr-plus_178-1_all.ipk root@192.168.1.1:/tmp
    >>
    >> download: scp root@192.168.1.1:/tmp/file.tar.gz  /home/liukanglai/
    > 
    > win: winscp
 
- mtd -r(reboot after) write /tmp/... 

## enter breed

- 拔除电源，按住restart，开机，十秒后松开

## 刷入

1. 固件
2. ssh登录
    
    - ssh root@192.168.1.1

3. 刷入

# fuction

> OPKG 软件包

- VPN
- SSH
- 单线多拨
- 去广告


