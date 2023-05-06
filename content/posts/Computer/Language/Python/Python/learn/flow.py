# !usr/bin/env python3
# -*- coding: utf-8 -*-
# Author:liukanglai
# Blog:
# Time:2022-05-20 09:08:54
# Name:flow.py
# Version:V1.0

import math

# control-flow
# and or not

number = 100
if number >= 0:  # must indent
    print(number)
else:
    print(-number)

if number > 0:
    print(number)
elif number > 100:
    print(number + number)
else:
    print(number + number + number)

# Loop
classmates = ['Cong', 'Yuan', 'Che']
for mate in classmates:
    print(mate)
sum = 0
for x in list(range(101)):
    sum = sum + x
print(sum)

number = 100
while number > 0:
    if number > 10:
        break
        continue
    sum = sum + number
    number = number - 2
print(sum)

# exercise/practice
n = input('Please input a odd number: ')
n = int(n)


def addflag0():
    sum = 0
    flag = 0
    i = 1
    while i <= n:
        if flag:
            sum -= i
            flag = 0
        else:
            sum += i
            flag = 1
        i = i + 2
    print(sum)


def addflag1():
    sum = 0
    flag = 1
    for i in range(1, 2 * n, 2):
        sum += i * flag
        flag = flag * (-1)
    print(sum)


def findFlower():
    for i in range(100, 1000):
        a = i // 100
        b = i // 10 % 10
        c = i % 10
        if math.pow(a, 3) + math.pow(b, 3) + math.pow(c, 3) == i:
            print(i)
