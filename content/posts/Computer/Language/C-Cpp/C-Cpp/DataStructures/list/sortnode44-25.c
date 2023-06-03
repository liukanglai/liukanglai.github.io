#include<stdio.h>
#include<stdlib.h>
#define Maxsize 100

typedef struct node{
    int data;
    struct node *next;
}node;

void sort(node *L){
    if(!(L->next)){
        printf("NULL!\n");
        return ;
    }
    //寻找中间结点, 双指针法
    node *p = L->next, *q = L->next;
    while(q->next){
        q = q->next;
        if(q->next){
            q = q->next;
            p = p->next;
        }
    }

    //将链表后半段逆置
    q = p->next;
    p->next = NULL;
    node *r;
    while(q){
        r = q->next;
        q->next = p->next;
        p->next = q;
        q=r;
    }

    q = p->next;
    r = p;  // record the front node of q;
    p = L->next;
    /* wrong, 
    while(q){
        r->next = q->next;
        q->next = p->next;
        p->next = q;
        p = q->next;
        q = r->next; // r->next will not NULL, because p->next = q...
    }
    */
    while(q){
        r = q->next;
        q->next = p->next;
        p->next = q;
        p = q->next;
        q = r; 
    }
}

int main(void)
{
    node *head = (node *)malloc(sizeof(node));
    int n;
    while(scanf("%d", &n) != EOF){
        node a[n];
        node *p = head;
        for(int i = 0; i < n; i++){
	          scanf("%d", &(a[i].data)); 
            p->next = &a[i];
            p = &a[i];
        }
        p->next = NULL;
        sort(head);
        for(int i = 0; i< n;i++){
	          printf("%d ",head->next->data);
	          head = head->next;
        }
    }
    return 0;
}
