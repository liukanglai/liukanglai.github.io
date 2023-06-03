#include<stdio.h>
#include<stdlib.h>
#include<string.h>

int findMissMin(int A[ ], int n){
    int i, *B; //标记数组
    B = (int *)malloc(sizeof(int) * n); //分配空间
    memset(B, 0, sizeof(int) * n); //赋初值为 0
    for(i = 0; i < n; i++){
        if(A[i] > 0 && A[i] <= n){ //若 A[i]的值介于1 ~n ,则标记数组 B
            B[A[i] - 1] = 1;
        }
    }
    for(i = 0; i < n; i++){ //扫描数组 B , 找到目标值
        if(B[i] == 0) break;
    }
    return i + 1;
}


int main(void)
{
    int n;
    scanf("%d", &n);
    int A[n];

    findMissMin(A, n);
}

