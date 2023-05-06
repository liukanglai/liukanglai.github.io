--[[
 THESE ARE EXAMPLE CONFIGS FEEL FREE TO CHANGE TO WHATEVER YOU WANT
 `lvim` is the global options object
]]
-- vim options
vim.opt.clipboard = "unnamedplus"          -- allows neovim to access the system clipboard
vim.opt.cmdheight = 2                      -- more space in the neovim command line for displaying messages
vim.opt.colorcolumn = "99999"              -- fixes indentline for now
vim.opt.completeopt = { "menuone", "noselect" }
vim.opt.conceallevel = 0                   -- so that `` is visible in markdown files
vim.opt.fileencoding = "utf-8"             -- the encoding written to a file
vim.opt.foldmethod = "manual"              -- folding set to "expr" for treesitter based folding
vim.opt.foldexpr = ""                      -- set to "nvim_treesitter#foldexpr()" for treesitter based folding
vim.opt.guifont = "monospace:h17"          -- the font used in graphical neovim applications
vim.opt.hidden = true                      -- required to keep multiple buffers and open multiple buffers
vim.opt.hlsearch = true                    -- highlight all matches on previous search pattern
vim.opt.ignorecase = true                  -- ignore case in search patterns
-- vim.opt.mouse = "a" -- allow the mouse to be used in neovim
vim.opt.pumheight = 10                     -- pop up menu height
vim.opt.showmode = false                   -- we don't need to see things like -- INSERT -- anymore
vim.opt.showtabline = 2                    -- always show tabs
vim.opt.smartcase = true                   -- smart case
vim.opt.smartindent = true                 -- make indenting smarter again
vim.opt.splitbelow = true                  -- force all horizontal splits to go below current window
vim.opt.splitright = true                  -- force all vertical splits to go to the right of current window
vim.opt.swapfile = false                   -- creates a swapfile
vim.opt.termguicolors = true               -- set term gui colors (most terminals support this)
vim.opt.title = true                       -- set the title of window to the value of the titlestring
vim.opt.titlestring = "%<%F%=%l/%L - nvim" -- what the title of the window will be set to
vim.opt.undodir = vim.fn.stdpath("cache") .. "/undo"
vim.opt.undofile = true                    -- enable persistent undo
vim.opt.writebackup = false                -- if a file is being edited by another program (or was written to file while editing with another program) it is not allowed to be edited
vim.opt.expandtab = true                   -- convert tabs to spaces
vim.opt.shiftwidth = 2                     -- the number of spaces inserted for each indentation
vim.opt.tabstop = 2                        -- insert 2 spaces for a tab
vim.opt.cursorline = true                  -- highlight the current line
vim.opt.number = true                      -- set numbered lines
vim.opt.relativenumber = true              -- set relative numbered lines
vim.opt.numberwidth = 4                    -- set number column width to 2 {default 4}
vim.opt.signcolumn = "yes"                 -- always show the sign column otherwise it would shift the text each time
vim.opt.wrap = true                        -- display lines as one long line
vim.opt.spell = false
vim.opt.spelllang = "en"
vim.opt.scrolloff = 5 -- is one of my fav
vim.opt.sidescrolloff = 5

vim.opt.errorbells = true
vim.opt.visualbell = true
vim.opt.fileformats = "unix,mac,dos"
vim.opt.magic = true
vim.opt.virtualedit = "block"
vim.opt.wildignorecase = true
vim.opt.wildignore =
".git,.hg,.svn,*.pyc,*.o,*.out,*.jpg,*.jpeg,*.png,*.gif,*.zip,**/tmp/**,*.DS_Store,**/node_modules/**,**/bower_modules/**"
vim.opt.history = 2000
vim.opt.shada = "!,'300,<50,@100,s10,h"
vim.opt.smarttab = true
vim.opt.shiftround = true
vim.opt.timeout = true
vim.opt.ttimeout = true
-- You will feel delay when you input <Space> at lazygit interface if you set it a positive value like 300(ms)
vim.opt.timeoutlen = 0
vim.opt.ttimeoutlen = 0
vim.opt.updatetime = 100
vim.opt.redrawtime = 1500
vim.opt.infercase = true
vim.opt.incsearch = true
vim.opt.wrapscan = true
vim.opt.complete = ".,w,b,k"
vim.opt.inccommand = "nosplit"
vim.opt.grepformat = "%f:%l:%c:%m"
vim.opt.grepprg = "rg --hidden --vimgrep --smart-case --"
vim.opt.breakat = [[\ \	;:,!?]]
vim.opt.startofline = false
vim.opt.whichwrap = "h,l,<,>,[,],~"
vim.opt.switchbuf = "useopen"
vim.opt.backspace = "indent,eol,start"
vim.opt.diffopt = "filler,iwhite,internal,algorithm:patience"
vim.opt.jumpoptions = "stack"
vim.opt.shortmess = "aoOTIcF"
vim.opt.foldlevelstart = 99
vim.opt.ruler = true
vim.opt.cursorcolumn = true
vim.opt.list = true
vim.opt.winwidth = 30
vim.opt.winminwidth = 10
vim.opt.helpheight = 12
vim.opt.previewheight = 12
vim.opt.showcmd = true
vim.opt.cmdwinheight = 5
vim.opt.equalalways = false
vim.opt.laststatus = 2
vim.opt.display = "lastline"
vim.opt.showbreak = "↳  "
vim.opt.listchars = "tab:»·,nbsp:+,trail:·,extends:→,precedes:←"
vim.opt.autoread = true
vim.opt.autowrite = true

