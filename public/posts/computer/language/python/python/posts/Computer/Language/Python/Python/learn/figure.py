# !usr/bin/env python3
# -*- coding: utf-8 -*-
# Author:liukanglai
# Blog:
# Time:2022-04-18 15:43:58
# Name:figure.py
# Version:V1.0

# Tk wxWidgets Qt GTK
# sudo pacman -S tk

# Tkinter(default)
from tkinter import *
import tkinter.messagebox as messagebox


class Application(Frame):

    def __init__(self, master=None):
        Frame.__init__(self, master)
        self.pack()  # pack 布局
        self.createWidgets()  # frame 也是 Widgets

    def createWidgets(self):
        self.helloLabel = Label(self, text='Hello, World!')
        self.helloLabel.pack()
        self.nameInput = Entry(self)
        self.nameInput.pack()
        self.alertButton = Button(self, text='Hello', command=self.hello)
        self.alertButton.pack()
        self.quitButton = Button(self, text='Quit', command=self.quit)
        self.quitButton.pack()

    def hello(self):
        name = self.nameInput.get() or 'world'
        messagebox.showinfo('Message', 'Hello, %s' % name)


# app = Application()
# 设置窗口标题:
# app.master.title('Hello World')
# 主消息循环:
# app.mainloop()

# Turtle Graphics
# 导入turtle包的所有内容:
from turtle import *

# 设置笔刷宽度:
width(4)

# 前进:
forward(200)
# 右转90度:
right(90)

# 笔刷颜色:
pencolor('red')
forward(100)
right(90)

pencolor('green')
forward(200)
right(90)

pencolor('blue')
forward(100)
right(90)

import time

# time.sleep(1)


def drawStar(x, y):
    pu()
    goto(x, y)
    pd()
    # set heading: 0
    seth(0)
    for i in range(5):
        fd(40)
        rt(144)


for x in range(0, 250, 50):
    drawStar(x, 0)

# 设置色彩模式是RGB:
colormode(255)

lt(90)

lv = 14
l = 120
s = 45

width(lv)

# 初始化RGB颜色:
r = 0
g = 0
b = 0
pencolor(r, g, b)

penup()
bk(l)
pendown()
fd(l)


def draw_tree(l, level):
    global r, g, b
    # save the current pen width
    w = width()

    # narrow the pen width
    width(w * 3.0 / 4.0)
    # set color:
    r = r + 1
    g = g + 2
    b = b + 3
    pencolor(r % 200, g % 200, b % 200)

    l = 3.0 / 4.0 * l

    lt(s)
    fd(l)

    if level < lv:
        draw_tree(l, level + 1)
    bk(l)
    rt(2 * s)
    fd(l)

    if level < lv:
        draw_tree(l, level + 1)
    bk(l)
    lt(s)

    # restore the previous pen width
    width(w)


speed("fastest")

draw_tree(l, 4)

# 调用done()使得窗口等待被关闭，否则将立刻关闭窗口:
done()
