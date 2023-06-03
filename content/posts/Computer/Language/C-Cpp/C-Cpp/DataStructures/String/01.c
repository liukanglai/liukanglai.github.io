#include<stdio.h>
#include<string.h>


void Next(char*T,int *next){
    next[0] = -1;
    next[1] = 0;
    int i = 1, j = 0;
    if(T[i] == T[j])
        next[i] = next[j];
    while (i < (strlen(T) - 1)){
        if (j == -1 || T[i] == T[j]){
            i++;
            j++;
            if (T[i] != T[j]){
                next[i] = j;
            }
            else{
                next[i] = next[j];
            }
        }else{
            j = next[j];
        }
    }
}


int main(void)
{
    char T[6] = {'a', 'a', 'a', 'a', 'a', 'e'};
    int next[6];
    Next(T, next);
    
    for(int i = 0; i < 6; i++){
        printf("%d ", next[i]);
    }
    
    return 0;
}
