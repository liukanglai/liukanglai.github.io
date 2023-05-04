/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
#include "uthash.h"
struct ListNode {
  int val;
  struct ListNode* next;
};

// 用地址去hash
struct hashTable {
  int key;
  int val;
  UT_hash_handle hh;
}* hashtable;
bool hasCycle(struct ListNode* head) {
  hashtable = NULL;
  while (head != NULL) {
    int ikey = head;
    struct hashTable* tmp;
    HASH_FIND_INT(hashtable, &ikey, tmp);
    if (tmp == NULL) {
      tmp = malloc(sizeof(struct hashTable));
      tmp->key = ikey;
      HASH_ADD_INT(hashtable, key, tmp);
    } else {
      return 1;
    }
    head = head->next;
  }
  return 0;
}

// 直接存入指针，hash
struct hashTable {
  struct ListNode* key;
  UT_hash_handle hh;
};

struct hashTable* hashtable;

struct hashTable* find(struct ListNode* ikey) {
  struct hashTable* tmp;
  HASH_FIND_PTR(hashtable, &ikey, tmp);
  return tmp;
}

void insert(struct ListNode* ikey) {
  struct hashTable* tmp = malloc(sizeof(struct hashTable));
  tmp->key = ikey;
  HASH_ADD_PTR(hashtable, key, tmp);
}

bool hasCycle(struct ListNode* head) {
  hashtable = NULL;
  while (head != NULL) {
    if (find(head) != NULL) {
      return true;
    }
    insert(head);
    head = head->next;
  }
  return false;
}

// 「Floyd 判圈算法」（又称龟兔赛跑算法）
bool hasCycle(struct ListNode* head) {
  if (head == NULL || head->next == NULL) {
    return false;
  }
  struct ListNode* slow = head;
  struct ListNode* fast = head->next;
  while (slow != fast) {
    if (fast == NULL || fast->next == NULL) {
      return false;
    }
    slow = slow->next;
    fast = fast->next->next;
  }
  return true;
}
