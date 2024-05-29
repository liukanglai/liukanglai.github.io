#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# comment
'''
jajgjgja
'''
"""
j
"""

# naming-style
# upper camel case: 首字母大写
# lower camel case: myCar
# 下划线：my_car

# variable 无需声明，无需类型

# int (no limit for size)
NUMBER = 1_000_000_000
HEXO = 0xabc3_abc  # 0b 0o
NUM = int('8')
a = b = 1
a, b, c = 1, 2, 3

# float (no limit for size, but there is a sign of 'inf' to display infinite)
FLOAT = -1.23
FLOAT = 1.23e9
FLOAT = 1.23e-5

# boolen
# Python 2：None, 0, 和空字符串都被算作 False，其他的均为 True
# Python 3：None，0，空字符串，空列表，空字典都算是False，所有其他值都是True
print(3 > 2)  # boolean
bool0 = False  # and or not

no = None
no = 1  # dynamic language
no = 'a'
print(no)

# constant
PI = 3.14159265359

# character (Unicode)
print('包含中文的str')

X = b'ABC'  # (bytes)
'ABC'.encode('ascii')
'中文'.encode('utf-8')
b'ABC'.decode('ascii') == 'ABC'
b'\xe4\xb8\xad\xe6\x96\x87'.decode('utf-8') == '中文'
b'\xe4\xb8\xad\xff'.decode('utf-8', errors='ignore')
len('ABC') == 3
len('中文') == 2
len('中文'.encode('utf-8')) == 6

# operation
print(10 / 3)
print(10 // 3)
print(10 % 3)
print(10**3)
ord('中')
chr(66)
print('\u4e2d\u6587')
a, b = 3, 5
c = a if a > b else b
c = {True: a, False: b}[a > b]
c = (a, b)[a > b]
