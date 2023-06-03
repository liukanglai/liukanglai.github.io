// calculate the value of the prefix expression
// such as: + + 2 * 3 - 7 4 / 8 4
// print: 13.0

#include<stdio.h>
#include<stdlib.h> // atoi
#include<ctype.h> // isdigit

float expression[40];  
char operator[40]; // char put in float will have problem, use it 
int Lexpression = 0;

int get()
{
    char s[10]; // store the operants, which may be > 10...  and  will be a float... 
    int i = 0;
    int c;

    // if input a operator, just store it in expression.
    if(!isdigit(s[0] = getchar())){
        operator[Lexpression++] = s[0];
        if(getchar() != ' '){    // end record space
            printf("ERROR");  
            exit(0);
        } 
    }
    else{
        while(isdigit(s[++i] = getchar()));    // collect integer part
        if(s[i] == '.'){    // collect fraction part
            while(isdigit(s[++i] = getchar()));
        }
        expression[Lexpression++] = atof(s);
    if(s[i] != ' ')  return 1; //end
    } 
    get(); // put again
}

float stack[40];
int Lstack = 0;

void push(float a)
{
    stack[Lstack++] = a;
}

float pop()
{
    return stack[--Lstack];
}

int main(void)
{
    for(int i = 0; i < 40; i++){
        operator[i] = 0;
    } // expression not need, because switch need use operator
    get();

    float opop = 0; // record pop
    for(int i = Lexpression - 1; i >= 0; i--){
        switch(operator[i]){   // can't judge float...
            case 0: 
                push(expression[i]);
                break;
            case '+':
                push(pop() + pop());
                break;
            case '-':
                opop = pop();
                push(opop - pop());
                break;
            case '*':
                push(pop() * pop());
                break;
            case '/':
                opop = pop();
                push(opop / pop());
                break;
        }
    }

    printf("%.1f\n",stack[0]);

    return 0;
}
