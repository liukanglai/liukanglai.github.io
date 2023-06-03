// Time:2022-09-08 15:01:19
#include <stdio.h>

typedef struct tree {
  int location;
  struct tree *next;
} tree;

int main(void) {
  int L, i, j, n; // L 为区间的长度,n 为区间的个数,i 和 j 是循环变量。
  int trees[10001]; // 用一个布尔数组模拟树的存在情况。
  for (i = 0; i < 10001; i++) // 赋初值
    trees[i] = 1;
  scanf("%d%d", &L, &n);
  for (i = 0; i < n; i++) {
    int begin, end; // 用 begin,end 存储区间的起止位置。
    scanf("%d%d", &begin, &end);
    for (j = begin; j <= end; j++) // 将区间内的树移走,即赋值为 false。
      trees[j] = 0;
  }
  int count = 0; //用 count 计数,数数剩余的树的数目。
  for (i = 0; i <= L; i++)
    if (trees[i])
      count++;
  printf("%d\n", count);
}

int myMethod(int L, n) {
  int length = 2 * (n + 1);
  trees[1] = 501;
  for (int i = 0; i < n; i++) {
    int begin, end; // 用 begin,end 存储区间的起止位置。
    scanf("%d%d", &begin, &end);
    for (int j = 0; j < length; j++) {
      if (begin < trees[j])
    }
  }
}
