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

struct ListNode* removeElements0(struct ListNode* head, int val) {
  while (head != NULL && head->val == val) {
    head = head->next;
  }
  if (head == NULL) {
    return NULL;
  }
  struct ListNode* pre = head;
  struct ListNode* now = head->next;
  while (now != NULL) {
    if (now->val == val) {
      pre->next = now->next;
      free(now);
      now = pre->next;
    } else {
      pre = now;
      now = now->next;
    }
  }
  return head;
}

// 这个递归想，返回值是重点！！！
struct ListNode* removeElements(struct ListNode* head, int val) {
  if (head == NULL) {
    return head;
  }
  head->next = removeElements(head->next, val);
  return head->val == val ? head->next : head;
}

// 迭代，加一头结点
struct ListNode* removeElements(struct ListNode* head, int val) {
  struct ListNode* dummyHead = malloc(sizeof(struct ListNode));
  dummyHead->next = head;
  struct ListNode* temp = dummyHead;
  while (temp->next != NULL) {
    if (temp->next->val == val) {
      temp->next = temp->next->next;
    } else {
      temp = temp->next;
    }
  }
  return dummyHead->next;
}
