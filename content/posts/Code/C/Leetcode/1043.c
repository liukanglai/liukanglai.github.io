#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int maxSumAfterPartitioning(int* arr, int arrSize, int k) {
  int max[arrSize];
  memset(max, 0, sizeof(max));
  max[0] = arr[0];
  for (int i = 1; i < arrSize; i++) {
    for (int j = i; j > i - k && j >= 0; j--) {
      int maximum = 0;
      for (int m = i; m >= j; m--) {
        maximum = maximum > arr[m] ? maximum : arr[m];
      }
      if (j == 0) {
        max[i] =
            max[i] > maximum * (i - j + 1) ? max[i] : maximum * (i - j + 1);
      } else {
        max[i] = max[i] > maximum * (i - j + 1) + max[j - 1]
                     ? max[i]
                     : maximum * (i - j + 1) + max[j - 1];
      }
    }
  }
  return max[arrSize - 1];
}

// 两个改进：max求法! + max数组有-1下标

#define MAX(a, b) ((a) > (b) ? (a) : (b))

int s_maxSumAfterPartitioning(int* arr, int arrSize, int k) {
  int d[arrSize + 1];
  memset(d, 0, sizeof(d));
  for (int i = 1; i <= arrSize; i++) {
    int maxValue = arr[i - 1];
    for (int j = i - 1; j >= 0 && j >= i - k; j--) {
      d[i] = MAX(d[i], d[j] + maxValue * (i - j));
      if (j > 0) {
        maxValue = MAX(maxValue, arr[j - 1]);
      }
    }
  }
  return d[arrSize];
}

int main(void) { return 1; }
