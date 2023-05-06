---
title: "IntroductionToAlgorithm小记"
date: 2023-03-28T12:44:45+08:00
draft: false
tags: ["Algorithm"]
author: "liukanglai"
description: " "
---

# analysis

## T(n)

- worst time
- average time: weighted average
- best time(bogus): cheat

## time

1. computer

- relative speed(same computer)
- absolute speed(different computer)

# asymptotic analysis

- (渐进分析)，忽略依赖机器的常量，不检查实际运行时间，关注运行时间的增长
- 去低阶，去常量
- n-> ,

- &Theta;(): O and &Omega;, seem as =, 忽略了。。。
- O(): \<=; Ex: 2n^2 = O(n^3) (2n^2 &in; O(n^3))
- o(): <
- &Omega;(): >=
- &omega;(): >

# recurrences

> use recursion tree to guess, than use substitution to proof

1. substitution, 归纳

   - guess the form, such as n^2...
   - 归纳
   - 求常数

     T(n) = 4T(n/2) + n, T(1) = &Theta;(1)

     1. T(n) = O(n^2)
     2. assume: T(k) <= ck^2, k <=n
        T(n) <= cn^2 + n ... <= cn^2 即可
        can't, let T(k) <= c1k^2 -c2k
     3. make a c, remember the T(1)

2. recursion tree

> 1 + 1/2 + 1/4 + ... use binary, is 1.1111... is 2

        T(n) = T(n/4) + T(n/2) + N^2 is O(n^2)
        对每一层就解，然后相加，可找规律

3. master method
   - 特定的递归：T(n) = aT(n/b) + f(n), a >= 1, b > 1, n >= n0 with f(n) > 0;
   1. compare f(n) with n^logb(a)(树叶节点)
      - f(n) = O(n^(logb(a)-c)), c > 0; T(n) = &Theta;(n^logb(a))
      - f(n) = &Theta;(n^logb(a) _ log2n ^ k), k >= 0; T(n) = &Theta;(n^logb(a) _ log2n ^(k+1))
      - f(n) = &Omega;(n^logb(a) + c), c > 0, af(n/b) <= (1-c0)f(n), c0 > 0 上一层大于下一层; T(n) = &Theta;(f(n))

# design

# divide and conquer

1. divide
2. conquer
3. combine

# sorting

1.  insertion sort algorithm

        for j <- [1-n];
            key = a[j];
            i = j - 1;
            while(i >= 0)
                a[i+1] = a[i];
                if(a[i--] < key)
                    break;
            a[i+1] = key;

            while(i >= 0 && a[i] > key)
                a[i+1] = a[i];
                i--;
            a[i+1] = key;

- &theta;(n^2)

2. merge sort

   - n = 1, break; &theta;(1) just a constant
   - recursively sort a[0, n/2(向上取整)] and a[n/2 + 1(向下取整), n]; 2T(n/2)
   - merge subroutine. &theta;(n)

   - conquer: 比较两数组的第一项，谁小入谁，接着比.

- T(n) = 2T(n/2) + cn = 2(2T(n/4) +cn/2) + cn = ...
- recursive tree, height is lg2n, leaves are n
- T(n) = (cn)lg2n + &theta;(n) = &theta;(nlg2n)

# Binary search

- T(n) = T(n/2) + &Theta;(1) = &Theta;(log2n)

# Fibonacci numbers

- f(n) = 0, n = 0
- f(n) = 1, n = 1
- f(n) = f(n-1) + f(n-2), n >= 2

1. native recursive

   - &Omega;(&phi;^n); &phi; = (1 + $\sqrt{2}$)/2

2. Bottom-up
   - compute f0, f1, f2...; T(n) = &Theta;(n)

---
