#include<stdio.h>
#include<string.h>
#define Maxsize 100

int S[Maxsize], P[Maxsize], next[Maxsize];
int lp = 0, ls = 0;

void Next(char*T){
    next[0] = -1;
    next[1] = 0;
    int i = 1, j = 0;
    if(T[i] == T[j])
        next[i] = next[j]; // 优化
    while (i < (strlen(T) - 1)){
        if (j == -1 || T[i] == T[j]){
            i++;
            j++;
            if (T[i] != T[j]){
                next[i] = j;
            }
            else{
                next[i] = next[j]; //
            }
        }else{
            j = next[j];
        }
    }
}



/*
void Next(char*T,int *next){
    next[1]=0;
    next[2]=1;
    int i=2;
    int j=1;
    while (i<strlen(T)) {
        if (j==0||T[i-1]==T[j-1]) {
            i++;
            j++;
            if (T[i-1]!=T[j-1]) {
               next[i]=j;
            }
            else{
                next[i]=next[j];
            }
        }else{
            j=next[j];
        }
    }
}

int KMP(char * S,char * T){
    int next[10];
    Next(T,next);//根据模式串T,初始化next数组
    int i=1;
    int j=1;
    while (i<=strlen(S)&&j<=strlen(T)) {
        //j==0:代表模式串的第一个字符就和当前测试的字符不相等；S[i-1]==T[j-1],如果对应位置字符相等，两种情况下，指向当前测试的两个指针下标i和j都向后移
        if (j==0 || S[i-1]==T[j-1]) {
            i++;
            j++;
        }
        else{
            j=next[j];//如果测试的两个字符不相等，i不动，j变为当前测试字符串的next值
        }
    }
    if (j>strlen(T)) {//如果条件为真，说明匹配成功
        return i-(int)strlen(T);
    }
    return -1;
}
*/
void KMP()
{
    int i = 0, j = 0;
    for(; i < ls; i++){
        while(S[i] != P[j]){
            if(j == -1){
                break;
            }
            j = next[j];
        }
        j++;
        if(j == lp){
            printf("Find P in S!\n");
            return ;
        }
    }
    printf("Can't find P in S!\n");
}

int main(void)
{
    KMP();
    return 0;
}

/* the function to find next by me, it's so complicated...
void Findnext()
{
    int i = 0, flag = 1, next1 = 0;

    while(i < lp){
        for(int j = 0; j < i-1; j++){
            for(int k = 0; k <= j; k++){
                if(P[k] != P[i-j+k-1]){
                    flag = 0;
                    break;
                }
            }
            if(flag) next1 = j+1;
            flag = 1;
        }
        next[i] = next1;
        if(!i) next[i] = -1;
        i++;
    }
}
*/

