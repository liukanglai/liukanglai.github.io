---
title: "Arch individual config"
date: 2023-03-27T19:10:38+08:00
draft: false
tags: ["Arch"]
author: "liukanglai"
description: " "
---

## install

1. 联网

- systemctl start dhcpcd #立即启动 dhcp

1. systemd-boot

- bootctl install(/boot)
- bootctl --path=/boot install
- vim /boot/loader/loader.conf:

```text
default archlinux
timeout 1
```

- vim /boot/loader/entries/arch.conf

```text
title archlinux
linux /vmlinuz-linux
initrd /initramfs-linux.img
options root=PARTUUID=deba4ba7-0c8f-c64e-a60e-e34e5bb87ab3 rw
> :r !blkid to get partuuid
```

## config

1. 字体

- noto-fonts noto-fonts-cjk noto-fonts-emoji ttf-Iosevka ttf-nerd-fonts-symbols
- fonts.conf

1. install

```text
xorg xf86-input-libinput
linux-headers man
yakuake fzf ark p7zip zip gzip tar unzip unrar unarchiver lzop lrzip
# 注意的是解压 windows 下的压缩包，可能会乱码，安装 ark 的可选依赖之一 unarchiver，使用 unar 可以避免这个问题
packagekit-qt5 packagekit appstream-qt appstream # 确保Discover(软件中心)可用, 需重启
gwenview deepin-screenshot flameshot cheese vlc net-tools(ifconfig) kdeconnect
tlp okular neofetch Foliate (sudo systemctl start tlp.service) filelight
git make libconfig wget curl npm exfat-utils cmake ctags nodejs pip python
google-chrome aliyunpan-liupan1890 baidunetdisk-bin calibre
vim neovim kate bind
utools
```

- yay -S node-fanyi rime-ice

1. 美化

- layan
- widgets cpu, memory, network, ip yay -S plasma5-applets-netspeed ksysguard
- konsole: gruvbox yakuake(.config/yakuakerc) .locla/share/konsole have profile(勾选默认)

1. git

- look Git+/git/ssh.md

## Code

(c, c++, java)
(python, javascript)
(scheme, lua, vimscript)
(markdown, latex)

- clion clion-jre
- openjdk-doc openjdk-src(include jre-openjdk jdk-openjdk)
- intellij-idea-ultimate-edition intellij-idea-ultimate-edition-jre
- fleet

## vim

lunarvim

- cargo: `curl --proto '=https' --tlsv1.2 -sSf https://sh.rustup.rs | sh`
- yay -S lazygit ripgrep sqlite fd yarn lldb go unzip zoxide xclip
- (pip install pynvim)
- install: `LV_BRANCH='release-1.2/neovim-0.8' bash <(curl -s https://raw.githubusercontent.com/lunarvim/lunarvim/fc6873809934917b470bff1b072171879899a36b/utils/installer/install.sh)`

- comment: first v, then gb gcc, gcA, gco, gcO
- lsp: K, gd, gD, gr!!!, gI, gs, gl, leader+lr

- c/c++ java python make/cmake
- javascript vue css html yaml json
- scheme lua bash vim
- markdown latex

- MasonInstall cpplint markdownlint pylint vint codespell shellcheck luacheck cspell
- stylua prettier shfmt black codelldb
- proselint
- yay -S cppcheck luarocks eslint google-java-format checkstyle(难搞) checkmake stylelint

- scheme: `https://github.com/ufo5260987423/scheme-langserver`

- 记得设置 npm 的 prefix 以设置可访问的全局安装路径: `npm config set perfix ~/.local`
- The default html server has bug which does not support embeded javascript completion.
- npm i -g vscode-html-languageserver-bin (will be started when you open html file)

> checkHealth:

## dolphin

- `https://wiki.archlinux.org/title/Dolphin#File_previews`
- kdegraphics-thumbnailers
- dolphin-plugins
- poppler poppler-data(pdf)

---
