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

在 Lightline 里显示警告和错误的数量

不要和 ALE 打架，让 ALE 负责其他格式文件的 linting，上面提到的语言则让 YCM 完成

给跳转设置按键

改善生活的细节设置

Arch 仓库里和 Homebrew 里的包名都叫做 ccls。

安装好后需要设置 YCM，在 vimrc 中设置 LSP：

      let g:ycm_language_server =
                  \[
                  \   {
                  \       'name': 'ccls',
                  \       'cmdline': ['ccls'],
                  \       'filetypes': ['c', 'cpp', 'objc', 'objcpp'],
                  \       'project_root_files': ['.ccls-root', 'compile_commands.json']
                  \   },
                  \]

ccls 完成！

- 开玩笑，ccls 和 C 系项目的配合参见 ccls wiki，主要内容就是如何填写或让你的 项目产生上面写到的 .ccls-root、compile_commands.json 文件。不过此时直接打开 单个 c 文件已经有基本的补全和提示了，说完成也八九不离十了吧。

- 另外如果你的 ccls 不在 PATH 里，比如你直接从 GitHub 上下载了二进制，上面的 cmdline 配置里需要写上完整的路径。当然最好还是直接放进 PATH 里啦。

- 三种 lsp：clangd, ccls, cquery。这里说明如何使用 ccls 补全。

- ccls 是 lsp(language server Protocal)（语言补全协议）中的一个，用于补全 C/C++

ccls 官方提供了很多方法，这里我说明如何使在 coc.nvim 中进行补全。
打开 VIM，输入:CocConfig 后回车可打开 coc 的配置文件，然后输入:

        {
          "languageserver": {
            "ccls": {
              "command": "ccls",
              "filetypes": ["c", "cpp", "cuda", "objc", "objcpp"],
              "rootPatterns": [".ccls-root", "compile_commands.json"],
              "initializationOptions": {
                "cache": {
                  "directory": ".ccls-cache"
                },
                "client": {
                  "snippetSupport": true
                }
              }
            }
          }
        }

> 在函数或变量上按 shift+K 可以显示函数或变量的原型。

- find head

如果你的程序足够小，可以通过在工程根目录下编写.ccls 文件来让 ccls 找到自己的头文件。
.ccls 中的每一行都是一个编译指令:

        -Iinclude
        -std=c++11

但是注意不能够在里面使用 执行命令。
然后每次打开 vim，ccls 都会检车这个文件，并且根据这个文件进行补全配置。

- 在 MacOS 下，ccls 没办法找到系统头文件，这个时候你必须自己编写.ccls 文件，在文件中加入如下内容帮助 ccls 找到头文件:

        -isystem
        /usr/local/include
        -isystem
        /Applications/Xcode.app/Contents/Developer/Toolchains/XcodeDefault.xctoolchain/usr/include/c++/v1
        -isystem
        /Applications/Xcode.app/Contents/Developer/Toolchains/XcodeDefault.xctoolchain/usr/lib/clang/10.0.1/include
        -isystem
        /Applications/Xcode.app/Contents/Developer/Toolchains/XcodeDefault.xctoolchain/usr/include
        -isystem
        /Applications/Xcode.app/Contents/Developer/Platforms/MacOSX.platform/Developer/SDKs/MacOSX10.14.sdk/usr/include

- 工程的情况下使用 compile_commands.json
  如果你使用的是大工程的话，可以考虑编写 compile_commands.json 文件：

          [
              {
              "arguments": ["c++", "-Iinclude", "-std=c++11", "main.cpp"],
              "file": "main.cpp"
              }
          ]

arguments 通过将编译指令各个部分拆开称数组。
file 则指定了你要编译的文件。 但是每次都编写 compile_commands.json 也很烦，有一些工具可以帮助你自动生成。

- CMake

        如果你使用的是CMake，可以加上构建选项-DCMAKE_EXPORT_COMPILE_COMMANDS=YES让cmkae自动生成。

- bear
  bear 可以根据多个构建工具来帮助你生成，如果你使用的是 make，那么可以使用: bear make 来自动生成。

#

# history

作者：知乎用户
链接：https://www.zhihu.com/question/489147609/answer/2182313621
来源：知乎

