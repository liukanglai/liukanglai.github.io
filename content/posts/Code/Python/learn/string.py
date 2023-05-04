# !usr/bin/env python3
# -*- coding: utf-8 -*-
# Author:liukanglai
# Blog:
# Time:2022-05-20 08:09:42
# Name:string.py
# Version:V1.0

# string
STRING = 'abc'  # '' or ""
STRING = '1'

# escape
STRING = "a'bc"
print("a\'b\"c\"")

# format

print('Hello, %s' % 'world')
print('Hello, %s, %d' % ('world', 100))  # %d %f %s %x(0x int) %%(no \%) ...

name = 'liu'
# name[0] = 'k' ?
number = 19.2
print('%-f' % number)
print('Hello, {0}, 成绩提升了 {1:.1f}%'.format('小明', number))
print(f'The area of a circle with radius {name} is {number:.2f}')

print('hello ' + name * 3)

print("\n, \t, \\")
print(r"\n, \t, \\")

print('''line0
line1
line2 ''')  # no print(r''' ''')

# I/O

print(10 + 10)
print('10 + 10 =', 10 + 10)
print('hell', 'j', "jslg")  # , will be space

name = input('please enter your name: ')
print('hello:', name)

birthday = input('birth: ')
print(birthday)
