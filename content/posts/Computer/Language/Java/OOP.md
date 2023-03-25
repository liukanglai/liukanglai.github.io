---
title: ""
draft: false
tags: ["first"]
author: "liukanglai"
# author: ["Me", "You"] # multiple authors
showToc: true
TocOpen: false
hidemeta: false
comments: false
description: "Desc Text."
canonicalURL: "https://canonical.url/to/page"
disableHLJS: true # to disable highlightjs
disableShare: false
disableHLJS: false
hideSummary: false
searchHidden: true
ShowReadingTime: true
ShowBreadCrumbs: true
ShowPostNavLinks: true
ShowWordCount: true
ShowRssButtonInSectionTermList: true
UseHugoToc: true
cover:
    image: "<image path/url>" # image path/url
    alt: "<alt text>" # alt text
    caption: "<text>" # display caption under cover
    relative: false # when using page bundles set this to true
    hidden: true # only hide on current single page
editPost:
    URL: "https://github.com/<path_to_repo>/content"
    Text: "Suggest Changes" # edit text
    appendFilePath: true # to append file path to Edit link
---# class

- class, object(instance)

## property nature attribute character

- 属性，成员变量，field，域
- 前可加权限(public...)

## methods

- 方法，成员方法，函数

- 局部变量: 方法内，形参


        class Person {
            public void method(...){
            } // a method must have public or..., can have static, abstract, final
        }
        Person a_person = new Person();
        a_person.field;
        a_person.method();
        new Person().method();  // 匿名对象使用

- 局部变量前无权限值，用方法权限代替

> constructor

## code block

## inner class


# three characteristic(feature)

## Encapsulation 

- public: all
- protect: class inner, same package, different package's subclass
- default: class inner, same package
- private: class inner

- 修饰类的内部结构
- 修饰类：只能用default, public

- this(): 只能放在首行


## inheritance 

- extends class
- super

- 构造方法不能继承

## polymorphism

- overwrite, override: subclass to superclass, 权限不小，不能重写private方法
- overload: name same, number different, or type different

## abstract


# other



## static

## final

## abstract

## interface

## package

## import

- 
