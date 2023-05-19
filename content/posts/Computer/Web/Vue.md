---
title: "Vue"
date: 2023-05-19T19:24:38+08:00
draft: false
tags: ["first"]
author: "liukanglai"
description: "vue知识"
---

> 前端框架，构建用户界面的渐进式框架

## install

- npm install -g @vue/cli
- vue --version

## start

- vue create vue-demo
- select config
- npm run serve

- vue init webpack demo
- vue-router

## 语法

1. 文本

   - {{message}}; data(){return{message: "h"}}
   - v-html
   - v-bind:id="..." (v-bind 可省略不写)

1. 列表

   - \<li v-for="item in items" :key = "item.id"> {{item.name}}
   - v-if
   - v-show

1. 事件

   - v-on :click="handleClick" (用 @ 更方便)

1. 表单

   - v-model="message"
   - .lazy 回车再加载
   - .trim 去首尾空格

## 组件

- 单文件(.vue)
- template
- script
- style
- import my... from "./..."
- components:{my...}
- \<my... />
- scoped: style 不作用与其它引用组件

## 目录

- buile：webpack 的初始化配置
- static：静态资源目录
- package.json 项目依赖配置
- node_modules：项目依赖包
- src
- index.html

> 所谓单页面应用，就是整个项目只有这一个 html 文件，当我们打开这个应用，表面上可以有很多页面，实际上它们都是动态地加载在一个 div 中。

## src

1. assets
1. components
1. App.vue: 根组件

   - `<script>`标签里的内容即该组件的脚本，也就是 js 代码，export default 是 ES6 的语法
   - 意思是将这个组件整体导出，之后就可以使用 import 导入组件了。大括号里的内容是这个组件的相关属性。

   - `<router-view/>`，是一个容器，名字叫“路由视图”，
   - 意思是当前路由（ URL）指向的内容将显示在这个容器中。
   - 也就是说，其它的组件即使拥有自己的路由（URL，需要在 router 文件夹的 index.js 文件里定义）
   - 也只不过表面上是一个单独的页面，实际上只是在根组件 App.vue 中

1. main.js: App.vue 和 index.html 联系

   ```javascript
   // vue 模块在 node_modules 中，App 即 App.vue 里定义的组件，router 即 router 文件夹里定义的路由
   import Vue from "vue";
   import App from "./App";
   import router from "./router";
   Vue.config.productionTip = false;
   /* eslint-disable no-new */
   new Vue({ el: "#app", router, components: { App }, template: " <App /> " });
   ```

   - 在这个 js 文件中，我们创建了一个 Vue 对象（实例），
   - el 属性提供一个在页面上已存在的 DOM 元素作为 Vue 对象的挂载目标，
   - router 代表该对象包含 Vue Router，并使用项目中定义的路由。
   - components 表示该对象包含的 Vue 组件，
   - template 是用一个字符串模板作为 Vue 实例的标识使用，类似于定义一个 html 标签。

1. router

- index.js:
- ***
