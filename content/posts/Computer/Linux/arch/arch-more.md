---
title: "ArchLinux 软件，问题"
date: 2023-03-27T19:10:34+08:00
draft: false
tags: ["Arch"]
author: "liukanglai"
description: " "
---

- yay -S octopi #包管理器前端界面
- Imagemask

## rime

- ~/.local/share/fcitx5/rime/build/default.yaml: put simple first(in schema_list)
- use new file(no deffect default.yaml), in build fold, create default.custom.yaml:

- yay -S rime-cloverpinyin (schema_list: - schema: clover)

> https://github.com/fkxxyz/rime-cloverpinyin/wiki/linux

- yay -S ttf-apple-emoji

## 软件

- code clion idea qtcreater
- sublime-text-dev 代码编辑器

- ranger
- vnote typora suziwen/markdownxiaoshujiang https://github.com/marktext/marktext
- gimp

- install deepin-wine firstly
- deepin-wine-qq
- deepin-wine-wechat
- deepin-wine-tim

- telegram-desktop 客户端开源的加密聊天工具
- qbittorrent 好用的 BT 下载工具

- google-chrome/chromium (Chromium 的用户资料在~/.config/chromium/Default)

- woeusb
- openssh 远程连接工具
- SimpleScreenRecorder 轻量的录屏软件
- kdenlive shotcut 强大的视频剪辑软件
- redshift 显示屏色温调节工具
- calibre 电子书转换、编辑、阅读工具
- gthumb 图片浏览工具,可简单编辑图片,可清除照片元数据
- peek 录制 GIF 动图
- inkscape 强大的矢量图形编辑软件
- fontforge 字体设计、编辑软件

cool tips:

- neofetch
- sl(steam locomotive)
- cmatrix
- aalib (aafire -driver curses)
- fortune-mod
- yes lufei(c-r)

# 系统时间

1. 24 小时：

   - qt5-base-24h

2. windows 修改 Windows 硬件时钟为 UTC 时间

   - 以管理员身份打开 「PowerShell」，输入以下命令：

   Reg add HKLM\SYSTEM\CurrentControlSet\Control\TimeZoneInformation /v RealTimeIsUniversal /t REG_DWORD /d 1
   或者打开「注册表编辑器」，定位到 计算机\HKEY_LOCAL_MACHINE\SYSTEM\CurrentControlSet\Control\TimeZoneInformation 目录下，新建一个 DWORD 类型，名称为 RealTimeIsUniversal 的键，并修改键值为 1 即可。

- sudo pacman -S ntpdate
- sudo ntpdate time.windows.com
- sudo hwclock --localtime --systohc
- hwclock --show
- hwclock --systohc

# deb 安装

- yay -S debtap
- 也应该安装 bash， binutils ，pkgfile 和 fakeroot 依赖包。
- 创建/更新 pkgfile 和 debtap 数据库。
- sudo debtap -u
- 转换 deb 包 debtap (-q / -Q: no question) \*.deb
- 安装 sudo pacman -U <package-name>

        # /usr/bin/debtap
        替换：http://ftp.debian.org/debian/dists
        为：https://mirrors.ustc.edu.cn/debian/dists

        替换：http://archive.ubuntu.com/ubuntu/dists
        为：https://mirrors.ustc.edu.cn/ubuntu/dists/

# display

- vim /etc/sddm.conf.d/dpi.conf: `[X11] ServerArguments=-dpi 96`

# 录屏

- obs-studio
- nvenc 编码不行就改

> 录制的声音太大/太吵可以调小麦克风音量

- yay -S wemeet-bin(二维码一直弹不出来，开启独显才好。)
- yay -S skypeforlinux-stable-bin

- yay -S deskreen(投屏)

## ulauncher utools stacer

## vmbox

- // sudo pacman -S linux-headers

- virtualbox virtualbox-ext-vnc virtualbox-guest-iso virtualbox-host-modules-arch
- 再去官网下载 Oracle VM VirtualBox Extension Pack ，在设置中导入使用
- sudo restart systemd-modules-load.service