vim.opt.synmaxcol = 2500
vim.opt.formatoptions = "1jcroql"
vim.opt.autoindent = true
--vim.opt.tabstop = 4
--vim.opt.shiftwidth = 4
--vim.opt.softtabstop = 4
vim.opt.breakindentopt = "shift:2,min:20"
vim.opt.linebreak = true
vim.opt.foldenable = true
vim.opt.concealcursor = "niv"

vim.cmd([[
let fcitx5state=system("fcitx5-remote")
autocmd InsertLeave * :silent let fcitx5state=system("fcitx5-remote")[0] | silent !fcitx5-remote -c
autocmd InsertEnter * :silent if fcitx5state == 2 | call system("fcitx5-remote -o") | endif
]])
-- You will likely want to reduce updatetime which affects CursorHold
-- note: this setting is global and should be set only once
vim.o.updatetime = 250
lvim.lsp.diagnostics.underline = false
lvim.lsp.diagnostics.virtual_text = false
-- vim.cmd [[autocmd! CursorHold,CursorHoldI * lua vim.diagnostic.open_float(nil, {focus=false})]]

-- general
lvim.log.level = "info"
lvim.format_on_save = {
  enabled = true,
  -- pattern = "*.lua",
  timeout = 1000,
}
-- to disable icons and use a minimalist setup, uncomment the following
-- lvim.use_icons = false

-- keymappings <https://www.lunarvim.org/docs/configuration/keybindings>
lvim.leader = "space"
-- add your own keymapping
lvim.keys.normal_mode["<C-s>"] = ":w<cr>"
lvim.keys.normal_mode["<leader>0"] = "$" --leaderq???
lvim.keys.normal_mode["dl"] = "d$"       --leaderq???
lvim.keys.normal_mode["ga"] = "%"
lvim.keys.normal_mode["T"] = "q"
lvim.keys.normal_mode["q"] = ":q<cr>"
lvim.keys.normal_mode["j"] = "<Plug>(accelerated_jk_gj)"
lvim.keys.normal_mode["k"] = "<Plug>(accelerated_jk_gk)"
lvim.keys.normal_mode["<S-l>"] = ":BufferLineCycleNext<CR>"
lvim.keys.normal_mode["<S-h>"] = ":BufferLineCyclePrev<CR>"

lvim.keys.visual_mode["t"] = ":TranslateW<CR>"

-- -- Use which-key to add extra bindings with the leader-key prefix
-- lvim.builtin.which_key.mappings["W"] = { "<cmd>noautocmd w<cr>", "Save without formatting" }
-- lvim.builtin.which_key.mappings["P"] = { "<cmd>Telescope projects<CR>", "Projects" }
lvim.builtin.which_key.mappings["m"] = {
  name = "tool+",
  m = { "<cmd>MarkdownPreview<cr>", "markdown-preview" },
  h = { ": w | !xdg-open %<cr>", "html-preview" },
  a = { "<cmd>LLPStartPreview<cr>", "latex-preview" },
  -- t = { "viw:Translate ZH<cr>", "latex-preview" },
  -- t = { "<cmd>Translate ZH<cr>", "latex-preview" },
  t = { "<cmd>TranslateW<cr>", "translate word" }, -- C-w +p to jump between windows.
  l = { "<cmd>1TranslateW<cr>", "translate line" },
  w = { "<cmd>WakaTimeToday<cr>", "WakaTimeToday" },
  d = { "<cmd>TodoQuickFix<cr>", "Todo" },
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
lvim.builtin.which_key.mappings.s =
    vim.tbl_extend("keep", lvim.builtin.which_key.mappings.s, { d = { "<cmd>TodoTelescope<cr>", "Todo" } })
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
    exec "!g++ -g % -o %<"
    exec "!time ./%<"
    ":term ./%<
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
 endif
endfunc
]])
vim.cmd(
  [[
  if has("autocmd")
  " When editing a file, always jump to the last known cursor position.
  " Don't do it for commit messages, when the position is invalid, or when
  " inside an event handler (happens when dropping a file on gvim).
  autocmd BufReadPost *
    \ if line("'\"") > 1 && line("'\"") <= line("$") |
    \   exe "normal! g`\"" |
    \ endif
endif
  ]]
)

