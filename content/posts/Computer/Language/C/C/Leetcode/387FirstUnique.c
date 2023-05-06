#include "uthash.h"

struct hashTable {
  int key;
  int num;
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
    tmp->key = ikey, tmp->num = 1;
    HASH_ADD_INT(hashtable, key, tmp);
  } else {
    (it->num)++;
  }
}
int firstUniqChar(char *s) {
  hashtable = NULL;
  for (int i = 0; i < strlen(s); i++) {
    insert(s[i]);
  }
  for (int i = 0; i < strlen(s); i++) {
    struct hashTable *tmp = find(s[i]);
    if (tmp->num == 1) {
      return i;
    }
  }
  return -1;
}

int s_firstUniqChar(char *s) {
  struct hashTable *frequency = NULL;
  int n = strlen(s);
  for (int i = 0; i < n; i++) {
    int ikey = s[i];
    struct hashTable *tmp;
    HASH_FIND_INT(frequency, &ikey, tmp);
    if (tmp == NULL) {
      tmp = malloc(sizeof(struct hashTable));
      tmp->key = ikey;
      tmp->num = 1;
      HASH_ADD_INT(frequency, key, tmp);
    } else {
      tmp->num++;
    }
  }
  for (int i = 0; i < n; i++) {
    int ikey = s[i];
    struct hashTable *tmp;
    HASH_FIND_INT(frequency, &ikey, tmp);
    if (tmp != NULL && tmp->num == 1) {
      return i;
    }
  }
  return -1;
}

int s_firstUniqChar1(char *s) {
  struct hashTable *position = NULL;
  int n = strlen(s);
  for (int i = 0; i < n; ++i) {
    int ikey = s[i];
    struct hashTable *tmp;
    HASH_FIND_INT(position, &ikey, tmp);
    if (tmp != NULL) {
      tmp->num = -1;
    } else {
      tmp = malloc(sizeof(struct hashTable));
      tmp->key = ikey;
      tmp->num = i;
      HASH_ADD_INT(position, key, tmp);
    }
  }

  int first = n;
  struct hashTable *iter, *tmp;
  HASH_ITER(hh, position, iter, tmp) {
    int pos = iter->num;
    if (pos != -1 && pos < first) {
      first = pos;
    }
  }
  if (first == n) {
    first = -1;
  }
  return first;
}
