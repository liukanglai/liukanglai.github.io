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