-- -- Change theme settings
-- lvim.colorscheme = "gruvbox-material"

lvim.builtin.alpha.active = true
lvim.builtin.alpha.mode = "dashboard"
lvim.builtin.terminal.active = true
lvim.builtin.nvimtree.setup.view.side = "left"
lvim.builtin.nvimtree.setup.renderer.icons.show.git = false
lvim.builtin.dap.active = true
lvim.builtin.terminal.open_mapping = "<c-t>"

-- Automatically install missing parsers when entering buffer
lvim.builtin.treesitter.auto_install = true
lvim.builtin.treesitter.rainbow.enable = true
lvim.builtin.treesitter.matchup.enable = true -- for vim-matchup

-- lvim.builtin.treesitter.ignore_install = { "haskell" }

-- -- always installed on startup, useful for parsers without a strict filetype
-- lvim.builtin.treesitter.ensure_installed = { "comment", "markdown_inline", "regex" }

-- -- generic LSP settings <https://www.lunarvim.org/docs/languages#lsp-support>

-- --- disable automatic installation of servers
-- lvim.lsp.installer.setup.automatic_installation = false

-- ---configure a server manually. IMPORTANT: Requires `:LvimCacheReset` to take effect
-- ---see the full default list `:lua =lvim.lsp.automatic_configuration.skipped_servers`
-- vim.list_extend(lvim.lsp.automatic_configuration.skipped_servers, { "pyright" })
-- local opts = {} -- check the lspconfig documentation for a list of all possible options
-- require("lvim.lsp.manager").setup("pyright", opts)

-- vim.list_extend(lvim.lsp.automatic_configuration.skipped_servers, { "clangd" })
-- local capabilities = require("lvim.lsp").common_capabilities()
-- capabilities.offsetEncoding = { "utf-16" }
-- local opts = { capabilities = capabilities }
-- require("lvim.lsp.manager").setup("clangd", opts)

-- ---remove a server from the skipped list, e.g. eslint, or emmet_ls. IMPORTANT: Requires `:LvimCacheReset` to take effect
-- ---`:LvimInfo` lists which server(s) are skipped for the current filetype
-- lvim.lsp.automatic_configuration.skipped_servers = vim.tbl_filter(function(server)
--   return server ~= "emmet_ls"
-- end, lvim.lsp.automatic_configuration.skipped_servers)

-- -- you can set a custom on_attach function that will be used for all the language servers
-- -- See <https://github.com/neovim/nvim-lspconfig#keybindings-and-completion>
-- lvim.lsp.on_attach_callback = function(client, bufnr)
--   local function buf_set_option(...)
--     vim.api.nvim_buf_set_option(bufnr, ...)
--   end
--   --Enable completion triggered by <c-x><c-o>
--   buf_set_option("omnifunc", "v:lua.vim.lsp.omnifunc")
-- end

-- table.insert(lvim.builtin.cmp.sources, 1, { name = "nvim_lua" })
-- -- table.insert(lvim.builtin.cmp.sources, 2, { name = "spell" })
-- table.insert(lvim.builtin.cmp.sources, 1, { name = "tmux" })
-- table.insert(lvim.builtin.cmp.sources, 4, { name = "latex_symbols" })

-- linters and formatters <https://www.lunarvim.org/docs/languages#lintingformatting>
local formatters = require("lvim.lsp.null-ls.formatters")
formatters.setup({
  { command = "black", filetypes = { "python" } },
  -- { command = "isort", filetypes = { "python" } },
  -- { command = "stylua", filetypes = { "lua" } },
  { command = "shfmt" },
  -- { command = "google-java-format", filetypes = { "java" } },
  {
    command = "prettier",
    extra_args = { "--print-width", "100" },
    -- filetypes = { "typescript", "typescriptreact" },
  },
})
local linters = require("lvim.lsp.null-ls.linters")
linters.setup({
  -- { command = "flake8", filetypes = { "python" } },
  { command = "shellcheck",   args = { "--severity", "warning" } },
  { command = "codespell",    filetypes = { "javascript", "python" } },
  -- {
  -- 	command = "cpplint",
  -- 	filetype = { "c", "cpp" }, -- extra_args = { "--style", "{IndentWidth: 4}" }
  -- }, -- clangtidy is better.
  { command = "cppcheck",     filetype = { "c", "cpp" } },
  { command = "cpplint",      filetype = { "c", "cpp" } },
  -- { command = "checkmake", filetype = { "make" } },
  -- { command = "checkstyle", filetype = { "java" } },
  { command = "pylint",       filetype = { "python" } },
  -- { command = "eslint",       filetypes = { "typescript", "javascript" }},
  { command = "eslint" },
  -- { command = "stylelint", filetype = { "css" } },
  { command = "tidy",         filetypes = { "html" } },
  { command = "vint",         filetypes = { "vim" } },
  -- { command = "luacheck", filetypes = { "lua" }, },
  { command = "markdownlint", filetypes = { "markdown" } },
})
-- -- set additional code_actions
local code_actions = require("lvim.lsp.null-ls.code_actions")
code_actions.setup({
  { command = "proselint" },
  { command = "cspell" },
  { command = "eslint" },
  -- { command = "refactoring" },
})

