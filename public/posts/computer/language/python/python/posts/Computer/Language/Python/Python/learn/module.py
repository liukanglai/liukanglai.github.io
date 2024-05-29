# !usr/bin/env python3
# Author:liukanglai
# Blog:
# Time:2022-03-19 16:57:47
# Name:module.py
# Version:V1.0

# 在Python中，一个.py文件就称之为一个模块（Module）。
# 在编写模块时，不必考虑名字会与其他模块冲突，但尽量不要与内置函数名字冲突。
# 为了避免模块名冲突，Python又引入了按目录来组织模块的方法，称为包（Package）

# 每一个包目录下面都会有一个 __init__.py 的文件，这个文件是必须存在的，否则，Python就把这个目录当成普通目录
# __init__.py可以是空文件，也可以有代码，因为__init__.py 本身就是一个模块，而它的模块名就是mycompany

# mycompany
# ├─ __init__.py
# ├─ abc.py
# └─ xyz.py (mycompany.abc)

# 创建自己的模块时，要注意：
# 模块名要遵循Python变量命名规范，不要使用中文、特殊字符；
# 模块名不要和系统模块名冲突，最好先查看系统是否已存在该模块，检查方法是在Python交互环境执行import abc，若成功则说明系统存在此模块。

# create a module
' a test module '  # 任何模块代码的第一个字符串都被视为模块的文档注释

__author__ = 'Michael Liao'

import sys
from math import sin as S  # namly


def test():
    args = sys.argv
    if len(args) == 1:
        print('Hello, world!')
    elif len(args) == 2:
        print('Hello, %s!' % args[1])
    else:
        print('Too many arguments!')


# 当我们在命令行运行hello模块文件时，Python解释器把一个特殊变量__name__置为__main__，
# 而如果在其他地方导入该hello模块时，if判断将失败，因此，这种if测试可以让一个模块通过命令行运行时执行一些额外的代码，最常见的就是运行测试
if __name__ == '__main__':
    test()

# 作用域
# 正常的函数和变量名是公开的（public），可以被直接引用
# 类似__xxx__这样的变量是特殊变量，可以被直接引用，但是有特殊用途，比如上面的__author__，__name__就是特殊变量，hello模块定义的文档注释也可以用特殊变量__doc__访问，我们自己的变量一般不要用这种变量名；
# 类似_xxx和__xxx这样的函数或变量就是非公开的（private），不应该被直接引用(不是“不能”)


def _private_1(name):
    return 'Hello, %s' % name


def _private_2(name):
    return 'Hi, %s' % name


def greeting(name):
    if len(name) > 3:
        return _private_1(name)
    else:
        return _private_2(name)


# 这也是一种非常有用的代码封装和抽象的方法，即：外部不需要引用的函数全部定义成private，只有外部需要引用的函数才定义为public。

# install Module: pip(pip3)
# 第三方库都会在Python官方的`pypi.python.org`网站注册，要安装一个第三方库，必须先知道该库的名称，可以在官网或者pypi上搜索，比如Pillow的名称叫Pillow
# pip install Pillow

# 在使用Python时，我们经常需要用到很多第三方库，例如，上面提到的Pillow，以及MySQL驱动程序，Web框架Flask，科学计算Numpy等。
# 用pip一个一个安装费时费力，还需要考虑兼容性。 so Anaconda

# Module 的搜索路径
print(sys.path)

# 如果我们要添加自己的搜索目录，有两种方法：

# 一是直接修改sys.path，添加要搜索的目录： 这种方法是在运行时修改，运行结束后失效。
sys.path.append('/Users/michael/my_py_scripts')

# 第二种方法是设置环境变量PYTHONPATH，该环境变量的内容会被自动添加到模块搜索路径中。设置方式与设置Path环境变量类似。注意只需要添加你自己的搜索路径，Python自己本身的搜索路径不受影响

# 常用的内建模块

# 常用的第三方模块

## Pillow pip install pillow
from PIL import Image, ImageFilter

# 打开一个jpg图像文件，注意是当前路径:
im = Image.open('test.jpg')
# 获得图像尺寸:
w, h = im.size
print('Original image size: %sx%s' % (w, h))
# 缩放到50%:
im.thumbnail((w // 2, h // 2))
print('Resize image to: %sx%s' % (w // 2, h // 2))
# 把缩放后的图像用jpeg格式保存:
im.save('thumbnail.jpg', 'jpeg')

# 应用模糊滤镜:
im2 = im.filter(ImageFilter.BLUR)
im2.save('blur.jpg', 'jpeg')

import random

from PIL import Image, ImageDraw, ImageFilter, ImageFont


# 随机字母:
def rndChar():
    return chr(random.randint(65, 90))


# 随机颜色1:
def rndColor():
    return (random.randint(64,
                           255), random.randint(64,
                                                255), random.randint(64, 255))


# 随机颜色2:
def rndColor2():
    return (random.randint(32,
                           127), random.randint(32,
                                                127), random.randint(32, 127))


# 240 x 60:
width = 60 * 4
height = 60
image = Image.new('RGB', (width, height), (255, 255, 255))
# 创建Font对象:
font = ImageFont.truetype('Arial.ttf', 36)
# 创建Draw对象:
draw = ImageDraw.Draw(image)
# 填充每个像素:
for x in range(width):
    for y in range(height):
        draw.point((x, y), fill=rndColor())
# 输出文字:
for t in range(4):
    draw.text((60 * t + 10, 10), rndChar(), font=font, fill=rndColor2())
# 模糊:
image = image.filter(ImageFilter.BLUR)
image.save('code.jpg', 'jpeg')
