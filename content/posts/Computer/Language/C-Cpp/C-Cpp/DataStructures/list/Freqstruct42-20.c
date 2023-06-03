#include<stdio.h>
#include<stdlib.h>
#include <sys/select.h>

typedef struct node{
    int data;
    struct node *pred;
    struct node *next;
    int freq;
}node;

void Freq0(node *L)
{
    while(L->next != NULL){
        L->freq = 0;
        L = L->next;
    }
}

node* Locate(node *L, int x)
{
    node *a = (node *)malloc(sizeof(node));
    a = L;
    while(a != NULL && a->data != x){   // NULL!!!!!
        a = a->next;
    }
    if(a == NULL){
        printf("Can't find x");
        return a;
    }
    (a->freq)++;
    node *Tem = L;
    while(Tem != NULL && a->freq < Tem->freq){
        Tem = Tem->next;
    }
    a->pred->next = a->next;
    a->next = Tem;
    Tem->pred->next = a;

    // don't forget the pred!!
    a->pred = Tem->pred;
    Tem->pred = a;
    return a;
}

int main(void)
{
    int x;
    node *head;
    Freq0(head);
    Locate(head, x);
    return 0;
}
