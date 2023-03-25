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
------
title: "My First Post"
date: 2021-08-25T19:25:59+08:00
draft: false
---


#
- $\frac{(n-1)S^2}{\theta^2} - X^2(n-1)$

X¯∼N(μ,σ2n)(n−1)S2σ2∼χ2(n−1)X¯与S2相互独立
- X¯−μS/n−−√∼t(n−1)



# p

1. 

2. 

3. 

$\pm$

- (0-1)分布
        p(X=k)=pk(1−p)1−kp(X=k)=pk(1−p)1−k,k=0,1
        
        E(X)=p
        
        D(X)=p(1-p)
        
        二项分布 X~b(n,p)
        p(X=k)=Cknpk(1−p)n−kp(X=k)=Cnkpk(1−p)n−k
        E(X)=np
        
        D(X)=np(1-p)
        
        泊松分布 X~π(λ)π(λ)
        p(X=k)=λke−λk!p(X=k)=λke−λk!
        E(X)=λλ
        D(X)=λλ
        均匀分布 X~U(a,b)
        f(x)={1b−a,0,a<x<belseE(X)=a+b2D(X)=(b−a)212F(X)=⎧⎩⎨⎪⎪0,x−ab−a,1,x<aa≤x<bx≥b
        f(x)={1b−a,a<x<b0,elseE(X)=a+b2D(X)=(b−a)212F(X)={0,x<ax−ab−a,a≤x<b1,x≥b
        指数分布
        f(x)={1θe−xθ,0,x>0elseE(X)=θD(X)=θ2F(X)={1−e−xθ,0,x>0else
        f(x)={1θe−xθ,x>00,elseE(X)=θD(X)=θ2F(X)={1−e−xθ,x>00,else
        正态/高斯分布 X~N(μ,σ2μ,σ2)
        E(X)=μμ
        D(X)=σ2σ2
        F(X)=P(X≤x)=ϕ(x−μσ)F(X)=P(X≤x)=ϕ(x−μσ)

        χ2χ2分布 χ2∼χ2(n)χ2∼χ2(n)
        Xi∼N(0,1)n:自由度χ2=∑i=1nX2iE(χ2)=nD(χ2)=2nχ21+χ22∼χ2(n1+n2)
        Xi∼N(0,1)n:自由度χ2=∑i=1nXi2E(χ2)=nD(χ2)=2nχ12+χ22∼χ2(n1+n2)
        t分布 t~t(n)
        X∼N(0,1)Y∼χ2(n)t=XYn−−√
        X∼N(0,1)Y∼χ2(n)t=XYn
        F分布 F~F(n1,n2n1,n2)
        U∼χ2(n1)V∼χ2(n2)F=U/n1V/n2
        U∼χ2(n1)V∼χ2(n2)F=U/n1V/n2
        正态总体的样本均值X¯X¯与样本方差S2S2的分布
        E(X¯)=μD(X¯)=σ2nE(S2)=E[1n−1(∑i=1nX2i−nX¯2)]=1n−1[∑i=1nE(X2i)−nE(X¯2)]=1n−1[∑i=1n(σ2+μ2)−n(σ2n+μ2)]=σ2
        E(X¯)=μD(X¯)=σ2nE(S2)=E[1n−1(∑i=1nXi2−nX¯2)]=1n−1[∑i=1nE(Xi2)−nE(X¯2)]=1n−1[∑i=1n(σ2+μ2)−n(σ2n+μ2)]=σ2
        Xi来自N(μ,σ2)Xi来自N(μ,σ2),则
        X¯∼N(μ,σ2n)(n−1)S2σ2∼χ2(n−1)X¯与S2相互独立X¯−μS/n−−√∼t(n−1)
        X¯∼N(μ,σ2n)(n−1)S2σ2∼χ2(n−1)X¯与S2相互独立X¯−μS/n∼t(n−1)
        
        单个总体N( μ.σ2μ.σ2)置信区间
        (X¯±Sn−−√tα/2(n−1))
        (X¯±Sntα/2(n−1))
        
        两个总体N(μ1.σ21)，N(μ2.σ22)的μ1−μ2置信水平1−α的置信区间两个总体N(μ1.σ12)，N(μ2.σ22)的μ1−μ2置信水平1−α的置信区间
        (X¯−Y¯±tα/2(n1+n2−2)Sω1n1+1n2−−−−−−−√)S2ω=(n1−1)S21+(n2−1)S22n1+n2−2,Sω=Sω2−−−√
