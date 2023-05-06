# !usr/bin/env python3
# -*- coding: utf-8 -*-
# Author:liukanglai
# Blog:
# Time:2022-04-17 15:28:29
# Name:IO.py
# Version:V1.0

# Stream

# 同步 异步 IO

# 回调模式 轮询模式

# 把操作系统提供的低级C接口封装

# 文件读写 文件对象

try:
    f = open('/home/liukanglai/1', 'r')  # r, rb, w, a
    f.read()
finally:
    if f:
        f.close()

with open('/home/liukanglai/1', 'r') as f:
    f.read()
    f.readline()
    f.readlines()  # return list
    for line in f.readlines():
        print(line.strip())  # 把末尾的'\n'删掉

# file-like Object read()
# StringIO

# binary file
with open('/home/liukanglai/1', 'rb') as f:
    f.read()
# with open('/home/liukanglai/1', 'r', encoding='gbk') as f:
# f.read()
with open('/home/liukanglai/1', 'r', encoding='gbk', errors='ignore') as f:
    f.read()

# change r to w
# 'a' append
# f.write('')
# f.writelines('This is the first line\r\n')
# f.close()

# StringIO in memory for str
from io import StringIO

f = StringIO()
f.write('hello')
print(f.getvalue())
from io import StringIO

f = StringIO('Hello!\nHi!\nGoodbye!')
while True:
    s = f.readline()
    if s == '':
        break
    print(s.strip())

# BytesIO
from io import BytesIO

f = BytesIO()
f.write('刘'.encode('utf-8'))
f.getvalue()

# operate file/directory
import os

print(os.name)  # posix nt
print(os.uname())
print(os.environ)
print(os.environ.get('PATH'))

os.path.abspath('.')
os.path.join('/home/liukanglai', 'testdir')  # '/' vs '\'
os.path.split('home/liukanglai/testdir')
os.path.splitext('home/liukanglai/testdir/text.txt')
os.mkdir('home/liukanglai/testdir')
os.rmdir('home/liukanglai/testdir')

os.rename()
os.remove()

# copy in shutil module
print([x for x in os.listdir('.') if os.path.isdir(x)])
[
    x for x in os.listdir('.')
    if os.path.isfile(x) and os.path.splitext(x)[1] == '.py'
]

# 变量从内存中变成可存储或传输的过程称之为序列化，在Python中叫pickling，在其他语言中也被称之为serialization，marshalling，flattening等等 (unpickling)
import pickle

d = dict(name='Bob', age=20, score=80)
pickle.dumps(d)  # to bytes
pickle.dump(d, f)
d.pickle.load(f)
f.close()
print(d)

# JSON
# 在不同的编程语言之间传递对象，就必须把对象序列化为标准格式，比如XML，但更好的方法是序列化为JSON，
# 因为JSON表示出来就是一个字符串，可以被所有语言读取，也可以方便地存储到磁盘或者通过网络传输。
# JSON不仅是标准格式，并且比XML更快，而且可以直接在Web页面中读取，非常方便。
import json

d = dict(name='Bob', age=20, score=80)
D = json.dumps(d)
json.loads(D)


class Student(object):

    def __init__(self, name, age, score):
        self.name = name
        self.age = age
        self.score = score


s = Student('Bob', 20, 88)


def student2dict(std):
    return {'name': std.name, 'age': std.age, 'score': std.score}


print(json.dumps(s, default=student2dict))
print(json.dumps(s, default=lambda obj: obj.__dict__))

# consider how to write loads() ?
print(json.loads(json_str, object_hook=dict2student))
