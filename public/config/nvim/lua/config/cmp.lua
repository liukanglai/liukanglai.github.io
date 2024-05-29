-- Setup nvim-cmp.
local cmp = require 'cmp'

cmp.setup({
    mapping = {
        ['<Tab>'] = function(fallback)
            if cmp.visible() then
                cmp.select_next_item()
            else
                fallback()
            end
        end,
        ['<C-b>'] = function(fallback)
            if cmp.visible() then
                cmp.select_prev_item()
            else
                fallback()
            end
        end,
        -- ['<Esc>'] = cmp.mapping.close(),
        -- ['<CR>'] = cmp.mapping.confirm({select = true}),
        ['<C-y>'] = cmp.config.disable,
        ['<C-d>'] = cmp.mapping(cmp.mapping.scroll_docs(-4), {'i', 'c'}),
        ['<C-f>'] = cmp.mapping(cmp.mapping.scroll_docs(4), {'i', 'c'}),
        ['<C-Space>'] = cmp.mapping(cmp.mapping.complete(), {'i', 'c'}),
        ['<C-e>'] = cmp.mapping({
            i = cmp.mapping.abort(),
            c = cmp.mapping.close()
        })
    },
    sources = {
        {name = 'nvim_lsp'}, -- For nvim-lsp
        -- { name = 'ultisnips' }, -- For ultisnips user.
        {name = 'nvim_lua'}, -- for nvim lua function
        {name = 'path'}, -- for path completion
        {name = 'buffer', keyword_length = 1}, -- for buffer word completion
        {name = 'look', insert = true}, {name = 'spell', insert = true},
        {name = 'omni'}, {name = 'emoji', insert = true} -- emoji completion
    },
    completion = {keyword_length = 1, completeopt = "menu,noselect"},
    experimental = {ghost_text = false}

    -- formatting = {
    -- format = lspkind.cmp_format({
    -- with_text = false,
    -- menu = {
    -- nvim_lsp = "[LSP]",
    ---- ultisnips = "[US]",
    -- nvim_lua = "[Lua]",
    -- path = "[Path]",
    -- buffer = "[Buffer]",
    -- emoji = "[Emoji]"
    -- }
    -- })
    -- }
})

-- Use buffer source for `/` (if you enabled `native_menu`, this won't work anymore).
cmp.setup.cmdline('/', {sources = {{name = 'buffer'}}})

-- Use cmdline & path source for ':' (if you enabled `native_menu`, this won't work anymore).
cmp.setup.cmdline(':', {
    sources = cmp.config.sources({{name = 'path'}}, {{name = 'cmdline'}})
})

