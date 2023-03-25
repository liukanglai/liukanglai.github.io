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
---# easy operation

[[ 跳转到代码块的开头去(但要求代码块中'{'必须单独占一行)

- gD 跳转到局部变量的定义处

## easymotion

- <Leader><Leader>+w b e ge/tT/fF/kj/nN to start
- good operation

        _/$ {/} % zz/zt/zb

        f+
        vi"
        */#
        c-o/c-i/''
        cc
        mx/'x
        :Ex
        >> <<  缩进

# g

- gj gk: for long sentence
- gh: select mode???
- gf: go to file
- gd: like \*, #

# 移动光标（普通模式下）

- h j k l
- ctr+f(b,d,u) (翻页)
- 行： 0 _ (行首) ^(移动到本行的第一个不是 blank 字符) $(行尾) g_ （移动到本行最后一个不是 blank 字符的位置）
- ( 上一个句子， ) 下一个句子
- { 上一段， } 下一段
- 词： w （下一个单词的开头） e (结尾) b（上头）/ge W E B(广义单词，空格)
  > 狭义单词由数字，字母，下划线组成，广义单词除空白字符外所有字符组成。
- 行内查找： f nf（第 n 个） F（反向查找）nF t （移动光标至字符的前一个字符）nt /T

  > ; 和, 当使用 f, F, t ,T, 关键字指定字符跳转的时候，使用 ；可以快速跳转到下一个指定的字符，, 是跳到前一个指定的字符

- % 匹配括号移动，包括 ( , { , [ 光标 on it.
- 全文: gg G nG （n 行的行首）
- 页: H M L zt (把当前行移动到当前屏幕的最上方) zz (中间) zb (尾部???)
- \*（或 g*) 和 # 匹配光标当前所在的单词，移动光标到下一个（或者上一个）匹配的单词（ * 是下一个，# 是上一个）

# 返回回撤

- 光标返回： ctr+o(ctr+i 反) /‘’

> ^M 是 Ctrl + v + m 打出来的（按下这三个键，VIM 会显示成 ^M ）,^M 代表快捷键是 Ctrl + m ,

# 编辑

- 进入插入模式： i a I A s(删除字符后进入, ns) gi(上一次插入)
- delete: x
- o O(行插入)
- 行合并： J
- r(替换一个) R(依次替换) c(删除字符后插入，cc/S（一行, 会保持前一行的缩进）！！！) C(到尾) :help vreplace-mode

  > cw (use :help text-objects)
  > ciw ci( ci" ci( ci"
  > caw ...
  > w 表示词/W, s 表示句子，p 表示段落，t 表示 HTML/XML 标签

- d(dd ndd d4l db dW) y p/P

  > yi" yi(
  > yf...

- 撤销： u ctr+r（反撤销）
- ~: 将光标下的字母改变大小写(n~)
- g~\~: 改变当前行字母的大小写
- gUU 将当前行的字母改成大写 gUw(词) guu 小写 guw

# Mark

- mx 设置书签,x 只能是 a-z 的 26 个字母 a-zA-Z 是创建标记的名字，小写字母用来创建单个文件的标记，大些字母用来创建文件之间的标记。
- \`x 跳转到书签处("\`"是 1 左边的键) \`撇号通常用来定位到之前光标所在的位置 ‘单引号通常用来定位到标记所在的行
- :marks 显示所有的标记
- :delmarks 删除指定的标记
- :delmarks! 删除所有标记（大些字母的标记除外)

# 可视模式

- v/V
- :normal command (ps: isome)
- ctr+v no need, then :norm $cw..
- o to move

# 注释

- "
- <space>cc //nerdcommenter

# 插入模式

- ctr+p/n:补全
- c-o: go into normal, than return

# 命令模式 (ex 模式 Q into（无）)

- shift+k: can find a function in man
- . 该命令是重复上一个操作的命令 (n.)
- :3 (行号) :+3
- :ab email kickcodeman@gmail.com, ab 是关键字 ,该命令执行后，然后切换到编辑模式下,输入 email 会把输入的 email 自动替换成 kickcodeman@gmail.com。这个命令主要是处理频繁输入同样的长串字符串
- :Set spell (拼写检查)

- c-p/c-n: 相当 ↑↓
- c-b/c-e：命令开头，结尾
- c+↑↓
- c-f: look history, c-c to edit
  > :help comdline-editing

> ctr+x+s 匹配
> z= 在词处显示提示词
> :
> 注释:s#^#//#g
> 删除空行
> 命令模式下 g/^$/d，前面 g 命令是扩展到全局，中间是匹配空行，后面 d 命令是执行删除动作。用替换也可以实现，键入 %s#^\n##g，意思是把所有以换行开头的行全部替换为空。类似地，如果要把多个空行转换为一个可以输入 g/^\n$/d 或者 %s#^\n$##g

- :color (default)

# terminal mode

- :! :后面紧跟着!，!后面紧跟着 linux 命令（command 指操作 Linux 系统的一系列命令，如创建文件，新建文件夹，查询文件的属性的等
- 保存: `:w !sudo tee % `
- :terminal(term) :vert term(vsplit)
- :term ls
  " Navigate windows with <Ctrl-hjkl> in terminal job mode.
  tnoremap <c-j> <c-w><c-j>
  tnoremap <c-k> <c-w><c-k>
  tnoremap <c-l> <c-w><c-l>
  tnoremap <c-h> <c-w><c-h>

... don't know

- c-w+n: enter terminal-normal(i, a... will into work)
- c-w+": 寄存器
- c-w,c-c...

# 替换

- substitute
- g: 行，
- %：全行第一个
- $: last line,
- 结合可视模式

> :help cmdline-ranges

- s/zempty/handsome/g (行 zempty 替换成 handsome) (no g, replace next)
- %s/zempty/handsome/g (全文)
- n1,n2s/zempty/handsome/g (n1 到 n2 行)
- 12;$s/zempty/handsome/g (12 行到最后一行)
- 12;/dog/s/zempty/handsome/g (12 行开始搜索到有 dog 的行, 其间替换)

- 只匹配 s，no ss: /\\<s\\> to search

- i 表示大小写不敏感查找，I 表示大小写敏感：
- %s/zempty/handsome/i 替换掉所有行第一个出现 zempty (不区分大小写) 为 handsome 。
- %s/zempty/handsome/gi 替换掉所有行出现 zempty (不区分大小写) 为 handsome
- c 表示需要确认 e 表示不显示错误

# 搜索:

- /(front): n(next) N(before)
- ?(back)
- set hlsearch set incsearch(未输入完就跳转)
- :noh (no hlsearch)

1. 跨文件

- :grep // great tool
- :vimgrep(:vim grep main _\*/_.py) then, :cn, :cp to move, :copen will open all

2. ack

- sudo apt-get install ack-grep // linux use ack
- ack.vim
- :ack --file what
