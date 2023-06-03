#include<stdio.h>
#include<string.h>


void Next(char*T,int *next){
    next[1]=0;
    next[2]=1;
    int i=2;
    int j=1;
    //if(T[i-1]==T[j-1]){
     //   next[2] = next[1];
    //}
    while (i<strlen(T)) {
        if (j==0||T[i-1]==T[j-1]) {
            i++;
            j++;
            //if (T[i-1]!=T[j-1]) {
               next[i]=j;
            //}
            //else{
            //    next[i]=next[j];
            //}
        }else{
            j=next[j];
        }
    }
}

int main(void)
{
    char T[6] = {'a', 'a', 'b', 'a', 'a', 'c'};
    int next[7];
    Next(T, next);
    
    for(int i = 0; i < 7; i++){
        printf("%d ", next[i]);
    }
    
    return 0;
}

