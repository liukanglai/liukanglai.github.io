# !usr/bin/env python3
# -*- coding: utf-8 -*-
# Author:liukanglai
# Blog:
# Time:2022-04-17 21:53:59
# Name:regex.py
# Version:V1.0

# 匹配字符串

# \d \w . *(>=0) +(>0) ?(0|1) {n} {n,m}

# \d{3}\s+\d{3,8}
# \d{3}\-\d{3,8}

# []表示范围
# [a-zA-Z\_][0-9a-zA-Z\_]*

# ^表示行的开头，^\d表示必须以数字开头。

# $表示行的结束，\d$表示必须以数字结束。

# re pattern
s = 'ABC\\-001'
s = r'ABC\-001'

import re

test = '用户输入的字符串'
if re.match(r'正则表达式', test):
    print('ok')
else:
    print('failed')

# 切分字符串
print('a b   c'.split(' '))
print(re.split(r'[\s\,]+', 'a, b, d  c'))

# 分组
m = re.match(r'^(\d{3})-(\d{3,8})$', '010-12345')
print(m)
print(m.group(0))
print(m.group(1))
print(m.group(2))

t = '14:59:0'
m = re.match(
    r'^(0[0-9]|1[0-9]|2[0-3]|[0-9])\:(0[0-9]|1[0-9]|2[0-9]|3[0-9]|4[0-9]|5[0-9]|[0-9])\:(0[0-9]|1[0-9]|2[0-9]|3[0-9]|4[0-9]|5[0-9]|[0-9])$',
    t)
print(m.groups())

# 贪婪匹配
print(re.match(r'^(\d+)(0*)$', '102300').groups())
print(re.match(r'^(\d+?)(0*)$', '102300').groups())

# 编译 预编译正则表达式，多次使用
re_telephone = re.compile(r'^(\d{3})-(\d{3,8})$')
re_telephone.match('010-12345').groups()