1. share fold

- sudo mount -t vboxsf share /mnt/kylin

2. 全屏

- 选择不同分辨率

## hibernate

- cat /sys/power/image_size: swap size
- sudo filefrag -v /swapfile | sed -n '4p' | awk '{print $4+0}' : get resume_offset
- sudo vim /boot/leader/entries/arch.conf: options root=UUID=SOMEUUID rw resume=/dev/sda1 resume_offset=12345
- sudo vim /etc/mkinitcpio.conf: HOOKS=( base udev **resume** autodetect modconf block filesystems keyboard fsck ) -- add resume
- sudo mkinitcpio -p linux

## space

- mkdir /home/space
- mount /dev/... /home/space
- vim /etc/fstab: `/dev/... /home/space ext4 defaults 1 1`

## Easyconnect

- `https://www.wannaexpresso.com/2020/06/07/easy-connect-manjaro/`

- 错：您的客户端版本与服务器不匹配，请下载更新
- 由于最新版与服务器要求版本不一致，所以需要修改源码包中的 PKGBUILD 文件，然后重新手动 makepkg 生成服务器要求版本然后再安装。

1.  修改 PKGBUILD 文件

        source=("http://download.sangfor.com.cn/download/product/sslvpn/pkg/linux_767/EasyConnect_x64_7_6_7_3.deb"
              "http://ftp.acc.umu.se/pub/GNOME/sources/pango/1.42/pango-1.42.4.tar.xz")
        md5sums=('ac2020ce44583d5ee4552c81563dce9c'
              'deb171a31a3ad76342d5195a1b5bbc7c')

- 修改为

        source=("http://download.sangfor.com.cn/download/product/sslvpn/pkg/linux_01/EasyConnect_x64.deb"
              "http://ftp.acc.umu.se/pub/GNOME/sources/pango/1.42/pango-1.42.4.tar.xz")
        md5sums=('6ed6273f7754454f19835a456ee263e3'
              'deb171a31a3ad76342d5195a1b5bbc7c')

# 打印机

对于日常办公来说，打印机是非常必要的。除此之外，我们建议读者维持一份纸质的密码，包括你可以将你虚拟货币钱包中的私钥打印出来保存，这是非常好的一个方案。对于打印机的品牌，我们建议使用惠普打印机。其对于 Linux 的支持非常到位，可以去其网站查看所支持的设备等详情。在 Arch Linux 上，安装包 hplip 即可。

sudo pacman -S hplip

# worng

一般屏幕会出现形如 A stop job is running for...(1m30s)的信息，这是经常会遇到的关机卡住 1 分 30 秒的问题，一般来说这种情况是出现了某个进程在关机时不愿停止，需要等到超时时间到达强行停止。通用的解决办法是调整缩短这个等待时间，建议从 1 分 30 秒调整至 30 秒，30 秒已经足够几乎所有进程正常结束。

编辑 /etc/systemd/system.conf

sudo vim /etc/systemd/system.conf
找到其中 DefaultTimeoutStopSec 一项，将其前方的井号去掉，并赋值为 30s 即可。最后执行 daemon-reload 使其生效。

sudo systemctl daemon-reload
上述解决方案其实只是将这个等待时间缩小了，并没有解决实际问题。如果你想排查问题真正的原因所在，在关机时如果出现了 A stop job is running for...(1m30s)的信息，耐心等待其结束关机，然后重新启动电脑，执行以下命令：

journalctl -p5
按/(斜杠键)搜索 Killing 关键字，找到你关机的时间附近所在的匹配行，你可以在附近看到到底是哪一个进程导致了 timeout,然后再去排查这个进程有什么问题即可。

升级系统时出现形如 unable to lock database 的错误
可能存在升级系统时异常关机或程序异常退出的情况，或者多个 pacman 的相关程序在同时执行。移除 pacman 的 db 锁即可

sudo rm /var/lib/pacman/db.lck

---
