-- generic LSP settings
-- make sure server will always be installed even if the server is in skipped_servers list
lvim.lsp.installer.setup.ensure_installed = {
	-- "jsonls",
}
-- -- change UI setting of `LspInstallInfo`
-- -- see <https://github.com/williamboman/nvim-lsp-installer#default-configuration>
-- lvim.lsp.installer.setup.ui.check_outdated_servers_on_open = false
-- lvim.lsp.installer.setup.ui.border = "rounded"
-- lvim.lsp.installer.setup.ui.keymaps = {
--     uninstall_server = "d",
--     toggle_server_expand = "o",
-- }

-- ---@usage disable automatic installation of servers
lvim.lsp.installer.setup.automatic_installation = false

-- ---configure a server manually. !!Requires `:LvimCacheReset` to take effect!!
-- ---see the full default list `:lua print(vim.inspect(lvim.lsp.automatic_configuration.skipped_servers))`
vim.list_extend(lvim.lsp.automatic_configuration.skipped_servers, { "clangd" })
local capabilities = require("lvim.lsp").common_capabilities()
capabilities.offsetEncoding = { "utf-16" }
local opts = { capabilities = capabilities }
require("lvim.lsp.manager").setup("clangd", opts)
-- ---The default file:
-- lvim.lsp.templates_dir = join_paths(get_runtime_dir(), "after", "ftplugin")
-- ---edit this file by running `:lua vim.cmd("edit " .. lvim.lsp.templates_dir .. "/lua.lua")`
-- require("lvim.lsp.manager").setup("sumneko_lua")

-- ---remove a server from the skipped list, e.g. eslint, or emmet_ls. !!Requires `:LvimCacheReset` to take effect!!
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

-- Can not be placed into the config method of the plugins.
-- lvim.builtin.cmp.formatting.source_names["copilot"] = "(Copilot)"
table.insert(lvim.builtin.cmp.sources, 1, { name = "nvim_lua" })
-- table.insert(lvim.builtin.cmp.sources, 2, { name = "spell" })
table.insert(lvim.builtin.cmp.sources, 3, { name = "tmux" })
table.insert(lvim.builtin.cmp.sources, 4, { name = "latex_symbols" })

-- Lazy-loading the linter/formatter/code_actions setup???
-- -- set a formatter, this will override the language server formatting capabilities (if it exists)
local formatters = require("lvim.lsp.null-ls.formatters")
formatters.setup({
	-- { command = "black", filetypes = { "python" } },
	-- { command = "isort", filetypes = { "python" } },
	{ command = "stylua", filetypes = { "lua" } },
	{ command = "shfmt", filetypes = { "shell" } },
	{ command = "google-java-format", filetypes = { "java" } },
	{
		-- each formatter accepts a list of options identical to https://github.com/jose-elias-alvarez/null-ls.nvim/blob/main/doc/BUILTINS.md#Configuration
		command = "prettier",
		---@usage arguments to pass to the formatter
		-- these cannot contain whitespaces, options such as `--line-width 80` become either `{'--line-width', '80'}` or `{'--line-width=80'}`
		extra_args = { "--print-with", "100" },
		---@usage specify which filetypes to enable. By default a providers will attach to all the filetypes it supports.
		-- filetypes = { "markdown", "typescript", "typescriptreact" },
	},
})

-- -- set additional linters
local linters = require("lvim.lsp.null-ls.linters")
linters.setup({
	{
		-- each linter accepts a list of options identical to https://github.com/jose-elias-alvarez/null-ls.nvim/blob/main/doc/BUILTINS.md#Configuration
		command = "shellcheck",
		---@usage arguments to pass to the formatter
		-- these cannot contain whitespaces, options such as `--line-width 80` become either `{'--line-width', '80'}` or `{'--line-width=80'}`
		extra_args = { "--severity", "warning" },
	},
	{ command = "codespell", filetypes = { "javascript", "python" } },
	{
		command = "cpplint",
		filetype = { "c", "cpp" }, -- extra_args = { "--style", "{IndentWidth: 4}" }
	}, -- clangtidy is better.
	{ command = "cppcheck", filetype = { "c", "cpp" } },
	{ command = "checkmake", filetype = { "make" } },
	{ command = "checkstyle", filetype = { "java" } },
	{ command = "pylint", filetype = { "python" } },
	-- { command = "eslint", filetypes = { "typescript", "javascript" }, },
	-- { command = "stylelint", filetype = { "css" }, },
	-- { command = "tidy", filetypes = { "html" }, },
	{ command = "vint", filetypes = { "vim" } },
	-- { command = "luacheck", filetypes = { "lua" }, },
	{ command = "markdownlint", filetypes = { "markdown" } },
})

-- -- set additional code_actions
local code_actions = require("lvim.lsp.null-ls.code_actions")
code_actions.setup({
	{ command = "proselint" },
	{ command = "cspell" },
	-- { command = "eslint" },
	-- { command = "refactoring" },
})
