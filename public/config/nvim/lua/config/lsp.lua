local api = vim.api
local lsp = vim.lsp

local custom_attach = function(client, bufnr)
    -- Mappings.
    local opts = {silent = true, buffer = bufnr}
    vim.keymap.set("n", "<space>ld", vim.lsp.buf.declaration, opts)
    vim.keymap.set("n", "<space>lf", vim.lsp.buf.definition, opts)
    vim.keymap.set("n", "<space>lt", vim.lsp.buf.type_definition, opts)
    vim.keymap.set("n", "<space>li", vim.lsp.buf.implementation, opts)
    vim.keymap.set("n", "K", vim.lsp.buf.hover, opts)
    vim.keymap.set("n", "<space>lh", vim.lsp.buf.signature_help, opts)
    vim.keymap.set("n", "<space>wa", vim.lsp.buf.add_workspace_folder, opts)
    vim.keymap.set("n", "<space>wr", vim.lsp.buf.remove_workspace_folder, opts)
    vim.keymap.set("n", "<space>wl", function()
        print(vim.inspect(vim.lsp.buf.list_workspace_folders()))
    end, opts)
    vim.keymap.set("n", "<space>lr", vim.lsp.buf.rename, opts)
    vim.keymap.set("n", "gr", vim.lsp.buf.references, opts)
    vim.keymap.set("n", "<space>lm", vim.diagnostic.goto_prev, opts)
    vim.keymap.set("n", "<space>ln", vim.diagnostic.goto_next, opts)
    vim.keymap.set("n", "<space>q",
                   function() vim.diagnostic.setqflist({open = true}) end, opts)
    vim.keymap.set("n", "<space>la", vim.lsp.buf.code_action, opts)

    vim.api.nvim_create_autocmd("CursorHold", {
        buffer = bufnr,
        callback = function()
            local opts = {
                focusable = false,
                close_events = {
                    -- "BufLeave", "CursorMoved", "InsertEnter", "FocusLost"
                    "BufLeave", "CursorMoved", "InsertEnter"
                },
                border = 'rounded',
                source = 'always', -- show source in diagnostic popup window
                prefix = ' '
            }
            vim.diagnostic.open_float(nil, opts)
        end
    })

    -- Set some key bindings conditional on server capabilities
    if client.server_capabilities.document_formatting then
        vim.keymap.set("n", "<space>lq", vim.lsp.buf.formatting_sync, opts)
    end
    if client.server_capabilities.document_range_formatting then
        vim.keymap.set("x", "<space>lq", vim.lsp.buf.range_formatting, opts)
    end

    -- The blow command will highlight the current variable and its usages in the buffer.
    if client.server_capabilities.document_highlight then
        vim.cmd([[
      hi! link LspReferenceRead Visual
      hi! link LspReferenceText Visual
      hi! link LspReferenceWrite Visual
      augroup lsp_document_highlight
        autocmd! * <buffer>
        autocmd CursorHold <buffer> lua vim.lsp.buf.document_highlight()
        autocmd CursorMoved <buffer> lua vim.lsp.buf.clear_references()
      augroup END
    ]])
    end

    if vim.g.logging_level == 'debug' then
        local msg = string.format("Language server %s started!", client.name)
        vim.notify(msg, 'info', {title = 'Nvim-config'})
    end
end

local capabilities = lsp.protocol.make_client_capabilities()
capabilities = require('cmp_nvim_lsp').default_capabilities(capabilities)
capabilities.textDocument.completion.completionItem.snippetSupport = true

local lspconfig = require("lspconfig")

-- Change diagnostic signs.
vim.fn.sign_define("DiagnosticSignError",
                   {text = "●", texthl = "DiagnosticSignError"})
vim.fn.sign_define("DiagnosticSignWarn",
                   {text = "!", texthl = "DiagnosticSignWarn"})
-- vim.fn.sign_define("DiagnosticSignWarn", {text = "", texthl = "DiagnosticSignWarn"})
vim.fn.sign_define("DianosticSignInformation",
                   {text = "", texthl = "DiagnosticSignInfo"})
vim.fn.sign_define("DiagnosticSignHint",
                   {text = "", texthl = "DiagnosticSignHint"})

-- global config for diagnostic
vim.diagnostic.config({
    underline = false,
    virtual_text = false,
    signs = true,
    severity_sort = true
})