-- Additional Plugins <https://www.lunarvim.org/docs/plugins#user-plugins>
lvim.plugins = {
  -- navigation
  {
    "phaazon/hop.nvim", -- neovim motions on speed!
    event = "BufRead",
    config = function()
      require("hop").setup({ keys = "etovxqpdygfblzhckisuran" })
      vim.api.nvim_set_keymap("n", "w", ":HopWord<cr>", { silent = true })
      vim.api.nvim_set_keymap("n", "<leader>j", ":HopLine<cr>", { silent = true })
    end,
  },
  {
    "kevinhwang91/nvim-bqf", -- better quickfix window
    event = { "BufRead", "BufNew" },
    config = function()
      require("bqf").setup({
        auto_enable = true,
        preview = {
          win_height = 12,
          win_vheight = 12,
          delay_syntax = 80,
          border_chars = { "┃", "┃", "━", "━", "┏", "┓", "┗", "┛", "█" },
        },
        func_map = {
          vsplit = "",
          ptogglemode = "z,",
          stoggleup = "",
        },
        filter = {
          fzf = {
            action_for = { ["ctrl-s"] = "split" },
            extra_opts = { "--bind", "ctrl-o:toggle-all", "--prompt", "> " },
          },
        },
      })
    end,
  },
  {
    "windwp/nvim-spectre", -- search and replace ???
    event = "BufRead",
    config = function()
      require("spectre").setup()
    end,
  },
  {
    "rainbowhxch/accelerated-jk.nvim",
    config = function()
      require("accelerated-jk").setup()
    end,
  },
  {
    "ethanholz/nvim-lastplace",
    event = "BufRead",
    config = function()
      require("nvim-lastplace").setup({
        lastplace_ignore_buftype = { "quickfix", "nofile", "help" },
        lastplace_ignore_filetype = {
          "gitcommit", "gitrebase", "svn", "hgcommit",
        },
        lastplace_open_folds = true,
      })
    end,
  },
  {
    "romainl/vim-cool", -- Auto clear highlight after search
    event = { "CursorMoved", "InsertEnter" },
  },
  {
    "edluffy/specs.nvim", -- Hint cursor place when jump multiple lines
    event = "CursorMoved",
    config = function()
      require("specs").setup({
        show_jumps = true,
        min_jump = 10,
        popup = {
          delay_ms = 0, -- delay before popup displays
          inc_ms = 10,  -- time increments used for fade/resize effects
          blend = 10,   -- starting blend, between 0-100 (fully transparent), see :h winblend
          width = 10,
          winhl = "PMenu",
          fader = require("specs").pulse_fader,
          resizer = require("specs").shrink_resizer,
        },
        ignore_filetypes = {},
        ignore_buftypes = { nofile = true },
      })
    end,
  },

  -- treesitter
  { "sainnhe/gruvbox-material" },
  {
    "windwp/nvim-ts-autotag", -- autoclose and autorename html tag
    config = function()
      require("nvim-ts-autotag").setup()
    end,
  },
  {
    "andymass/vim-matchup", -- navigate and highlight matching words
    event = "CursorMoved",
    config = function()
      vim.g.matchup_matchparen_offscreen = { method = "popup" }
    end,
  },
  {
    "JoosepAlviste/nvim-ts-context-commentstring", -- commentstring option based on the cursor location
    event = "BufRead",
  },
  { "p00f/nvim-ts-rainbow" },                          -- rainbow parentheses
  { "nvim-treesitter/playground", event = "BufRead" }, -- view treesitter information
  {
    "romgrk/nvim-treesitter-context",                  -- Show current function at the top of the screen when function does not fit in screen
    config = function()
      require("treesitter-context").setup({
        enable = true,   -- Enable this plugin (Can be enabled/disabled later via commands)
        throttle = true, -- Throttles plugin updates (may improve performance)
        max_lines = 0,   -- How many lines the window should span. Values <= 0 mean no limit.
        patterns = {
          -- Match patterns for TS nodes. These get wrapped to match at word boundaries.
          -- For all filetypes
          -- Note that setting an entry here replaces all other patterns for this entry.
          -- By setting the 'default' entry below, you can control which nodes you want to
          -- appear in the context window.
          default = {
            "class",
            "function",
            "method",
          },
        },
      })
    end,
  },

  -- telescope
  { "nvim-telescope/telescope-fzy-native.nvim", build = "make", event = "BufRead" },
  -- { "nvim-telescope/telescope-project.nvim",
  --   event = "BufWinEnter",
  --   setup = function()
  --     vim.cmd([[packadd telescope.nvim]])
  --   end,
  -- },

  -- lsp enhancement
  {
    "folke/lsp-colors.nvim", --lsp diagnostics highlight groups for non lsp colorschemes
    event = "BufRead",
  },
  {
    "norcalli/nvim-colorizer.lua", -- Display detected color
    config = function()
      require("colorizer").setup({ "css", "scss", "html", "javascript" }, {
        RGB = true,      -- #RGB hex codes
        RRGGBB = true,   -- #RRGGBB hex codes
        RRGGBBAA = true, -- #RRGGBBAA hex codes
        rgb_fn = true,   -- CSS rgb() and rgba() functions
        hsl_fn = true,   -- CSS hsl() and hsla() functions
        css = true,      -- Enable all CSS features: rgb_fn, hsl_fn, names, RGB, RRGGBB
        css_fn = true,   -- Enable all CSS *functions*: rgb_fn, hsl_fn
      })
    end,
  },
  {
    "rmagatti/goto-preview", -- previewing goto definition calls
    config = function()
      require("goto-preview").setup({
        width = 120,              -- Width of the floating window
        height = 25,              -- Height of the floating window
        default_mappings = false, -- Bind default mappings
        debug = false,            -- Print debug information}
        opacity = nil,            -- 0-100 opacity level of the floating window where 100 is fully transparent.
        post_open_hook = nil,     -- A function taking two arguments, a buffer and a window to be ran as a hook.
        -- You can use "default_mappings = true" setup option
        -- Or explicitly set keybindings
        vim.cmd("nnoremap gpd <cmd>lua require('goto-preview').goto_preview_definition()<CR>"),
        vim.cmd("nnoremap gpi <cmd>lua require('goto-preview').goto_preview_implementation()<CR>"),
        vim.cmd("nnoremap gP <cmd>lua require('goto-preview').close_all_win()<CR>"),
      })
    end,
  },
  -- { "tzachar/cmp-tabnine", -- TabNine completion engine for hrsh7th/nvim-cmp
  --   build = "./install.sh",
  --   dependencies = "hrsh7th/nvim-cmp",
  --   event = "InsertEnter",
  -- },
  {
    'Exafunction/codeium.vim',
    config = function()
      -- Change '<C-g>' here to any keycode you like.
      vim.keymap.set('i', '<M-i>', function() return vim.fn['codeium#Accept']() end, { expr = true })
      vim.keymap.set('i', '<M-j>', function() return vim.fn['codeium#CycleCompletions'](1) end, { expr = true })
      vim.keymap.set('i', '<M-k>', function() return vim.fn['codeium#CycleCompletions'](-1) end, { expr = true })
      vim.keymap.set('i', '<M-o>', function() return vim.fn['codeium#Clear']() end, { expr = true })
    end
  },
  {
    "ray-x/lsp_signature.nvim", -- hint when you type, 小熊猫
    event = "BufRead",
    config = function()
      require("lsp_signature").on_attach()
    end,
  },
  -- { "lukas-reineke/cmp-under-comparator", module = "cmp-under-comparator" },
  -- { "hrsh7th/cmp-nvim-lua"},
  -- { "andersevenrud/cmp-tmux" },
  -- { "f3fora/cmp-spell"},
  -- { "kdheepak/cmp-latex-symbols"},
  {
    "simrat39/symbols-outline.nvim", -- a tree like view for symbols: <leader>lo
    config = function()
      require("symbols-outline").setup()
    end,
  },
  {
    "folke/trouble.nvim", -- diagnostics, references, telescope results, quickfix and location lists
    cmd = "TroubleToggle",
  },
  -- { "michaelb/sniprun", -- ???
  --   opt = true,
  --   run = "bash ./install.sh",
  --   cmd = { "SnipRun", "'<,'>SnipRun" },
  -- },
  {
    "gelguy/wilder.nvim", -- More useful wild menu
    event = "CmdlineEnter",
    config = function()
      local wilder = require("wilder")

      wilder.setup({ modes = { ":", "/", "?" } })
      wilder.set_option("use_python_remote_plugin", 0)
      wilder.set_option("pipeline", {
        wilder.branch(
          wilder.cmdline_pipeline({ use_python = 0, fuzzy = 1, fuzzy_filter = wilder.lua_fzy_filter() }),
          wilder.vim_search_pipeline(),
          {
            wilder.check(function(_, x)
              return x == ""
            end),
            wilder.history(),
            wilder.result({
              draw = {
                function(_, x)
                  return "" .. " " .. x
                end,
              },
            }),
          }
        ),
      })

      local popupmenu_renderer = wilder.popupmenu_renderer(wilder.popupmenu_border_theme({
        border = "rounded",
        highlights = {
          border = "Title", -- highlight to use for the border
        },
        empty_message = wilder.popupmenu_empty_message_with_spinner(),
        highlighter = wilder.lua_fzy_highlighter(),
        left = {
          " ",
          wilder.popupmenu_devicons(),
          wilder.popupmenu_buffer_flags({
            flags = " a + ",
            icons = { ["+"] = "", a = "", h = "" },
          }),
        },
        right = {
          " ",
          wilder.popupmenu_scrollbar(),
        },
      }))
      local wildmenu_renderer = wilder.wildmenu_renderer({
        highlighter = wilder.lua_fzy_highlighter(),
        apply_incsearch_fix = true,
      })
      wilder.set_option(
        "renderer",
        wilder.renderer_mux({
          [":"] = popupmenu_renderer,
          ["/"] = wildmenu_renderer,
          substitute = wildmenu_renderer,
        })
      )
    end,
    dependencies = { { "romgrk/fzy-lua-native", after = "wilder.nvim" } },
  },
  -- Git
  {
    "f-person/git-blame.nvim",
    event = "BufRead",
    config = function()
      vim.cmd("highlight default link gitblame SpecialComment")
      vim.g.gitblame_enabled = 0
    end,
  },

  -- General
  {
    "metakirby5/codi.vim", -- interactive scratchpad for hackers ???
    cmd = "Codi",
  },
  { "tpope/vim-repeat" },      -- enable repeating supported plugin maps with "."
  { "wakatime/vim-wakatime" }, -- :WakaTimeApiKey, :WakaTimeToday
  {
    "rcarriga/nvim-notify",    --???
    config = function()
      local notify = require("notify")
      notify.setup({
        ---@usage Animation style one of { "fade", "slide", "fade_in_slide_out", "static" }
        stages = "slide",
        ---@usage Function called when a new window is opened, use for changing win settings/config
        on_open = nil,
        ---@usage Function called when a window is closed
        on_close = nil,
        ---@usage timeout for notifications in ms, default 5000
        timeout = 2000,
        -- @usage User render fps value
        fps = 30,
        -- Render function for notifications. See notify-render()
        render = "default",
        ---@usage highlight behind the window for stages that change opacity
        background_colour = "Normal",
        ---@usage minimum width for notification windows
        minimum_width = 50,
        ---@usage notifications with level lower than this would be ignored. [ERROR > WARN > INFO > DEBUG > TRACE]
        level = "TRACE",
      })

      vim.notify = notify
    end,
  },
  {
    "j-hui/fidget.nvim", -- show plugin load
    event = "BufReadPost",
    config = function()
      require("fidget").setup({
        window = { blend = 0 },
      })
    end,
  },

  -- tool
  {
    "iamcco/markdown-preview.nvim",
    build = "cd app && npm install",
    ft = "markdown",
    config = function()
      vim.g.mkdp_auto_start = 1
    end,
  },
  {
    "turbio/bracey.vim", -- live edit html, css, and javascript
    cmd = { "Bracey", "BracyStop", "BraceyReload", "BraceyEval" },
    build = "npm install --prefix server",
  },
  { "chrisbra/csv.vim",       lazy = true, ft = "csv" },
  -- { "fatih/vim-go",
  --   opt = true,
  --   ft = "go",
  --   run = ":GoInstallBinaries",
  --   config = function()
  --     vim.g.go_doc_keywordprg_enabled = 0
  --     vim.g.go_def_mapping_enabled = 0
  --     vim.g.go_code_completion_enabled = 0
  --   end,
  -- },
  { "voldikss/vim-translator" },
  {
    "folke/todo-comments.nvim",
    event = "BufRead",
    config = function()
      require("todo-comments").setup({
        signs = true,      -- show icons in the signs column
        sign_priority = 8, -- sign priority
        -- keywords recognized as todo comments
        keywords = {
          FIX = {
            icon = " ",                              -- icon used for the sign, and in search results
            color = "error",                            -- can be a hex color, or a named color (see below)
            alt = { "FIXME", "BUG", "FIXIT", "ISSUE" }, -- a set of other keywords that all map to this FIX keywords
            -- signs = false, -- configure signs for some keywords individually
          },
          TODO = { icon = " ", color = "info" },
          HACK = { icon = " ", color = "warning" },
          WARN = { icon = " ", color = "warning", alt = { "WARNING", "XXX" } },
          PERF = { icon = " ", alt = { "OPTIM", "PERFORMANCE", "OPTIMIZE" } },
          NOTE = { icon = " ", color = "hint", alt = { "INFO" } },
          TEST = { icon = "⏲ ", color = "test", alt = { "TESTING", "PASSED", "FAILED" } },
        },
        gui_style = {
          fg = "NONE",         -- The gui style to use for the fg highlight group.
          bg = "BOLD",         -- The gui style to use for the bg highlight group.
        },
        merge_keywords = true, -- when true, custom keywords will be merged with the defaults
        -- highlighting of the line containing the todo comment
        -- * before: highlights before the keyword (typically comment characters)
        -- * keyword: highlights of the keyword
        -- * after: highlights after the keyword (todo text)
        highlight = {
          multiline = true,                -- enable multine todo comments
          multiline_pattern = "^.",        -- lua pattern to match the next multiline from the start of the matched keyword
          multiline_context = 10,          -- extra lines that will be re-evaluated when changing a line
          before = "",                     -- "fg" or "bg" or empty
          keyword = "wide",                -- "fg", "bg", "wide", "wide_bg", "wide_fg" or empty. (wide and wide_bg is the same as bg, but will also highlight surrounding characters, wide_fg acts accordingly but with fg)
          after = "fg",                    -- "fg" or "bg" or empty
          pattern = [[.*<(KEYWORDS)\s*:]], -- pattern or table of patterns, used for highlighting (vim regex)
          comments_only = true,            -- uses treesitter to match keywords in comments only
          max_line_len = 400,              -- ignore lines longer than this
          exclude = {},                    -- list of file types to exclude highlighting
        },
        -- list of named colors where we try to extract the guifg from the
        -- list of highlight groups or use the hex color if hl not found as a fallback
        colors = {
          error = { "DiagnosticError", "ErrorMsg", "#DC2626" },
          warning = { "DiagnosticWarn", "WarningMsg", "#FBBF24" },
          info = { "DiagnosticInfo", "#2563EB" },
          hint = { "DiagnosticHint", "#10B981" },
          default = { "Identifier", "#7C3AED" },
          test = { "Identifier", "#FF00FF" },
        },
        search = {
          command = "rg",
          args = {
            "--color=never",
            "--no-heading",
            "--with-filename",
            "--line-number",
            "--column",
          },
          -- regex that will be used to match keywords.
          -- don't replace the (KEYWORDS) placeholder
          pattern = [[\b(KEYWORDS):]], -- ripgrep regex
          -- pattern = [[\b(KEYWORDS)\b]], -- match without the extra colon. You'll likely get false positives
        },
      })
    end,
  },
}

