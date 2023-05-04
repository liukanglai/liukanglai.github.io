---
title: "Hexo"
date: 2023-03-28T13:00:12+08:00
draft: false
tags: ["blog"]
author: "liukanglai"
description: " "
---

# install

1. node.js
2. npm (or cnpm..)
3. npm install hexo, than PATH="$PATH:./node_modules/.bin" in .zshrc
4. npx hexo

- sudo npm -g uninstall
- npm install -g cnpm --registry='https://registry.npm.taobao.org'
- npm config set registry 'https://registry.npm.taobao.org'
- 再次安装： cnpm install hexo-renderer-sass --save

## config

- mkdir blog
- cd
- 初始化：hexo init
- npm install
- 生成页面：hexo g
- hexo s (server)
- 增加文件：heso n "..."

  > cd
  >
  > cd ../..

- hexo clean
- hexo g
- hexo d

## push

- github: liukanglai.github.io
- sudo npm install --save hexo-deployer-git
- vim \_config.yml

  低部:deployment
  type: git
  repo: git@github.com:liukanglai/liukanglai.github.io.git or https://github.com/liukanglai/liukanglai.github.io.git
  branch: master

- ssh-keygen -t rsa -C Email # Email 替换为 git 配置的用户邮箱
- cat ~/.ssh/id_rsa.pub # 查看 public key，复制内容到 github 账户设置页
- ssh -T git@github.com # 测试 ssh 认证

- hexo g
- hexo d

        使用自己的域名，用Git pages 解析：
        1. created a file CNAME, (防止在push时消失，建立在source文件夹中)
        2. write your 域名(无前缀，ps：liukanglai.tk) in it
        3. 域名解析，加记录，可ip地址（ping 原域名得到），可直接原域名

## themes

- git clone ... themes/...
- vim \_config.yml
- theme: ...(修改)
  > use [even](https://github.com/ahonn/hexo-theme-even)

## write

- default_layout: ...

1. post, 文章, in source/posts, show in the website

   - > hexo n ...

2. page, 页面, 用于首页，归档等

```markdown
menu:
home: / || home
about: /about/ || user

- tags: /tags/ || tags
- categories: /categories/ || th
- archives: /archives/ || archive
  其中，|| 之前的值表示菜单链接，之后的值表示所用的 FontAwesome 图标名称。
```

- hexo new page ... in `http://localhost:4000/.../`
- will create a folder under source, in it the index.md can be eidted.

- draft > hexo new draft ... > > hexo server --draft

## RSS

- look your using theme.
  ps: in themes/\_config.yml

      	url:
      	rss: atom.xml

- than your rss url is `https://你的博客域名/atom.xml`

## discuss

- look your using theme.

## 数据统计与分析

- look your using theme.

## 搜索引擎优化（SEO）

- 前往 Google 搜索的[控制台](https://search.google.com/search-console/not-verified?original_url=/search-console/ownership&original_resource_id)添加自己的博客地址
- [Bing](https://www.bing.com/toolbox/webmaster/)

这一步就是告诉搜索引擎你的网站有哪些链接，提交后搜索引擎就会自动顺着站点地图中的链接爬取你的站点内容了，若是没有这一步，在搜索引擎当中直接搜索自己的博客地址是没有任何结果的。要完成这一步骤，需要在博客目录下输入以下指令安装 hexo-generator-sitemap 插件：

npm install hexo-generator-sitemap --save
这个插件默认站点地图生成路径为 https://你的博客域名/sitemap.xml，在使用 hexo g 重新生成网址内容后，将此网址提交到各个搜索引擎就可以了，以 Google 为例子，只需要发送 http://www.google.com/ping?sitemap=https://你的博客域名/sitemap.xml 这个网络请求即可，也可以在 Google 搜索控制台中的 sitemaps（站点地图）一栏提交自己的站点地图。而 Bing 则是需要在其 Web 面板中添加 sitemap。

> `http://www.guxiaobei.com/submit-your-content-of-google.html` > `https://viflythink.com/Use_GithubPages_and_Hexo_to_build_blog_advanced/` > `https://hoxis.github.io/Hexo+Next%20SEO%E4%BC%98%E5%8C%96.html`

- 打开'https://www.google.com/webmasters/tools'，转到网址检查，输入你的新页面的网址，这就可以及时提交新的网页了。

## HTTPs

- `https://tzhou2018.github.io/2018/04/%E4%B8%BAGitHub-Pages%E8%87%AA%E5%AE%9A%E4%B9%89%E5%9F%9F%E5%90%8D%E5%B9%B6%E6%B7%BB%E5%8A%A0SSL-%E5%BC%80%E5%90%AFHTTPS%E5%BC%BA%E5%88%B6/`

---
