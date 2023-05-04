#include "uthash.h"
#include <stdio.h>
// 时间太长
int maxProfit0(int *prices, int pricesSize) {
  int maxProfit = 0;
  for (int i = 0; i < pricesSize; i++) {
    for (int j = i + 1; j < pricesSize; j++) {
      maxProfit =
          prices[j] - prices[i] > maxProfit ? prices[j] - prices[i] : maxProfit;
    }
  }
  return maxProfit;
}

int cmp(const void *_a, const void *_b) {
  int *a = _a, *b = _b;
  return *a == *b ? 0 : *a > *b ? 1 : -1;
}
// hash
struct hashTable {
  int key;
  int pos[10000]; // 出现的位置
  int num;        // 出现的次数
  UT_hash_handle hh;
};

struct hashTable *hashtable;

struct hashTable *find(int ikey) {
  struct hashTable *tmp;
  HASH_FIND_INT(hashtable, &ikey, tmp);
  return tmp;
}

void insert(int ikey, int ipos) {
  struct hashTable *it = find(ikey);
  if (it == NULL) {
    struct hashTable *tmp = malloc(sizeof(struct hashTable));
    tmp->key = ikey, tmp->pos[0] = ipos, tmp->num = 1;
    HASH_ADD_INT(hashtable, key, tmp);
  } else {
    it->pos[(it->num)++] = ipos;
  }
}
int maxProfit(int *prices, int pricesSize) {
  hashtable = NULL;
  for (int i = 0; i < pricesSize; i++) {
    insert(prices[i], i);
  }
  qsort(prices, pricesSize, sizeof(int), cmp);
  int maxProfit = 0;
  for (int i = 0; i < pricesSize; i++) {
    for (int j = pricesSize - 1; j > i; j--) {
      struct hashTable *iti = find(prices[i]);
      struct hashTable *itj = find(prices[j]);
      int iNum = iti->num;
      int jNum = itj->num;
      while ((iNum--) > 0) {
        while ((jNum--) > 0) {
          if (iti->pos[iNum] < itj->pos[jNum]) {
            maxProfit = prices[j] - prices[i] > maxProfit
                            ? prices[j] - prices[i]
                            : maxProfit;
            break;
          }
        }
        jNum = itj->num;
      }
    }
  }
  return maxProfit;
}

int main() {
  int prices[] = {3, 2, 6, 5, 0, 3};
  int pricesSize = 6;
  printf("%d\n", maxProfit(prices, pricesSize));
}

// 天才！
int s_maxProfit(int *prices, int pricesSize) {
  int min_price = prices[0];
  int maxProfit = 0;
  for (int i = 1; i < pricesSize; i++) {
    min_price = prices[i] < min_price ? prices[i] : min_price;
    maxProfit =
        (prices[i] - min_price) > maxProfit ? prices[i] - min_price : maxProfit;
  }
  return maxProfit;
}
