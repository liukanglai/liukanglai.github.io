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
---

## leader

- tmux -V
- tmux to open
- all use need a leader(c-b)

        # Use Ctrl-\ as a prefix. alt is M-b
        unbind-key C-b
        set -g prefix 'C-\'
        bind-key 'C-\' send-prefix

- c-b, than :source-file ~/.tmux.conf
- exit or c-d

        # 列出所有快捷键，及其对应的 Tmux 命令
        $ tmux list-keys
        # 列出所有 Tmux 命令及其参数
        $ tmux list-commands
        # 列出当前所有 Tmux 会话的信息
        $ tmux info
        # 重新加载当前的 Tmux 配置
        $ tmux source-file ~/.tmux.conf

## windows

- vsplit: leader + %

        # Use - to create vertical splits.
        bind - split-window -v
        unbind '%'

- split: leader + "

        # Use | to create horizontal splits.
        bind | split-window -h
        unbind '"'

- leader + 方向键跳转

        # Navigate panes with hjkl.
        bind h select-pane -L
        bind j select-pane -D
        bind k select-pane -U
        bind l select-pane -R

- open a window: leader + c
- leader + x : exit a window

        Ctrl+b c：创建一个新窗口，状态栏会显示多个窗口的信息。

        Ctrl+b p：切换到上一个窗口（按照状态栏上的顺序）。
        Ctrl+b n：切换到下一个窗口。
        Ctrl+b <number>：切换到指定编号的窗口，其中的<number>是状态栏上的窗口编号。
        Ctrl+b w：从列表中选择窗口。

        Ctrl+b ,：窗口重命名。

        Ctrl+b %：划分左右两个窗格。
        Ctrl+b "：划分上下两个窗格。
        Ctrl+b <arrow key>：光标切换到其他窗格。<arrow key>是指向要切换到的窗格的方向键，比如切换到下方窗格，就按方向键↓。
        Ctrl+b ;：光标切换到上一个窗格。
        Ctrl+b o：光标切换到下一个窗格。
        Ctrl+b {：当前窗格与上一个窗格交换位置。
        Ctrl+b }：当前窗格与下一个窗格交换位置。
        Ctrl+b Ctrl+o：所有窗格向前移动一个位置，第一个窗格变成最后一个窗格。
        Ctrl+b Alt+o：所有窗格向后移动一个位置，最后一个窗格变成第一个窗格。
        Ctrl+b x：关闭当前窗格。

        Ctrl+b !：将当前窗格拆分为一个独立窗口。
        Ctrl+b z：当前窗格全屏显示，再使用一次会变回原来大小。

        Ctrl+b Ctrl+<arrow key>：按箭头方向调整窗格大小。

        Ctrl+b q：显示窗格编号。

## 会话(detach)

> 会话与窗口分离

- tmux new -s name
- list: leader + s, tmux ls / list-sessions
- tmux attach -t name

- switch: tmux switch -t name
- leader + (/) to move
- rename: leader + $, tmux rename-session -t name new-name

- exit(don't leave the window, can recover): leader + d, tmux detach
- kill: tmux kill-session -t name

        # Smart pane switching with awareness of Vim splits.
        # See: https://github.com/christoomey/vim-tmux-navigator
        is_vim="ps -o state= -o comm= -t '#{pane_tty}' \
         | grep -iqE '^[^TXZ ]+ +(\\S+\\/)?g?(view|n?vim?x?)(diff)?$'"
        bind-key -n C-h if-shell "$is_vim" "send-keys C-h" "select-pane -L"
        bind-key -n C-j if-shell "$is_vim" "send-keys C-j" "select-pane -D"
        bind-key -n C-k if-shell "$is_vim" "send-keys C-k" "select-pane -U"
        bind-key -n C-l if-shell "$is_vim" "send-keys C-l" "select-pane -R"
        bind-key -T copy-mode-vi C-h select-pane -L
        bind-key -T copy-mode-vi C-j select-pane -D
        bind-key -T copy-mode-vi C-k select-pane -U
        bind-key -T copy-mode-vi C-l select-pane -R
        # use with tpm:
        set -g @plugin 'christoomey/vim-tmux-navigator'
        run '~/.tmux/plugins/tpm/tpm'

## copy-mode

- leader + [
- use vi: setw -g mode-keys vi

## TPM

> `https://github.com/tmux-plugins/tpm`

## theme & color

- `https://github.com/egel/tmux-gruvbox`

- in terminal: echo $TERM
- in tmux: echo $TERM

> set -g default-terminal "xterm-256color" or "screen-256color" same as the terminal
>
> > use "set -g default-terminal "tmux-256color"" int tmux (form neovim)

## escape-time

> [韦易笑](https://zhuanlan.zhihu.com/p/47801331)
