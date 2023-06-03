#include<stdio.h>
#define Maxsize 100

void Sort(int *a, int i, int j)
{
    int exchange = 1;
    for(int s = i; s < j && exchange; s++){
        for(int k = j - 1, exchange = 0; k > i; k--){
            if(a[k] < a[k-1]){
                int temp = a[k];
                a[k] = a[k-1];
                a[k-1] = temp;
                exchange = 1;
            }
        }
    }
}

int main(void)
{
    int n;
    while(scanf("%d", &n) != EOF){
        int a[Maxsize], b[Maxsize], A[Maxsize], B[Maxsize];
        for(int i = 0; i < n; i++){
            scanf("%d", &a[i]);
        }
        for(int i = 0; i < n; i++){
            scanf("%d", &b[i]);
        }
        int max = 0, flag = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(b[j] > max){
                    max = b[j];
                    flag = j;
                }
            }
            B[i] = b[flag];
            b[flag] = -1;
            A[i] = a[flag];
            max = 0;
            flag = 0;
        }
        for(int i = 1; i < n; i++){
            if(B[i] == B[i-1]){
                int j = i;
                while(j < n && B[j] == B[j-1]){
                    j++;
                }
                Sort(A, i, j);
                i = j;
            }
        }
        for(int i = 1; i < n; i++){
            printf("%d ", A[i]);
        }
    }

    return 0;
}
