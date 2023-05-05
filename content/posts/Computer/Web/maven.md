#

> `https://how2j.cn/k/maven/maven-introduction/1328.html`

- maven:
- 专门用于构建和管理 java 项目的工具，
- Maven 是意第绪语，依地语（犹太人使用的国际语），表示专家的意思

## use

- 使用 Maven 管理的 Java 项目都有着相同的项目结构

1. 有一个 pom.xml 用于维护当前项目都用了哪些 jar 包
2. 所有的 java 代码都放在 src/main/java 下面
3. 所有的测试代码都放在 src/test/java 下面

比如说有 3 个 Java 项目，这些项目都不是 maven 风格。那么这 3 个项目，就会各自维护一套 jar 包。 而其中有些 jar 包是相同的。

而 maven 风格的项目，首先把所有的 jar 包都放在"仓库“ 里，
然后哪个项目需要用到这个 jar 包，只需要给出 jar 包的名称和版本号就行了。 这样 jar 包就实现了共享

如图所示，在 pom.xml 里，表示用到了 mysql 的 jar 包，版本号是 5.1.30。

## j

- 当浏览器向服务器发送请求获取 HTML 文件时，HTML 文件通常包含 `<link>` 和 `<script>` 元素，
- 这些元素分别指向了外部的 CSS 样式表文件和 JavaScript 脚本文件。
- 了解这些文件被浏览器解析的顺序是很重要的：

1. 浏览器首先解析 HTML 文件，并从中识别出所有的 `<link>` 和 `<script>` 元素，获取它们指向的外部文件的链接。

1. 继续解析 HTML 文件的同时，浏览器根据外部文件的链接向服务器发送请求，获取并解析 CSS 文件和 JavaScript 脚本文件。

1. 接着浏览器会给解析后的 HTML 文件生成一个 DOM 树（在内存中），

1. 会给解析后的 CSS 文件生成一个 CSSOM 树（在内存中），并且会编译和执行解析后的 JavaScript 脚本文件。

1. 伴随着构建 DOM 树、应用 CSSOM 树的样式、以及执行 JavaScript 脚本文件，浏览器会在屏幕上绘制出网页的界面；用户看到网页界面也就可以跟网页进行交互了。

## npm

- command: npm update npm audit npm ls npm run dev

- npm init: create package.json
- npm install parcel
- npx parcel
- npx parcel build index.html

1. for reduce

- parcel build index.html --experimental-scope-hoisting

## toolchain

- JSX, a React-related set of syntax extensions that allow you to do things like defining component structures inside JavaScript. You won't need to know React to follow this tutorial, but we've included this to give you an idea of how a non-native web language could be integrated into a toolchain.
- The latest built-in JavaScript features (at time of writing), such as import.
- Useful development tools such as Prettier for formatting and ESLint for linting.
- PostCSS: to provide CSS nesting capabilities.
- Parcel: to build and minify our code, and to write a bunch of configuration file content automatically for us.
- GitHub: to manage our source code control.
- Netlify: to automate our deployment process.
