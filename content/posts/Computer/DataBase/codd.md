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
---  本论文主要面向访问包含格式化数据的大型数据库的基础关系理论的应用。未来，大型数据库的用户不需要再去关心数据的内部实现，数据在服务器内部甚至是一些外部组织形式的变化不应该对终端用户和大部分应用程序造成影响。而数据表现形式的改变往往由查询，更新，负载报告和各种类型的存储信息自然增长造成。已经存在的非推理？，数据格式化系统为用户提供树形文件结构或网状模型的数据，这些结构难以处理数据独立性，冗余，一致性约束等其它问题。这里提出了一种新的数据模型，并且重点讨论了数据独立性和在非演绎系统中的数据冗余及一致性问题。

  第一部分，作者提出了数据库关系模型基础理论，用于保护格式化数据系统的用户可能面对的数据库破坏问题，以及在数据库中的增长和负载引起的变化问题。讨论已有模式的不足之处，介绍一种基于多元关系的模型，由数据基础关系标准和通用数据语言的组成。一方面，在应用系统之间提供一个基础的、高层次的数据库语言，另一方面，在应用程序和服务器组织形式提供最大的独立性。三个依赖性问题： 排序依赖，展示顺序和存储顺序；索引依赖, 创建和销毁索引的能力；访问路径依赖, 结构变化时，应用程序将会面临逻辑损坏。用笛卡尔积定义了在域上的n元关系，提出5个简单的属性；区分有序域和无序域(两个或者更多相同的域)，简单域（元素是原子的）和非简单域（将关系作为元素），看到了标准化过程的描述和其带来的好处；介绍了动态域，主码，外码的概念。最后，提出通用的基于实用谓语的数据语言加上了可描述的，可命名的和存储关系分别的特点。

  第二部分，定义了关系操作和两个类型的冗余，以及如何处理数据一致性状态的问题。关系是集合，所有的常见集合操作也适用于关系，然而，结果不一定是关系。关系模式一个长远优势是它声明了一个处理可导出性，冗余和关系一致性提供基础原理。这里指出了一系列的操作，置换；投影；连接；组合；限制；接着提出了冗余及一致性的处理。简单的两种方法：系统在每次插入，删除和更新时，检测可能出在的不一致；定义一致性检测为一种操作性，周期执行，都可处理。

  文章提出的概念甚多，且十分抽象，先引出问题，再定义概念，接着举例分析，最后提出总结，才让人影响深刻。而对于有些问题点到为止，有时迷糊。像“演绎系统”，“可推导”等词汇真让人难受。论文的语言表达着实令人大开眼界，精确性，分层次，逻辑化，由表及里，娓娓道来。需深刻理解新模型提出的必然性，数据库发展的大趋势，知道做什么，再提出为什么，接着怎么干，为什么这么干，有什么好处？在定义的无比飘忽，概念的形而上学之中领会真谛，将举例子，类比法运用自如，体会那真实而又虚无的世界。
