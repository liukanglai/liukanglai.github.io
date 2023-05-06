-- if you don't want all the parsers change this to a table of the ones you want
lvim.builtin.treesitter.ensure_installed = {
	"bash",
	"vim",
	"lua",
	"c",
	"cpp",
	"make",
	"cmake",
	"java",
	"python",
	"scheme",
	"javascript",
	"json",
	"jsonc",
	"typescript",
	"tsx",
	"css",
	"yaml",
	"html",
	"rust",
	"go",
	"gomod",
	"latex",
	"markdown",
	"regex",
}

lvim.builtin.treesitter.ignore_install = { "haskell" }
lvim.builtin.treesitter.highlight.enable = true
lvim.builtin.treesitter.rainbow.enable = true
