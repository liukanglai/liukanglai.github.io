#include<stdio.h>

#define Maxsize 100

int Stack[Maxsize];
int Ls1 = 0, Ls2 = 0;

void s1push(int a)
{
    if((Ls1 + Ls2) == 99){
        printf("The Stack is full!\n");
        return ;
    }
    Stack[Ls1++] = a;
}

int s1pop()
{
    if(!Ls1){
        printf("The Stack is emputy!\n");
        return -1;
    }
    return Stack[--Ls1];
}


void s2push(int a)
{
    if((Ls1 + Ls2) == 99){
        printf("The Stack is full!\n");
        return ;
    }
    Stack[Maxsize - (Ls2++)] = a;
}

int s2pop()
{
    if(!Ls2){
        printf("The Stack is emputy!\n");
        return -1;
    }
    return Stack[Maxsize - (--Ls2) - 1];
}

int main(void)
{
    return 0;
}

/*
int push(int i, elemtp x) {
//入操作 。 L 为核号 ,工= 0 表示左边的 sl 枝, i=l 表示右边的 s2 拢, x 是入校元素
//入成功返回 l ,否则返回 o
printf ( ”栈号输入不对 ”) ;
exit (0);
return O;
*/
