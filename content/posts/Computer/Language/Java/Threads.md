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
---# create 

> 主线程（用户线程），守护线程（垃圾回收, 异常处理...）随用户线程结束

- four ways


## extends Thread

> 同一个线程不能多start

- void start()  // !!!

- run()
- String getName()
- void setName(String name)
- static Thread currentThread()
- static void yield() // free the cpu, 但还可以抢到
- join() // thread a use b.join(), then a is blocked, just do b untill it ends.
- static void sleep(long millis) //ms
- stop()
- boolean isAlive()


- getPriority();  // Just high probability!!!
- setPriority(int );

        MAX_PRIORITY: 10
        MIN_PRIORITY: 1
        NORM_PRIORITY: 5 // default
        Thread.MIN_PRIORITY


## implements Runnable

- share data use the same class. 

        class MyThread implements Runnable {
        }

        MyThread thread = new MyThread();
        Thread thread0 = new Thread(thread);
        Thread thread1 = new Thread(thread);
        thread1.start();


## 

# life

- create
- ready
- run
- block
- died

- start
- yield
- sleep join synchronized wait suspend(no, deadlock...)
- notify notifyAll resume(no...)
- stop

# safe


## synchronized code block

- lock: any class's object, some threads must!!! use the same object (this, )


## synchronized method

- public synchronized void show(){}

- the lock is this, the static method's lock is this.class.

> deadlock.


## Lock

- ReentrantLock lock = new ReentrantLock();
- lock.lock();
- lock.unlock();

## 

## 

## 

## 

## 

## 

