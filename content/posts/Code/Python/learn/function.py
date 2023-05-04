# !usr/bin/env python3
# Author:liukanglai
# Blog:
# Time:2022-03-14 09:03:07
# Name:function.py
# Version:V1.0

# function (look doc)

print(abs(-100))
max(1, 2, -10)

print(int('123'))
print(float('12.3'))
print(str(12.3))
print(bool(1))
print(bool('1'))
print(bool(''))

a = abs
print(a(-9))

print(str(hex(78)))

# define


def my_abs(x):  # from function(no .py) import my_abs
    if not isinstance(x, (int, float)):
        raise TypeError('bad operand type')
    if x >= 0:
        return x
    else:
        return -x
    return


print(my_abs(-9))


def nonefunction():
    pass


if 1 > 2:
    pass

import math


def move(x, y, step, angle=0):
    nx = x + step * math.cos(angle)
    ny = y + step * math.sin(angle)
    return nx, ny


x, y = move(100, 100, 60, math.pi / 6)
print(move(100, 100, 60, math.pi / 6))  # return a tuple!
print(x, y)


# 位置参数
def power(p, n):
    s = p
    while n > 1:
        s = s * p
        n = n - 1
    return s


# 默认参数
def power2(p, n=2, x=4):
    s = p
    while n > 1:
        s = s * p
        n = n - 1
    return s


print(power2(5))
power2(2, x=3)
power2(2, 2)
power2(2, 2, 3)


def add_end(L=[]):
    L.append('END')
    return L


print(add_end())
print(add_end())  # !!! need unchangable variable


def add_endNone(L=None):
    if L is None:
        L = []
    L.append('END')
    return L


# 不变对象一旦创建，对象内部的数据就不能修改，这样就减少了由于修改数据导致的错误。此外，由于对象不变，多任务环境下同时读取对象不需要加锁，同时读一点问题都没有。


# 可变参数
def calc(*numbers):
    sum = 0
    for n in numbers:
        sum = sum + n * n
    return sum


print(calc())
print(calc(1, 2))

nums = [1, 2, 3]
calc(*nums)  # one by one to transport.


# 关键字参数 dict
def person(name, age, **kw):
    print('name:', name, 'age:', age, 'other:', kw)


person('Michael', 30)
person('Bob', 35, city='Beijing')
person('Adam', 45, gender='M', job='Engineer')

extra = {'city': 'Beijing', 'job': 'Engineer'}
person('Jack', 24, **extra)


# 命名关键字参数 (限制关键字参数？) 和普通参数有何不同？
def personRestrict(name, age, *, city, job):
    print(name, age, city, job)


personRestrict('Jack', 24, city='Beijing', job='Engineer')


def person0(name, age, *args, city, job):
    print(name, age, args, city, job)


def person1(name, age, *, city='Beijing', job):
    print(name, age, city, job)


# 参数组合 参数定义的顺序必须是：必选参数、默认参数、可变参数、命名关键字参数和关键字参数。
# 所以，对于任意函数，都可以通过类似 func(*args, **kw) 的形式调用它，无论它的参数是如何定义的。


# recursion (stack overflow)
def fact(n):
    if n == 1:
        return 1
    return n * fact(n - 1)


# 尾递归是指，在函数返回的时候，调用自身本身，并且，return语句不能包含表达式。
# 这样，编译器或者解释器就可以把尾递归做优化，使递归本身无论调用多少次，都只占用一个栈帧，不会出现栈溢出的情况。
# 遗憾的是，大多数编程语言没有针对尾递归做优化，Python解释器也没有做优化，所以，即使把上面的fact(n)函数改成尾递归方式，也会导致栈溢出。


def fact0(n):
    return fact_iter(n, 1)


def fact_iter(num, product):
    if num == 1:
        return product
    return fact_iter(num - 1, num * product)


def Hanoi(n, a, b, c):
    if n > 1:
        Hanoi(n - 1, a, c, b)
        print(a, '-->', c)
        Hanoi(n - 1, b, a, c)
    else:
        print(a, '-->', c)
