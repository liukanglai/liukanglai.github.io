-- keymappings [view all the defaults by pressing <leader>Lk, or :map(nmap, vmap, imap)]
-- To see if a particular key has already been bound :verbose map <TAB>
lvim.leader = "space"
-- add your own keymapping
lvim.keys.normal_mode["<leader>0"] = "$" --leaderq???
lvim.keys.normal_mode["dl"] = "d$" --leaderq???
lvim.keys.normal_mode["ga"] = "%"

lvim.keys.normal_mode["<C-s>"] = ":w<cr>"
lvim.keys.normal_mode["j"] = "<Plug>(accelerated_jk_gj)"
lvim.keys.normal_mode["k"] = "<Plug>(accelerated_jk_gk)"
lvim.keys.normal_mode["<S-l>"] = ":BufferLineCycleNext<CR>"
lvim.keys.normal_mode["<S-h>"] = ":BufferLineCyclePrev<CR>"

lvim.keys.visual_mode["t"] = ":TranslateW<CR>"
-- vim.keymap.del("n", "<C-Up>")
-- override a default keymapping
-- lvim.keys.normal_mode["<C-q>"] = ":q<cr>" -- or vim.keymap.set("n", "<C-q>", ":q<cr>" )
-- To modify LSP keybindings
-- add your own keymapping
-- lvim.lsp.buffer_mappings.normal_mode['<leader>lh'] = { vim.lsp.buf.hover, "Show documentation" }
-- r map default functionality to a different key
-- lvim.lsp.buffer_mappings.normal_mode['gk'] = lvim.lsp.buffer_mappings.normal_mode['K']
-- Remove a binding(LSP bindings take precedence over regular keybindings)
-- lvim.lsp.buffer_mappings.normal_mode['K'] = nil
-- lvim.keys.normal_mode['K'] = "<Cmd>echo Okay!<CR>"

-- Use which-key to add extra bindings with the leader-key prefix
-- lvim.builtin.which_key.mappings["P"] = { "<cmd>Telescope projects<CR>", "Projects" }
lvim.builtin.which_key.mappings["m"] = {
	name = "tool+",
	m = { "<cmd>MarkdownPreview<cr>", "markdown-preview" },
	a = { "<cmd>LLPStartPreview<cr>", "latex-preview" },
	-- t = { "viw:Translate ZH<cr>", "latex-preview" },
	-- t = { "<cmd>Translate ZH<cr>", "latex-preview" },
	t = { "<cmd>TranslateW<cr>", "translate word" }, -- C-w +p to jump between windows.
	l = { "<cmd>1TranslateW<cr>", "translate line" },
}
lvim.builtin.which_key.mappings["t"] = {
	name = "Diagnostics",
	t = { "<cmd>TroubleToggle<cr>", "trouble" },
	w = { "<cmd>TroubleToggle workspace_diagnostics<cr>", "workspace" },
	d = { "<cmd>TroubleToggle document_diagnostics<cr>", "document" },
	q = { "<cmd>TroubleToggle quickfix<cr>", "quickfix" },
	l = { "<cmd>TroubleToggle loclist<cr>", "loclist" },
	r = { "<cmd>TroubleToggle lsp_references<cr>", "references" },
	f = { "<cmd>Trouble lsp_definitions<cr>", "Definitions" },
}

lvim.builtin.which_key.mappings.l =
	vim.tbl_extend("keep", lvim.builtin.which_key.mappings.l, { o = { "<cmd>SymbolsOutline<cr>", "Open Outline" } })
lvim.builtin.which_key.mappings.s =
	vim.tbl_extend("keep", lvim.builtin.which_key.mappings.s, { n = { "<cmd>Telescope notify<cr>", "Notify" } })
lvim.builtin.which_key.mappings.d =
	vim.tbl_extend("keep", lvim.builtin.which_key.mappings.d, { l = { "<cmd>call RunCode()<cr>", "Run" } })
