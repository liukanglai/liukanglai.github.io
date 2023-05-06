/**
 * Note: The returned array must be malloced, assume caller calls free().
 */

#include <math.h>
#include <stdio.h>
#include <stdlib.h>

int *sortedSquares(int *nums, int numsSize, int *returnSize);
int main() {
  int nums[] = {-4, -1, 0, 3, 10, 100};
  int numsSize = sizeof(nums) / sizeof(nums[0]);
  int *returnSize = (int *)malloc(sizeof(int));
  int *ret = sortedSquares(nums, numsSize, returnSize);
  for (size_t i = 0; i < numsSize; i++) {
    printf("%d ", ret[i]);
  }
}

int *sortedSquares(int *nums, int numsSize, int *returnSize) {
  *returnSize = numsSize;
  int *ret = (int *)malloc(numsSize * sizeof(int));
  int positive = numsSize;
  int position = 0;
  for (int i = 0; i < numsSize; i++) {
    if (nums[i] >= 0) {
      positive = i;
      break;
    }
  }
  int negative = positive - 1;
  while (1) {
    if (positive == numsSize) {
      while (negative >= 0) {
        ret[position++] = pow(nums[negative--], 2);
      }
      return ret;
    }
    if (negative == -1) {
      while (positive <= numsSize - 1) {
        ret[position++] = pow(nums[positive++], 2);
      }
      return ret;
    }
    if (pow(nums[positive], 2) <= pow(nums[negative], 2)) {
      ret[position++] = pow(nums[positive++], 2);
    } else {
      ret[position++] = pow(nums[negative--], 2);
    }
  }
}

int *s_sortedSquares(int *nums, int numsSize, int *returnSize) {
  int negative = -1;
  for (int i = 0; i < numsSize; ++i) {
    if (nums[i] < 0) {
      negative = i;
    } else {
      break;
    }
  }

  int *ans = malloc(sizeof(int) * numsSize);
  *returnSize = 0;
  int i = negative, j = negative + 1;
  while (i >= 0 || j < numsSize) {
    if (i < 0) {
      ans[(*returnSize)++] = nums[j] * nums[j];
      ++j;
    } else if (j == numsSize) {
      ans[(*returnSize)++] = nums[i] * nums[i];
      --i;
    } else if (nums[i] * nums[i] < nums[j] * nums[j]) {
      ans[(*returnSize)++] = nums[i] * nums[i];
      --i;
    } else {
      ans[(*returnSize)++] = nums[j] * nums[j];
      ++j;
    }
  }

  return ans;
}
