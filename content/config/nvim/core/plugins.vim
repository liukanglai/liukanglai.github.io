" neoformat
augroup fmt
  autocmd!
  autocmd BufWritePre * undojoin | Neoformat
  " autocmd BufWritePost | Neoformat
augroup END

let g:neoformat_enabled_python = ['yapf']

"let g:neoformat_cpp_clangformat = {
      "\ 'exe': 'clang-format',
      "\ 'args': ['--style="{IndentWidth: 4}"']
      "\ }
"let g:neoformat_c_clangformat = {
      "\ 'exe': 'clang-format',
      "\ 'args': ['--style="{IndentWidth: 4}"']
      "\ }

let g:neoformat_enabled_cpp = ['clangformat']
let g:neoformat_enabled_c = ['clangformat']

" latex
let g:livepreview_engine = 'xelatex'
let g:livepreview_previewer = 'okular'

" indent
let g:indentLine_enabled = 1
"let g:indentLine_char_list = ['┆']
let g:indentLine_char_list = ['¦']

"NERDTree
"autocmd VimEnter * NERDTree | wincmd p
"let NERDTreeShowBookmarks = 1
" directory
"autocmd StdinReadPre * let s:std_in=1
"autocmd VimEnter * if argc() == 1 && isdirectory(argv()[0]) && !exists('s:std_in') |
      "\ execute 'NERDTree' argv()[0] | wincmd p | enew | execute 'cd '.argv()[0] | endif
" Exit Vim if NERDTree is the only window remaining in the only tab.
"autocmd BufEnter * if tabpagenr('$') == 1 && winnr('$') == 1 && exists('b:NERDTree') && b:NERDTree.isTabTree() | quit | endif
" Open the existing NERDTree on each new tab.
"autocmd VimEnter * NERDTree | wincmd p


" lae
"let g:ale_fix_on_save = 0

""let g:ale_sign_column_always = 1
"let g:ale_sign_error = '●'
"let g:ale_sign_warning = '▶'

"let g:ale_disable_lsp = 1
""let g:airline#extensions#ale#enabled = 1

"let g:ale_completion_enable = 0

"let g:ale_set_loclist = 0
"let g:ale_set_quickfix = 1
""let g:ale_open_list = 1
""let g:ale_keep_list_window_open = 1
""let g:ale_list_window_size = 5

"" nmap <silent> <C-k> <Plug>(ale_previous_wrap)
"nmap <silent> tam <Plug>(ale_previous_wrap)
"" nmap <silent> <C-j> <Plug>(ale_next_wrap)
"nmap <silent> tan <Plug>(ale_next_wrap)
""nmap <silent> tae :ALECodeAction<CR>
""

" tree
" vimrc
let g:nvim_tree_git_hl = 1 "0 by default, will enable file highlight for git attributes (can be used without the icons).
let g:nvim_tree_highlight_opened_files = 1 "0 by default, will enable folder and file icon highlight for opened files/directories.
let g:nvim_tree_root_folder_modifier = ':~' "This is the default. See :help filename-modifiers for more options
let g:nvim_tree_add_trailing = 1 "0 by default, append a trailing slash to folder names
let g:nvim_tree_group_empty = 1 " 0 by default, compact folders that only contain a single folder into one node in the file tree
let g:nvim_tree_icon_padding = ' ' "one space by default, used for rendering the space between the icon and the filename. Use with caution, it could break rendering if you set an empty string depending on your font.
let g:nvim_tree_symlink_arrow = ' >> ' " defaults to ' ➛ '. used as a separator between symlinks' source and target.
let g:nvim_tree_respect_buf_cwd = 1 "0 by default, will change cwd of nvim-tree to that of new buffer's when opening nvim-tree.
let g:nvim_tree_create_in_closed_folder = 1 "0 by default, When creating files, sets the path of a file when cursor is on a closed folder to the parent folder when 0, and inside the folder when 1.
let g:nvim_tree_special_files = { 'README.md': 1, 'Makefile': 1, 'MAKEFILE': 1 } " List of filenames that gets highlighted with NvimTreeSpecialFile
let g:nvim_tree_show_icons = {
    \ 'git': 1,
    \ 'folders': 1,
    \ 'files': 1,
    \ 'folder_arrows': 1,
    \ }
"If 0, do not show the icons for one of 'git' 'folder' and 'files'
"1 by default, notice that if 'files' is 1, it will only display
"if nvim-web-devicons is installed and on your runtimepath.
"if folder is 1, you can also tell folder_arrows 1 to show small arrows next to the folder icons.
"but this will not work when you set renderer.indent_markers.enable (because of UI conflict)

" default will show icon by default if no icon is provided
" default shows no icon by default
let g:nvim_tree_icons = {
    \ 'default': "",
    \ 'symlink': "",
    \ 'git': {
    \   'unstaged': "✗",
    \   'staged': "✓",
    \   'unmerged': "",
    \   'renamed': "➜",
    \   'untracked': "★",
    \   'deleted': "",
    \   'ignored': "◌"
    \   },
    \ 'folder': {
    \   'arrow_open': "",
    \   'arrow_closed': "",
    \   'default': "",
    \   'open': "",
    \   'empty': "",
    \   'empty_open': "",
    \   'symlink': "",
    \   'symlink_open': "",
    \   }
    \ }

" a list of groups can be found at `:help nvim_tree_highlight`
"highlight NvimTreeFolderIcon guibg=blue
autocmd BufEnter * ++nested if winnr('$') == 1 && bufname() == 'NvimTree_' . tabpagenr() | quit | endif

" neomake
"call neomake#configure#automake('nrwi', 500)

" livedown
" should markdown preview get shown automatically upon opening markdown buffer
let g:livedown_autorun = 0

" should the browser window pop-up upon previewing
let g:livedown_open = 1

" the port on which Livedown server will run
let g:livedown_port = 1337

" the browser to use, can also be firefox, chrome or other, depending on your executable
let g:livedown_browser = "google-chrome"

" Copilot
imap <silent><script><expr> <C-l> copilot#Accept("\<CR>")
let g:copilot_no_tab_map = v:true
