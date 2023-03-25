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
---# memory

    sudo fallocate -l 1G /swapfile
    sudo dd if=/dev/zero of=/swapfile bs=1024 count=1048576
    sudo chmod 600 /swapfile
    sudo mkswap /swapfile
    sudo swapon /swapfile

    sudo dd if=/dev/zero of=/var/swap.img bs=1024k count=100
    sudo mkswap /var/swap.img
    sudo swapon /var/swap.img


- vim /etc/fstab

        /swapfile swap swap defaults 0 0 

- sudo swapon --show / sudo free -h

## swappiness

- 0~100, 越高，交换越频繁
- cat /proc/sys/vm/swappiness
- sudo sysctl vm.swappiness=10
- vim /etc/sysctl.conf: vm.swappiness=10

- sudo swapoff -v /swapfile
- than delete the text in /etc/fstab
- sudo rm /swapfile
