#include <stdio.h>
#include <stdlib.h>
int comparator(const void* p, const void* q) {
  int l = *(int*)p;
  int r = *(int*)q;
  return (l - r);
}

/* 困难
int makeArrayIncreasing(int* arr1, int arr1Size, int* arr2, int arr2Size) {
  int sum = 0;
  qsort(arr2, arr2Size, sizeof(int), comparator);
  int j = 0;
  int min = -1;
  for (int i = 0; i < arr1Size - 1; i++) {
    if (arr1[i] >= arr1[i + 1]) {
      for (; j < arr2Size; j++) {
        if (arr2[j] < arr1[i + 1]) {
          min = arr2[j];
          break;
        }
      }
      if (min == -1) {
        return -1;
      }
      arr2[flag] = arr1[i];
      arr1[i] = min;
      sum++;
    }
  }
  return sum;
}
*/

// 递归
int makeArrayIncreasing(int* arr1, int arr1Size, int* arr2, int arr2Size) {
  int sum = 0;
  qsort(arr2, arr2Size, sizeof(int), comparator);
  int j = 0;
  int min = -1;
  for (int i = 0; i < arr1Size - 1; i++) {
    if (arr1[i] >= arr1[i + 1]) {
      for (; j < arr2Size; j++) {
        if (arr2[j] < arr1[i + 1]) {
          min = arr2[j];
          break;
        }
      }
      if (min == -1) {
        return -1;
      }
      arr2[flag] = arr1[i];
      arr1[i] = min;
      sum++;
    }
  }
  return sum;
}

int main(int argc, char* argv[]) {
  int arr1[5] = {1, 5, 3, 6, 7};
  int arr2[4] = {1, 3, 2, 4};
  printf("%d\n", makeArrayIncreasing(arr1, 5, arr2, 4));
}
