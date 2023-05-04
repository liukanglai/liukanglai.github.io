# !usr/bin/env python3
# -*- coding: utf-8 -*-
# Author:liukanglai
# Blog:
# Time:2022-05-20 09:07:57
# Name:sequence.py
# Version:V1.0

# list
classmates = ['Cong', 'Yuan', 'Che']
len(classmates)
classmates[0] = 'Hao'
classmates[1:] = ['Hao']  # change ['Hao'] to 'Hao' ?

classmates.append('Lang')
classmates.insert(0, 'Lai')
classmates.pop()  # delete end
del classmates[0]
classmates.pop(0)

classmates0 = ['people', 123, True]
classmates1 = ['people', [123, True]]
classmates1[1][1]
L = []  # null list
len(L) == 0

print(classmates * 3)
print(classmates + classmates0)
print('Hao' in classmates)

# tuple, can't be changed, safe, so use it as long as possible.

atuple = tuple(classmates)
atuple = ('Cong', 'Yuan', 'Lang')  # changable tuple ???

atuple = (1)  # it is int 1 !
atuple = (1, )

# dict dictionary map use key-value (structure)

dic = {'Cong': 80, 'Lang': 95, 'Yuan': 90}
print(dic['Yuan'])
if 'Cong' in dic:
    dic['Cong'] = 90

if dic.get('Yuan'):  # dic.get('Lang', -1), return what you like.
    dic['Yuan'] = 88

dic.pop('Cong')
print(dic)
dic = {'Cong', 'Lang', 'Yuan'}
print(dic)
dic = {(1, 2): 1}
# dic = {(1, 2, [1, 2]): 1}

# 查找和插入的速度极快，不会随着key的增加而变慢；
# 需要占用大量的内存，内存浪费多。
# Hash need key can't change, so the key is the fixed variable.

# set (only key, no repetition)

alist = [1, 2, 3]
classSet0 = set(alist)
print(classSet0)
alist = (1, 2, 3)
classSet0 = set(alist)
print(classSet0)
classSet1 = set([1, 1, 1, 2, 2, 3])
print(classSet1)

classSet1.add(1)
classSet1.add(0)
classSet1.remove(0)

classSet0 & classSet1
classSet0 | classSet1

# about the changable

testList = ['b', 'c', 'a']
testList.sort()
print(testList)

testStr = 'abc'
testStr.replace('a', 'A')

# list is changable, while 'abc'(String) can't change, thought testStr changed.
# list/tuple is sequential link-list, while dict(set) is Hash map which use key to map value, so the key must fixed.
