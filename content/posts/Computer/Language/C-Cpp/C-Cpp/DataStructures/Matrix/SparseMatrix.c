#include <bits/pthreadtypes-arch.h>
#include<stdio.h>
#include<stdlib.h>
#define Maxsize 100

struct Trituple{
    int data;
    int row, col;
};

struct SparseMatrix{
    struct Trituple TritupleArray[Maxsize];
    int rows, cols;
    int numbers;
};

void PutSparseMatrix(struct SparseMatrix S)
{
    int index = 0; // 作为待输出三元组的下缀
    for(int i = 0; i <=6; i++){
        for(int j = 0; j <=7; j++){
            if(index < S.numbers && i == S.TritupleArray[index].row && j == S.TritupleArray[index].col)
                printf("%d ",S.TritupleArray[index].data);
            else
                printf("0 ");
        }
        printf("\b\n");
    }
    
}

struct SparseMatrix FaseTransposeSMatrix(struct SparseMatrix S)
{
    struct SparseMatrix Sm;
    int num[7], cpot[7]; // num为S中列的非0元个数，cpot为S中每一列第一个元素转置后在新三元组的位置。 cpot[i] = num[i-1] + cpot[i-1]
    for(int i = 0; i < S.numbers; i++){
        Sm.TritupleArray[cpot[S.TritupleArray[i].col]].row = S.TritupleArray[i].col;
        Sm.TritupleArray[cpot[S.TritupleArray[i].col]].col = S.TritupleArray[i].row;
        Sm.TritupleArray[cpot[S.TritupleArray[i].col]].data = S.TritupleArray[i].data;
        cpot[S.TritupleArray[i].col]++;
    }
    return Sm;
}


int main(void)
{
    int a[6][7];
    struct SparseMatrix S;
    struct SparseMatrix Sm;
    int k = 0;
    for(int i = 0; i <=6; i++){
        for(int j = 0; j <=7; j++){
            S.TritupleArray[k].col = j;
            S.TritupleArray[k].row = i;
            S.TritupleArray[k].data = a[i][j];
            k++;
        }
    }
    PutSparseMatrix(S);
    Sm = FaseTransposeSMatrix(S);

    return 0;
}
