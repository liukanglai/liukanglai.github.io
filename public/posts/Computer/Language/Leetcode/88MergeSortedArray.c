#include <string.h>

void merge(int *nums1, int nums1Size, int m, int *nums2, int nums2Size, int n);

int main() {
  int nums1[] = {4, 5, 6, 0, 0, 0}, m = 3, nums2[] = {1, 2, 3}, n = 3;
  merge(nums1, 6, m, nums2, 3, n);
}
void merge(int *nums1, int nums1Size, int m, int *nums2, int nums2Size, int n) {
  int position = nums1Size - 1;
  int i = m - 1;
  int j = n - 1;
  int tem;
  while (1) {
    if (j < 0) {
      break;
    }
    if (i < 0) {
      // while (position >= 0) {
      //   nums1[position--] = nums2[j--];
      // }
      memcpy(nums1, nums2, (j + 1) * sizeof(int));
      break;
    }
    if (nums1[i] >= nums2[j]) {
      tem = nums1[i--];
    } else {
      tem = nums2[j--];
    }
    nums1[position--] = tem;
  }
}

int cmp(int *a, int *b) { return *a - *b; }

void s_merge(int *nums1, int nums1Size, int m, int *nums2, int nums2Size,
             int n) {
  for (int i = 0; i != n; ++i) {
    nums1[m + i] = nums2[i];
  }
  qsort(nums1, nums1Size, sizeof(int), cmp);
}
