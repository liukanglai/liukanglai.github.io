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

- 浮动 float，只有左右浮动，直接加入属性 float
- 绝对定位
- 固定定位

> 浮动的缺点：造成父元素的高度塌陷，也会对后续元素产生影响

- 清除浮动

- 固定位置，相对定位，绝对定位

### CSS3 特性

- 圆角
- 阴影
- 动画
- 媒体查询
- 雪碧图
- 字体图标： 阿里

## javascript

- 脚本语言：不具备开发 OS，只用来控制程序的脚本。嵌入式语言

- 操纵浏览器
- 广泛使用，易学

> ECMAScript 是规范，JavaScript 是实现

1. 执行

- js 不是简单的从上到下执行，变量提升

1. 语法

- 注释: // /\*\*/
- 数据类型：原始类型：数值类型，字符串类型，布尔类型；引用类型，对象{}(object); 特殊值：null 一般对象，undefined 一般数值
- \+ - \* / % ++ -- = += ... < ... (==是相等 ===严格相等，比较类型)(!= !==)
- ! && ||(对非字符串基本为 false，除了 null, 0, NaN, "", undefined, false)

1. 关键字

- console.log(typeof 123)，一般判断基本类型，其他不用
- if/else switch ( ? :)
- for while break continue

1. 字符串

- 单引号和双引号一样，可以相互嵌套（转义\\）
- \\ 可以换行
- str.length
- charAt()
- concat() 所有类型都转为字符串 （直接用 + 即可）
- substring(0, 2) 不包含 2，为负数自动转换为 0，第二个参数更大会自动换成第一个参数
- substr() 第二个参数是长度，第一个参数为负到着数，第二个参数为负转为 0
- indexOf() 匹配字符或字符串的第一个位置，没有为-1。第二个参数为从那开始匹配，前面不匹配
- trim() 去除前后端的空白符(\t, \v, \n, \r) （ES6：trimStart, trimEnd）
- split("|",5) 将字符串分割，返回数组，传空("")切成字符
- replace() 替换字符串，返回替换后的字符串

1. 数组

- var arr = [1, 2, 3]; arr[4] = "j";
- 不用管大小和类型，可以随便加
- arr.length
- 遍历：for, which, for(var i in arr) {arr[i]}
- Array.isArray(arr), typeof 不行
- arr.push(), arr.pop()
- arr.shift(), arr.unshift(). while(item = arr.shift){}
- arr.join() 转为字符串
- arr.concat() 合并
- arr.reverse() 翻转，实现字符串的翻转
- arr.indexOf()

1. 函数

- 函数名的提升，先调用后创建！
- function add(a, b) {return a + b}

1. 对象

- 键值对
- var obj = {name: "tom", age: 18}

- Math.abs() (max, min, floor, ceil) Math.random()(>=0, <1)
- function random(min, max) {return Math.random() \* (max - min) + min}

- Date
- Date.now(); 时间戳指的是 1970 年 1 月 1 日 0 时 0 分 0 秒 到现在的总秒数（Unix 出现）（北京时间是 8 时）
- Date(Date.now())/Date()：转为为现在时间
- Date(Date.now()).getDate() (getDay, getFullYear, getMouth...)

```javascript
function daysToNewYear() {
  const today = new Date();
  const newYear = new Date(today.getFullYear() + 1, 0, 1);
  const diff = newYear - today;
  const days = Math.floor(diff / (1000 * 60 * 60 * 24));
  return days;
}

console.log("距离下一年还有 " + daysToNewYear() + " 天");
```

1. DOM

- 文档对象模型，Document Object Model，将网页转为一个 javascript 对象，从而进行操作
- 浏览器根据 DOM 模型，将 HTML 解析成一系列的节点，组成一个树状图（DOM tree）
- 节点有七个类型：

  1. Document: HTML
  1. DocumentType: DOCTYPE
  1. Element:
  1. Attribute:
  1. Text:
  1. Comment:
  1. DocumentFragment:

- document.nodeType == ?

- var d = document.getElementsByTagName("div")\[0] (getElementsByClassName, getElementsByName, getElementsById)
- var el = document.querySelector(".class") var el = document.querySelectorAll("div")
- document.createElement
- innerHTML 和 innerText
- 查询器获取元素的值，属性，style 等，进行操作，操作 css 等

- 事件处理：HTML 事件和 DOM 事件，html 与 js 是否分离

- onclick="function()", addEventListener("click", function(){})
- ondblclick onmousedown onmouseup onmouseover onmouseout onkeydown onkeypress
- Event 事件对象，上面 addEventListener 中的 click 即是
- event.targer, event.type, event.preventDefault(阻止默认的行为，如链接跳转), event.stopPropagation(组件嵌套)

- 事件代理，委托
- 用 event.targer.tagName === "子元素"，父元素处理

1. 定时器

- setTimeout(function(){}, 3000)，3000ms 后执行 function， clearTimeout(timer)
- setInterval()

- 防抖
- 节流

### ES6

- babel：将 ES6 转为 ES5(npm install)
- .babelrc 文件

1. let const

- 作用域只有块级作用域，不用于 var 函数级作用域
- let 没有变量提升
- const 常量

1. 对象解构赋值

- const {name, age} = user;

1. string

- unicode
- for(let i of string){}
- 字符串模板: ${}
- includes() startsWith() endsWith() repeat() padStart() padEnd() trimStart() trimEnd() at()

1. 数组

- 拓展运算符： var arr = [1, 2, 3]; (...arr);
- Math.max.apply(null, arr) -> Math.max(...arr)
- Array.from(); (arguments, 元素集合，对象数组) Array.of(1, 2, 3); Array(3);

1. 对象

- 属性的简洁表示法
- 属性名的表达式
- 对象的拓展运算符

1. 函数

- var fun = (x, y) => ({add: x + y; div: x/y}); 后面的()是为了返回对象

1. set

- 集合，值唯一
- var a = new Set();
- a.add(); a.size(); delete() has() clear()

1. Promise

- 异步编程

```javascript
const promise = new Promise(function(resolve, reject){
    // code
    if(){
            resolve(value);
    }else{
        reject(error);
    }
});
promise.then(function(value){
    },function(error){
    });
```

- Ajax
- Async 异步变同步(async await) 网络请求的顺序依赖

1. Class类

```
class Person {
    constructor(name){
        this.name = name;
    }
    sayName(){
        console.log(this.name);
    }
}

var a = new Person("h");
```

- static
- extends

1. Module

- export default var ...; import{.. as ..} from "x.js"; import \* ...
---
