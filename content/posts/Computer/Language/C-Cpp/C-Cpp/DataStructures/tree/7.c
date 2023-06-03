#include<stdio.h>
#include<stdlib.h>

typedef struct node{
    char data; //存储操作数或操作符
    struct node *left , *right;
}BTree;

char ch;
int n_input = 0;

// build a binarytree
void creatTree(BTree **p)  // here is **p for changing the p, if it is *p, it will change the *p only, can't change the p!!!
{ 
    ch = getchar(); // there you can't judge whether the recursion should end, how to solve......
    n_input++;
    if(n_input > 100)
    {
        printf("Input is too long(>100)!");
        exit(0);
    }
    if(ch =='#'){
        *p = NULL;
        return ;
    }
    *p = (BTree*)malloc(sizeof(BTree));
    (*p)->data = ch;
    creatTree(&((*p)->left));
    creatTree(&((*p)->right));
    return ;
}

void B_TtoExp(BTree *node, BTree *root) //the ()'s output
{
    if(root == NULL || root->left == NULL || root->right == NULL){
        printf("wrong!!!");
        return ; //空结点返回
    } 
    if(node->left||node->right)
    if(node != root) printf("(");
    if(node->left){
        B_TtoExp(node->left, root);
    }
    printf("%c", node->data);
    if(node->right){
        B_TtoExp(node->right, root);
    }
    if(node->left||node->right)
    if(node != root) printf("(");
}

int main(void)
{
    BTree *root; 
    creatTree(&root);
    B_TtoExp(root, root);

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
