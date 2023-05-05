---
title: "Web基础"
date: 2023-05-05T10:30:53+08:00
draft: false
tags: ["web"]
author: "liukanglai"
description: " "
---

## html

- 超文本标记语言
- 标签

### 框架

- !DOCTYPE html
- html
- head
- body

### head

- title: seo
- meta: 单标签 charset=utf-8

### 元素标签

- 标题：h1-6

- 段落：p
- 换行：br（单标签）
- 水平线：hr（单标签）
- em
- b
- i
- strong
- del
- span

- 分割线：

### 属性

- align: left/center/right
- color
- width
  > 像素：1920 宽 px
- size

### picture

- 单标签 img
- src= path
- alt= 无法显示的文本
- width
- height
- title: 鼠标悬停显示

### link

- 超文本链接 a
- href= path
- title: 鼠标悬停显示

### list

- 有序列表: ol -> li (type=)
- 无序列表: ul -> li (type=disc circle square none)

### table

- 表格 table
- 行 tr
- 列 td

- 属性：
- border
- cellpadding
- cellspacing
- align
- width
- height

- 合并单元格
- rowspan
- colspan

### form 表单

- 交互

- 属性：
- action：服务器地址
- name：表单名字
- method：get, post

- 标签： input
- 文本框： type=text name=
- 密码框：type=password
- 按钮： type=submit value=
- 文本框：type=textarea
- 标签： type=select

### 块元素和内联元素

- 块元素： div, form, h1, hr, p, table, ul
- 独占一行，可以设置 width，height 等，可以包含其他元素

- 内联元素： a, span, em, i, strong, b, u, s
- 只占自身大小，无 widhth 等

- 行内块级元素：可以识别 width (button, img, input)

### 其他

- div 容器标签

- html5 新标签：

## css

- style 三种添加方式（标签内，head 内，单独文件）link ref="stylesheet" type=text/css href=path
- 层叠样式表，级联样式表
- 选择器+样式（属性+属性值）

### 选择器

1. 全局选择器

- \*{}

1. 标签选择器

- p,span,h{}

1. 类选择器

- 先在标签中加 class 属性
- .oneclass{}

1. ID 选择器

- 对某一特定标签，只能使用一次，ID 唯一
- #...{}

1. 合并选择器

- p,span,h,

> 优先级问题

### CSS 属性

1. 外观

- color: red, #ff0000, rgb(255,0,0)
- font-size(最小是 12px)
- font-weight: bold, normal, bolder, lighter(700 最常用)
- font-style: italic, oblique, normal
- font-family: "Microsoft YaHei", "", "宋体"

1. 背景

- background-color
- background-image
- background-repeat: no-repeat
- background-attachment
- background-position：起始位置，默认左上方开始
- background-size(cover)

1. 文本

- text-align: left/center/right/justify/center/justify/left/right/
- text-decoration: none/underline/overline/line-through
- text-transform: captical/uppercase/lowercase/none
- text-indent: 缩进
- letter-spacing: 字间距

1. 表格

- border
- border-collapse: collapse
- cellpadding
- cellspacing
- text-align
- vertical-align
- width
- height
- padding: 周围间距

### 关系选择器

1. 后代选择器

- 以空格隔开

1. 子代选择器（直系后代）

- use \>

1. 相邻兄弟选择器（相邻的）

- use +

1. 通用兄弟选择器 (all)

- use ~

### CSS 盒子模型 Box Model

- margin(外边距), border(边框), padding(内间距), content

### 弹性盒模型（flex box）

1. 弹性容器：

- display: flex
- flex-direction: row/column/row-reverse/column-reverse（盒子排列）
- justify-content: flex-start/flex-end/center/space-between/space-around （垂直）
- align-items: flex-start/flex-end/center/baseline/stretch （水平）

1. 弹性元素

- flex-grow/flex（份数）
- flex-shrink
- flex-basis

### 文档流

> 对象的排列，高矮不齐，底边不齐；空格折叠；元素无空隙

脱离文档流，会创建一个新的文档流，组件与原组件覆盖：

- 浮动 float，只有左右浮动
- 绝对定位
- 固定定位

## javascript

### ES6

## Vue

---
