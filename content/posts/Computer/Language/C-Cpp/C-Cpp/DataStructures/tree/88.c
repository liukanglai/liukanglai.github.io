#include<stdio.h>
#include<stdlib.h>
#define Maxsize 100

typedef struct node{
    char data; 
    int layer;
    int degree;
    struct node *child;
    struct node *brother;
}node;

node *root;
node Tnode[Maxsize];
int  degree[Maxsize];
char data[Maxsize];
int n; // the node sum

void BuildTree()
{
    root = &Tnode[0];
    for(int i = 0, j = 1; i < n; i++){
        if(degree[i]){
            Tnode[i].child = &Tnode[j];
            j++;
        } 
        else
            Tnode[i].child = NULL;
        int d = degree[i];
        if(d ==  1)
            Tnode[j-1].brother = NULL;
        while(d > 1){
            Tnode[j-1].brother = &Tnode[j];
            j++;
            d--;
        }
    }
}

void Inordertraversal(node *a)
{
    if(!n){
        printf("NULL!\n");
        return ;
    }
    if(a->child)
        Inordertraversal(a->child);
    printf("%c ", a->data);
    if(a->brother)
        Inordertraversal(a->brother);
   
}

int main(void)
{
    scanf("%d", &n);
  
    for(int i = 0; i < n; i++){
        scanf(" %c", &data[i]);
        //Tnode[i] = (node *)malloc(sizeof(node));
        Tnode[i].data = data[i];
    }
    for(int i = 0; i < n; i++){
        scanf("%d", &degree[i]);
        Tnode[i].degree = degree[i];
    }
    BuildTree();
    Inordertraversal(root);
    return 0;
}