- 编辑器之战再起波澜老故事自从 2015 年 11 月 neovim 横空出世，让沉寂很久的编辑器之战掀起波澜，只是这次是 vim 内部之间的战争，那就是从 vim 内部分裂出去的 neovim。随着 neovim 的一个又一个新特性推出，比如，内嵌终端，悬浮窗口，多线程异步 IO，立刻将一大部分原来的 vim 用户吸引过去，而代表老一派的 vim 作者也不放弃，立马跟进，neovim 有的，我 vim 也有而且做得更好，更稳定。这段时间，两者特性更新都很快，随着新特性而来的是如雨后春笋般出现的新插件们，插件作者们看到让 vim 接近 emacs 的机会，都说 emacs 是操作系统，现在 vim & neovim 有了这么多牛逼特性，vim 可以多线程异步执行任务了，vim 可以内嵌终端了，vim 可以悬浮窗口，vim & neovim 可以玩游戏了......这让 vim & neovim 看起来更像一个现代的编辑器，但是依旧保留了它的优点。这段时间，有些脸皮厚像我，也开始晒配置了。还出现了 space-vim 和 SpaceVim 这样的配置之争，两者几乎同时出现（前者早几个星期），他们都想模仿著名的 emacs 配置框架 Spacemacs。也几乎在同时，我也产生了同样的想法，希望我的配置是可方便裁剪，集成尽可能多功能，快捷键也是以 Space 开始，不一样的是，我希望界面上尽可能低调，功能牛逼.....我是一个 vim 支持者，同样情况下 vim 能兼容更多环境，而且 vim 该有的功能都有，neovim 刚起步比 vim 不稳定些。好在两者在大部分情况下，一份配置是能互相兼容的，偶尔想玩下新特性就切换到 neovim。往事不提也罢....沉寂期逐渐 vim 和 neovim 的开发速度放下来了，从我的角度来看，两者都向着一个大方向前进，那就是内嵌速度更快更灵活的编程语言来配置 vim & neovim。所以两个项目都进入漫长的开发期。以前的我，几乎隔几天就更新一下 vim，现在我停止更新了，因为会带来各种兼容性问题和不稳定。由于 neovim 也陷入了长期新特性的开发，所以我有好一段时间没有更新编辑器也没有更新我的配置，而是专心代码了。这段时间大概维持了有接近两年。再起波澜 vim 朝着 vim9 的方向出发，目标是开发一种更快的 vim 脚本。目前的进度根据 bram 本人说可能还需要“a few month"。neovim 这段时间朝着下面三个方向前进：以 lua 为第一配置编程语言。Lua 是一种轻量小巧的脚本语言，用标准 C 语言编写并以源代码形式开放， 其设计目的是为了嵌入应用程序中，从而为应用程序提供灵活的扩展和定制功能。Lua 是巴西里约热内卢天主教大学（Pontifical Catholic University of Rio de Janeiro）里的一个研究小组于 1993 年开发的。支持 Language server protocol (LSP)。LSP 是一种被用于编辑器或集成开发环境 与 支持比如自动补全，定义跳转，查找所有引用等语言特性的语言服务器之间的一种协议支持 Treesitter。它是一个语法解析工具库。目标是足够快并且支持绝大部分编程语言而且可灵活嵌入到任何应用中。neovim 再次掀起了编辑器之战的波澜，neovim 0.5 率先发布，实现了上面三个特性。这个版本的发布带起一阵学习 lua 的旋风，也让更多的人第一次知道了 LSP 和 Treesitter。用普通人能听懂的话来总结这次更新就是：neovim 配置更灵活，扩展更方便。启动更快。neovim 配置更灵活，扩展更方便。启动更快。补全跳转更智能，速度更快，支持更多的编程语言，只要 LSP 支持的，neovim 都支持。语法高亮渲染更快速了更准确，再也不会看到白茫茫一片的代码了。如何配置 lua 写的 neovim 插件作为使用者，我们其实也没必要为了 neovim 的新特性将配置全部改成 lua，neovim 的兼容性还是很好的。我想保持兼容性的前提又用上 neovim 的新特性，只需要在原来的配置上做一些小小的区分，以及知道 lua 的基本语法就行。第一步根据 neovim 版本来区别配置：

        function! te#env#IsNvim() abort
        if has('nvim')
        let v = api_info().version
        return v.major + v.minor/10.0 + v.patch / 100.0
        endif
        return 0

- endfunction 如上面函数，该函数返回 neovim 的版本或者 0（表示不是 neovim)。当版本号大于等于 0.5 时，我们就可以在 vim 脚本里面（我们的配置）加上一些必要的 lua 插件及其配置，当然我们加载插件还是用我们喜欢的插件管理器：

        Plug 'hrsh7th/nvim-cmp', {'branch': 'main' }
        lua << EOF
        require('nvim_cmp')
        EOF

- 现在 neovim 的用 lua 写的插件只支持用 lua 配置，我们可以通过上面这样的语法将 lua 代码嵌入到 vim 脚本里面，当然在 vim 脚本里面插入太多 lua 代码不是一件明智的做法，所以我们这里只是简单的进行 require，而把所有细节都放在 lua/nvim_cmp.lua 文件中。这里要说明的是 neovim 会自动在 lua 文件夹下找对应的 lua 模块，在你的 init.vim 所在目录下创建一个 lua 文件夹即可，下面是我的配置的目录结构。.

  ├── after
  │ └── ftplugin
  ├── autoload
  │ └── te
  │ ├── ctrlp
  │ ├── fzf
  │ └── leaderf
  ├── bin
  ├── bundle
  ├── lua
  ├── rc
  ├── init.vim
  └── vimrc

- 必装插件首先基于 LSP 特性的补全插件，这里首推 nvim-cmp，及其众多 source 插件。其中 nvim-lspconfig 是官方的 lsp 接口插件是 nvim-cmp 依赖的。

        Plug 'hrsh7th/cmp-nvim-lsp', {'branch': 'main' }
        Plug 'hrsh7th/cmp-buffer', {'branch': 'main' }
        Plug 'hrsh7th/nvim-cmp', {'branch': 'main' }
        Plug 'hrsh7th/cmp-path', {'branch': 'main' }
        Plug 'hrsh7th/cmp-nvim-lua',{'branch': 'main'}
        Plug 'quangnguyen30192/cmp-nvim-ultisnips', {'branch': 'main' }
        Plug 'octaltree/cmp-look'
        Plug 'neovim/nvim-lspconfig'

- lsp 服务端下载插件：nvim-lspinstall 或者 nvim-lsp-installer，它们可以帮助我快速安装对应编程语言的 LSP 服务端程序。
- 最后就是 treesitter 插件了：nvim-treesitter 还有许多看起来很炫目的插件实际上不是必要的，旧插件早就实现了相同功能。

- 前面的补全插件配好以后，需要在插入模式按 ctrl-x ctrl-o 才能触发补全。不如 IDE 方便。那能不能支持自动触发呢？能，但要安装新的插件。在这里我推荐使用 cmp，也是 lua 开发的，非常快

- My bad, had an old vls binary in /usr/local/bin which was being picked up :( Sorry for the noise, it all works fine with the latest vls.
