" set config
"runtime ./vimrc.vim

" plugins
"runtime ./lua/plugins.lua
lua require('lua-init')

"packloadall
"lua require('config/treesitter')

"{ Main configurations
let g:config_files = [
      \ 'vimrc.vim',
      \ 'map.vim',
      \ 'color.vim',
      \ 'plugins.vim'
      \ ]

" ???
for s:fname in g:config_files
  execute printf('source %s/core/%s', stdpath('config'), s:fname)
endfor
"}
