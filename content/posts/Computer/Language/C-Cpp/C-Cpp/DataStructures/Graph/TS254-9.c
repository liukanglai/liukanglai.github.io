#include<stdio.h>
#define Maxsize 100

int Nnode;

typedef struct Arcnode{
    int adjVex;
    int weight;
    struct Arcnode *next;
}Arcnode;
Arcnode *AdjacencyList[Maxsize];

int root[Maxsize];
int Nroot;

int DFSnodevisited[Maxsize];
void DFSnodevisited0()
{
    for(int s = 0; s < Nnode; s++){
        DFSnodevisited[s] = 0;
    }
}
int father[Maxsize]; // 从father点查其子节点，如查到他自己，则有环, 因一节点有多个father，只要找到一个，即为环，故需数组
void DFSfathervisited0()
{
    for(int s = 0; s < Nnode; s++){
        father[s] = 0;
    }
}
int DFS(int node)
{
    if(DFSnodevisited[node]){
        return 0;
    }
    father[node] = 1;
    Arcnode *Tem = AdjacencyList[node]->next;
    while(Tem){
        if(father[Tem->adjVex]){
            return 1;
        }
        DFSnodevisited[node] = 1;
        if(DFS(Tem->adjVex)){
            return 1;
        }
        father[Tem->adjVex] = 0; // 当查找平行节点时，上一个father值需归0
        Tem = Tem->next;
    }
    printf("%d ", node);
    return 0;
}

int main(void)
{
    for(int i = 0; i < Nroot; i++){
        DFSnodevisited0();
        DFSfathervisited0();
        if(DFS(root[i])){
            printf("Have loop!\n");
            break;
        }
    };
    return 0;
}
