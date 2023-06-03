#include<stdio.h>
#include<stdlib.h>
#include<ctype.h>
#define Maxsize 100

int n;
double Stack[Maxsize];
int Ls1 = 0, Ls2 = 0;

void s1push(double a)
{
    if((Ls1 + Ls2) == n){
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


void s2push(double a)
{
    if((Ls1 + Ls2) == n){
        printf("The Stack is full!\n");
        return ;
    }
    Stack[n - (Ls2++)] = a;
}

int s2pop()
{
    if(!Ls2){
        printf("The Stack is emputy!\n");
        return -1;
    }
    return Stack[n - (--Ls2) - 1];
}

int get(double *c, int *flag, char *C)
{
    char s[10]; // store the operants, which may be > 10...  and  will be a float... 
    int i = 0;

    if((s[0] = getchar()) == '#'){
        *C = s[0];
        *flag = 1;
        getchar(); // space...
        return 0;
    }
    else{
        while(isdigit(s[++i] = getchar()));    // collect integer part
        if(s[i] == '.'){    // collect fraction part
            while(isdigit(s[++i] = getchar()));
        }
        *c = atof(s);
        return 1;
    } 
}

int main(void)
{
    scanf("%d", &n);
    getchar(); // '\n'
    double c = 0, *cp = &c; // to store number
    char C = 0, *Cp = &C; // to record '#'
    int flag = 0, *flagp = &flag;
    for(int i = 0; i < n; i++){
        if(get(cp, flagp, Cp)){
            if(!flag){
                s1push(c);
            }
            else{
                Stack[i] = c;
                Ls2++;
            }
        }
        else{
            Stack[i] = -1;
        }
    }
    Ls2++;
    int a, b;
    while(scanf("%d", &a) != EOF){
        scanf("%d", &b);
        if(!a)
            s1push(b);
        else
            s2push(b);
    }
        for(int i = 0; i < n; i++){
            if(Stack[i] == -1){
                printf("# ");
            }
            else
                printf("%.0f ", Stack[i]);
        }
        printf("\n");
    return 0;
}
