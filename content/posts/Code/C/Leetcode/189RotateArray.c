// 方法1: 来一个数组
void rotate(int *nums, int numsSize, int k) {
  int *nums1 = (int *)malloc(numsSize * sizeof(int));
  if (k > numsSize) {
    k = k % numsSize;
  }
  int pos = numsSize - k;
  int pos1 = 0;
  while (pos < numsSize) {
    nums1[pos1++] = nums[pos++];
  }
  pos = 0;
  while (pos < numsSize - k) {
    nums1[pos1++] = nums[pos++];
  }
  memcpy(nums, nums1, numsSize * sizeof(int));
  free(nums1);
}

// !!
void swap(int *a, int *b) {
  int t = *a;
  *a = *b, *b = t;
}
void reverse(int *nums, int start, int end) {
  while (start < end) {
    swap(&nums[start], &nums[end]);
    start += 1;
    end -= 1;
  }
}
void s_rotate(int *nums, int numsSize, int k) {
  k %= numsSize;
  reverse(nums, 0, numsSize - 1);
  reverse(nums, 0, k - 1);
  reverse(nums, k, numsSize - 1);
}
