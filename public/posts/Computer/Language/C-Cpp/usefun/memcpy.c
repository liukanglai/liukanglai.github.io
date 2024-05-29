#include <stdio.h>
#include <string.h>

int main() { memcpy(void *a, const void *b, n * sizeof()); }

/*
# memcpy

- void 指针主要用于内存拷贝。源块和目的块的地址就都可以用 void
指针表示。C/C++中有以下标准库函数:
- void *memcpy(void *dest, const void \*src, unsigned int n);
- 它在头文件 string.h 和 mem.h 中声明,作用就是将地址 src 开始的 n 字节内容,拷贝
到地址 dest。返回值就是 dest 。

        int a1[10];
        int a2[10];
        memcpy( a2, a1, 10*sizeof(int));

        */
