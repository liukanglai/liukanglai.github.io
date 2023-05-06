# !usr/bin/env python3
# -*- coding: utf-8 -*-
# Author:liukanglai
# Blog:
# Time:2022-03-19 18:46:47
# Name:OOP.py
# Version:V1.0

# process procedure
std1 = {'name': 'Michael', 'score': 98}
std2 = {'name': 'Bob', 'score': 81}


def print_score(std):
    print('%s: %s' % (std['name'], std['score']))


# object
# Class vs Instance
class Student(object):  # object 默认继承类

    def __init__(self, name, score):  # 初始化，the first argument must be self.
        self.name = name
        self.score = score

    def print_score(self):
        print('%s: %s' % (self.name, self.score))


bart = Student(
    'Bart Simpson', 59
)  # Instance, if the class has init, it must transfer arguments, while self is no need.
lisa = Student('Lisa Simpson', 87)
lisa.print_score()

# 数据封装
bart.print_score()
# add new function...
# 和静态语言不同，Python允许对实例变量绑定任何数据
bart.name = '...'
bart.age = 8
bart.weight = 120
del bart.name


# privilege
class Student1(object):

    def __init__(self, name, score):
        self.__name = name  # private, no __name__
        self.__score = score

    def get_name(self):
        return self.__name

    def get_score(self):
        return self.__score

    def set_score(self, score):
        if 0 <= score <= 100:
            self.__score = score
        else:
            raise ValueError('bad score')

    def run(self):
        print(self.__name, 'is running...')


bart = Student1('Bart Simpson', 59)
# print(bart.__name)
print(bart.get_name())

# _name，这样的实例变量外部是可以访问的，但是，按照约定俗成的规定，当你看到这样的变量时，意思就是，“虽然我可以被访问，但是，请把我视为私有变量，不要随意访问”。
# 不能直接访问__name是因为Python解释器对外把__name变量改成了_Student__name，所以，仍然可以通过_Student__name来访问__name变量，不同版本的Python解释器可能会把__name改成不同的变量名。

bart.__name = 'liu'
print(bart.__name)  # a new avaliable
print(bart.get_name())


# 继承 新的class称为子类（Subclass），而被继承的class称为基类、父类或超类（Base class、Super class）
class Dog(Student1):

    def run(self):  # 多态
        print('Dog is running...')


dog = Dog('dog0', 2)
print(dog.get_name())
dog.run()
isinstance(dog, Dog)
dog = Student('dog0', 2)
isinstance(dog, Dog)

# “开闭”原则：
# 对扩展开放：允许新增子类
# 对修改封闭：不需要修改依赖父类类型的函数

# 动态语言的“鸭子类型”，它并不要求严格的继承体系，一个对象只要“看起来像鸭子，走起路来像鸭子”，那它就可以被看做是鸭子。
# Python的“file-like object“就是一种鸭子类型。对真正的文件对象，它有一个read()方法，返回其内容。但是，许多对象，只要有read()方法，都被视为“file-like object“。许多函数接收的参数就是“file-like object“，你不一定要传入真正的文件对象，完全可以传入任何实现了read()方法的对象。

# 获取对象信息
print(type(123))
print(type('123'))
print(type(abs))
type(123) == int
import types


def fn():
    pass


print(type(fn) == types.FunctionType)
type(abs) == types.BuiltinFunctionType
type(lambda x: x) == types.LambdaType
type((x for x in range(10))) == types.GeneratorType

isinstance(dog, Student)
isinstance(b'a', bytes)  # the same as type()
isinstance([1, 2, 3], (list, tuple))  # judge mutex

# dir(): all attribution
print(dir('ABC'))
len('ABC')
'ABC'.__len__()


# write yourself
class MyDog(object):

    def __len__(self):
        return 100


dog = MyDog()
len(dog)
'ABC'.lower()
hasattr(dog, 'name')  # 也可作用与方法
setattr(dog, 'name', 'k')
print(dog.name)
getattr(dog, 'name')
getattr(dog, 'z', 404)  # 获取属性'z'，如果不存在，返回默认值404


# 把dict的key - value复制到obj，前提是obj有对应的property
def dict2bean(obj, d):
    for k, v in items(d):
        if hasattr(obj, k):
            setattr(obj, k, v)  # 能写成obj.k = v吗？一个赋值，一个定义


