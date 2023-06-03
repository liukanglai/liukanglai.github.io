#include<stdio.h>
#define Maxsize 100

typedef struct node{
    char data; 
    int layer;
    int degree;
    struct node *child;
    struct node *brother;
}node;

node *root;
node *Tnode[Maxsize];
int layer[Maxsize], degree[Maxsize]; // if two node have the same layer, you can't sort them...
int n; // the node sum

void sort() // sort the layer, and the degree is fit to the node in layer.
{
}

void BuildTree(node *root)
{
    root = Tnode[0];
    for(int i = 0, j = 1; i < n; i++){
        if(degree[i]) Tnode[i]->child = Tnode[j];
        int Tlayer = layer[j];
        while(layer[j] == Tlayer){
            Tnode[j]->brother = Tnode[j+1];
            j++;
        }
    }
}

int main(void)
{
    root->layer = layer[1];
    root->degree = degree[1];
    BuildTree(root);
    return 0;
}
