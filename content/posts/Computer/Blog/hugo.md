---
title: ""
draft: false
tags: ["first"]
author: "liukanglai"
# author: ["Me", "You"] # multiple authors
showToc: true
TocOpen: false
hidemeta: false
comments: false
description: "Desc Text."
canonicalURL: "https://canonical.url/to/page"
disableHLJS: true # to disable highlightjs
disableShare: false
disableHLJS: false
hideSummary: false
searchHidden: true
ShowReadingTime: true
ShowBreadCrumbs: true
ShowPostNavLinks: true
ShowWordCount: true
ShowRssButtonInSectionTermList: true
UseHugoToc: true
cover:
    image: "<image path/url>" # image path/url
    alt: "<alt text>" # alt text
    caption: "<text>" # display caption under cover
    relative: false # when using page bundles set this to true
    hidden: true # only hide on current single page
editPost:
    URL: "https://github.com/<path_to_repo>/content"
    Text: "Suggest Changes" # edit text
    appendFilePath: true # to append file path to Edit link
---# Hugo

## install

- sudo pacman -S hugo
- hugo version
- hugo new site studyhugo

## quickstart

1. git init

2. theme

   - git submodule add `https://github.com/olOwOlo/hugo-theme-even themes/even`
   - cp themes/even/exampleSite/config.toml ./

3. content

   - hugo new posts/my-first-post.md (in even, need post)

4. hugo serve -D(-D make draft push)

5. `http://127.0.0.1:1313`

> build static pages: hugo -D, int /public, (don't need if you use github pages)

## github pages

1. create a new repository: liukanglai.github.io
2. create a new file: index.html

```bash
echo "# liukanglai.github.io" >> README.md
git add .
git commit -m "first commit"
git branch -M main
git remote add origin git@github.com:liukanglai/liukanglai.github.io.git
git push -u origin main
```

- git actions -> set up a workflow yourself -> .github/workflows/gh-pages.yml
- paste the [code](https://gohugo.io/hosting-and-deployment/hosting-on-github/)
- commit

- git pull

- 需要修改 config.toml 里的 baseURL 的参数，确保改成 username.github.io
- baseURL = "http://nightan42643.github.io"

> the draft will not publish

- domain:
- static/CNAME: write your domain: liukanglai.tk

## config
