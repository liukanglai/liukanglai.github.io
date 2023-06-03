#include<stdio.h>

typedef struct node{
    char data[10]; //存储操作数或操作符
    struct node *left , *right;
}BTree;

BTree *root;

void B_TtoExp(BTree *node) //the ()'s output
{
    if(root == NULL || root->left == NULL || root->right == NULL){
        printf("wrong!!!");
        return ; //空结点返回
    } 
    //wrong!!! look to 7.c
    if(node->left){
        if(node != root) printf("(");
        B_TtoExp(node->left);
    }
    printf("%s", node->data);
    if(node->right){
        B_TtoExp(node->right);
        if(node != root) printf(")");
    }
}

int main(void)
{

    return 0;
}



/*
void BtreeToE(BTree *root){
    BtreeToExp(root , l) ; //根的高度为 l
}
void BtreeToExp(BTree *root, int deep){
    if(root==NULL) return ; //空结点返回
    else if(root->left == NULL && root->right == NULL){ //若为叶子结点
        printf("%s", root->data); 
    } 
    else{
        if(deep>1) printf("("); //若有子表达式则力I] 1 层括号
        BtreeToExp(root->left, deep+1);
        printf("%s", root->data); //输出操作符
        BtreeToExp(root->right, deep+1);
        if(deep>1) printf(")"); //若有子表达式则加l l 层括号
    }
}
*/
