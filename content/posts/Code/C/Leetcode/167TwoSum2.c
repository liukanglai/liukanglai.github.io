#include "uthash.h"
int *twoSum0(int *nums, int numsSize, int target, int *returnSize) {
  *returnSize = 2;
  int *ret = (int *)malloc(2 * sizeof(int));
  for (int i = 0; i < numsSize; i++) {
    for (int j = i + 1; j < numsSize && (nums[i] + nums[j] <= target); j++) {
      if ((nums[i] + nums[j]) == target) {
        *ret = i;
        *(ret + 1) = j;
        return ret;
      }
    }
  }
}

// hash
struct hashTable {
  int key;
  int val;
  UT_hash_table hh;
} *hashtable;

struct hashtable *find(int ikey) {
  struct hashTable *tmp;
  HASH_FIND_INT(hashtable, &ikey, tmp);
  return tmp;
}

void insert(int ikey, int ival) {
  struct hashTable *it = find(ikey);
  if (it == NULL) {
    it = (struct hashTable *)malloc(sizeof(struct hashTable));
    it->key = ikey, it->val = ival;
    HASH_ADD_INT(hashtable, key, it);
  } else {
    it->val = ival; // 多个键值？？？
  }
}

int *twoSum(int *nums, int numsSize, int target, int *returnSize) {
  *returnSize = 2;
  int *ret = (int *)malloc(2 * sizeof(int));
  hashtable = NULL;
  for (int i = 0; i < numsSize; i++) {
    insert(nums[i]);
  }
}