-- -- Autocommands (`:help autocmd`) <https://neovim.io/doc/user/autocmd.html>
-- vim.api.nvim_create_autocmd("FileType", {
--   pattern = "zsh",
--   callback = function()
--     -- let treesitter use bash highlight for zsh files as well
--     require("nvim-treesitter.highlight").attach(0, "bash")
--   end,
-- })

-- Change Telescope navigation to use j and k for navigation and n and p for history in both input and normal mode.
-- we use protected-mode (pcall) just in case the plugin wasn't loaded yet.
local _, actions = pcall(require, "telescope.actions")
lvim.builtin.telescope.defaults.mappings = {
  -- for input mode
  i = {
    ["<C-j>"] = actions.move_selection_next,
    ["<C-k>"] = actions.move_selection_previous,
    ["<C-n>"] = actions.cycle_history_next,
    ["<C-p>"] = actions.cycle_history_prev,
  },
  -- for normal mode
  n = {
    ["<C-j>"] = actions.move_selection_next,
    ["<C-k>"] = actions.move_selection_previous,
  },
}
lvim.builtin.telescope.on_config_done = function(telescope)
  -- pcall(telescope.load_extension, "neoclip")
  pcall(telescope.load_extension, "notify")
  pcall(telescope.load_extension, "fzy")
  pcall(telescope.load_extension, "projects")
  -- pcall(telescope.load_extension, "undo")
  -- any other extensions loading