-- Change border of documentation hover window, See https://github.com/neovim/neovim/pull/13998.
lsp.handlers["textDocument/hover"] = lsp.with(vim.lsp.handlers.hover,
                                              {border = "rounded"})

-- show diagnostics automatically
-- You will likely want to reduce updatetime which affects CursorHold
-- note: this setting is global and should be set only once
-- vim.o.updatetime = 250
-- vim.cmd [[autocmd! CursorHold,CursorHoldI * lua vim.diagnostic.open_float(nil, opts)]]

-- lint

require('lint').linters_by_ft = {
    -- javascript = {"eslint"},
    -- typescript = {"eslint"},
    html = {"tidy"},
    -- markdown = {'vale'},
    -- markdown = {'markdownlint'},
    python = {'pylint'},
    -- java = {'checkstyle'},
    -- vim = {'vint'},
    cpp = {'clangtidy', 'cppcheck', 'cpplint'},
    -- c = {'cppcheck', 'clangtidy', 'cpplint'}
    -- cpp = {'clangtidy'},
    c = {'clangtidy'}
    -- css = {'stylelint'}
    -- go = {"golangcilint"}
}
-- vim.cmd([[au BufWritePost <buffer> lua require('lint').try_lint()]])
vim.cmd([[
au BufEnter * lua require('lint').try_lint()
au BufWritePost * lua require('lint').try_lint()
"au TextChanged * lua require('lint').try_lint()
"au InsertLeave * lua require('lint').try_lint()
"au FileChangedShellPost * lua require('lint').try_lint()
]])

-- installer

local lsp_installer = require("nvim-lsp-installer")
-- Register a handler that will be called for all installed servers.
-- Alternatively, you may also register handlers on specific server instances instead (see example below).
lsp_installer.on_server_ready(function(server)
    local optts = {on_attach = custom_attach, capabilities = capabilities}
    -- local opts = {on_attach = on_attach, capabilities = capabilities}

    -- (optional) Customize the options passed to the server
    -- if server.name == "javascript" then
    -- opts.root_dir = function() ... end
    -- end

    -- This setup() function is exactly the same as lspconfig's setup function.
    -- Refer to https://github.com/neovim/nvim-lspconfig/blob/master/doc/server_configurations.md
    server:setup(optts)
end)

-- Use a loop to conveniently call 'setup' on multiple servers and
-- map buffer local keybindings when the language server attaches
-- local servers = { 'rust_analyzer', 'tsserver', 'pylsp', 'ccls' }
-- for _, lsp in pairs(servers) do
-- require('lspconfig')[lsp].setup {
-- on_attach = on_attach,
-- flags = {
---- This will be the default in neovim 0.7+
-- debounce_text_changes = 150,
-- }
-- }
-- end

-- require'lspconfig'.eslint.setup {}

-- Go-to definition in a split window
local function goto_definition(split_cmd)
    local util = vim.lsp.util
    local log = require("vim.lsp.log")
    local api = vim.api

    -- note, this handler style is for neovim 0.5.1/0.6, if on 0.5, call with function(_, method, result)
    local handler = function(_, result, ctx)
        if result == nil or vim.tbl_isempty(result) then
            local _ = log.info() and log.info(ctx.method, "No location found")
            return nil
        end

        if split_cmd then vim.cmd(split_cmd) end

        if vim.tbl_islist(result) then
            util.jump_to_location(result[1])

            if #result > 1 then
                util.set_qflist(util.locations_to_items(result))
                api.nvim_command("copen")
                api.nvim_command("wincmd p")
            end
        else
            util.jump_to_location(result)
        end
    end

    return handler
end

vim.lsp.handlers["textDocument/definition"] = goto_definition('split')

-- 插入模式函数
require("lsp_signature").setup({
    bind = true,
    -- 边框样式
    handler_opts = {
        -- double、rounded、single、shadow、none
        border = "rounded"
    },
    -- 自动触发
    floating_window = false,
    -- 绑定按键
    toggle_key = "<C-j>",
    -- 虚拟提示关闭
    hint_enable = false,
    -- 正在输入的参数将如何突出显示
    hi_parameter = "LspSignatureActiveParameter"
})

-- code_action
-- lua/code_action_utils.lua