def readImage(fp):
    if hasattr(fp, 'read'):
        return readData(fp)
    return None


# 在Python这类动态语言中，根据鸭子类型，有read()方法，不代表该fp对象就是一个文件流，它也可能是网络流，也可能是内存中的一个字节流，但只要read()方法返回的是有效的图像数据，就不影响读取图像的功能。


# 实例属性和类属性
class Student(object):
    name = 'Student'  # 类属性，self 是实例属性，相同名称的实例属性将屏蔽掉类属性


class Student(object):

    count = 0

    def __init__(self, name):

        self.name = name

        Student.count += 1


# __slots__  实例属性添加很随意，需要限制(但对子类不限制)
class Student(object):
    __slots__ = ('name', 'age')  # 用tuple定义允许绑定的属性名称
    pass


s = Student()
s.name = 'Michael'
#s.score = 1


def set_age(self, age):  # 定义一个函数作为实例方法
    self.age = age


from types import MethodType

#s.set_age = MethodType(set_age, s)
#s.set_age(25)

s2 = Student()  # 创建新的实例
#s2.set_age(25)  # 尝试调用方法


def set_score(self, score):
    self.score = score


Student.set_score = set_score

#s.set_score(100)
#s2.set_score(99)


# 使用@property (decorator) 把一个方法变成属性调用
class Student(object):

    def get_score(self):
        return self._score

    def set_score(self, value):
        if not isinstance(value, int):
            raise ValueError('score must be an integer!')
        if value < 0 or value > 100:
            raise ValueError('score must between 0 ~ 100!')
        self._score = value


s = Student()
s.set_score(60)
#s.set_score(600)


class Student(object):

    @property  # make getter mothod become attribute
    def score(self):
        return self._score

    @score.setter  # make setter mothod become attribute
    def score(self, value):
        if not isinstance(value, int):
            raise ValueError('score must be an integer!')
        if value < 0 or value > 100:
            raise ValueError('score must between 0 ~ 100!')
        self._score = value


s = Student()
s.score = 60
#s.score = 600


class Student(object):

    @property
    def birth(self):  # 可读写属性
        return self._birth

    @birth.setter
    def birth(self, value):
        self._birth = value

    @property
    def age(self):  # 只读属性，不设置 setter 方法
        return 2022 - self._birth


# 属性的方法名不要和实例变量重名


class Student(object):

    # 方法名称和实例变量均为birth:
    @property
    def birth(self):
        return self.birth


# 调用s.birth时，首先转换为方法调用，在执行return self.birth时，又视为访问self的属性，于是又转换为方法调用，造成无限递归，最终导致栈溢出报错 RecursionError


# 多重继承
class Animal(object):
    pass


# 大类:
class Mammal(Animal):
    pass


class Bird(Animal):
    pass


# 各种动物:
class Dog(Mammal):
    pass


class Bat(Mammal):
    pass


class Parrot(Bird):
    pass


class Ostrich(Bird):
    pass


class Runnable(object):

    def run(self):
        print('Running...')


class Flyable(object):

    def fly(self):
        print('Flying...')


class Dog(Mammal, Runnable):
    pass


class Bat(Mammal, Flyable):
    pass


# 过多重继承就可以实现，比如，让Ostrich除了继承自Bird外，再同时继承Runnable。这种设计通常称之为MixIn。


# 定制类
class Student():

    def __init__(self, name):
        self.name = name

    def __str__(self):
        return 'Student object (name: %s)' % self.name

    __repr__ = __str__  # __str__()返回用户看到的字符串，而__repr__()返回程序开发者看到的字符串，也就是说，__repr__()是为调试服务的。


liu = Student('liu')
print(liu)


class Fib(object):

    def __init__(self):
        self.a, self.b = 0, 1  # 初始化两个计数器a，b

    def __iter__(self):  # for iteration
        return self  # 实例本身就是迭代对象，故返回自己

    def __next__(self):
        self.a, self.b = self.b, self.a + self.b  # 计算下一个值
        if self.a > 100000:  # 退出循环的条件
            raise StopIteration()
        return self.a  # 返回下一个值

    def __getitem__(self, n):  # for list
        if isinstance(n, int):  # n是索引
            a, b = 1, 1
            for x in range(n):
                a, b = b, a + b
            return a
        if isinstance(n, slice):  # n是切片
            start = n.start
            stop = n.stop
            if start is None:
                start = 0
            a, b = 1, 1
            L = []
            for x in range(stop):
                if x >= start:
                    L.append(a)
                a, b = b, a + b
            return L


