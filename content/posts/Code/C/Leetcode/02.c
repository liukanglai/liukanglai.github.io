// 20/11/20 Friday
// Sort a linked list using insertion sort.
//

#include<stdio.h>
#include<stdlib.h>

struct ListNode{
    int val;
    struct ListNode *next;
};

struct ListNode* insertionSortList(struct ListNode* head){
    // judge whether the linked list is NULL

    if(head == NULL)
        return head;

    // create a new linked list to store the result
    struct ListNode* list = (struct ListNode*)malloc(sizeof(struct ListNode));
    // make sure there was enough memory!
    if(list == NULL) return NULL;

    // 
    list->val = head->val;
    list->next = NULL;

    struct ListNode* node = head->next; // is the node in old linked list 

    // define the sort pointer
    struct ListNode* pre = list;
    struct ListNode* now = list;
    

    // insert in head and other

    while(node != NULL){
        struct ListNode* Onode = node->next; // record the node->next
        if(node->val <= now->val){
            list = node;
            node->next = now;
        }
        else{
            now = now->next;
            while(now != NULL){
                if(node->val <= now->val){
                    break; 
                }
                now = now->next;
                pre = pre->next;
            }
            pre->next = node;
            node->next = now;
        }

        node = Onode;
        pre = now = list; // turn back
    }

    return list;
}
