//X is the push,Y is the pop,judege whether the sequence is valid.  ps:XYXYXXYY

#include<stdio.h>


int main(void)
{
    int stack = 0; char c;
    while((c = gerchar()) != EOF){
        if(stack < 0){
            printf("Invalid!");
            exit(0);
        }
        if(c == "X") stack++;
        if(c == "Y") stack--;
        else{
            printf("The char is invalid");
            exit(0);
        }
    }
    printf("Valid");
    return 0;
}
