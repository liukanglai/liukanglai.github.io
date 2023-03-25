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
---
Nice: `https://www.cnblogs.com/yangguang-it/p/11667772.html`

        list_entry: 获得节点对应的入口

        list_first_entry: 获得第一个入口

        list_last_entry: 获得最后一个入口

        list_first_entry_or_null: 获得第一个入口或 NULL

        list_next_entry: 获得下一个入口

        list_prev_entry: 获得前一个入口

        list_for_each: 正序遍历所有节点

        list_for_each_prev: 倒叙遍历所有节点

        list_for_each_safe: 安全正序遍历所有节点

        list_for_each_prev_safe: 安全倒叙遍历所有节点

        list_for_each_entry: 正序遍历所有入口

        list_for_each_entry_reverse: 倒叙遍历所有入口

        list_prepare_entry: 获得指定入口

        list_for_each_entry_continue: 从指定入口开始正序遍历剩余的入口

        list_for_each_entry_continue_reverse: 从指定入口开始倒叙遍历剩余的入口

        list_for_each_entry_from: 从指定入口正序遍历剩余入口

        list_for_each_entry_from_reverse: 从指定入口倒序遍历剩余入口

        list_for_each_entry_safe: 安全正序遍历所有入口

        list_for_each_entry_safe_continue: 安全从指定入口正序遍历剩余入口

        list_for_each_entry_safe_from: 安全从指定入口正序遍历剩余入口

        list_for_each_entry_safe_reverse: 安全从指定入口倒序遍历剩余入口

        list_safe_reset_next: 安全获得下一个入口

# list\_head

    struct list_head{
      struct list_head *prev, *next;
    }

    #define LIST_HEAD_INIT(name) {&(name), &(name)}

    #define LIST_HEAD(name) struct list_head name = LIST_HEAD_INIT(name)

    INIT_LIST_HEAD(struct list_head *list){
      list->prev = list;
      list->next = list;
    }

    so INIT_LIST_HEAD(need a struct list_head!) is same as LIST_HEAD(just need a name).


# list\_add

- 头插法:

        static inline void __list_add(struct list_head *new,
                    struct list_head *prev,
                    struct list_head *next)
        {
          if (!__list_add_valid(new, prev, next))
            return;

          next->prev = new;
          new->next = next;
          new->prev = prev;
          WRITE_ONCE(prev->next, new);
        } // 4次插入

        /**
         * list_add - add a new entry
         * @new: new entry to be added
         * @head: list head to add it after
         *
         * Insert a new entry after the specified head.
         * This is good for implementing stacks.
         */
        static inline void list_add(struct list_head *new, struct list_head *head)
        {
          __list_add(new, head, head->next);
        }

- 尾:


        /**
         * list_add_tail - add a new entry
         * @new: new entry to be added
         * @head: list head to add it before
         *
         * Insert a new entry before the specified head.
         * This is useful for implementing queues.
         */
        static inline void list_add_tail(struct list_head *new, struct list_head *head)
        {
          __list_add(new, head->prev, head);
        }


# list\_for\_each

        /**
         * list_for_each	-	iterate over a list
         * @pos:	the &struct list_head to use as a loop cursor.
         * @head:	the head for your list.
         */
        #define list_for_each(pos, head) \
          for (pos = (head)->next; pos != (head); pos = pos->next)

- end when pos = head

        list_for_each的第一个参数pos，代表位置，struct list_head * ，临时变量

- print:

        使用printf("age = %d\n",((struct person *)pos)->age), 将链表放在结构体的首地址处?
        no 处于结构体的首地址, container_of，offsetof这两个广为人知的宏。

## offsetof

        #define offsetof(TYPE, MEMBER) ((size_t) &((TYPE *)0)->MEMBER)
        //TYPE（结构体）类型中成员MEMBER相对于结构体的偏移地址
        // 很有意思的是，空指针是可以引用的，在这相当与取 0 地址!!!

