---
title: "Git"
date: 2023-03-28T13:01:49+08:00
draft: false
tags: ["git"]
author: "liukanglai"
description: " "
---

# git

- 工作区 暂存区(stage) git 仓库

## command

    init    add .     config --global    commit -m ""     remote add origin    push

- git init: 在当前目录生成

- git status: 查看状态
- git add (file): . 代表所有, 准备提交
- git diff: 查看改动
- git log

- git ls-files: 查看仓库内容
- git rm --cached "....": 停止追踪
- git checkout: 仓库到本地
- git rm ...: 同时删除本地和仓库

## config

- git config list
- git config --global user.name/email ""
- git commit -m "description": if no -m, it will a vi,then you can write it
- git commit -a : add+commit,but 未追踪 file no
- git config --global core.editor vim

## reset

- git reset: 撤销 add 操作(git reset HEAD) 只更改暂存区
- git reset --hard HEAD~1: 工作区目录也更改，回退 1 下
- git reset --hard 897d...
- git reflog: look up all log

## more

- vim .gitignore: write a file name --还没有追踪的 file

## 远程仓库

- git clone http
- git pull : 下载更新
- git pull --rebase

- git push --set-upstream origin master
- git push -u origin master

- git blame 查看历史(人)

## branch

- git branch name: create a branch
- git checkout ...: 切换 branch
- git checkout -b name: create and change
- git merge ...: 合并 branch
- git branch -d ...: del -D 强制
- git branch: look all branch
- git branch -m oldbranch newbranch: rename

### 远程分支

- git branch -a: 查看本地与远程分支
- git push origin ...: push 分支
- git fetch: 查看远程分支
- git push origin :...: delete 远程分支，本地还有
- git checkout -b local_branch origin/remote...: 拉取远程分支到本地

### merge 冲突

- 查看冲突文件
- 与远程冲突时，先拉一下 pull

## tag(发布版本)

- git tag ...

## ssh

    git config --global user.name “xxxxname”
    git config --global user.email “171xxxx887@qq.com”
    git config --global credential.helper cache

- In github: picture->settings->ssh and gpg keys->new ssh key-paste your ssh
- your ssh: rm -r .ssh
- creat:ssh-keygen -t rsa -C "liukanglai" (or: email)
- cat ~/.ssh/id_rsa.pub (copy it to github's ssh)
- ssh -T git@github.com (check)

## gitpush

- 本地提交代码免密码提交（ssh 方式）
- 使用如下命令：git remote -v，会出现如下内容：

      origin https://github.com/lony2016/myLeetcode.git (fetch)
      origin https://github.com/lony2016/myLeetcode.git (push)

- 出现上述内容说明还是通过 https 方式访问的。

- 下面把访问方式改为 ssh 方式，输入如下命令：
- git remote set-url origin git@github.com:liukanglai/Learing.git

---
