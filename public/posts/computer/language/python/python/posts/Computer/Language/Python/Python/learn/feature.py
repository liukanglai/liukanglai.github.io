# !usr/bin/env python3
# Author:liukanglai
# Blog:
# Time:2022-03-14 11:05:25
# Name:feature.py
# Version:V1.0

# 切片

L = ['Michael', 'Sarah', 'Tracy', 'Bob', 'Jack']
L[0:3]  # (0,1,2)
L[-2:]
L[-2:-1]
L[:2]
print(L[:4:2])
print(L[:])
print('abcd'[::3])
print('abcd'[0:1:-1])  # 从start 往左搜，下标错误


def trim(s):
    while s:
        if s[0] == ' ':
            s = s[1:]
        elif s[-1] == ' ':
            s = s[:-1]
        else:
            break
    return s


print(trim(input('Please input a string: ')))

# Iteration

d = {'a': 1, 'b': 2, 'c': 3}
for key in d:
    print(key)
for value in d.values():
    print(value)
for k, v in d.items():
    print(k, v)
for ch in 'ABC':
    print(ch)

from collections.abc import Iterable

isinstance('abc', Iterable)
isinstance(d, Iterable)
isinstance(123, Iterable)

for i, value in enumerate(d):
    print(i, value)


def findMinAndMax(L):
    if len(L) == 0:
        return (None, None)

    else:
        max = L[0]
        min = L[0]
        for a in L:
            if a >= max:
                max = a
            if a <= min:
                min = a
        return (min, max)


# List Comprehensions
list(range(1, 11))
[x * x for x in range(1, 11)]

[x * x for x in range(1, 11) if x % 2 == 0]  # no else
[x if x % 2 == 0 else -x for x in range(1, 11)]  # must have else

[m + n for m in 'ABC' for n in 'XYZ']
d0 = {'a': 'x'}
[k + '=' + v for k, v in d0.items()]
#[k + '=' + v for k, v in d.items()]

import os

[file for file in os.listdir('.')]

[s.lower() for s in L]

# generator
L = [x * x for x in range(10)]
g = (x * x for x in range(10))
print(next(g))
for n in g:
    print(n)


# yield
def fib(max):
    n, a, b = 0, 0, 1
    while n < max:
        print(b)
        yield b
        a, b = b, a + b
        n = n + 1
    return 'done'


# get return
f = fib(6)
print(next(f))
while True:
    try:
        x = next(f)
        print('f:', x)
    except StopIteration as e:
        print('Generator return value:', e.value)
        break


# what will happen when function runs yield statement?
def odd():
    print('step 1')
    yield 1
    print('step 2')
    yield (3)
    print('step 3')
    yield (5)


o = odd()
for n in o:
    print(n)


# 杨辉三角
def triangles():
    results = []
    pre = []
    n = 1
    while True:
        results.append(1)
        k, p = n - 1, 0
        while k > 1:
            results.append(pre[p] + pre[p + 1])
            k = k - 1
            p = p + 1
        if n > 1:
            results.append(1)
        yield results
        pre = results
        results = []
        n = n + 1


r = triangles()
print(next(r))


# look this: ...
def triangles0():
    L = [1]
    while True:
        yield L
        L = [1] + [L[n] + L[n + 1] for n in range(len(L) - 1)] + [1]
        # L = [L[i-1] + L[i] if i!=0 and i!=len(L) else 1 for i in range(len(L)+1)]


# 我们已经知道，可以直接作用于for循环的数据类型有以下几种：
# 一类是集合数据类型，如list、tuple、dict、set、str等；
# 一类是 generator，包括生成器和带 yield 的 generator function。
# 这些可以直接作用于 for 循环的对象统称为可迭代对象：Iterable。
# 可以使用 isinstance() 判断一个对象是否是 Iterable 对象

isinstance((x for x in range(10)), Iterable)

# 可以被next()函数调用并不断返回下一个值的对象称为迭代器：Iterator
# 可以使用isinstance()判断一个对象是否是Iterator对象

from collections.abc import Iterator

isinstance((x for x in range(10)), Iterator)
isinstance([], Iterator)
isinstance(iter([]), Iterator)
isinstance(iter('abc'), Iterator)

# 集合数据类型如list、dict、str等是Iterable但不是Iterator，不过可以通过iter()函数获得一个Iterator对象。
# Python的for循环本质上就是通过不断调用next()函数实现的
