#include<stdio.h>

int M_Search(int A[] , int B[ ], int L){
    int s1 = 0, d1 = L - 1, m1, s2 = 0 ,d2 = L - 1, m2; //分别表示序列 A 和 B 的首位数、末位数和中位数
    while(s1 != d1 || s2 != d2){
        m1 = (s1 + d1) / 2;
        m2 = (s2 + d2) / 2;
        if(A[m1] == B[m2]) return A[m1]; 
        if(A[m1] < B[m2]) { 
            if((s1 + d1) % 2 == 0) { //若元素个数为奇数
            s1 = m1; //舍弃 A 中间点以前的部分且保留中间点
            d2 = m2; //舍弃 B 中间点 以后的部分且保留中间点
            }
            else{ //元素个数为偶数
            s1 = m1 + 1; //舍弃 A 中间点及中间点以前部分
            d2 = m2 ; //舍弃 B 中间点 以后部分且保留中间点
            }
        }
        else{ 
            if((s2 + d2) % 2 == 0 ) { //若元素个数为奇数
                d1 = m1; //舍弃 A 中 间 点以后 的部分且保留中间点
                s2 = m2 ; //舍弃 B 中间点以前的部分且保留中间点
            }
            else{ //元素个数为偶数
                d1 = m1; //舍弃 A 中间点以后部分且保留中间点
                s2 = m2 + 1; //舍弃 B 中 间 点及中间点以前部分
            }
        }
    }
    return (A[s1] < B[s2]) ? A[s1] : B[s2];
}

int main(void)
{
    int L;
    scanf("%d", &L);
    int A[L], B[L];
    printf("%d",M_Search(A, B, L));
    return 0;
}
