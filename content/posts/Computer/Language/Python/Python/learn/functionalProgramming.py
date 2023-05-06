# !usr/bin/env python3
# Author:liukanglai
# Blog:
# Time:2022-03-14 16:41:53
# Name:functionalProgramming.py
# Version:V1.0

# 函数是Python内建支持的一种封装，我们通过把大段代码拆成函数，通过一层一层的函数调用，就可以把复杂任务分解成简单的任务，这种分解可以称之为面向过程的程序设计。函数就是面向过程的程序设计的基本单元。

# 函数式编程就是一种抽象程度很高的编程范式，纯粹的函数式编程语言编写的函数没有变量，因此，任意一个函数，只要输入是确定的，输出就是确定的，这种纯函数我们称之为没有副作用。
# 而允许使用变量的程序设计语言，由于函数内部的变量状态不确定，同样的输入，可能得到不同的输出，因此，这种函数是有副作用的。

# 函数式编程的一个特点就是，允许把函数本身作为参数传入另一个函数，还允许返回一个函数！

# Python 对函数式编程提供部分支持。由于 Python 允许使用变量，因此，Python 不是纯函数式编程语言。

# 1. Higher-order function
f = abs
print(f(-10))
abs = 10
print(abs)
import builtins

builtins.abs = 10  # 修改abs变量的指向在其它模块也生效

# 既然变量可以指向函数，函数的参数能接收变量，那么一个函数就可以接收另一个函数作为参数，这种函数就称之为高阶函数。


def add(x, y, f):
    return f(x) + f(y)


print(add(5, -6, f))


# map()
def f2(x):
    return x * x


r = map(f2, [1, 2, 3, 4, 5, 6, 7, 8, 9])
print(next(r))
print(list(r))
print(tuple(map(str, [1, 2, 3])))


def add2(x, y):
    return x + y


# reduce()
from functools import reduce

print(reduce(add2, [1, 3, 5, 7, 9]))


def fn(x, y):
    return x * 10 + y


print(reduce(fn, [1, 3, 5, 7, 9]))

# string to int
DIGITS = {
    '0': 0,
    '1': 1,
    '2': 2,
    '3': 3,
    '4': 4,
    '5': 5,
    '6': 6,
    '7': 7,
    '8': 8,
    '9': 9,
    '.': '.'
}


def str2int(s):

    def fn(x, y):
        return x * 10 + y

    def char2num(s):
        return DIGITS[s]

    return reduce(fn, map(char2num, s))


# change capital and lower-case
def normalize(name):
    return name[0].upper() + name[1:].lower()


def normalize0(name):
    return name.title()


# string to float
def str2float(s):

    def char2num(s):
        return DIGITS[s]

    return reduce(fn, map(char2num, s))


# filter
def is_odd(n):
    return n % 2 == 1


# filter()函数返回的是一个Iterator，也就是一个惰性序列
list(filter(is_odd, [1, 2, 4, 5, 6, 9, 10, 15]))


# 计算素数的一个方法是埃氏筛法
def _odd_iter():
    n = 1
    while True:
        n = n + 2
        yield n


def _not_divisible(n):
    return lambda x: x % n > 0


def primes():
    yield 2
    it = _odd_iter()
    while True:
        n = next(it)
        yield n
        it = filter(_not_divisible(n), it)


# 打印1000以内的素数:
def pprime():
    for n in primes():
        if n < 1000:
            print(n)
        else:
            break


# 回数
def is_palindrome(n):
    return str(n) == str(n)[::-1]


# print('abcdefghijklm'[10:2:-1])

print(list(filter(is_palindrome, range(1, 100))))

# sorted
sorted([209, -92, 29, -20])
sorted([209, 92, 29, 20], key=f)
sorted(['bob', 'about', 'Zoo', 'Credit'])
sorted(['bob', 'about', 'Zoo', 'Credit'], key=str.lower)
sorted(['bob', 'about', 'Zoo', 'Credit'], key=str.lower, reverse=True)

L = [('Bob', 75), ('Adam', 92), ('Bart', 66), ('Lisa', 88)]


def by_name(t):
    return t[0]


def by_score(t):
    return -t[1]
    return t[-1]


print(sorted(L, key=by_name))
print(sorted(L, key=by_score))


# 2. return function 闭包（Closure）
def lazy_sum(*args):

    def sum():
        ax = 0
        for n in args:
            ax = ax + n
        return ax

    return sum


f = lazy_sum(1, 3, 5, 7, 9)
print(f)
print(f())
f1 = lazy_sum(1, 3, 5, 7, 9)
print(f == f1)


def count():
    fs = []
    for i in range(1, 4):

        def f():
            return i * i

        fs.append(f)
    return fs


f1, f2, f3 = count()
print(f1(), f2(), f3())  # 返回闭包时牢记一点：返回函数不要引用任何循环变量，或者后续会发生变化的变量。


def count():

    def f(j):

        def g():
            return j * j

        return g

    fs = []
    for i in range(1, 4):
        fs.append(f(i))  # f(i)立刻被执行，因此i的当前值被传入f()
    return fs


f1, f2, f3 = count()
print(f1(), f2(), f3())


# nonlocal
def inc():
    x = 0

    def fn():
        # 仅读取x的值:
        return x + 1

    return fn


f = inc()
print(f())
print(f())


def inc():
    x = 0

    def fn():
        nonlocal x
        x = x + 1
        return x

    return fn


f = inc()
print(f())
print(f())

# 匿名函数
list(map(lambda x: x * x, [1, 2, 3, 4, 5, 6, 7, 8, 9]))

f = lambda x: x * x
f(5)


def build(x, y):
    return lambda: x * x + y * y


# 装饰器 decorator
def now():
    print('2022-03-19')


print(now.__name__)


def log(func):

    def wrapper(*args, **kw):
        print('call %s():' % func.__name__)
        return func(*args, **kw)

    return wrapper


@log  # same as now = log(now)
def now():
    print('2022-03-19')


print(now())


# 带参
def log(text):

    def decorator(func):

        def wrapper(*args, **kw):
            print('%s %s():' % (text, func.__name__))
            return func(*args, **kw)

        return wrapper

    return decorator


@log('execute')  # is now = log('execute')(now)
def now():
    print('2022-03-19')


print(now())

# restore name
print(now.__name__)  # wrong, need: functools

import functools


def log(func):

    @functools.wraps(func)
    def wrapper(*args, **kw):
        print('call %s():' % func.__name__)
        return func(*args, **kw)

    return wrapper


def log(text):

    def decorator(func):

        @functools.wraps(func)
        def wrapper(*args, **kw):
            print('%s %s():' % (text, func.__name__))
            return func(*args, **kw)

        return wrapper

    return decorator


# work 在调用之前打印，在之后呢？
import time, functools


def metric(fn):

    @functools.wraps(fn)
    def do_time(*args, **kw):
        print('%s executed in %s ms' % (fn.__name__, 10.24))
        return fn(*args, **kw)

    return do_time


@metric
def fast(x, y):
    time.sleep(0.0012)
    return x + y


print(fast(11, 22))

# 偏函数 partial function 把一个函数的某些参数给固定住（也就是设置默认值），返回一个新的函数，调用这个新函数会更简单。
print(int('1235'))
print(int('1235', base=8))
print(int('1235', 16))


def int2(x, base=2):
    return int(x, base)


print(int2('10110'))

# no need to def
import functools

int2 = functools.partial(int, base=2)
print(int2('10010'))  # look follow:
kw = {'base': 2}
int('10010', **kw)

int2('1000000', base=10)  # you can also define argument by yourself.
