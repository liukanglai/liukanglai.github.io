// 20/11/19 Thursday
// move all 0 to the end of the array, other values' order can't be changed.
//

#include <stdio.h>

void swap(int *i, int *j) {
  int template = 0;
  template = *i;
  *i = *j;
  *j = template;
}

void moveZeroes(int *nums, int numsSize) {
  int i = 0, j = 0;
  while (j < numsSize) {
    if (!nums[i]) {
      while (j < numsSize) {
        if (nums[++j]) { // judge if j
          swap(nums + i, nums + j);
          break;
        }
      }
    }
    i++;
  }
}

int main(void) {
  int a[] = {0, 1, 0, 3, 12};
  moveZeroes(a, 5);
  for (int i = 0; i < 5; i++) {
    printf("%d ", a[i]);
  }
  return 0;
}

/*
// wrong [1]
//
void moveZeroes(int* nums, int numsSize){
    int i = 0, j = 0;

    while(j < numsSize){
        if(!nums[i]){
            while(j < numsSize){
                if(nums[j]){
                    nums[i] = nums[j];
                    nums[j] = 0;
                    break;
                }
                j++;
            }
        }
        i++;
    }
}

*/
void moveZeroes1(int *nums, int numsSize) {
  int nums0 = 0;
  for (int i = 0; i < numsSize; i++) {
    if (nums[i] == 0) {
      nums0++;
    }
  }
  if (nums0 == 0) {
    return;
  }
  int pos = 0; // 把非0元素放前面
  for (int i = 0; i < numsSize; i++) {
    if (nums[i] != 0) {
      nums[pos++] = nums[i];
    }
  }
  memset(nums + numsSize - nums0, 0, nums0 * (sizeof(int)));
}
void s_moveZeroes(int *nums, int numsSize) {
  int i = 0, j = 0;

  while (j < numsSize && i < numsSize) {
    if (!nums[i]) {
      while (j < numsSize) {
        if (nums[j]) {
          nums[i] = nums[j];
          nums[j] = 0;
          break;
        }
        j++;
      }
    }
    i++;
    j++; // remember
  }
}
