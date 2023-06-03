#include<stdio.h>
#include<stdlib.h>
#include<ctype.h>
#define MAX 100
#define NUMBER '0'

int operant[MAX]; // record the result
int Loperant = 0;

int get(char * s){
    int i = 0;
    while((s[0] = getchar()) == ' ' || s[0] == '\t' || s[0] == '\n');
    if(!isdigit(s[0])){
        return s[0];
    }
    while((s[++i] = getchar()) != ' ');
    return NUMBER;
}
void push(int type)
{
    operant[Loperant++] = type;
}
int pop(void)
{
    if(Loperant){
        return operant[--Loperant];
    }
    else{
        printf("error: stack empty\n");
        return -1;
    }
}

int main()
{
    int type;
    int opop; // store pop, 
    char s[MAX];  // store the operant, which may be > 10...
    while ((type = get(s)) != '#'){
        switch(type){
            case NUMBER:
                push(atoi(s)); 
                break;
            case '+': 
                push(pop() + pop());
                break;
            case '-': 
                opop = pop(); 
                push(pop() - opop); // can't use pop() - pop()
                break;
            case '*': 
                push(pop() * pop()); 
                break;
            default:
                break;
        }
    }
    if(Loperant == 1){
        printf("%d\n", pop()); 
    }
    else printf("Expression wrong!\n"); 
    return 0;
}