-- --Plugin Legendary
-- "n|<C-p>" = map_cr("Legendary"):with_silent():with_noremap(),
-- -- Plugin SnipRun
-- 	["v|<leader>r"] = map_cr("SnipRun"):with_noremap():with_silent(),
-- 	["n|<leader>r"] = map_cu([[%SnipRun]]):with_noremap():with_silent(),

--[[
--]]
vim.cmd([[
"" Compile function
func! RunCode()
  exec "w"
  if &filetype == 'c'
    set splitbelow
    exec "!gcc -g % -o %<"
    "exec "! ./%<"
    exec "!time ./%<"
    "exec "! rm %<"

  elseif &filetype == 'cpp'
    set splitbelow
    exec "!g++ -g -std=c++11 % -Wall -o %<"
    :sp
    :res -15
    :term ./%<

  elseif &filetype == 'java'
    set splitbelow
    :sp
    :res -5
    term javac % && time java %<

  elseif &filetype == 'sh'
    :!time bash %
"exec "!chmod a+x %"
"exec "!./%"

  elseif &filetype == 'python'
    set splitbelow
    :sp
    :term python3 %
    ":term
    "exec "norm A"

  elseif &filetype == 'html'
    silent! exec "!".g:mkdp_browser." % &"

  elseif &filetype == 'markdown'
    exec "InstantMarkdownPreview"

  elseif &filetype == 'tex'
    silent! exec "VimtexStop"
    silent! exec "VimtexCompile"

  elseif &filetype == 'dart'
    exec "CocCommand flutter.run -d ".g:flutter_default_device." ".g:flutter_run_args
    silent! exec "CocCommand flutter.dev.openDevLog"

  elseif &filetype == 'javascript'
    set splitbelow
    :sp
    :term export DEBUG="INFO,ERROR,WARNING"; node --trace-warnings .

  elseif &filetype == 'go'
    set splitbelow
    :sp
    :term go run .

 endif
endfunc


autocmd BufNewFile *.py,*.c,*.sh,*.java exec ":call SetTitle()"
func SetTitle()
    if expand ("%:e") == 'sh'
        call setline(1, "# !/bin/bash")
        call setline(2, "# Author:liukanglai")
        call setline(3, "# Blog:")
        call setline(4, "# Time:".strftime("%F %T"))
        call setline(5, "# Name:".expand("%"))
        call setline(6, "# Version:V1.0")
        call setline(7, "# Description:This is a production script.")
      elseif expand ("%:e") == 'c'
        call setline(1, "/******************************************************************")
        call setline(2, "** Name: ".expand("%"))
        call setline(3, "** Copyright (c) 1998-1999 *********")
        call setline(4, "** Author: liukanglai")
        call setline(5, "** Time: ".strftime("%F %T"))
        call setline(6, "** Description: ")
        call setline(7, "** Version: V1.0")
        call setline(8, "**-----------------------------------------------------------------------------")
        call setline(9, "******************************************************************/")
        call setline(10, "")
        call setline(11, "#include <stdio.h>")
        call setline(12, "")
        call setline(13, "int main(void) {")
        call setline(14, "")
        call setline(15, "return 0;")
        call setline(16, "}")
      elseif expand ("%:e") == 'py'
        call setline(1, "# !usr/bin/env python3")
        call setline(2, "# -*- coding: utf-8 -*-")
        call setline(3, "# Author:liukanglai")
        call setline(4, "# Blog:")
        call setline(5, "# Time:".strftime("%F %T"))
        call setline(6, "# Name:".expand("%"))
        call setline(7, "# Version:V1.0")
      elseif expand ("%:e") == 'java'
        call setline(1, "// Author:liukanglai")
        call setline(2, "// Blog: ")
        call setline(3, "// Time:".strftime("%F %T"))
        call setline(4, "// Name:".expand("%"))
        call setline(5, "// Version:V1.0")
    endif
endfunc
]])
