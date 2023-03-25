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
---# <center>Install</center>

[文档](https://yq.aliyun.com/articles/384086)

## node.js:

[Web](https://nodejs.org)

>wget https://nodejs.org/dist/v4.2.4/node-v4.2.4.tar.gz

>tar zxf node-v4.2.4.tar.gz && cd node-v4.2.4

>./configrue --prefix=/usr/local/

>sudo make && sudo make install

>node -v

## npm:(NPM的全称是Node Package Manager,是Node.js包管理和分发工具)

>npm -v
`npm config set registry http://registry.npm.taobao.org`

##

>npm install  gitbook-cli -g
___

# Gitbook

## 生成：

>gitbook init

	命令：
	gitbook install 会自动安装必要的插件与书籍项目指定的插件(.json)
	gitbook help //列出gitbook所有的命令
	gitbook --help //输出gitbook-cli的帮助信息
	gitbook build //生成静态网页
	gitbook serve //生成静态网页并运行服务器
	gitbook build --gitbook=2.0.1 //生成时指定gitbook的版本, 本地没有会先下载
	gitbook ls //列出本地所有的gitbook版本
	gitbook ls-remote //列出远程可用的gitbook版本
	gitbook fetch 标签/版本号 //安装对应的gitbook版本
	gitbook update //更新到gitbook的最新版本
	gitbook uninstall 2.0.1 //卸载对应的gitbook版本
	gitbook build --log=debug //指定log的级别
	gitbook builid --debug //输出错误信息

## Files

	README.md:书的介绍文字，如前言、简介，在章节中也可做为章节的简介。
	SUMMARY.md:定制书籍的章节结构和顺序。
	LANGS.md:多种语言设置。
	GLOSSARY.md:词量表和定义描述。
	book.json(js):配置。

- SUMMARY：[]内的是目录名，（）内的是文件路径(相对路径，最多3） 
 如需加子目录，tab即可

```
执行 gitbook init 会根据 SUMMARY.md 目录生成对应的文件夹和 md 文件，每一个 md 文件对应每一章节，每一章节的内容在对应的 md 文件里编辑
如果想要新增章节，可以在 SUMMARY.md 里面新增，然后执行 gitbook init 就会新增对应的 md 文件，原有文件不会变化
如果想要删除章节，在 SUMMARY.md 里面删除，然后执行 gitbook init 想要删除的 md 文件并不会删除，需要手动删除
```

- book.json:

```
{
    // behind "" need to add',' , but the last no need

    "title": null,
    "description": null,
    "language": "zh",
    // Plugins list, can contain "-name" for removing default plugins.. "-name" for disable,"name" for use.`gitbook install will do`
      "plugins": [
    "disqus",
    "github",
    "editlink",
    "prism",
    "-highlight",
    "baidu",
    "splitter",
    "sitemap"
  ],
  // Global configuration for plugins
        
  "pluginsConfig": {
    "disqus": {
      "shortName": "webpack-handbook"
    },
    "github": {
      "url": "https://github.com/zhaoda/webpack-handbook"
    },
    "editlink": {
      "base": "https://github.com/zhaoda/webpack-handbook/blob/master/content",
      "label": "编辑本页"
    },
    "baidu": {
        "token": "a9787f0ab45d5e237bab522431d0a7ec"
    },
    "fontSettings": {
            "theme": "sepia", "night" or "white",
            "family": "serif" or "sans",
            "size": 1 to 4
        },
    "sitemap": {
        "hostname": "http://zhaoda.net/"
    }
  },
    // Links in template (null: default, false: remove, string: new value)
    "links": {
        // Custom links at top of sidebar
        "sidebar": {
            "Custom link name": "https://customlink.com"
        },

        // Sharing links
        "sharing": {
            "google": null,
            "facebook": null,
	    "twitter": null,
            "weibo": null,
            "all": null
        }
    }
}
```
- 常用的插件 [blog](https://zhaoda.net/2015/11/09/gitbook-plugins/)

```
changyan，为GitBook页面添加畅言评论框。
sharing-plus，GitBook默认分享工具的增强版，加入了中国常用的社交网站。
bibtex-indexed-cite，使用bibtex格式，自动生成参考文献。
```

