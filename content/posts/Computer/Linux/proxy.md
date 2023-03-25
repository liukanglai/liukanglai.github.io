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
---# proxy 

1. 环境变量

        export http_proxy=http://127.0.0.1:12333
        export https_proxy=http://127.0.0.1:12333

2. bash直接在.bashrc或者.zshrc添加下面内容

        export http_proxy="http://localhost:port"
        export https_proxy="http://localhost:port"
        export http_proxy="socks5://127.0.0.1:1080"
        export https_proxy="socks5://127.0.0.1:1080"

- or:
    
        export ALL_PROXY=socks5://127.0.0.1:1080 (source ~/.bashrc to update file)

- 设置alias简写，要用时输入setproxy，or unsetproxy。

        alias setproxy="export ALL_PROXY=socks5://127.0.0.1:1080" 
        alias unsetproxy="unset ALL_PROXY"

3. 改相应工具的配置，比如apt的配置
- sudo vim /etc/apt/apt.conf, at the end add:
        
        Acquire::http::Proxy "http://proxyAddress:port"

## for ssh

1. ssh -o ProxyCommand="nc -X 5 -x 127.0.0.1:1080 %h %p" root@server

- nc -X 5 -x 127.0.0.1:1080 %h %p, 127.0.0.1:1080代理实际地址和端口, root@server是你需要登录的服务器和用户名
-X是指定代理协议 4是socks4协议 5是socks5协议

2. global

- vim .ssh/config

        Host *
        ProxyCommand nc -X 5 -x 127.0.0.1:1080 %h %p

> no nc, just google it, archlinux install openbsd-netcat for nc

> 以上方法需是sock代理

3. http proxy

- install corkscrew
- vim .ssh/config

        ProxyCommand /usr/local/bin/corkscrew(执行路径) 127.0.0.1 1080 %h %p

## just for git

1. http

        git config --global http.proxy 'socks5://127.0.0.1:1080' 
        git config --global https.proxy 'socks5://127.0.0.1:1080'

> 不起作用，因为很多repo用的是SSL的地址，http和https的proxy。

2. 使用SSL的proxyCommand

- vim .ssh/config

        Host github.com
        Hostname github.com
        User XXXX
        IdentityFile /home/XXXX/.ssh/id_rsa
        ProxyCommand /bin/nc -X5 -x 172.0.0.2:1080 %h %p

最后一行会让 git 使用 172.0.0.2:1080 地址的 socket5 代理。我的 linux 跑在 VM 里，这个地址是我 windows 上的 s-s 的地址。

- 服务器端 supervisord 建立了一个 socat 转发到 github.com 的服务：

        socat tcp-l:61222,fork,reuseaddr tcp:github.com:22

- 客户端 ssh/.config:

        Host my.github.com
        HostName <服务器域名或者 IP>
        Port 61222

- 客户端再克隆的时候，github.com 上面的地址例如： git@github.com:updateing/lede-source.git
- 克隆的时候在 @前面加上 my 就可以从镜像克隆，不加则是官方地址克隆。

