---
title: "ArchLinux Config"
date: 2023-03-27T19:10:29+08:00
draft: false
tags: ["Arch"]
author: "liukanglai"
description: " "
---

## 用户

- pacman -S sudo
- useradd -m -G wheel -s /bin/bash ... (wheel 附加组可 sudo，以 root 用户执行命令 -m 同时创建用户家目录)
- passwd ..(name)
- 修改 sudo 权限: vim /etc/sudoers

`Uncomment to allow members of group wheel to execute any command 去%wheel前#`

## 源

1. vim /etc/pacman.conf 文末：

- [multilib]去# (32 bits support)

2. archlinuxcn

```
[archlinuxcn]
# The Chinese Arch Linux communities packages.
# SigLevel = Optional TrustAll
#SigLevel = Optional TrustedOnly
Include = /etc/pacman.d/archlinuxcn(need created)

- vim /etc/pacman.d/archlinuxcn:
# 官方源
Server = http://repo.archlinuxcn.org/$arch
# 163 源
Server = http://mirrors.163.com/archlinux-cn/$arch
# 清华大学
Server = https://mirrors.tuna.tsinghua.edu.cn/archlinuxcn/$arch
```

- 安装 archlinuxcn-keyring
- pacman -Syyu

## 桌面

- sudo pacman -S plasma-meta konsole yakuake dolphin
- for wayland: plasma-wayland-session egl-wayland(nvidia)
- 可选：kde-applications

- systemctl enable sddm
- systemctl start sddm

## network

- systemctl disable iwd
- systemctl stop iwd
- sudo systemctl enable --now NetworkManager (确保先启动 NetworkManager，并进行网络连接 若 iwd 已经与 NetworkManager 冲突 则执行完上一步重启一下电脑即可。)

## base software

### yay

1.  compiler

```
git clone https://aur.archlinux.org/yay.git
cd yay
makepkg -si
```

2.  pacman -S yay

