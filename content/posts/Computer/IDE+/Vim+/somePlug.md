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
---# YouCompleteMe

        nnoremap <leader>gl :YcmCompleter GoToDeclaration<CR>
        nnoremap <leader>gf :YcmCompleter GoToDefinition<CR>
        nnoremap <leader>gi :YcmCompleter GoToDefinitionElseDeclaration<CR>

        set completeopt=menu,menuone
        let g:ycm_add_preview_to_completeopt = 0
        let g:ycm_show_diagnostics_ui = 0
        let g:ycm_server_log_level = 'info'
        let g:ycm_min_num_identifier_candidate_chars = 2
        let g:ycm_collect_identifiers_from_comments_and_strings = 1
        let g:ycm_complete_in_strings=1
        let g:ycm_key_invoke_completion = '<c-z>'
        noremap <c-z> <NOP>

> `https://zhuanlan.zhihu.com/p/33046090`

        vim中输入:echo has('python') || has('python3')   - if return 1,show right
        vim --version | grep python(shoule be +, if -, than compile vim)
        Install cmake python clang boost llvm-libs llvm
        Plug 'Valloric/YouCompleteMe', {'do': './install.py'}
        cd .vim/plugged/YouCompleteMe
        sudo python3 install.py --clangd-completer (all)

        let g:ycm_min_num_identifier_candidate_chars = 2
        let g:ycm_semantic_triggers =  {
    		                          \ 'c,cpp,python,java,go,erlang,perl': ['re!\w{2}'],
    		                          \ 'cs,lua,javascript': ['re!\w{2}'],
    		                          \ }

- 如果你和我一样想把它改成上面比较素雅的灰色的话，可以自己定义 highlight：https://jonasjacek.github.io/colors/(auto)

        highlight PMenu ctermfg=0 ctermbg=242 guifg=black guibg=darkgrey
        highlight PMenuSel ctermfg=242 ctermbg=8 guifg=darkgrey guibg=black

- 我不喜欢 YCM 自动弹出函数原型预览窗口，它搞乱我的布局，我有其他方法查看函数的原型，如果你和我一样想关闭该功能的话，增加两行配置：

        set completeopt=menu,menuone
        let g:ycm_add_preview_to_completeopt = 0

- YCM 默认会显示诊断信息，语言标注出来你代码问题, 屏蔽: 这样你可以用其他插件来完成自动/非自动代码静态检查

        let g:ycm_show_diagnostics_ui = 0

- 最后建议设置一下：g:ycm_filetype_whitelist 这个白名单，避免编辑白名单外的文件类型时 YCM 也在那分析半天，比如你打开个 1MB 的 TXT 文件，YCM 还要再那里空跑半天就傻了：

        let g:ycm_filetype_whitelist = {
        			\ "c":1,
        			\ "cpp":1,
        			\ "objc":1,
        			\ "sh":1,
        			\ "zsh":1,
        			\ "zimbu":1,
        			\ "markdown":1,
        			\ }

# coc.nvim

- nodejs(npm) neovim yarn?
- plug '...'
- checkhealth/ CocInfo

- CocInstall
- CocUninstall
- CocList extensions //tab
- file coc-settings.json
- :CocConfig

# ale

- :ALEFixSuggest
- :lopen to open
- :ALEToggle to open and close
- :ALEGoToDefinition 跳转定义
- :ALEFindReferences 查找定义的引用

        "let g:ale_linters = {
        "\    'javascript': ['eslint'],
        "\    'css': ['stylelint'],
        "\ 'cpp': ['clang'],
        "\ 'c': ['clang'],
        "\ 'python': ['pylint'],
        "\}

        "let g:ale_fixers = {
        \   '*': ['remove_trailing_lines', 'trim_whitespace'],
        "\   'javascript': ['eslint'],
        "\   'css': ['stylelint'],
        "\   'c': ['clang-format'],
        "\}

        let g:ale_fix_on_save = 0

        "let g:ale_sign_column_always = 1
        let g:ale_sign_error = '●'
        let g:ale_sign_warning = '▶'

        let g:ale_disable_lsp = 1
        let g:airline#extensions#ale#enabled = 1

        let g:ale_completion_enable = 1

        let g:ale_set_loclist = 0
        let g:ale_set_quickfix = 1
        "let g:ale_open_list = 1
        "let g:ale_keep_list_window_open = 1
        "let g:ale_list_window_size = 5

        " nmap <silent> <C-k> <Plug>(ale_previous_wrap)
        nmap <silent> tam <Plug>(ale_previous_wrap)
        " nmap <silent> <C-j> <Plug>(ale_next_wrap)
        nmap <silent> tan <Plug>(ale_next_wrap)

" code

" gutentags 搜索工程目录的标志，碰到这些文件/目录名就停止向上一级目录递归 "
" let g:gutentags_project_root = ['.root', '.svn', '.git', '.project']
" 所生成的数据文件的名称 "
" let g:gutentags_ctags_tagfile = '.tags'
" 将自动生成的 tags 文件全部放入 ~/.cache/tags 目录中，避免污染工程目录 "
" let s:vim_tags = expand('~/.cache/tags')
" let g:gutentags_cache_dir = s:vim_tags
" 检测 ~/.cache/tags 不存在就新建 "
" if !isdirectory(s:vim_tags)
" silent! call mkdir(s:vim_tags, 'p')
" endif
" 配置 ctags 的参数 "
" let g:gutentags_ctags_extra_args = ['--fields=+niazS', '--extra=+q']
" let g:gutentags_ctags_extra_args += ['--c++-kinds=+pxI']
" let g:gutentags_ctags_extra_args += ['--c-kinds=+px']
