// Time:2022-01-24 14:04:03

#include <stdio.h>
#include <stdlib.h>

// https://www.cnblogs.com/foreverjoker/archive/2013/05/25/qsort-sort.html

// void qsort(void *base, int nelem, unsigned int width, int ( * pfCompare)(
// const void *, const void *));
/* 1. 如果 _ elem1 应该排在 _ elem2
 * 前面,则函数返回值是负整数(任何负整数都行)，升序*/
/* 2. 如果 _ elem1 和_ elem2 哪个排在前面都行,那么函数返回 0*/
/* 3. 如果 _ elem1 应该排在 _ elem2 后面,则函数返回值是正整数(任何正整数都行)*/

#define NUM 5

int comparator(const void *p, const void *q) {
  int l = *(int *)p;
  int r = *(int *)q;
  return (l - r);
}

int main() {
  unsigned int an[NUM] = {8, 123, 11, 10, 4};
  qsort(an, NUM, sizeof(unsigned int), comparator);
  for (int i = 0; i < NUM; i++)
    printf("%u ", an[i]);
  return 0;
}
