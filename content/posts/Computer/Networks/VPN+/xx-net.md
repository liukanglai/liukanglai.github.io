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

```
python2-notify  python2-pyopenssl  python-pyopenssl libffi pygtk nss 

- supervisor(no need)
- miredo(ipv6)


```

# sudo ./start

# 127.0.0.1:8085


## gae_proxy

## x-tunnel


# certificates

setting->security,more->manage certificates->authorities->import

- xx-net/data/gae_proxy/CA.crt



# proxy




# xx_net.sh start/stop/restart

开机自启: - sudo vim /etc/rc.local : `sudo  /home/liukanglai/Downloads/XX-Net./xx_net.sh start`

# ipv6

## 代理隧道

- yay -S miredo
- sudo systemctl enable miredo
- sudo systemctl start  miredo 
# sudo systemctl start  miredo.service    //起服务生成虚拟网卡，可能要重启系统
# sudo systemctl enable miredo.service 
# sudo systemctl status miredo.service
- sudo miredo
- ifconfig: 有teredo

- add dns

 vim  /etc/resolv.conf     //添加ip v6 的DNS  
nameserver 202.103.24.68
nameserver 218.104.111.122
nameserver 2001:470:20::2

IPv6 连接测试网站 http://test-ipv6.com/

 
## Teredo

python xx_net/code/default/gae_proxy/local/ipv6_tunnel/pteredor.py(Teredo服务器测试)
code/default/gae_proxy/local/ipv6_tunnel/pteredor.py
打开在61行有 teredo_server_list =[XXXXXXX] 就是服务器选项了

- miredo : /etc/miredo/miredo.conf/ServerAddress



- windows

管理员权限运行cmd

#看当前状态
netsh int teredo show state

#更换teredo服务器
netsh int ipv6 set teredo enterpriseclient [IP]

#刷新dns缓存
ipconfig /flushdns


# more

Teredo 隧道 合格（已连接） (仍然连接不上？等一会儿，或者尝试降低连接缓冲数值)，但是ipv6的状态显示fail

自动调整ip扫描线程数
思路：
在缺乏ip时，开大线程扫描ip数
加快扫描的速度
在有足够好ip之后，降低扫描的线程数，减少资源开销
足够多ip的定义：
对ip的ssl握手时间进行排序，前100个ip的握手耗时作为度量标准
根据经验，200ms是足够好，700ms最差
自动调整的规则：
200ms 停止扫描
300ms 启动10个线程
400ms 启动20个线程
...
700ms 启动50个线程
默认最多50个线程，如果调整这个数字，按比例调整规则。

1、关闭“自动调整扫描线程数”
2、用服务器 IP地址而非用域名
3、提高“最大扫描线程数”


ping www.baidu.com(get ip)

