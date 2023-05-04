# !usr/bin/env python3
# -*- coding: utf-8 -*-
# Author:liukanglai
# Blog:
# Time:2022-04-02 16:03:52
# Name:debug.py
# Version:V1.0
"""
在程序运行过程中，总会遇到各种各样的错误。

有的错误是程序编写有问题造成的，比如本来应该输出整数结果输出了字符串，这种错误我们通常称之为bug，bug是必须修复的。

有的错误是用户输入造成的，比如让用户输入email地址，结果得到一个空字符串，这种错误可以通过检查用户输入来做相应的处理。

还有一类错误是完全无法在程序运行过程中预测的，比如写入文件的时候，磁盘满了，写不进去了，或者从网络抓取数据，网络突然断掉了。这类错误也称为异常，在程序中通常是必须处理的，否则，程序会因为各种问题终止并退出。

Python内置了一套异常处理机制，来帮助我们进行错误处理。

此外，我们也需要跟踪程序的执行，查看变量的值是否正确，这个过程称为调试。Python的pdb可以让我们以单步方式执行代码。

最后，编写测试也很重要。有了良好的测试，就可以在程序修改后反复运行，确保程序输出符合我们编写的测试。

"""

# 返回错误代码

try:
    print('try...')
    r = 10 / 0
    print('result:', r)
except ZeroDivisionError as e:
    print('except:', e)
finally:  # must be executed
    print('finally...')
print('END')

try:
    print('try...')
    r = 10 / int('2')
    print('result:', r)
except ValueError as e:
    print('ValueError:', e)
except ZeroDivisionError as e:
    print('ZeroDivisionError:', e)
else:
    print('no error!')
finally:
    print('finally...')
print('END')

# Python所有的错误都是从BaseException类派生的，常见的错误类型和继承关系看这里：
# https://docs.python.org/3/library/exceptions.html#exception-hierarchy


def foo(s):
    return 10 / int(s)


def bar(s):
    return foo(s) * 2


def main():
    try:
        bar('0')
    except Exception as e:
        print('Error:', e)
    finally:
        print('finally...')


# 不需要在每个可能出错的地方去捕获错误，只要在合适的层次去捕获错误就可以了

# 调用栈
# 如果错误没有被捕获，它就会一直往上抛，最后被Python解释器捕获，打印一个错误信息，然后程序退出。
"""
def foo(s):
    return 10 / int(s)


def bar(s):
    return foo(s) * 2


def main():
    bar('0')


main()
"""

# 判断错误信息

# 我们能捕获错误，就可以把错误堆栈打印出来，然后分析错误原因，同时，让程序继续执行下去。

# Python内置的logging模块可以非常容易地记录错误信息：

import logging


def foo(s):
    return 10 / int(s)


def bar(s):
    return foo(s) * 2


def main():
    try:
        bar('0')
    except Exception as e:
        logging.exception(e)


main()
print('END')


# 抛出错误
class FooError(ValueError):
    pass


def foo(s):
    n = int(s)
    if n == 0:
        raise FooError('invalid value: %s' % s)
    return 10 / n


foo('0')


def foo(s):
    n = int(s)
    if n == 0:
        raise ValueError('invalid value: %s' % s)
    return 10 / n


def bar():
    try:
        foo('0')
    except ValueError as e:
        print('ValueError!')
        raise  # 向上抛


try:
    10 / 0
except ZeroDivisionError:
    raise ValueError('input error!')  # 转换类型

bar()

# debug


# 断言 assert
def foo(s):
    n = int(s)
    assert n != 0, 'n is zero!'
    return 10 / n


# 程序中如果到处充斥着assert，和print()相比也好不到哪去。不过，启动Python解释器时可以用-O参数来关闭assert: python -O err.py

# logging 终极
# 它允许你指定记录信息的级别，有debug，info，warning，error等几个级别，当我们指定level=INFO时，logging.debug就不起作用了。
# 指定level=WARNING后，debug和info就不起作用了。这样一来，你可以放心地输出不同级别的信息，也不用删除，最后统一控制输出哪个级别的信息。
import logging

logging.basicConfig(level=logging.INFO)
s = '0'
n = int(s)
logging.info('n = %d' % n)
print(10 / n)

# logging的另一个好处是通过简单的配置，一条语句可以同时输出到不同的地方，比如console和文件。

# pdb: python -m pdb err.py ()
# l
# n
# p
# q

# pdb.set_trace() 断点
import pdb

s = '0'
n = int(s)
pdb.set_trace()  # 运行到这里会自动暂停
print(10 / n)

# c

# IDE: PyCharm vscode ...

# “测试驱动开发”（TDD：Test-Driven Development）
# 单元测试是用来对一个模块、一个函数或者一个类来进行正确性检验的测试工作

# 编写单元测试时，我们需要编写一个测试类，从unittest.TestCase继承。

# 以test开头的方法就是测试方法，不以test开头的方法不被认为是测试方法，测试的时候不会被执行。

# 对每一类测试都需要编写一个test_xxx()方法。由于unittest.TestCase提供了很多内置的条件判断，我们只需要调用这些方法就可以断言输出是否是我们所期望的。最常用的断言就是assertEqual()：

# run unittest:

# setUp() tearDown() method

# 文档测试 doctest module
