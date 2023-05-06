-- Bootstrapping
local fn = vim.fn
local install_path = fn.stdpath('data') .. '/site/pack/packer/start/packer.nvim'
if fn.empty(fn.glob(install_path)) > 0 then
    packer_bootstrap = fn.system({
        'git', 'clone', '--depth', '1',
        'https://github.com/wbthomason/packer.nvim', install_path
    })
end

-- AutoUpdated when plugins.lua is changed.
vim.cmd([[
  augroup packer_user_config
    autocmd!
    autocmd BufWritePost plugins.lua source <afile> | PackerCompile
  augroup end
]])

-- Load packer.nvim
vim.cmd("packadd packer.nvim")

return require('packer').startup(function(use)
    use({"wbthomason/packer.nvim", opt = true})

    -- "Plug 'dracula/vim', { 'as': 'dracula' }
    -- " Plug 'ajmwagar/vim-deus'

    use "mhinz/vim-startify"
    -- use 'luochen1990/rainbow'
    -- use 'kien/rainbow_parentheses.vim'

    -- tabline

    -- use {
    -- 'nvim-lualine/lualine.nvim',
    -- event = 'VimEnter',
    -- requires = {'kyazdani42/nvim-web-devicons', opt = true}
    -- }
    -- use({
    -- "akinsho/bufferline.nvim",
    -- event = "VimEnter",
    -- after = 'lualine.nvim',
    -- config = [[require('config.line')]]
    -- })
    use "vim-airline/vim-airline"
    use "vim-airline/vim-airline-themes" -- 综合图标支持such vim-airline lightline, vim-startify
    use "ryanoasis/vim-devicons"
    use "sainnhe/gruvbox-material"

    -- look!!!

    -- " File navigation
    -- Plug 'preservim/nerdtree', {'on': 'NERDTreeToggle'}
    -- Plug 'tiagofumo/vim-nerdtree-syntax-highlight'
    use {
        'kyazdani42/nvim-tree.lua',
        requires = {
            'kyazdani42/nvim-web-devicons', -- optional, for file icon
            config = [[require('config.tree')]]
        }
    }

    use {
        'nvim-telescope/telescope.nvim',
        requires = {{'nvim-lua/plenary.nvim'}}
    }
    -- search emoji and other symbols
    use 'nvim-telescope/telescope-symbols.nvim'

    --  register

    -- Plug 'junegunn/vim-peekaboo'
    -- use({"jdhao/better-escape.vim", event = {"InsertEnter"}})

    -- Undo Tree 修改历史
    -- "noremap <f5> :GundoToggle<cr>
    -- " Plug 'sjl/gundo.vim'
    -- "Plug 'mbbill/undotree'

    --  mark
    use 'kshenoy/vim-signature'
    --  Bookmarks
    --  Plug 'MattesGroeger/vim-bookmarks'

    -- Clear highlight search automatically for you
    use({"romainl/vim-cool", event = "VimEnter"})
    -- Highlight URLs inside vim
    use({"itchyny/vim-highlighturl", event = "VimEnter"})
    --  see
    use 'Yggdroot/indentLine'
    -- " 相同字符串下划线
    use 'itchyny/vim-cursorword'
    -- Automatic insertion and deletion of a pair of characters
    use({"Raimondi/delimitMate", event = "InsertEnter"})
    -- Show match number for search
    use {
        'kevinhwang91/nvim-hlslens',
        branch = 'dev',
        event = "VimEnter",
        config = function() require('hlslens').setup() end
    }

    -- type!!!

    -- use 'rlue/vim-barbaric' -- change input?
    -- " Plug 'lyokha/vim-xkbswitch' let g:XkbSwitchEnabled = 1
    -- "Plug 'lilydjwg/fcitx.vim'
    -- " Find & Replace
    -- "Plug 'brooth/far.vim', { 'on': ['F', 'Far', 'Fardo'] }
    -- " search fzf ack
    -- " <leader><leader>+
    use 'easymotion/vim-easymotion'

    use 'iamcco/ds-pinyin-lsp'

    -- code !!!

    -- use 'dense-analysis/ale'
    use 'mfussenegger/nvim-lint'
    use 'neomake/neomake'

    -- auto-completion engine
    use {"hrsh7th/nvim-cmp", config = [[require('config.cmp')]]}
    use {"hrsh7th/cmp-nvim-lsp", after = "nvim-cmp"}
    use({"neovim/nvim-lspconfig", after = "cmp-nvim-lsp"})
    use({'williamboman/nvim-lsp-installer', after = "nvim-lspconfig"})
    use {
        "ray-x/lsp_signature.nvim",
        after = "nvim-lsp-installer",
        config = [[require('config.lsp')]]
    }
    -- use {'glepnir/lspsaga.nvim', config = [[require('config.lspsaga')]]}
    -- Plug 'nvim-lua/lsp-status.nvim'

    -- use {"onsails/lspkind-nvim", event = 'BufEnter'} -- 美化自动完成提示信息
    use {"hrsh7th/cmp-nvim-lua", after = "nvim-cmp"} -- nvim-cmp source for neovim Lua API.
    use {"hrsh7th/cmp-path", after = "nvim-cmp"} -- 自动提示硬盘上的文件
    use {"hrsh7th/cmp-buffer", after = "nvim-cmp"} -- 从buffer中智能提示
    use {"hrsh7th/cmp-cmdline", after = "nvim-cmp"}
    use {"hrsh7th/cmp-emoji", after = 'nvim-cmp'} -- 输入: 可以显示表情
    use {"octaltree/cmp-look", after = 'nvim-cmp'} -- 用于完成英语单词
    -- use {"hrsh7th/cmp-calc", after = 'nvim-cmp'} -- 输入数学算式（如1+1=）自动计算
    use {"f3fora/cmp-spell", after = 'nvim-cmp'} -- nvim-cmp 的拼写源基于 vim 的拼写建议

    -- AI code
    -- use {"github/copilot.vim"} -- run :Copilot setup

    -- 插入模式获得函数签名

    -- notification plugin
    -- use({
    -- "rcarriga/nvim-notify",
    -- event = "BufEnter",
    -- config = [[require('config.nvim-notify')]]
    -- })

    -- "" Treesitter
    use({
        "nvim-treesitter/nvim-treesitter",
        event = 'BufEnter',
        run = ":TSUpdate",
        config = [[require('config.treesitter')]]
    })

    -- " post install (yarn install | npm install) then load plugin only for editing supported files
    -- use {
    -- 'prettier/vim-prettier',
    -- run = 'yarn install',
    -- ft = {
    -- 'javascript', 'typescript', 'css', 'less', 'scss', 'graphql',
    -- 'markdown', 'vue', 'html'
    -- }
    -- }
    -- use {
    -- 'prettier/vim-prettier',
    -- run = "yarn install --frozen-lockfile --production"
    -- }
    --
    -- Auto format tools
    use({"sbdchd/neoformat", cmd = {"Neoformat"}})

    -- Comment plugin
    -- use({"tpope/vim-commentary", event = "VimEnter"})
    -- " in <space>cc to comment a line
    use 'scrooloose/nerdcommenter'

    use({'dhruvasagar/vim-table-mode', ft = {'markdown', 'vim-plug'}})

    use({
        "iamcco/markdown-preview.nvim",
        run = function() fn["mkdp#util#install"]() end,
        ft = {"markdown", "html", "jsp"}
    })
    use {"ellisonleao/glow.nvim"}

    -- Additional powerful text object for vim, this plugin should be studied
    -- carefully to use its full power
    use({"wellle/targets.vim", event = "VimEnter"})

    -- Plugin to manipulate character pairs quickly
    -- use 'tpope/vim-surround'
    use({"machakann/vim-sandwich", event = "VimEnter"})

    -- .tmux.conf syntax highlighting and setting check
    use({"tmux-plugins/vim-tmux", ft = {"tmux"}})

    -- Asynchronous command execution
    use({"skywind3000/asyncrun.vim", opt = true, cmd = {"AsyncRun"}})

    -- use({"cespare/vim-toml", ft = {"toml"}, branch = "main"})

    -- Debugger plugin
    -- if vim.g.is_win or vim.g.is_linux then
    -- use({
    -- "sakhnik/nvim-gdb",
    -- run = {"bash install.sh"},
    -- opt = true,
    -- setup = [[vim.cmd('packadd nvim-gdb')]]
    -- })
    -- end

    -- The missing auto-completion for cmdline!
    use({
        "gelguy/wilder.nvim",
        opt = true,
        setup = [[vim.cmd('packadd wilder.nvim')]]
    })

    use({"lervag/vimtex", ft = {"tex"}})
    -- Plug 'xuhdev/vim-latex-live-preview', { 'for': 'tex' }
    --

    -- git
    use {
        'lewis6991/gitsigns.nvim',
        -- tag = 'release' -- To use the latest release
        config = function() require('gitsigns').setup() end
    }

    -- web
    use {'shime/vim-livedown'}

end)
