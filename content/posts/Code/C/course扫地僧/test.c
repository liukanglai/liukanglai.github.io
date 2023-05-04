// Copyright

#include <stdio.h>
#include <stdlib.h>

// 排序
int main(int argc, char *argv[]) {
  int a[] = {33, 654, 4, 455, 6, 33, 4};
  int num = sizeof(a) / sizeof(a[0]);
  int tmp = 0;
  for (int i = 0; i < 7; i++) {
    for (int j = i + 1; j < 7; j++) {
      if (a[i] < a[j]) {
        tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
      }
    }
  }
  printf("hello\n");
  return 0;
}

void printArray(int *a, int nums) {}  // int a[7]; 这个a也是一个指针！同*a

void sortArray(int *a, int nums) {}
