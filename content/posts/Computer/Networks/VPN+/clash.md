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

- sudo gunzip \*\*\*.gz
- chmod +x clash\*\*\*
- ./clash -d .

- wget (-P /opt/clash/) -O config.yaml [你的订阅链接]
- config.yaml

# arch

- pacman -S clash / or clash-premium-bin
- run clash
- ~/.config/clash: yaml

- delete: /usr/lib/systemd/system/clash@.service and /usr/lib/systemd/user/clash@.service

# run silently

- nohup clash &

- sudo nano /usr/share/applications/clash.desktop，然后输入以下内容：

```
[Desktop Entry]
Version=0.10.2
Name=Clash
Comment=A rule-based tunnel in Go
Exec=/full/path/to/clash-linux
Icon=/full/path/to/clash-logo.png
Terminal=false
Type=Application
Categories=Network
```

# autostart: https://github.com/Dreamacro/clash/wiki/clash-as-a-daemon

- /etc/systemd/system/clash.service

        [Unit]
        Description=Clash daemon, A rule-based proxy in Go.
        After=network.target

        [Service]
        Type=simple
        Restart=always
        Restart=on-failure
        ExecStart=/usr/local/bin/clash -d /etc/clash // need change

        [Install]
        WantedBy=multi-user.target

- Launch clashd on system startup with:
- systemctl enable clash
- Launch clashd immediately with:
- systemctl start clash
- Check the health and logs of Clash with:
- systemctl status clash
- journalctl -xe

# update subscription

[root@localhost ~]# crontab -e
填入以下内容
29 6 \* \* _ root pgrep clash | xargs kill -s 9
30 6 _ \* _ root mv /opt/clash/config.yaml /opt/clash/configbackup.yaml
31 6 _ \* _ root wget -P /opt/clash/ -O config.yaml [你的订阅链接]
32 6 _ \* \* root nohup /opt/clash/clash -d /opt/clash/
按 Esc 和:wq 保存退出
重启 crontab，使配置生效
[root@localhost ~]# systemctl restart crond.service

# cotroller

- 取消注释 external-controller、external-ui 和 secret，并配置 secret 作为访问 dashboard 的口令。

- 在终端中通过 clash 命令启动 Clash。如果配置了 dashboard，可以在局域网内的其他设备上开启浏览器，访问 http://10.0.1.11:6300/ui/，其中 10.0.1.11 即此前配置的 Pi 的 IP 地址，端口 6300 即 Clash 监听的外部控制器端口。然后输入如下信息：

- Host 为 10.0.1.11，即 Pi 的 IP 地址。
- 端口为 6300，即 external-controller: 0.0.0.0:6300 所配置的端口。
- 密钥即 secret 所配置的口令，上述示例中为 your-secret-passphrase。

        # external-controller 主要是用于 web 端管理页面，必须监听在 0.0.0.0
        external-controller: 0.0.0.0:9090

        # secret 是进入管理面板所需要的密码，可填可不填，建议填上
        secret: "123456"

        # external-ui 表示管理面板的路径，这个路径就是你前面解压缩的dashboard的路径，根据你实际的改
        external-ui: /opt/clash-dashboard-gh-pages(/usr/share/yacd)

# cfw

        mixin: # 注意下面缩进
          dns:
            enable: true
            enhanced-mode: redir-host
            nameserver:
              - 114.114.114.114 # 真实请求DNS，可多设置几个
          tun:
            enable: true
            stack: system # 或 gvisor
            dns-hijack: # DNS劫持设置为系统DNS
              - 1.0.0.1:53 # 请勿更改
