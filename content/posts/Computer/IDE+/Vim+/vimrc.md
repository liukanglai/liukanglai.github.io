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
---# ~/.vim/vimrc

- " is comment
- :syntax on

# map

" Resize splits with arrow keys
"noremap <up> :res +5<CR>
"noremap <down> :res -5<CR>
"noremap <left> :vertical resize-5<CR>
"noremap <right> :vertical resize+5<CR>

"" Place the two screens up and down
"noremap sh <C-w>t<C-w>K
"" Place the two screens side by side
"noremap sv <C-w>t<C-w>H

"" Disable the default s key
"noremap s <nop>

- map 递归映射（可自定义再定义），noremap 非递归(系统默认)
- <c-u>: Ctrl+u <a-u>/<m-u>: Alt+u <s-u>: Shift+u
- <cr><enter>表示回车 <space> <esc> <tab> bs 退格
- <up> <down> <left> <right>箭头 <pageup> <pagedown> 上下翻页
- <f1>...
- <nop>无操作
  > :help index :map g

> nore is no recursive, ps:
>
> > noremap j gj " it will use the original meaning of gj, rather than the meaning after changing.

- nmap/nnoremap 正常模式
- vmap/vnoremap 可视，选择模式
- xmap/xnoremap 可视模式?
- smap/snoremap 选择模式
- omap/onoremap 操作待决模式?
- map!/noremap! 插入和命令行模式
- imap/inoremap 插入模式
- cmap/cnoremap 命令行模式

        inoremap " ""<esc>i

## leader

- default: \
- let mapleader = " " or "\<space>" 定义在前

# 全局配置

- 关闭 vi 兼容模式 set nocompatible (nocp)
- 设置历史记录步数: set history=1000

"开启相关插件"
"侦测文件类型" filetype on
"载入文件类型插件" filetype plugin on
"为特定文件类型载入相关缩进文件" filetype indent on

- "当文件在外部被修改时，自动更新该文件" set autoread

"激活鼠标的使用" set mouse=a / set selection=exclusive / set selectmode=mouse,key

"保存全局变量" set viminfo+=!

"带有如下符号的单词不要被换行分割" set iskeyword+=\_,$,@,%,#,-

"通过使用: commands 命令，告诉我们文件的哪一行被改变过" set report=0

"被分割的窗口间显示空白，便于阅读" set fillchars=vert:\ ,stl:\ ,stlnc:\

# 字体和颜色

" 高亮多余的空白字符及 Tab: highlight RedundantSpaces ctermbg=red guibg=red / match RedundantSpaces /\s\+$\| \+\ze\t\|\t/

"自动开启语法高亮" syntax enable

"设置字体" set guifont=dejaVu\ Sans\ MONO\ 10 / set guifont=Courier_New:h10:cANSI

"设置颜色" "colorscheme desert

"高亮显示当前行" set cursorline / hi cursorline guibg=#00ff00 / hi CursorColumn guibg=#00ff00

"高亮显示普通 txt 文件（需要 txt.vim 脚本）" au BufRead,BufNewFile \* setfiletype txt

# 代码折叠功能

"激活折叠功能" set foldenable set nofen（这个是关闭折叠功能）"

"设置按照语法方式折叠（可简写 set fdm=XX）"
"有 6 种折叠方法：
"manual 手工定义折叠"
"indent 更多的缩进表示更高级别的折叠"
"expr 用表达式来定义折叠"
"syntax 用语法高亮来定义折叠"
"diff 对没有更改的文本进行折叠"
"marker 对文中的标志进行折叠"
set foldmethod=manual
"set fdl=0（这个是不选用任何折叠方法）"

"设置折叠区域的宽度"
"如果不为 0，则在屏幕左侧显示一个折叠标识列
"分别用“-”和“+”来表示打开和关闭的折叠
set foldcolumn=0

"设置折叠层数为 3" setlocal foldlevel=3

"设置为自动关闭折叠" set foldclose=all

"用空格键来代替 zo 和 zc 快捷键实现开关折叠"
"zo O-pen a fold (打开折叠)
"zc C-lose a fold (关闭折叠)
"zf F-old creation (创建折叠)
"nnoremap <space> @=((foldclosed(line('.')) < 0) ? 'zc' : 'zo')<CR>

# 文字处理

"使用空格来替换 Tab" set expandtab

"设置所有的 Tab 和缩进为 4 个空格" set tabstop=4

"设定<<和>>命令移动时的宽度为 4" set shiftwidth=4

"使得按退格键时可以一次删除 4 个空格" set softtabstop=4 / set smarttab

