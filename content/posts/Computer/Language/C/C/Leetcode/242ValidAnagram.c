#include "uthash.h"
struct hashTable {
  int key;
  int val;
  UT_hash_handle hh;
};

bool isAnagram(char* s, char* t) {
  if (strlen(s) != strlen(t)) {
    return 0;
  }
  struct hashTable* hashtable = NULL;
  for (int i = 0; i < strlen(s); i++) {
    int ikey = s[i];
    struct hashTable* tmp;
    HASH_FIND_INT(hashtable, &ikey, tmp);
    if (tmp == NULL) {
      tmp = malloc(sizeof(struct hashTable));
      tmp->key = ikey, tmp->val = 1;
      HASH_ADD_INT(hashtable, key, tmp);
    } else {
      (tmp->val)++;
    }
  }
  for (int i = 0; i < strlen(t); i++) {
    int ikey = t[i];
    struct hashTable* tmp;
    HASH_FIND_INT(hashtable, &ikey, tmp);
    if (tmp == NULL || tmp->val <= 0) {
      return 0;
    } else {
      (tmp->val)--;
    }
  }
  return 1;
}

// 排序啊，
int cmp(const void* _a, const void* _b) {
  char a = *(char*)_a, b = *(char*)_b;
  return a - b;
}

bool s_isAnagram(char* s, char* t) {
  int len_s = strlen(s), len_t = strlen(t);
  if (len_s != len_t) {
    return false;
  }
  qsort(s, len_s, sizeof(char), cmp);
  qsort(t, len_t, sizeof(char), cmp);
  return strcmp(s, t) == 0;
}
