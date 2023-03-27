---
title: "Vim More"
date: 2023-03-27T19:02:31+08:00
draft: false
tags: ["vim"]
author: "liukanglai"
description: "vim面板？"
---

## buffer

- :ls look files(same as :buffers, :files)
- :e file (file tree)
- :bn(next)/bp(previous) b 1(or b1) b name(partly, can use tab to complete)
- :bd (only close a file)

- vim-unimpaired

        [b ]b 循环遍历缓冲区
        [f ]f 循环遍历同一目录下文件，并生成缓冲区
        [l ]l 遍历位置列表
        [q ]q 遍历快速修复列表
        [q ]q 遍历tag

# Tab

- :tabnew web 使用 ：tabnew 创建一个名字叫 web 的 tab ,当然名字也可以没有，这样会创建一个没有名字的 tab
- :tabc(close) 关闭当前的 tab
- :tabn 切换到下一个 tab /gt /ngt /:tabmove N
- :tabp 切换到上一个 tab /gT /ngT
- :tabs 查看一共有几个 tab
- :tabe >+/-tabnext
- tabmove N

# split

- :split(sp) file vsplit(vs)
- ctr+w+hjkl 光标移动
- Ctrl + w s/v 上下/分割当前打开的文件。
- 左右分屏： vim -On file1 file2 ... filen
- 上下分屏： vim -on file1 file2 ... filen

- Ctrl + w c 关闭当前的分屏
- Ctrl + w q 关闭当前的分屏，如果是最后一个分屏将会退出 VIM
- Ctrl + w o 关闭所有其他
- :wqa(w,q,all) 关闭所有并退出
- 关闭缓冲区，而不关窗口，in vimrc: command! Bd :bp | :sp | :bn | :bd, then use :Bd

# 窗口

- :help window-moving, :help window-resize
- c-w+HJKL: move the current window to ...
- change: c-w-r,x...
- 编号算了。。。

- c-w-=: all windows high and weigh same
- c-w--,+,<,>
- :resize(res) +,-N... :vertical resize(vert res) +,-N...

# fold

- 设置折叠模式: set foldmethod=indent(manual, expr（正则）, marker(文中的特殊标记如（{【), syntax, diff)
- autocmd BufRead \* normal zR , will open all fold when open a file
- zo: open fold
- zc: close
- za: open/close
- zR: open all
- zM: close all

# undotree

- gundo.vim
- noremap <f5> :GundoToggle<cr>
  > help: undo-tree

# filetree

1. (内置)Netrw: use :Ex
   - enter, -(上一层目录), D(delete), R :Vex(左右分割打开 Netrw），:Sex, :Lex :Ex(or :e) sftp://<domain>/<directory>/, :e scp://<domain>/<directory>/<file>
2. set wildmenu(启动增强的 tab 自动补全)，set wildmode=list:longest,full(允许的最长字符串)
   - :e, then use tab, can open file(shift+tab, turn)
3. NERDTree
   - :NERDTree to start
   - bookmarks: use :Bookmark to make a bookmark(is a file), use B to look
   - let NERDTreeShowBookmarks = 1
   - audocmd VimEnter \* NERDTree "自动打开
4. Vinegar
   - use - will enter Netrw (use I to show the help, shift+~will open ~)
5. CtrP
   - 按 ctr+P 会进入文件选择，ctr+j,k 上下，esc 退出
   - ctr+f，b 切换搜索模式，打开搜索模式 :CtrlPBuffer, :CtrlPMRU(最近使用), :CtrlPMixed（同时）

# open file

- vim \*.c +14(行号)

# Register

- " 访问寄存器
- "ayy 表示的是复制当前行内容到 a 寄存器当中，如需附加复制，使用 A
- “ap 表示的是从 a 寄存器当中取出内容
- :reg 该命令会列出所有的寄存器
- :reg a 会查看 a 寄存器里寄存的内容 ((%寄存)器当前文件名，#上次打开的文件名，.最后插入的文本，:最后的命令)
- “” 两个双引号就是一个无名寄存器，通常我们复制黏贴的时候都会自动启用这个寄存器。
- 0 寄存器是最近一次的 （1，2, ...）
- 插入模式下:c-r+寄存器会粘贴

- \*寄存器（macOS，windows 的），+寄存器（linux 默认的 ctr+c，ctr+v）
- .vimrc: set clipboard=unamed " 复制到\*\*
- set clipboard=unnamedplus " 复制到+
- set clipboard=unamed, unnamedplus " 同时

# 快速恢复列表 quickfix

为了方便的跳转到文件的某个部分, 如:make, :grep 等产生的信息

- :copen to open all
- :cclose/:bd
- :cnext(cn) :cprevious(cp/cN)
- :cwindow/:cw 只在出错时打开

# 位置列表

- :lgrep :lmake to open
- :lopne :lclose ...

# diff

---
