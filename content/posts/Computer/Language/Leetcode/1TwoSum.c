/**
 * Note: The returned array must be malloced, assume caller calls free().
 */

#include "uthash.h"
#include <ctype.h>
#include <stdio.h>
#include <stdlib.h>

int *twoSum(int *nums, int numsSize, int target, int *returnSize);

struct hashTable {
  int key;
  int val;
  UT_hash_handle hh;
};

struct hashTable *hashtable;

struct hashTable *find(int ikey) {
  struct hashTable *tmp;
  HASH_FIND_INT(hashtable, &ikey, tmp);
  return tmp;
}

void insert(int ikey, int ival) {
  struct hashTable *it = find(ikey);
  if (it == NULL) {
    struct hashTable *tmp = malloc(sizeof(struct hashTable));
    tmp->key = ikey, tmp->val = ival;
    HASH_ADD_INT(hashtable, key, tmp);
  } else {
    it->val = ival;
  }
}

int *s_twoSum(int *nums, int numsSize, int target, int *returnSize) {
  hashtable = NULL;
  for (int i = 0; i < numsSize; i++) {
    struct hashTable *it = find(target - nums[i]);
    if (it != NULL) {
      int *ret = malloc(sizeof(int) * 2);
      ret[0] = it->val, ret[1] = i;
      *returnSize = 2;
      return ret;
    }
    insert(nums[i], i);
  }
  *returnSize = 0;
  return NULL;
}

int main() {
  int nums[10000];
  char c;
  int numsSize = 0;
  int target = 0;
  int *returnSize;
  while ((c = getchar()) != '\n') {
    if (isdigit(c)) {
      // 负数存不进去？
      ungetc(c, stdin); // 将c送回输入流
      scanf("%d", &nums[numsSize++]);
    }
  }
  for (int i = 0; i < numsSize; i++) {
    printf("%d ", nums[i]);
  }
  printf("\nPlease input the target: ");
  scanf("%d", &target);
  int *ret = twoSum(nums, numsSize, target, returnSize);
  for (int i = 0; i < 2; i++) {
    printf("%d ", ret[i]);
  }
  free(ret);
}
int *twoSum0(int *nums, int numsSize, int target, int *returnSize) {
  // 用不了，函数内malloc有问题！
  // 想清楚了，这个returnSize是啥！！！
  returnSize = (int *)malloc(2 * sizeof(int));
  for (int i = 0; i < numsSize; i++) {
    for (int j = i + 1; j < numsSize; j++) {
      if ((nums[i] + nums[j]) == target) {
        *returnSize = i;
        *(returnSize + 1) = j;
        return returnSize;
      }
    }
  }
}

int *twoSum(int *nums, int numsSize, int target, int *returnSize) {
  int *ret = (int *)malloc(2 * sizeof(int));
  for (int i = 0; i < numsSize; i++) {
    for (int j = i + 1; j < numsSize; j++) {
      if ((nums[i] + nums[j]) == target) {
        *ret = i;
        *(ret + 1) = j;
        return ret;
      }
    }
  }
}
