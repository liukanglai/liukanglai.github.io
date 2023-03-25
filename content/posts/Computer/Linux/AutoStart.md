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
---# xdg-open


- ln -s ~/.config/mimeapps.list ~/.local/share/applications/mimeapps.list  // most important!!!
- ~/.config/mimeapps.list (maybe can't use...)
- ~/.local/share/applications: 
" - /etc/xdg/menus: ???
- /usr/share/application/:  list the application to open file

- 1.希望xls文件，默认打开方式为libreoffice
linux下可以使用xdg-open file 的方式来打开文件，他会从当前桌面环境中找到默认程序进行打开，因为我是原生的awesome，没有使用任何de（desktop enviorment），比如gnome、kde，xfce4等。使用命令：
xdg-mime query filetype some.xls
输出：
application/msword; charset=binary
前面的application/msword就是mimetype，再使用命令：
xdg-mime query default application/msword
如果输出是空，代表当前尚未设置默认的文件打开程序，当使用命令：
xdg-open some.xls 将会调用当前环境的浏览器，比如firefox、opera、chrome中一个来打开，会使用先找到的工具进行操作，因为这时候我们想使用，libreoffice进行默认的word、excel文件的打开方式，所以可以使用命令：
xdg-mime default libreoffice-writer.desktop application/msword
 设置，这时候你再使用，xdg-open some.xls，哈哈，是不是libreoffice启动了？
chrome中当有下载文件时，选择show in folder的时候，默认打开的程序仍然是chrome浏览器。如果这时候我想用xfce4下的thunar打开怎么办呢？
操作步骤跟上面一样，先找到目录属于的mime-type是什么，然后设置对应的desktop文件就行了。
操作步骤：
xdg-mime query filetype /home/
 
xdg-mime query default inode/directory
 
xdg-mime default Thunar-folder-handler.desktop inode/director


# j

方法一：修改 /etc/rc.d/rc.local 文件
/etc/rc.d/rc.local 文件会在 Linux 系统各项服务都启动完毕之后再被运行。所以你想要自己的脚本在开机后被运行的话，可以将自己脚本路径加到该文件里。
$ chmod +x /etc/rc.d/rc.local
为了演示，我们创建了一个脚本，当它被执行之后，将在家目录下写入有特定信息的文件。

$ vim auto_run_script.sh

#!/bin/bash

date >> /home/alvin/output.txt
hostname >> /home/alvin/output.txt
保存退出后，再给它赋予可执行权限：

$ chmod +x auto_run_script.sh
然后，我们再将脚本添加到 /etc/rc.d/rc.local 文件最后一行：

$ vim /etc/rc.d/rc.local

/home/alvin/auto_run_script.sh
接下来，我们就可以试试效果了。直接重启系统就可以了：

- 
vim /etc/rc.local

步骤2:在文件底部加入需要执行的命令，示例如下：

#!/bin/bash
#THIS FILE IS ADDED FOR COMPATIBILITY PURPOSES
#
#It is highly advisable to create own systemd services or udev rules
#to run scripts during boot instead of using this file.
#
#In contrast to previous versions due to parallel execution during boot
#this script will NOT be run after all other services.
#
#Please note that you must run 'chmod +x /etc/rc.d/rc.local' to ensure
#that this script will be executed during boot.

docker container rm --force container_name
docker run 
exit 0

保存，reboot 重启，查看命令是否正常执行。
步骤3:设置 /etc/rc.local 文件的执行权限：

chmod +x /etc/rc.local
