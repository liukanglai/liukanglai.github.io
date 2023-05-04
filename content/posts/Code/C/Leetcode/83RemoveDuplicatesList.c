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

struct ListNode* deleteDuplicates(struct ListNode* head) {
  if (head == NULL) {
    return head;
  }
  struct ListNode* pre = head;
  struct ListNode* now = head->next;
  while (now != NULL) {
    if (now->val == pre->val) {
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

// pre可以省略
struct ListNode* deleteDuplicates(struct ListNode* head) {
    if (!head) {
        return head;
    }

    struct ListNode* cur = head;
    while (cur->next) {
        if (cur->val == cur->next->val) {
            cur->next = cur->next->next;
        } else {
            cur = cur->next;
        }
    }

    return head;
}