- 源：yay --aururl "https://aur.tuna.tsinghua.edu.cn" --save (https://aur.archlinux.org)
- 查看：yay -P -g(位于 ~/.config/yay/config.json)

> yay -Syu

```
yay -S google-chrome
ntfs-3g #识别NTFS格式的硬盘
fzf peazip ark p7zip zip gzip tar unzip unrar unarchiver lzop lrzip #安装ark可选依赖
需要注意的是解压 windows 下的压缩包，可能会乱码，安装 ark 的可选依赖之一 unarchiver，使用 unar 可以避免这个问题
sudo pacman -S unarchiver then: unar xxx.zip
packagekit-qt5 packagekit appstream-qt appstream #确保Discover(软件中心)可用, 需重启
gwenview deepin-screenshot flameshot cheese vlc
tlp okular(/calibre) neofetch Foliate (sudo systemctl start tlp.service)
vim neovim kate bind
git libconfig wget curl npm exfat-utils cmake ctags nodejs
net-tools(ifconfig) kdeconnect
```

## DNS

- vim 编辑/etc/resolv.conf，删除已有条目，并将如下内容加入其中

```
nameserver 8.8.8.8
nameserver 2001:4860:4860::8888
nameserver 8.8.4.4
nameserver 2001:4860:4860::8844
```

- 如果你的路由器可以自动处理 DNS,resolvconf 会在每次网络连接时用路由器的设置覆盖本机/etc/resolv.conf 中的设置，执行如下命令加入不可变标志，使其不能覆盖如上加入的配置

`sudo chattr +i /etc/resolv.conf`

## input

1. fcitx+fcitx-im+fcitx-sunpinyin(fcitx-qt5 fcitx-configtool) kcm-fcitx fcitx-qt4+fcitx-sogoupinyin(yay)

2. fictx5-im (fictx5+fictx5-gtk/qt+fcitx5-configtool)

```
fcitx5-im #基础包组
fcitx5-chinese-addons #官方中文输入引擎
fcitx5-anthy #日文输入引擎
fcitx5-pinyin-moegirl #萌娘百科词库 二刺猿必备(ArchLinuxCn)
fcitx5-pinyin-zhwiki #中文维基百科词库
fcitx5-material-color #主题
fcitx5-nord(Setting -> Location -> input method -> Configure addons -> Classic user interface -> Theme.)
fcitx5-rime
```

> 设置添加输入法，云拼音，颜色

> Edit /etc/environment and add the following lines:

```
GTK_IM_MODULE=fcitx
QT_IM_MODULE=fcitx
XMODIFIERS=@im=fcitx
SDL_IM_MODULE=fcitx
```

- For vim: vim-fcitx (set ttimeoutlen=100)

## terminal

- vim /etc/profile: export EDITOR='vim'

> copy zshrc, tmux.conf, nvim, .tmux(fold)

2. zsh

- yay -S zsh
- sudo chsh -s /bin/zsh username
- yay -S oh-my-zsh-git
- cp /usr/share/oh-my-zsh/zshrc ~/.zshrc
- powerlevel10k
- git clone --depth=1 https://github.com/romkatv/powerlevel10k.git ${ZSH_CUSTOM:-$HOME/.oh-my-zsh/custom}/themes/powerlevel10k
- or: git clone --depth=1 https://gitee.com/romkatv/powerlevel10k.git ${ZSH_CUSTOM:-$HOME/.oh-my-zsh/custom}/themes/powerlevel10k
- yakuake --get theme gruvbox

> look `../zsh.md`

3. translation

   - yay -S node-fanyi or sudo npm install fanyi -g
     > https://github.com/afc163/fanyi

4. tmux

- (https://wiki.archlinux.org/title/Tmux_(%E7%AE%80%E4%BD%93%E4%B8%AD%E6%96%87)#%E7%94%A8systemd%E5%90%8E%E5%8F%B0%E8%87%AA%E5%90%AFtmux)
- start with tmux@username.service

5. truecolor:

- look vim/UI, tmux

> `https://github.com/starship/starship`

## bluetooth

1. b

```
sudo pacman -S bluez bluez-utils
sudo systemctl enable --now bluetooth
```

2. 如果要连接蓝牙音频设备，需要安装 pulseaudio-bluetooth 并重启 pulseaudio。

```
sudo pacman -S pulseaudio-bluetooth
pulseaudio -k
```

## 声卡

- 别动(有问题，可安装：alsa-utils alsa-plugins pulseaudio-alsa pavucontrol-qt)(在 pavucontrol-qt 中调节)

## 显卡

- 查看：lspci | grep VGA
- 英特尔： sudo pacman -S mesa lib32-mesa vulkan-intel lib32-vulkan-intel
- amd: `https://archlinuxstudio.github.io/ArchLinuxTutorial/#/rookie/graphic_driver`
- nvidia: sudo pacman -S nvidia nvidia-settings lib32-nvidia-utils
- for new?: yay -S nvidia-beta nvidia-utils-beta nvidia-dkms
- change: yay -S optimus-manager optimus-manager-qt
- 安装完成后重启即可使用。optimus-manager 安装完成后会默认 enable optimus-manager 的服务，你可在重启前检查其状态，若没有 enable 则手动将其 enable。重启后在菜单栏搜索 optimus-manager 点击即可使用。可在其设置中设置开机自动启动。
- sudo systemctl enable optimus-manager

- 动态切换：
- sudo pacman -S nvidia-prime
- prime-run some_program #使用 prime-run 前缀来用独显运行某些程序

## 美化

1. proxy

- sudo pacman -S proxychains-ng
- sudo vim /etc/proxychains.conf
- 把配置文件中最后一行改为本地代理的 ip 和端口，如 socks5 127.0.0.1 1089
- proxychains systemsettings5 #通过代理打开系统设置

2. 壁纸

- 在桌面右键，选择配置桌面。在新出现的窗口中右下角选择添加图片可以选择你想要的图片。其中位置一项选择'缩放，保持比例'，背景一项选择'模糊'。这样你就可以拥有一个成比例，且边缘带有高斯模糊的漂亮的桌面壁纸。
- 收集的

3. 全局

- `https://github.com/vinceliuice/Tela-icon-theme`
- `https://github.com/vinceliuice/Layan-kde`
- 设置外观 layan
- color: gruvbox
- SDDM
- 欢迎屏幕(splashscreen)

4. widgets

- cpu, memory, network, ip
- yay -S plasma5-applets-netspeed
- sudo pacman -S ksysguard

5. konsole

- gruvbox konsole, yakuake(.config/yakuakerc)
- .locla/share/konsole have profile

6. fonts

- 无衬线：西文 Noto Sans，中文 Noto Sans CJK
- 衬线：西文 Noto Serif，中文 Noto Serif CJK
- 等宽：西文 Iosevka，中文 Noto Sans Mono CJK

- ttf-twemoji
- ttf-nerd-fonts-symbols
- ttf-Iosevka

- than use .config/fontconfig/font.conf yes!

- ttf-ibm-plex + nerd
- ttf-jetbrains-mono + nerd
- ttf-liberation ttf-wps-fonts ?

- `https://wiki.archlinux.org/title/Localization_(%E7%AE%80%E4%BD%93%E4%B8%AD%E6%96%87)/Simplified_Chinese_(%E7%AE%80%E4%BD%93%E4%B8%AD%E6%96%87)#fontconfig_%E8%AE%BE%E7%BD%AE`
- `https://wiki.archlinux.org/title/Font_Configuration_(%E7%AE%80%E4%BD%93%E4%B8%AD%E6%96%87)/Chinese_(%E7%AE%80%E4%BD%93%E4%B8%AD%E6%96%87)`

> ~/.config/fontconfig /etc/fonts/font.conf

no:

- wqy-zenhei #安装几个开源中文字体 一般装上文泉驿就能解决大多 wine 应用中文方块的问题
- adobe-source-han-sans-cn-fonts - 无衬线体(使用) adobe-source-han-sans-tw-fonts - 思源黑体繁体中文部分
- adobe-source-han-serif-cn-fonts - 衬线体(打印) 思源宋体简体中文部分 adobe-source-han-serif-tw-fonts - 思源宋体繁体中文部分

7. lattw-dock

truecolor:

- printf "\x1b[38;2;255;100;0mTRUECOLOR\x1b[0m\n"
- printf "\x1b[${bg};2;${red};${green};${blue}m\n"

# git

- look Git+/git/ssh.md

# professional

- sudo pacman -S libreoffice-still #稳定版
- sudo pacman -S libreoffice-fresh #尝鲜版
- yay -S onlyoffice-bin

- sudo pacman -S wps-office ttf-wps-fonts
- 如果你下载了国际版本缺失中文：
- sudo pacman -S wps-office-mui-zh-cn

# vim

(c, c++, java)
(python, javascript)
(scheme, lua, vimscript)
(markdown, latex)

- nvim python-pynvim(pip install pynvim)(npm -i -g neovim)
- neoformart: prettier eslint lua-format(aur) yapf(python)

- c/cpp: lspinstall clang, sudo pacman -S clangd, cppchek(lint), python-cpplint(lint)
- python: lspinstall pylsp, sudo pacman -S python-pylint(lint)
- java: checkstyle(lint)

- lua: lspinstall sumneko_lua,

- javascript: lspinstall quick_lint_js, pacman -S eslint(lint)
- html: lspinstall html, pacman -S tidy(lint)
- css: lspinstall cssls, stylelint(lint)

- vim: lspinstall vimls, sudo pacman -S vint(lint)

- markdown: lspinstall prosemd_lsp, nodejs-markdownlintcli(aur)(lint)
- latex: lspinstall

- `https://wiki.archlinux.org/title/Neovim` install lsp

> checkHealth:

- ruby python3 go
- python python-pip
- openjdk-doc openjdk-src(include jre-openjdk jdk-openjdk)

# dolphin

- https://wiki.archlinux.org/title/Dolphin#File_previews
- kdegraphics-thumbnailers
- dolphin-plug

# pdf

- poppler
- poppler-data

---
