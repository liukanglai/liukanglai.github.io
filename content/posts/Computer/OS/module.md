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

- lsmod
- insmod
- rmmod (-f)

#

- First, find out, which other modules use the module sdhci:

        lsmod | grep sdhci
- You will get a list like this:

        module size used_by
- Try unloading these modules (used\_by) before or together with the module you want to unload:

        sudo modprobe -r <module found from lsmod> <module you want to remove>
If you want to prevent the module from loading on the next boot, add it to the blacklist:

        echo -e "sdhci\n" | sudo tee -a /etc/modprobe.d/blacklist.conf