end

-- table.insert(lvim.plugins, {
--   "zbirenbaum/copilot-cmp",
--   event = "InsertEnter",
--   dependencies = { "zbirenbaum/copilot.lua" },
--   config = function()
--     vim.defer_fn(function()
--       require("copilot").setup() -- https://github.com/zbirenbaum/copilot.lua/blob/master/README.md#setup-and-configuration
--       require("copilot_cmp").setup() -- https://github.com/zbirenbaum/copilot-cmp/blob/master/README.md#configuration
--     end, 100)
--   end,
-- })
-- -- Make sure to run :Lazy load copilot-cmp followed by :Copilot auth once the plugin is installed to start the authentication process.

-- laguages:
lvim.lsp.diagnostics.virtual_text = true

lvim.builtin.treesitter.highlight.enable = true

-- Additional Plugins
table.insert(lvim.plugins, {
  "p00f/clangd_extensions.nvim",
})

vim.list_extend(lvim.lsp.automatic_configuration.skipped_servers, { "clangd" })

-- some settings can only passed as commandline flags, see `clangd --help`
local clangd_flags = {
  "--background-index",
  "--fallback-style=Google",
  "--all-scopes-completion",
  "--clang-tidy",
  "--log=error",
  "--suggest-missing-includes",
  "--cross-file-rename",
  "--completion-style=detailed",
  "--pch-storage=memory",     -- could also be disk
  "--folding-ranges",
  "--enable-config",          -- clangd 11+ supports reading from .clangd configuration file
  "--offset-encoding=utf-16", --temporary fix for null-ls
  -- "--limit-references=1000",
  -- "--limit-resutls=1000",
  -- "--malloc-trim",
  -- "--clang-tidy-checks=-*,llvm-*,clang-analyzer-*,modernize-*,-modernize-use-trailing-return-type",
  -- "--header-insertion=never",
  -- "--query-driver=<list-of-white-listed-complers>"
}

