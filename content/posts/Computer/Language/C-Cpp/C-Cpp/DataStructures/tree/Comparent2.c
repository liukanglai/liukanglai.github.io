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

int Temcode[MaxSize];

void HuffmanCoding(Tnode **p, int *Temcode, int L_T)
{
    // use the recursion
    if(*p == root){
        Temcode[L_T++] = 2;
    }
    //memcpy((*p)->HuffmanCode, Temcode, L_T*sizeof(int));
    for(int i = 0; i <= L_T; i++){
        (*p)->HuffmanCode[i] = Temcode[i];
    }
    if((*p)->lnode != NULL){
        Temcode[L_T++] = 1; 
        HuffmanCoding(&((*p)->lnode), Temcode, L_T);
        Temcode[L_T--] = -1; 
    }
    if((*p)->rnode != NULL){
        Temcode[L_T++] = 0; 
        HuffmanCoding(&((*p)->rnode), Temcode, L_T);
        Temcode[L_T--] = -1; 
    }
}

int node1, node2;
Tnode *T1, *T2;

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

int flag = 0;

void Find2node(Tnode **p, Tnode **T1, Tnode **T2)
{
    if((*p)->value == node1){
        *T1 = *p;
        flag++;
    }
    if((*p)->value == node2){
        *T2 = *p;
        flag++;
    }
    if(flag==2){
        return;
    }
    if((*p)->lnode != NULL){
        Find2node((&(*p)->lnode), T1, T2);
    }
    if((*p)->rnode != NULL){
        Find2node((&(*p)->rnode), T1, T2);
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
        if((T1->HuffmanCode)[j] == 1){
            p = p->lnode;
        }
        else{
            p = p->rnode;
        }
    }
    printf("%c\n", p->value);
}

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
    getchar(); // enter
    for(int i = 0; i <= MaxSize; i++){
        Temcode[i] = -1;
    }
    HuffmanCoding(&root, Temcode, L_T);
    do{
        printf("Input two node(end with EOF(linux:ctr-d, win:ctr-z)):");
        input2node(&T1, &T2);
        Find2node(&root, &T1, &T2);
        Findfather();
        flag = 0;  // big bug!!!!!!
    }while(getchar() != EOF);
    destroyTree(&root);
    free(T1); free(T2);
    return 0;
}
