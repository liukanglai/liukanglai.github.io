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
---# analysis

1. start time

   - vim --startuptime startuptime.log 记录行为到文件中
   - 第三列为启动时间。

2. 特定行为的分析(ps: CtrlP)
   - :profile start profile.log
   - :profile func \*(CtrlP)
   - :profile file \*(CtrlP)
   - open profile.log, G, \*可搜索单词

# install

## self

- mkidr -p ~/.vim/pack/plugins/start 总是需要加载的插件
- mkidr -p ~/.vim/pack/plugins/opt 手动加载的插件（use :packadd ..., to use）

  > command ! -nargs=\* Ack :packadd ack.vim | Ack <f-args> (:Ack to use)
  > autcmd! filetype markdown packadd goyo.vim | Goyo (use in markdown)

- in vimrc: packloadall "加载 silent! helptags ALL “加载帮助文档，silent! 是为隐藏错误
- git clone ... ~/.vim/pack/plugins/start/file

## use git to manage plugins

- cd ~/.vim
- git init
- git submodule add https://github.com/scroooloose/nerdtree.git
  pack/plugins/start/nerdtree
- git commit -am "Add NERDTree plugin"

update:

- git submodule update --recursive
- git commit -am "Update plugins"

delete

- git submodule deinit -f --pack/plugins/start/nerdtree
- rm -rf .git/modules/pack/plugins/start/nerdtree
- git rm -f pack/plugins/start/nerdtree

# Pathogen

# vim-plug

- github vim-plug
- curl

        curl -fLo ~/.vim/autoload/plug.vim --create-dirs \
            https://raw.githubusercontent.com/junegunn/vim-plug/master/plug.vim

        	call plug#begin('~/.vim/plugged')

        	Plug ' ' (ps: vim-airline/vim-airline(此名从github栏中找)

         " 延迟按需加载，使用到命令的时候再加载on或者打开对应文件类型for才加载
          Plug 'scrooloose/nerdtree', { 'on':  'NERDTreeToggle' } " when use :NERDTreeToggle, the plug will start
          Plug 'tpope/vim-fireplace', { 'for': 'clojure' }

          " 确定插件仓库中的分支或者 tag
          Plug 'rdnetto/YCM-Generator', { 'branch': 'stable' }
          Plug 'nsf/gocode', { 'tag': 'v.20150303', 'rtp': 'vim' }

        	call plug#end()

- :PlugInstall :PlugUpdate, but to update vim-plug, you need :PlugUpgrade, then reboot vim
- 删除 Plug 并: PlugClean
- use Plug 'junegunn/vim-plug' to look up :help vim-plug
- use this: (to install vim-plug auto)

        if empty(glob('~/.vim/autoload/plug.vim'))
          silent ! `curl -fLo ~/.vim/autoload/plug.vim --create-dirs \
            https://raw.githubusercontent.com/junegunn/vim-plug/master/plug.vim
          autocmd VimEnter * PlugInstall --sync | source $MYVIMRC
        endif

- load: :w | source $MYVIMRC (usually can't use!)

# Vundle

- be same to vim-plug
- use :PluginSearch ... !!!you can find plugins, then put the cursor on it, push i, will try it, but not installed it, you need use plug '' to install it.

#
