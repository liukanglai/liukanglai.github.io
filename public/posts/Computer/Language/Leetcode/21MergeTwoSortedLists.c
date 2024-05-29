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

// recursion
struct ListNode* mergeTwoLists(struct ListNode* list1, struct ListNode* list2) {
  if (list1 == NULL) {
    return list2;
  }
  if (list2 == NULL) {
    return list1;
  }
  if (list1->val <= list2->val) {
    list1->next = mergeTwoLists(list1->next, list2);
    return list1;
  }
  list2->next = mergeTwoLists(list1, list2->next);
  return list2;
}

/*
ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
  ListNode* preHead = new ListNode(-1);

  ListNode* prev = preHead;
  while (l1 != nullptr && l2 != nullptr) {
    if (l1->val < l2->val) {
      prev->next = l1;
      l1 = l1->next;
    } else {
      prev->next = l2;
      l2 = l2->next;
    }
    prev = prev->next;
  }

  // 合并后 l1 和 l2
  最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可 prev
      ->next = l1 == nullptr ? l2 : l1;

  return preHead->next;
}
*/
