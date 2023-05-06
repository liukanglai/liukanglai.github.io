/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */

struct ListNode {
  int val;
  struct ListNode* next;
};

struct ListNode* reverseList0(struct ListNode* head) {
  if (head == NULL) {
    return NULL;
  }
  struct ListNode* dummyHead = malloc(sizeof(struct ListNode));
  dummyHead->next = head;
  struct ListNode* next = head->next;
  struct ListNode* pre = head;
  while (next != NULL) {
    dummyHead->next = next;
    pre->next = next->next;
    next->next = head;
    next = pre->next;
    head = dummyHead->next;
  }
  return dummyHead->next;
}

// 迭代
struct ListNode* s_reverseList0(struct ListNode* head) {
  struct ListNode* prev = NULL;
  struct ListNode* curr = head;
  while (curr) {
    struct ListNode* next = curr->next;
    curr->next = prev;
    prev = curr;
    curr = next;
  }
  return prev;
}

// recursion
struct ListNode* s_reverseList(struct ListNode* head) {
  if (head == NULL || head->next == NULL) {
    return head;
  }
  struct ListNode* newHead = reverseList(head->next);
  // 主要是把head插入尾部，而尾部不要用返回的head去想，用原来的head去想。
  head->next->next = head;
  head->next = NULL;
  return newHead;
}