local provider = "clangd"

local custom_on_attach = function(client, bufnr)
  require("lvim.lsp").common_on_attach(client, bufnr)

  local opts = { noremap = true, silent = true, buffer = bufnr }
  vim.keymap.set("n", "<leader>lh", "<cmd>ClangdSwitchSourceHeader<cr>", opts)
  vim.keymap.set("x", "<leader>lA", "<cmd>ClangdAST<cr>", opts)
  vim.keymap.set("n", "<leader>lH", "<cmd>ClangdTypeHierarchy<cr>", opts)
  vim.keymap.set("n", "<leader>lt", "<cmd>ClangdSymbolInfo<cr>", opts)
  vim.keymap.set("n", "<leader>lm", "<cmd>ClangdMemoryUsage<cr>", opts)

  require("clangd_extensions.inlay_hints").setup_autocmd()
  require("clangd_extensions.inlay_hints").set_inlay_hints()
end

local status_ok, project_config = pcall(require, "rhel.clangd_wrl")
if status_ok then
  clangd_flags = vim.tbl_deep_extend("keep", project_config, clangd_flags)
end

local custom_on_init = function(client, bufnr)
  require("lvim.lsp").common_on_init(client, bufnr)
  require("clangd_extensions.config").setup({})
  require("clangd_extensions.ast").init()
  vim.cmd([[
  command ClangdToggleInlayHints lua require('clangd_extensions.inlay_hints').toggle_inlay_hints()
  command -range ClangdAST lua require('clangd_extensions.ast').display_ast(<line1>, <line2>)
  command ClangdTypeHierarchy lua require('clangd_extensions.type_hierarchy').show_hierarchy()
  command ClangdSymbolInfo lua require('clangd_extensions.symbol_info').show_symbol_info()
  command -nargs=? -complete=customlist,s:memuse_compl ClangdMemoryUsage lua require('clangd_extensions.memory_usage').show_memory_usage('<args>' == 'expand_preamble')
  ]])
end

local opts = {
  cmd = { provider, unpack(clangd_flags) },
  on_attach = custom_on_attach,
  on_init = custom_on_init,
}

require("lvim.lsp.manager").setup("clangd", opts)

-- install codelldb with :MasonInstall codelldb
-- configure nvim-dap (codelldb)
lvim.builtin.dap.on_config_done = function(dap)
  dap.adapters.codelldb = {
    type = "server",
    port = "${port}",
    executable = {
      -- provide the absolute path for `codelldb` command if not using the one installed using `mason.nvim`
      command = "/home/liukanglai/.local/share/nvim/mason/bin/codelldb",
      command = "codelldb",
      args = { "--port", "${port}" },
      -- On windows you may have to uncomment this:
      -- detached = false,
    },
  }

  dap.configurations.cpp = {
    {
      name = "Launch file",
      type = "codelldb",
      request = "launch",
      program = function()
        return vim.fn.input("Path to executable: ", vim.fn.getcwd() .. "/", "file")
      end,
      cwd = "${workspaceFolder}",
      stopOnEntry = false,
    },
  }

  dap.configurations.c = dap.configurations.cpp
  dap.configurations.rust = dap.configurations.cpp
end