- get the offset address, we can find the value in struct

## container\_of

        #define container_of(ptr, type, member) ({
              \ const typeof( ((type *)0)->member ) *__mptr = (ptr); \ (type *)( (char *)__mptr - offsetof(type,member) );})

- typeof: get the type
- ptr: &member
- 宏没有参数检查的功能，`const typeof( ((type *)0)->member ) *__mptr = (ptr)`，如果类型不匹配，会有警告
- get the address of the type!

# list\_for\_each\_entry

        #define list_entry(ptr, type, member) \
          	container_of(ptr, type, member)

        #define list_for_each_entry(pos, head, member)				\
            for (pos = list_first_entry(head, typeof(*pos), member);	\
               !list_entry_is_head(pos, head, member);			\
               pos = list_next_entry(pos, member))

- pos: struct *
- head: in struct list\_head \*, is &member, but is the head!
- member: \*head

在上面的实践中，使用 list_for_each() 函数的时候，当每次遍历一个节点的时候， list_for_each() 函数通过当前节点找到下一个节点，如下：

        #define list_for_each(pos, head) \
        for (pos = (head)->next; pos != (head); pos = pos->next)

如果是正常的遍历，那么下一个节点可以从当前节点中获得。如果此时将当前节点从链表中 删除之后，此时当前节点的 next 和 prev 指针已经被指向了一个不可用的地址。如果此时 还再使用当前节点去查找下一个节点的会必然会引起内核 panic。因此此时需要使用 safe 类 的接口解决这个问题，正如 list_for_each_safe() 函数定义，如下：

        #define list_for_each_safe(pos, n, head) \
        for (pos = (head)->next, n = pos->next; pos != (head); \
                pos = n, n = pos->next)

每次遍历的时候，函数都会提前将下一个节点缓存在 n 参数里，如果当前节点被删除之后， 下一个节点也可以从 n 参数中获得，这样不会导致内核 panic。



# list\_del

        static inline void __list_del(struct list_head * prev, struct list_head * next)
        {
          next->prev = prev;
          WRITE_ONCE(prev->next, next);
        }

        // list_del, NULL, may need:

        static inline void list_del_init(struct list_head *entry)
        {
          __list_del_entry(entry);
          INIT_LIST_HEAD(entry);
        }


        static inline void __list_del_entry(struct list_head *entry)
        {
          if (!__list_del_entry_valid(entry))
            return;

          __list_del(entry->prev, entry->next);
        }

        static inline void list_del(struct list_head *entry)
        {
          __list_del_entry(entry);
          entry->next = LIST_POISON1;
          entry->prev = LIST_POISON2;
        }

but:

        list_del(&pos->list);
        break; // !!!

- why not safe???
- `https://biscuitos.github.io/blog/LIST_ADV_safe/`

        lis_move和list_move_tail都有删除操作，但是这里却可以不使用list_for_each_entry_safe而直接使用list_for_each_entry，想想这是为什么呢？
        这是因为move函数，后面有一个添加链表的操作，将删除的节点前驱后继的LIST_POISON1和LIST_POISON2（本例中为NULL），重新赋值了

# list\_for\_each\_entry\_safe

        #define list_for_each_entry_safe(pos, n, head, member)			\
            for (pos = list_first_entry(head, typeof(*pos), member),	\
              n = list_next_entry(pos, member);			\
                 !list_entry_is_head(pos, head, member); 			\
                 pos = n, n = list_next_entry(n, member))

- 把后一个节点取出来使用n作为缓存，这样在还没删除节点时，就得到了要删除节点的下一个节点的地址，从而避免了程序出错。

> /* 在编译时加上-std=c99，使用c99标准，对内核链表进行编译，会报语法错误，那是因为c99并不支持某些gcc的语法特性，如果想在GNU中启用c99标准，可以使用-std=gnu99，使用这个选项之后，会对gnu语法进行特殊处理，并使用c99标准 */
