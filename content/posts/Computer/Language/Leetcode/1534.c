

#include <stdlib.h>
int countGoodTriplets(int *arr, int arrSize, int a, int b, int c) {
  int count = 0;
  for (int i = 0; i < arrSize - 2; i++) {
    for (int j = i + 1; j < arrSize - 1; j++) {
      if (abs(arr[i] - arr[j]) <= a) {
        for (int k = j + 1; k < arrSize; k++) {
          if (abs(arr[j] - arr[k]) <= b) {
            if (abs(arr[i] - arr[k]) <= c) {
              count++;
            }
          }
        }
      }
    }
  }
  return count;
}
