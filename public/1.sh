#!/bin/bash
for file in $(find ./posts -name "*.md"); do
	# sed -i '1 i\---\nAdded Text\n---\n' "$file"
	sed -i '1s%^%---\
title: ""\
draft: false\
tags: ["first"]\
author: "liukanglai"\
# author: ["Me", "You"] # multiple authors\
showToc: true\
TocOpen: false\
hidemeta: false\
comments: false\
description: "Desc Text."\
canonicalURL: "https://canonical.url/to/page"\
disableHLJS: true # to disable highlightjs\
disableShare: false\
disableHLJS: false\
hideSummary: false\
searchHidden: true\
ShowReadingTime: true\
ShowBreadCrumbs: true\
ShowPostNavLinks: true\
ShowWordCount: true\
ShowRssButtonInSectionTermList: true\
UseHugoToc: true\
cover:\
    image: "<image path/url>" # image path/url\
    alt: "<alt text>" # alt text\
    caption: "<text>" # display caption under cover\
    relative: false # when using page bundles set this to true\
    hidden: true # only hide on current single page\
editPost:\
    URL: "https://github.com/<path_to_repo>/content"\
    Text: "Suggest Changes" # edit text\
    appendFilePath: true # to append file path to Edit link\
---%' "$file"

done
