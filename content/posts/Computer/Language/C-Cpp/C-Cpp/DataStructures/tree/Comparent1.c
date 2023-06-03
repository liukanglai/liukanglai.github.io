#include<stdio.h>
#include<stdlib.h>
#include<string.h>

#define MaxSize 100

// define a tree
typedef struct Tnode
{
    struct Tnode *lnode;
    struct Tnode *rnode;
    char value;
    int HuffmanCode[MaxSize];
}Tnode;

Tnode *root=NULL;
char ch;
int n_input = 0; // input <= 100.

// build a binarytree
void creatTree(Tnode **p)  // here is **p for changing the p, if it is *p, it will change the *p only, can't change the p!!!
{ 
    ch = getchar(); // there you can't judge whether the recursion should end, how to solve......
    n_input++;
    if(n_input > MaxSize)
    {
        printf("Input is too long(>100)!");
        exit(0);
    }
    if(ch =='#'){
        *p = NULL;
        return ;
    }
    *p = (Tnode*)malloc(sizeof(Tnode));
    (*p)->value = ch;
    creatTree(&((*p)->lnode));
    creatTree(&((*p)->rnode));
    return ;
}

int node1, node2;
Tnode *T1 = NULL, *T2 = NULL;
int Temcode[MaxSize];
//int L_T = 0;

void input2node(Tnode **T1, Tnode **T2)
{
    *T1 = (Tnode*)malloc(sizeof(Tnode));
    *T2 = (Tnode*)malloc(sizeof(Tnode));
    node1 = getchar();
    getchar();
    node2 = getchar();
    (*T1)->value = node1;
    (*T2)->value = node2;
}

void HuffmanCoding(Tnode **p, int *Temcode, int L_T)
{
    // use the recursion
    if(*p == root){
        Temcode[L_T++] = 2;
    }
    if((*p)->value == T1->value) // in there, (*p)->value become wrong, and T2 too
    {
        T1 = *p;
    }
    if((*p)->value == T2->value)
    {
        T2 = *p;
    }
    //memcpy((*p)->HuffmanCode, Temcode, L_T*sizeof(int));
    for(int i = 0; i <= L_T; i++){  // 1. i < L_T wrong!!!
        (*p)->HuffmanCode[i] = Temcode[i];
    }
    if((*p)->lnode != NULL){    // 4. when it is NULL!!!!!!!!!!!!!!!!!!!!!!!
        Temcode[L_T++] = 1; 
        HuffmanCoding(&((*p)->lnode), Temcode, L_T);
        Temcode[L_T--] = -1;   // 2 & 3. only L_T--, no call it -1; the two should same!!!
    }
    if((*p)->rnode != NULL){
        Temcode[L_T++] = 0; 
        HuffmanCoding(&((*p)->rnode), Temcode, L_T);
        Temcode[L_T--] = -1;
    }
}

void Findfather()
{
    int i = 0;
    while((T1->HuffmanCode)[i] == (T2->HuffmanCode)[i] && (T1->HuffmanCode)[i] >=0 && (T2->HuffmanCode)[i] >=0){
        i++;
    }
    if((T1->HuffmanCode)[i] < 0){
        printf("%c", T1->value);
        return ;
    }
    if((T2->HuffmanCode)[i] < 0){
        printf("%c", T2->value);
        return ;
    }
    Tnode *p = root;
    for(int j = 1; j < i; j++){
        if((T1->HuffmanCode)[j] == 1){ // 5. at first i write i, not j
            p = p->lnode;
        }
        else{
            p = p->rnode;
        }
    }
    printf("%c", p->value);
}

//
void destroyTree(Tnode** p)
{
    if((*p) == NULL) return;
    destroyTree(&((*p)->lnode));
    destroyTree(&((*p)->rnode));
    free(*p);
}

int main(){
    int L_T = 0;
    printf("Input a BinaryTree with prefix(use '#'):");
    creatTree(&root);
    getchar(); // enter???
    printf("Input two node:");
    input2node(&T1, &T2);
    for(int i = 0; i <= MaxSize; i++)
    {
        Temcode[i] = -1;
    }
    HuffmanCoding(&root, Temcode, L_T);
    Findfather();
    destroyTree(&root);
    return 0;
}
