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
---# install

- sudo pacman -S neovim
- sudo pacman -S python-pynvim
- Python 2 and Ruby modules (currently only supported in neovim-git) are available from the AUR as python2-neovim and ruby-neovim respectively.

# nvim

- .config/nvim
- .config/nvim/init.vim -> ~/.vimrc
- .config/nvim -> ~/.vim

        mkdir -p $HOME/.config
        ln -s $HOME/.vim $HOME/.config/nvim
        ln -s $HOME/.vim/.vimrc $HOME/.config/nvim/init.vim

        windows:
        mklink /D %USERPROFILE%\AppData\Local\nvim %USERPROFILE%\vimfiles
        mklink %USERPROFILE%\AppData\Local\nvim\init.vim %USERPROFILE%\_vimrc

# check

- :checkhealth

- pip install neovim  " for python2
- python3 -m pip install neovim  " for python3


# config

- :help nvim-defaults

        if !has('nvim')
          set nocompatible                " not compatible with Vi
          filetype plugin indent on       " mandatory for modern plugins
          syntax on                       " enable syntax highlighting
          set autoindent                  " copy indent from the previous line
          set autoread                    " reload from disk
          set backspace=indent,eol,start  " modern backspace behavior
          set belloff=all                 " disable the bell
          set cscopeverbose               " verbose cscope output
          set complete-=i                 " don't scan current on included
                                          " files for completion
          set display=lastline,msgsep     " display more message text
          set encoding=utf-8              " set default encoding
          set fillchars=vert:|,fold:      " separator characters
          set formatoptions=tcqj          " more intuitive autoformatting
          set fsync                       " call fsync() for robust file saving
          set history=10000               " longest possible command history
          set hlsearch                    " highlight search results
          set incsearch                   " move cursor as you type when searching
          set langnoremap                 " helps avoid mappings breaking
          set laststatus=2                " always display a status line
          set listchars=tab:>\ ,trail:-,nbsp:+  " chars for :list
          set nrformats=bin,hex           " <c-a> and <c-x> support
          set ruler                       " display current line # in a corner
          set sessionoptions-=options     " do not carry options across sessions
          set shortmess=F                 " less verbose file info
          set showcmd                     " show last command in the status line
          set sidescroll=1                " smoother sideways scrolling
          set smarttab                    " tab setting aware <Tab> key
          set tabpagemax=50               " maximum number of tabs open by -p flag
          set tags=./tags;,tags           " filenames to look for the tag command
          set ttimeoutlen=50              " ms to wait for next key in a sequence
          set ttyfast                     " indicates that our connection is fast
          set viminfo+=!                  " save global variables across sessions
          set wildmenu                    " enhanced command line completion
        endif

# plugin

- dein 插件管理
- denite for search
- nyaovim
- neomake linting  :Neomake
- Neoterm  拓宽终端支持
- NCM2  代码补全
- gen_tags  for ctags

# GUI

## Oni

- ctrl-shift-p
- ctrl+g 可访问页面
