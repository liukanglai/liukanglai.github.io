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

        #include<iostream>
        #include<cstring>
        
        using namespace std;
        
        class Student
        {
            private:
            int num;//学号
            char name[100];//名字
            int score;//成绩
            public:
            Student(int n,char *str,int s);
            int print();
            int Set(int n,char *str,int s);
        };
        
        Student::Student(int n,char *str,int s)
        {
             num = n;
             strcpy(name,str);
             score = s;
        cout<<"Constructor"<<endl;
        }
        
        int Student::print()
        {
            cout<<num<<" "<<name<<" "<<score;
            return 0;
        }
        
        int Student::Set(int n,char *str,int s)
        {
             num = n;
             strcpy(name,str);
             score = s;
        }
        
        int main()
        {
            Student A(100,"dotcpp",11);
            A.print();
            return 0;
        }
