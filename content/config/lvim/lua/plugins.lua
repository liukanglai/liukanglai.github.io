-- Additional Plugins
lvim.plugins = {
	-- navigation
	{
		"phaazon/hop.nvim", -- neovim motions on speed!
		branch = "v2",
		event = "BufRead",
		config = function()
			require("hop").setup({ keys = "etovxqpdygfblzhckisuran" })
			vim.api.nvim_set_keymap("n", "w", ":HopWord<cr>", { silent = true })
			vim.api.nvim_set_keymap("n", "<leader>j", ":HopLine<cr>", { silent = true })
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
					"gitcommit",
					"gitrebase",
					"svn",
					"hgcommit",
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
		"edluffy/specs.nvim",
		event = "CursorMoved",
		config = function()
			require("specs").setup({
				show_jumps = true,
				min_jump = 10,
				popup = {
					delay_ms = 0, -- delay before popup displays
					inc_ms = 10, -- time increments used for fade/resize effects
					blend = 10, -- starting blend, between 0-100 (fully transparent), see :h winblend
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
	--  Hint cursor place when jump multiple lines

	-- treesitter
	{
		"windwp/nvim-ts-autotag",
		config = function()
			require("nvim-ts-autotag").setup({
				filetypes = {
					"html",
					"xml",
					"javascript",
					"typescriptreact",
					"javascriptreact",
					"vue",
				},
			})
		end,
	},
	{
		"andymass/vim-matchup",
		event = "CursorMoved",
		config = function()
			vim.g.matchup_matchparen_offscreen = { method = "popup" }
		end,
	},
	{ "p00f/nvim-ts-rainbow" },
	{ "nvim-treesitter/playground", event = "BufRead" },
	{
		"romgrk/nvim-treesitter-context",
		config = function()
			require("treesitter-context").setup({
				enable = true, -- Enable this plugin (Can be enabled/disabled later via commands)
				throttle = true, -- Throttles plugin updates (may improve performance)
				max_lines = 0, -- How many lines the window should span. Values <= 0 mean no limit.
				patterns = { -- Match patterns for TS nodes. These get wrapped to match at word boundaries.
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
	{ "nvim-telescope/telescope-fzy-native.nvim", run = "make", event = "BufRead" },
	{
		"nvim-telescope/telescope-project.nvim",
		event = "BufWinEnter",
		setup = function()
			vim.cmd([[packadd telescope.nvim]])
		end,
	},

	-- lsp enhancement
	{
		"folke/lsp-colors.nvim", --lsp diagnostics highlight groups for non lsp colorschemes
		event = "BufRead",
	},
	{
		"norcalli/nvim-colorizer.lua", -- Display detected color
		config = function()
			require("colorizer").setup({ "css", "scss", "html", "javascript" }, {
				RGB = true, -- #RGB hex codes
				RRGGBB = true, -- #RRGGBB hex codes
				RRGGBBAA = true, -- #RRGGBBAA hex codes
				rgb_fn = true, -- CSS rgb() and rgba() functions
				hsl_fn = true, -- CSS hsl() and hsla() functions
				css = true, -- Enable all CSS features: rgb_fn, hsl_fn, names, RGB, RRGGBB
				css_fn = true, -- Enable all CSS *functions*: rgb_fn, hsl_fn
			})
		end,
	},
	{
		"rmagatti/goto-preview", -- previewing goto definition calls
		config = function()
			require("goto-preview").setup({
				width = 120, -- Width of the floating window
				height = 25, -- Height of the floating window
				default_mappings = false, -- Bind default mappings
				debug = false, -- Print debug information}
				opacity = nil, -- 0-100 opacity level of the floating window where 100 is fully transparent.
				post_open_hook = nil, -- A function taking two arguments, a buffer and a window to be ran as a hook.
				-- You can use "default_mappings = true" setup option
				-- Or explicitly set keybindings
				vim.cmd("nnoremap gpd <cmd>lua require('goto-preview').goto_preview_definition()<CR>"),
				vim.cmd("nnoremap gpi <cmd>lua require('goto-preview').goto_preview_implementation()<CR>"),
				vim.cmd("nnoremap gP <cmd>lua require('goto-preview').close_all_win()<CR>"),
			})
		end,
	},
	-- { "tzachar/cmp-tabnine", -- TabNine completion engine for hrsh7th/nvim-cmp
	--   run = "./install.sh",
	--   requires = "hrsh7th/nvim-cmp",
	--   event = "InsertEnter"
	-- },
	{
		"ray-x/lsp_signature.nvim", -- hint when you type, 小熊猫
		event = "BufRead",
		config = function()
			require("lsp_signature").on_attach()
		end,
	},
	-- { "lukas-reineke/cmp-under-comparator", module = "cmp-under-comparator" },
	{ "hrsh7th/cmp-nvim-lua", after = "cmp-nvim-lsp" },
	{ "andersevenrud/cmp-tmux", after = "cmp-nvim-lua" },
	{ "f3fora/cmp-spell", after = "cmp-path" },
	{ "kdheepak/cmp-latex-symbols", after = "cmp-buffer" },
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
	{
		"michaelb/sniprun", -- ???
		opt = true,
		run = "bash ./install.sh",
		cmd = { "SnipRun", "'<,'>SnipRun" },
	},
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
		requires = { { "romgrk/fzy-lua-native", after = "wilder.nvim" } },
	},

	-- General
	{
		"metakirby5/codi.vim", -- interactive scratchpad for hackers ???
		cmd = "Codi",
	},
	{ "tpope/vim-repeat" }, -- enable repeating supported plugin maps with "."
	{ "wakatime/vim-wakatime" }, -- :WakaTimeApiKey, :WakaTimeToday
	{
		"rcarriga/nvim-notify", --???
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
		run = "cd app && npm install",
		ft = "markdown",
		config = function()
			vim.g.mkdp_auto_start = 1
		end,
	},
	{
		"turbio/bracey.vim", -- live edit html, css, and javascript
		cmd = { "Bracey", "BracyStop", "BraceyReload", "BraceyEval" },
		run = "npm install --prefix server",
	},
	{ "chrisbra/csv.vim", opt = true, ft = "csv" },
	{
		"fatih/vim-go",
		opt = true,
		ft = "go",
		run = ":GoInstallBinaries",
		config = function()
			vim.g.go_doc_keywordprg_enabled = 0
			vim.g.go_def_mapping_enabled = 0
			vim.g.go_code_completion_enabled = 0
		end,
	},
	{ "voldikss/vim-translator" },
}
