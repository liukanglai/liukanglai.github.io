#include<stdio.h>
#include<stdlib.h>

// define a tree
typedef struct Tnode
{
    struct Tnode *lnode;
    struct Tnode *rnode;
    char value;
}Tnode;

Tnode* root=NULL;
char ch;
int n_input = 0;

// build a binarytree
void creatTree(Tnode **p)  // here is **p for changing the p, if it is *p, it will change the *p only, can't change the p!!!
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
    *p = (Tnode*)malloc(sizeof(Tnode));
    (*p)->value = ch;
    creatTree(&((*p)->lnode));
    creatTree(&((*p)->rnode));
    return ;
}

// define a queue, it's a node in it, 

Tnode* queue[100];
int Startqueue = 0;
int Stopqueue = 0;

void inqueue(Tnode* a)
{
    queue[Startqueue++] = a;
}

Tnode* outqueue()
{
    return queue[Stopqueue++];
}

void displayTree(Tnode** p)  // put the tree in layer order simply, inqueue father, outqueue son.
{
    if(*p == NULL) return ;

    inqueue(*p);
    while(Stopqueue != Startqueue){
        Tnode *node = outqueue();
        if(node->lnode != NULL) inqueue(node->lnode);
        if(node->rnode != NULL) inqueue(node->rnode);
        putchar(node->value);
        putchar(' ');
    }
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

   creatTree(&root);
   displayTree(&root);
   destroyTree(&root);
   getchar(); // enter???
   return 0;
}

/*
char c; // 用于暂时储存读入的自字符
    int isEmpty = 0; // 用于记录是否要创建子节点，/就不新建了，是数字的话才新建节点
    int hasNum = 0; // 用于记录读入的是否为所需要的数据
    while ((c = getchar()) != EOF && !((c == ' ' || c == '\n') && hasNum)) // 当读入的字符为空格或者换行符 以及 读入的字符里有数字或者/的时候挑出循环
    {
        if (c == '/')
        {
            isEmpty = 1; // 读入的是/，所以不需要新建节点
            hasNum = 1; // 读入了所想要的字符
        } else if (c >= '0' && c <= '9') { // 如果是数字
            data = data * 10 + c - '0'; // 塞入数据
            hasNum = 1; // 读入了所想要的字符
        }
    }
*/
