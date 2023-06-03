#include<stdio.h>
#include<string.h>
#define Maxsize 100

int S[Maxsize], next[Maxsize];
char P[Maxsize];
int lp = 0, ls = 0;

void Next(){
    next[1]=0;
    next[2]=1;
    int i=2;
    int j=1;
    while (i<strlen(P)) {
        if (j==0||P[i-1]==P[j-1]) {
            i++;
            j++;
            //if (P[i-1]!=P[j-1]) {
               next[i]=j;
            //}
            //else{
             //   next[i]=next[j];
            //}
        }else{
            j=next[j];
        }
    }
}

int main(void)
{
    while(scanf("%d", &lp)!=EOF){
	  for(int i = 0; i<lp;i++){
		    scanf(" %c",&P[i]);
	  }
	  P[lp] = '\0';
	  Next();
	  for(int i = 0; i<lp;i++){
		    printf("%d ",next[i]);
	  }
	}
    return 0;
}
