// Copyright

#include <stdio.h>

int maxSubArray(int *nums, int numsSize);
int maxSub(int *nums, int left, int right);
int maxSub1(int *nums, int end, int *rsum);
int main() {
    int nums[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    int numsSize = sizeof(nums) / sizeof(int);
    maxSubArray(nums, numsSize);
    return 0;
}

/* int maxSubArray(int *nums, int numsSize) {
  int a[numsSize][numsSize];
  for (int i = 0; i < numsSize; i++) {
    for (int j = 0; j < numsSize; j++) {
      a[i][j] = 0;
    }
  }
  for (int i = 0; i < numsSize; i++) {
    for (int j = i; j >= 0; j--) {
      if (i == 0)
        a[j][i] = nums[i];
      else
        a[j][i] = nums[i] + a[j][i - 1];
    }
  }
  for (int i = 0; i < numsSize; i++) {
    for (int j = 0; j < numsSize; j++) {
      printf("%d ", a[i][j]);
    }
    printf("\n");
  }
  int sum = a[0][0];
  for (int i = 0; i < numsSize; i++) {
    for (int j = i; j < numsSize; j++) {
      if (a[i][j] > sum) {
        sum = a[i][j];
      }
    }
  }
  printf("%d", sum);
  return sum;
} */
// use divide and conquer
/*
int maxSubArray(int *nums, int numsSize) {
  int sum = 0;
  sum = maxSub(nums, 0, numsSize - 1);
  printf("%d\n", sum);
  return sum;
}

int maxSub(int *nums, int left, int right) {
  if (nums == NULL) {
    return -1;
  }
  if (left == right) {
    return nums[left];
  }

  int leftMax = maxSub(nums, left, (left + right) / 2); // a wrong, 注意中间值
  int rightMax = maxSub(nums, (left + right) / 2 + 1, right);
  int sum = leftMax > rightMax ? leftMax : rightMax;

  int leftSum = nums[(left + right) / 2];
  leftMax = leftSum;
  for (int i = (left + right) / 2 - 1; i >= left; i--) {
    leftSum += nums[i];
    if (leftMax < leftSum) {
      leftMax = leftSum;
    }
  }
  int rightSum = nums[(left + right) / 2 + 1];
  rightMax = rightSum;
  for (int i = (left + right) / 2 + 2; i <= right; i++) {
    rightSum += nums[i];
    if (rightMax < rightSum) {
      rightMax = rightSum;
    }
  }
  sum = sum > leftMax + rightMax ? sum : leftMax + rightMax;
  return sum;
}
*/

/*
int maxSubArray(int *nums, int numsSize) {
  int rsum = nums[0];
  int sum = maxSub1(nums, numsSize - 1, &rsum);
  printf("%d\n", sum);
  return sum;
}
// recursion
int maxSub1(int *nums, int end, int *rsum) {
  if (end == 0) {
    *rsum = nums[end];
    return nums[end];
  }
  int sum = maxSub1(nums, end - 1, rsum);
  *rsum = *rsum + nums[end] > nums[end] ? *rsum + nums[end] : nums[end];
  sum = *rsum > sum ? *rsum : sum;
  return sum;
}
*/
int maxSubArray(int *nums, int numsSize) {
    int rsum = nums[0];
    int sum = rsum;
    for (int i = 1; i < numsSize; i++) {
        rsum = rsum + nums[i] > nums[i] ? rsum + nums[i] : nums[i];
        sum = rsum > sum ? rsum : sum;
    }
    printf("%d\n", sum);
    return sum;
}
