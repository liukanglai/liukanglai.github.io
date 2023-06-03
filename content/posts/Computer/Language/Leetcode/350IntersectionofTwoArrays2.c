/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
#include "uthash.h"
int *intersect0(int *nums1, int nums1Size, int *nums2, int nums2Size,
                int *returnSize) {
  *returnSize = 0;
  int flag[nums2Size]; // 表示nums2里的元素被找过
  memset(flag, 0, nums2Size * sizeof(int));
  for (int i = 0; i < nums1Size; i++) {
    for (int j = 0; j < nums2Size; j++) {
      if (nums1[i] == nums2[j] && flag[j] == 0) {
        (*returnSize)++;
        flag[j] = 1;
        break;
      }
    }
  }
  int *ret = (int *)malloc((*returnSize) * sizeof(int));
  int pos = 0;
  for (int i = 0; i < nums2Size && pos < *returnSize; i++) {
    if (flag[i]) {
      ret[pos++] = nums2[i];
    }
  }
  return ret;
}

// hash
struct hashTable {
  int key;
  int shows; // 出现的次数
  int maps;  // 匹配的次数
  UT_hash_handle hh;
};

struct hashTable *hashtable;

struct hashTable *find(int ikey) {
  struct hashTable *tmp;
  HASH_FIND_INT(hashtable, &ikey, tmp);
  return tmp;
}

void insert(int ikey) {
  struct hashTable *it = find(ikey);
  if (it == NULL) {
    struct hashTable *tmp = malloc(sizeof(struct hashTable));
    tmp->key = ikey, tmp->shows = 1, tmp->maps = 0;
    HASH_ADD_INT(hashtable, key, tmp);
  } else {
    (it->shows)++;
  }
}

int *intersect(int *nums1, int nums1Size, int *nums2, int nums2Size,
               int *returnSize) {
  *returnSize = 0;
  hashtable = NULL;
  for (int i = 0; i < nums1Size; i++) {
    insert(nums1[i]);
  }
  for (int i = 0; i < nums2Size; i++) {
    struct hashTable *it = find(nums2[i]);
    if (it != NULL && it->shows > 0) {
      (it->maps)++;
      (it->shows)--;
      (*returnSize)++;
    }
  }
  int *ret = (int *)malloc((*returnSize) * sizeof(int));
  int pos = 0;
  for (int i = 0; pos < *returnSize; i++) {
    struct hashTable *it = find(nums1[i]);
    while ((it->maps--) > 0) {
      ret[pos++] = nums1[i];
    }
  }
  return ret;
}

int cmp(const void *_a, const void *_b) {
  int *a = _a, *b = (int *)_b;
  return *a == *b ? 0 : *a > *b ? 1 : -1;
}

int *s_intersect(int *nums1, int nums1Size, int *nums2, int nums2Size,
                 int *returnSize) {
  qsort(nums1, nums1Size, sizeof(int), cmp);
  qsort(nums2, nums2Size, sizeof(int), cmp);
  *returnSize = 0;
  int *intersection = (int *)malloc(sizeof(int) * fmin(nums1Size, nums2Size));
  int index1 = 0, index2 = 0;
  while (index1 < nums1Size && index2 < nums2Size) {
    if (nums1[index1] < nums2[index2]) {
      index1++;
    } else if (nums1[index1] > nums2[index2]) {
      index2++;
    } else {
      intersection[(*returnSize)++] = nums1[index1];
      index1++;
      index2++;
    }
  }
  return intersection;
}
