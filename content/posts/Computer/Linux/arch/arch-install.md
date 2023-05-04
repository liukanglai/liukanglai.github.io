---
title: "ArchLinux Install"
date: 2023-03-27T19:05:02+08:00
draft: false
tags: ["Arch"]
author: "liukanglai"
description: "ArchLinux基础安装"
---

## 启动

- 镜像 u 盘 (MD5… PGP…)
- ventoy, Rufus, etcher

> 例:dd bs=4M if=/home/liukanglai/Downloads/archlinux-2020.04.01-x86_64.iso of=/dev/sda status=progress oflag=sync

- 关闭主板设置中的 Secure Boot
- u 盘启动 UEFI `root@archiso~#`

## 查看指南:ls

- 验证启动模式:ls /sys/firmware/efi/efivars 有输出即为 UEFI

## 禁用 reflector

- reflector 会为你选择速度合适的镜像源，但其结果并不准确，同时会清空配置文件中的内容，对于新人来讲并不适用，我们首先对其进行禁用。

  systemctl stop reflector.service

## 联网

- ip link –看网卡 `enp开头有线网卡 wlp无线网卡`

  > 看有无网: 命令 ping www.baidu.com 后显 ….ms 即有网

(手机 usb 共享网,连接电脑)

### 无线

- ip link set .. up
- 如果随后看到类似 Operation not possible due to RF-kill 的报错，继续尝试 rfkill 命令来解锁无线网卡:
- rfkill unblock wifi

1. wpa

- 扫描：iwlist .. scan | grep ESSID
- 连接：

  > wpa_passphrase 网络名 密码 > internet.conf
  >
  > wpa_supplicant -c internet.conf -i 设备名 &

2. iwt

```
iwctl                           #执行iwctl命令，进入交互式命令行
device list                     #列出设备名，比如无线网卡看到叫 wlan0
station wlan0 scan              #扫描网络
station wlan0 get-networks      #列出网络 比如想连接YOUR-WIRELESS-NAME这个无线
station wlan0 connect YOUR-WIRELESS-NAME #进行连接 输入密码即可
exit                            #成功后exit退出
```

> 如需 web 登录(Captive Portal): elinks http…

## 安盘

1. 查看硬盘: lsblk 或 fdisk -l

- /dev/… nvme0n(高级)或 sda… (新盘不同)

2. 首先将磁盘转换为 gpt 类型，这里假设比如你想安装的磁盘名称为 sdx。如果你使用 NVME 的固态硬盘，你看到的磁盘名称可能为 nvme0n1。

```
lsblk                       #显示分区情况 找到你想安装的磁盘名称
parted /dev/sdx             #执行parted，进入交互式命令行，进行磁盘类型变更
(parted)mktable             #输入mktable
New disk label type? gpt    #输入gpt 将磁盘类型转换为gpt 如磁盘有数据会警告，输入yes即可
quit                        #最后quit退出parted命令行交互
```

3. 分盘: cfdisk 进 gpt 分后 yes

| 格式  | 大小 | 目录  | 格式             |
| ----- | ---- | ----- | ---------------- |
| fat32 | 300M | EFI   | EFI system       |
| ext4  |      | /     | linux filesystem |
| ext4  |      | /home | linux filesystem |
| swap  |      | /     | linux swap       |

4. 格式化:

- /：mkfs.ext4 /dev/..
- EFI: mkfs.vfat(systemd-boot)或 mkfs.fat -F32
- swap: mkswap -f /…

5. 挂载:

- mount /dev/.. /mnt
- mkdir /mnt/boot
- mount /dev/.. /mnt/boot
- mkdir /mnt/home
- mount /dev/... /mnt/home

## 配置

1. 关闭自动选择镜像：systemctl stop reflector.service

2. 时间

- timedatectl set-ntp true #将系统时间与网络时间进行同步
- timedatectl status #检查服务状态

> 手动: timectl set-time “year-month-date h-minute-s”

## 镜像源

- vim /etc/pacman.d/mirrorlist 把 China 移到最前

```
 清华大学
Server = https://mirrors.tuna.tsinghua.edu.cn/archlinux/$repo/os/$arch
## 163
Server = http://mirrors.163.com/archlinux/$repo/os/$arch
## aliyun
Server = http://mirrors.aliyun.com/archlinux/$repo/os/$arch
```

- 刷新: pacman -syy (-syu)

## 安装

- pacstrap /mnt base base-devel linux linux-firmware linux-headers vim man dhcpcd iwd bash-completion
<!--- pacman -S networkmanager iw wpa_supplicant dialog dhcpcd netctl-->

> linux 中包含 EFI 文件！！！

## 进入 chroot

1. 生成 fstab(定义磁盘分区)

- genfstab -U /mnt >> /mnt/etc/fstab

2. 检查:cat /mnt/etc/fstab

3. arch-chroot /mnt

## 基本设置

1. 时区: ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
2. 进行硬件时间设置，将当前的正确 UTC 时间写入硬件时间: hwclock –-systohc
3. 安装字体：

- noto-fonts, noto-fonts-cjk noto-fonts-emoji

4. 本地化:

- vim /etc/locale.gen (去#号 en_US.UTF-8 UTF-8 zh_CN.UTF-8 UTF-8 zh_HK.UTF-8 UTF-8 zh_TW.UTF-8 UTF-8 )
- locale-gen(生成)
- vim /etc/locale.conf 输入： LANG=en_US.UTF-8

5. 主机

- vim /etc/hostname 编辑主机名称 hostname
- vim /etc/hosts
- 文末加

```
127.0.0.1 localhost
::1 localhost
127.0.1.1 hostname
```

6. 设 root 密码:passwd(passwd root)

## 安装启动加载器

- pacman -S efibootmgr grub intel-ucode(or amd-ucode) os-prober

1. grub

- grub-install --target=x86_64-efi -–efi-directory=/boot –-bootloader-id=grub
- grub-install --target=x86_64-efi --efi-directory=/efi --removable(?)
- 接下来编辑/etc/default/grub 文件，去掉 GRUB_CMDLINE_LINUX_DEFAULT 一行中最后的 quiet 参数，同时把 log level 的数值从 3 改成 5。这样是为了后续如果出现系统错误，方便排错。同时在同一行加入 nowatchdog 参数，这可以显著提高开关机速度
- 生成:grub-mkconfig -o /boot/grub/grub.cfg

2. systemd-boot

- bootctl install(/boot)
- bootctl --path=/boot install
- vim /boot/loader/loader.conf:

```
default archlinux
timeout 1
```

- vim /boot/loader/entries/arch.conf

```
title archlinux
linux /vmlinuz-linux
initrd /initramfs-linux.img
options root=PARTUUID=deba4ba7-0c8f-c64e-a60e-e34e5bb87ab3 rw
> :r !blkid to get partuuid
```

## swap

```
swapon --show
free -h
```

- swap file

```
dd if=/dev/zero of=/swapfile bs=1M count=512(单位：M) status=progress
chmod 600 /swapfile
mkswap /swapfile
swapon /swapfile

vim /etc/fstab
/swapfile none swap defaults 0 0
```

## 重启:exit

- killall wpa_supplicant dhcpcd
- umount -R /mnt
- reboot

## 联网

1. 有线

- systemctl start dhcpcd #立即启动 dhcp
- ping www.gnu.org

2. 若为无线链接，则还需要启动 iwd 才可以使用 iwctl 连接网络

- systemctl start iwd #立即启动 iwd
- iwctl #和之前的方式一样，连接无线网络

3. wifi-menu 即可

---
