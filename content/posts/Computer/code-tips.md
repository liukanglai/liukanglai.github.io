---
title: "一些编程注意点"
date: 2023-05-04T22:12:58+08:00
draft: false
tags: ["code"]
author: "liukanglai"
description: " "
---

## 技巧

- 哨兵!!!

## 错误

- 引用指针一定要判断 NULL
- 循环记得清空值，再来，指针不用
- 分配时检查是否成功
- 用户输入情况讨论
- 函数送入的是个啥?函数返回的是个啥?
- 释放内存

## talk about the a[++i]

such as:

        while(i < strlen(a)){
            if(a[++i]) a[i] = 0;
        }

        printf("%d %d %d",i++,++i,i);

- if i = strlen(a) - 1, then a[++j] is wrong.
- and if use a[i++], the a[i] will be wrong.
- the most important thing is that the ++ is transported in function.

so the best way is to use i++ out of the a[]...

---
