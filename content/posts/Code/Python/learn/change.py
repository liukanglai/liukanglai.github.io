# !usr/bin/env python3
# -*- coding: utf-8 -*-
# Author:liukanglai
# Blog:
# Time:2022-05-20 11:15:02
# Name:change.py
# Version:V1.0

# list to str
A = ["a", "b", "c"]
StrA = "".join(A)
print(StrA)
# StrA is "abc"

StrA = " ".join(A)
# StrA is "a b c"

# must be str
a = [1, 2, 3]
print("".join([str(_) for _ in a]))
print("".join(map(str, a)))

# str to list
str1 = "12345"
list1 = list(str1)
print(list1)

str2 = "123 sjhid dhi"
list2 = str2.split()  #or list2 = str2.split(" ")
print(list2)

str3 = "www.google.com"
list3 = str3.split(".")
print(list3)
