# !usr/bin/env python3
# -*- coding: utf-8 -*-
# Author:liukanglai
# Blog:
# Time:2022-05-20 10:14:40
# Name:test.py
# Version:V1.0

list0 = [5, 8, -7, 4, 6, 2, -3, 0]
print(list0)

print(max(list0))

minIndex = list0.index(min(list0))
del list0[minIndex]
print(list0)
print(list(map(abs, list0)))
'''
for i in range(7):
    if list0[i] < 0:
        list0[i] = -list0[i]

print(list0)
'''


def triangles():
    L = [1]
    while True:
        yield L
        L = [1] + [L[n] + L[n + 1] for n in range(len(L) - 1)] + [1]


r = triangles()

for i in range(6):
    s = " ".join(map(str, next(r)))
    print(s.center(6 * 2))