# for n in Fib():
# print(n)

print(Fib()[5])
print(Fib()[:5])

# 但是没有对step参数作处理，也没有对负数作处理
# 如果把对象看成dict，__getitem__()的参数也可能是一个可以作key的object，例如str。 与之对应的是__setitem__()方法，把对象视作list或dict来对集合赋值。
# 最后，还有一个__delitem__()方法，用于删除某个元素。


# 调用不存在的属性，报错
def __getattr__(self,
                attr):  # call s.score, will return 99, others will return None
    if attr == 'score':
        return 99
    raise AttributeError('\'Student\' object has no attribute \'%s\'' %
                         attr)  # change None by default


def __getattr__(self, attr):  # call s.age()
    if attr == 'age':
        return lambda: 25


class Chain(object):

    def __init__(self, path=''):
        self._path = path

    def __getattr__(self, path):
        return Chain('%s/%s' % (self._path, path))

    def __str__(self):
        return self._path

    __repr__ = __str__


print(Chain().status.user.timeline.list)  # ???


class Student(object):

    def __init__(self, name):
        self.name = name

    def __call__(self):  # call class just like function
        print('My name is %s.' % self.name)


s = Student('Michael')
print(s())

# 需要判断一个对象是否能被调用，能被调用的对象就是一个Callable对象，
callable(Student('s'))
callable('str')

# 枚举类 for constant
from enum import Enum

Month = Enum('Month', ('Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug',
                       'Sep', 'Oct', 'Nov', 'Dec'))
for name, member in Month.__members__.items():
    print(name, '=>', member, ',', member.value)

print(Month.Jan.value)

from enum import Enum, unique


@unique  # 检查重复值
class Weekday(Enum):
    Sun = 0  # Sun的value被设定为0
    Mon = 1
    Tue = 2
    Wed = 3
    Thu = 4
    Fri = 5
    Sat = 6


print(Weekday.Tue)
print(Weekday['Tue'])
print(Weekday.Tue.value)
print(Weekday(1))

from enum import Enum, unique


class Gender(Enum):
    Male = 0
    Female = 1


class Student(object):

    def __init__(self, name, i):
        self.name = name
        self.gender = Gender(i)


bart = Student('Bart', Gender.Male)


# 元类
# 动态语言和静态语言最大的不同，就是函数和类的定义，不是编译时定义的，而是运行时动态创建的。
# type()函数可以查看一个类型或变量的类型，class的定义是运行时动态创建的，而创建class的方法就是使用type()函数
class Hello(object):

    def hello(self, name='world'):
        print('Hello, %s.' % name)


h = Hello()
print(type(Hello))
print(type(h))


def fn(self, name='world'):  # 先定义函数
    print('Hello, %s.' % name)


Hello = type('Hello', (object, ), dict(hello=fn))  # use type() 创建Hello class


# 控制类的创建行为，还可以使用 metaclass，先定义 metaclass，就可以创建类，最后创建实例。把类看成是metaclass创建出来的“实例”
# metaclass是类的模板，所以必须从`type`类型派生：
class ListMetaclass(type):  # 按照默认习惯，metaclass的类名总是以Metaclass结尾

    def __new__(cls, name, bases,
                attrs):  # 当前准备创建的类的对象； 类的名字； 类继承的父类集合； 类的方法集合。
        attrs['add'] = lambda self, value: self.append(value)
        return type.__new__(cls, name, bases, attrs)


class MyList(list, metaclass=ListMetaclass):
    pass


L = MyList()
L.add(1)
print(L)
L0 = list()
# print(L0.add(1)) no

# 总会遇到需要通过metaclass修改类定义的。ORM就是一个典型的例子。
# “Object Relational Mapping”，即对象-关系映射，就是把关系数据库的一行映射为一个对象，也就是一个类对应一个表，这样，写代码更简单，不用直接操作SQL语句。
# 要编写一个ORM框架，所有的类都只能动态定义，因为只有使用者才能根据表的结构定义出对应的类来。

# ....
