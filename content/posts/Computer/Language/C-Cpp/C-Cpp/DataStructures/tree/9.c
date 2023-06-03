#include<stdio.h>
#include<stdlib.h>
#include<string.h>

int n, c;
int C[100], l = 0; // put huffman code.
typedef struct node{
    int data;
    int weight;
    struct node *father;
    struct node *left;
    struct node *right;
}node;

void select2(int *a, char *A, int Flag) //select already has.
{
    int flag1 = 0, flag2 =0;//record the min,then let it be 10000
    int min1 = 10000,min2 = 10000;
    for(int i = 0; i < n; i++){
        if(a[i] < min1){ // can't use a[i] <= min,because the printf in turn...
            min1 =a[i]; 
            flag1 = i;
        }
    }
    if(A[flag1] == c){
        Flag = flag1;
    }
    a[flag1] = 10000;
    for(int i = 0;i < n;i++){
        if((a[i] < min2) && a[i] >= min1){
            min2 = a[i];
            flag2 = i;
        }
    }
    if(A[flag2] == c){
        Flag = flag2;
    }
    a[flag2] = 10000;
    if(Flag >= 0){
        if(Flag == flag2){
            if(min1 > min2){
                C[l++] = 0;
            }
            else{
                C[l++] = 1;
            }
            a[flag2] = min1 + min2;
            Flag = -1;
        }
        else{
            if(min1 > min2){
                C[l++] = 1;
            }
            else{
                C[l++] = 0;
            }
            a[flag1] = min1 + min2;
            Flag = -1;
        }
    }
    else
        a[flag2] = min1 + min2;
}

int main(void)
{
    n = 6;
    char A[7] = {'A','B','C','D','E','F'};
    int a[6] = {10, 35, 40, 50, 60, 200};
    scanf("%c", &c);
    //for(int i = 0;i < n;i++){
     //   scanf("%d", a+i);
    //}
    for(int j = 0;j < n;j++){
        C[j] = 0;
    }
    int Flag = -1; // judge if find c..
    for(int j = 0;j < n;j++){
        select2(a, A, Flag);
    }
    for(int i = l-2; i >= 0 ; i--){
        printf("%d ", C[i]);
    }
    return 0;
}
