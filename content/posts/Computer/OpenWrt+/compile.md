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

- 开始觉得编译挺难的，后来查找ssr+，发现也挺简单的。https://www.solarck.com/install-ssr-plus.html
- 主要是教程太难找了。。。 新手要研究还是找本书看（官方文档），一定要深入学习啊！！！

## Lean 源

1. download
 
        git clone https://github.com/coolsnowwolf/lede
        cd lede


4. 固件更新/安装扩展包 
 
        ./scripts/feeds update -a && ./scripts/feeds install -a


5. 个性化固件 
 
        make menuconfig 

    - Target System(系统架构)
    - Subtarget(子架构)
    - Target Profile(路由器型号)
    - LucI-> : 空格选中要的，呈*号，M而不是空格，那么相当于把该插件编译为模块而不是编译入固件，这样做当然可以，但是建议第一次先全部编译，然后再次单独编译，不然单独编译一个插件会失败。？？？？？？？？？？？？？？？？？？？？？？？？

6. 下载所有脚本和程序 科学上网，不然很多程序不能顺利下载导致编译失败。代码最后的-j5可以把数字替换为你CPU核数+1。

        make download -j5


7. 开始编译 核越多越快，这一步需要等待几分钟～几十分钟不等。

        make -j5 V=s


## Lienol 源

上面编译完成后，编译出的文件就可以在bin/packages/路由器架构/base/里找到你要的全部文件，先把luci-app-ssr-plus传到路由器安装试试。


cd bin/packages/arm_cortex-a9_vfpv3/base/
scp -P 22 luci-app-ssr-plus*.ipk root@192.168.250.1:/tmp/

切换到路由器shell执行（插件文件名每个人可能略有不同）

opkg install /tmp/luci-app-ssr-plus_1-99_all.ipk

如果你是原版openwrt，那么执行完安装后一定会报错，提示找不到依赖

satisfy_dependencies_for: Cannot satisfy the following dependencies for luci-app-ssr-plus: shadowsocksr-libev-alt ipset ip-full iptables-mod-tproxy dnsmasq-full coreutils coreutils-base64 bash pdnsd-alt wget shadowsocks-libev-ss-redir v2ray opkg_install_cmd: Cannot install package luci-app-ssr-plus.



你的提示可能会和我的有点出入，缺少的依赖或多或少，但一定会报错，原因就在于luci-app-ssr-plus依赖三个插件不在官方源中，所以我们要把下面几个编译好的插件传上路由器提前安装好。文件都在上面提到的目录中，上传方法也相同，这里就不赘述了。

shadowsocksr-libev-alt

pdnsd-alt

v2ray



最后还有一点要注意的，在安装所有非官方依赖后，安装luci-app-ssr-plus前，还有一步操作。openwrt系统都会内置dnsmasq用于DNS服务，但是这个插件与dnsmasq-full是冲突的，所以要手动卸载掉，但是可以不手动安装，作为官方源中可以找到的依赖插件，它是可以自动安装的。

opkg remove dnsmasq
opkg install /tmp/luci-app-ssr-plus_1-99_all.ipk


安装好后，默认是看不到插件的，需要开启彩蛋，在路由器shell执行下面的命令

echo 0xDEADBEEF > /etc/config/google_fu_mode


至此就算大功告成。不过在我的路由器上还有一个小问题需要修复，没有问题的配置好自己的服务器应该就可以科学上网了，无需往下看。



替换pdnsd
在我安装配置好之后，依然不能访问外网，搜索一番发现#817和#1599这两个问题和我遇到的一样，经过排查，问题确实出在pdnsd没有运行，索性我就用dnsforwarder把它替换掉。这个插件官方源中也不提供，不过好在有第三方提供，我们可以添加上直接使用，具体方法查看我之前的文章路由器自动翻墙中的安装密钥和新增源两部分。

准备就绪后就可以开始安装

opkg install dns-forwarder luci-app-dns-forwarder




方法一
修改 feeds.conf.default 文件，将最后一行的注释 # 删除， src-git lienol https://github.com/fw876/helloworld。
然后执行：

./scripts/feeds clean
./scripts/feeds update -a
./scripts/feeds install -a
ShellCopy
然后编译就有最终版 SSR-plus 了。

- 方法二

同样的，也可以直接下载这个源的软件包，small 是依赖包：

cd lede/package
git clone https://github.com/kenzok8/openwrt-packages.git
git clone https://github.com/kenzok8/small.git
ShellCopy
然后执行：

./scripts/feeds update -a
./scripts/feeds install -a
ShellCopy
接着编译 Passwall 和 SSR-plus 就都有了。

注：
如果 feeds update 出现一堆类似下面的警告：

WARNING: Makefile 'package/lean/shadowsocksR-libev-full/Makefile' has a dependency on 'libpcre', which does not exist
ShellCopy
解决办法就是删掉 feeds 整个文件夹，在 lede 或 openwrt 目录下执行 rm -rf ./feeds，然后再 update。

个人感觉 Lean's 的源码编译不是很好用，时而成功时而不行，原因根本不知道为什么，而 Lienol 的源基本网络没问题就编译没问题。
