// Copyright

#include "uthash.h"
#include <stdio.h>
#include <stdlib.h>

int containsDuplicate(int *nums, int numsSize);

int comparator(const void *p, const void *q) {
  int l = *((int *)p);
  int r = *((int *)q);
  return (l - r);
}

int main(void) {
  int *nums;
  int numsSize = 0;
  scanf("%d", &numsSize);

  nums = (int *)malloc((sizeof(int)) * numsSize); // in websites it gets.

  int flag = containsDuplicate(nums, numsSize);

  if (flag)
    printf("Ture!");
  else
    printf("False!");
}

int containsDuplicate1(int *nums, int numsSize) {
  // int size = sizeof(arr) / sizeof(arr[0]);
  qsort((void *)nums, numsSize, sizeof(int), comparator);
  for (int i = 1; i < numsSize; i++) {
    if (nums[i] == nums[i - 1])
      return 1;
  }
  return 0;
}

struct hashTable {
  int key;
  UT_hash_handle hh;
};

int containsDuplicate(int *nums, int numsSize) {
  struct hashTable *set = NULL;
  for (int i = 0; i < numsSize; i++) {
    struct hashTable *tmp;
    HASH_FIND_INT(set, nums + i, tmp);
    if (tmp == NULL) {
      tmp = malloc(sizeof(struct hashTable));
      tmp->key = nums[i];
      HASH_ADD_INT(set, key, tmp);
    } else {
      return 1;
    }
  }
  return 0;
}

// 作者：LeetCode-Solution
// 链接：https://leetcode.cn/problems/contains-duplicate/solution/cun-zai-zhong-fu-yuan-su-by-leetcode-sol-iedd/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