"缩进，自动缩进（继承前一行的缩进）"
"set autoindent 命令打开自动缩进，是下面配置的缩写
"可使用 autoindent 命令的简写，即“:set ai”和“:set noai”
"还可以使用“:set ai sw=4”在一个命令中打开缩进并设置缩进级别
set ai
set cindent

"智能缩进" set si

"自动换行” set wrap

"设置软宽度" set sw=4

"行内替换" set gdefault

# Vim 界面

"增强模式中的命令行自动完成操作" set wildmenu

"显示标尺" set ruler

"设置命令行的高度" set cmdheight=1

"显示行数" set nu

"不要图形按钮" set go=

"在执行宏命令时，不进行显示重绘；在宏命令执行完成后，一次性重绘，以便提高性能" set lz

"使回格键（backspace）正常处理 indent, eol, start 等" set backspace=eol,start,indent

"允许空格键和光标键跨越行边界" set whichwrap+=<,>,h,l

"设置魔术" set magic?

"关闭遇到错误时的声音提示" "关闭错误信息响铃" set noerrorbells

"关闭使用可视响铃代替呼叫" set novisualbell

"高亮显示匹配的括号([{和}])" set showmatch

"匹配括号高亮的时间（单位是十分之一秒）" set mat=2

"光标移动到 buffer 的顶部和底部时保持 3 行距离" set scrolloff=3

"搜索逐字符高亮" set hlsearch set incsearch

"搜索时不区分大小写" "还可以使用简写（“:set ic”和“:set noic”）" set ignorecase

"用浅色高亮显示当前行" autocmd InsertLeave _ se nocul / autocmd InsertEnter _ se cul

"输入的命令显示出来，看的清楚" set showcmd

# 编码设置

"设置编码" set encoding=utf-8 / set fencs=utf-8,ucs-bom,shift-jis,gb18030,gbk,gb2312,cp936

"设置文件编码" set fileencodings=utf-8

"设置终端编码" set termencoding=utf-8

"设置语言编码" set langmenu=zh_CN.UTF-8 set helplang=cn

"显示中文帮助" "set helplang=cn

# 其他设置

"开启新行时使用智能自动缩进"
set smartindent
set cin
set showmatch

"在处理未保存或只读文件的时候，弹出确认" set confirm

"隐藏工具栏" set guioptions-=T

"隐藏菜单栏" set guioptions-=m

"置空错误铃声的终端代码" set vb t_vb=

"显示状态栏（默认值为 1，表示无法显示状态栏）" set laststatus=2

"状态行显示的内容" set statusline=%F%m%r%h%w\ [FORMAT=%{&ff}]\ [TYPE=%Y]\ [POS=%l,%v][%p%%]\ %{strftime(\"%d/%m/%y\ -\ %H:%M\")}

"粘贴不换行问题的解决方法" set pastetoggle=<F9>

"设置背景颜色" set background=dark

"文件类型自动检测，代码智能补全" set completeopt=longest,preview,menu

"共享剪切板" set clipboard+=unnamed

"从不备份" set nobackup / set noswapfile

"自动保存" set autowrite

"显示中文帮助"
if version >= 603
set helplang=cn
set encoding=utf-8
endif

"设置高亮相关项"

highlight Search ctermbg=black ctermfg=white guifg=white guibg=black

"""=>在 shell 脚本开头自动增加解释器以及作者等版权信息<="""
"新建.py,.cc,.sh,.java 文件，自动插入文件头"
autocmd BufNewFile _.py,_.cc,_.sh,_.java exec ":call SetTitle()"
"定义函数 SetTitle，自动插入文件头"
func SetTitle()
if expand ("%:e") == 'sh'
call setline(1, "#!/bin/bash")
call setline(2, "#Author:bert")
call setline(3, "#Blog:https://blog.51cto.com/zpf666")
call setline(4, "#Time:".strftime("%F %T"))
call setline(5, "#Name:".expand("%"))
call setline(6, "#Version:V1.0")
call setline(7, "#Description:This is a production script.")
endif
endfunc

"set whichwrap+=<,>,h,l "允许空格键和光标键跨越行边界

"highlight CursorLine cterm=NONE ctermbg=black ctermfg=green guibg=NONE guifg=NONE
"highlight CursorColumn cterm=NONE ctermbg=black ctermfg=green guibg=NONE guifg=NONE

"cterm 表示为原生 vim 设置样式，设置为 NONE 表示可以自定义设置。
"ctermbg 设置终端 vim 的背景色
"ctermfg 设置终端 vim 的前景色
"guibg 和 guifg 分别是设置 gvim 的背景色和前景色
