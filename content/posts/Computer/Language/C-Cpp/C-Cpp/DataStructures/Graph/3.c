#include<stdio.h>
#include<stdlib.h>
#define Maxsize 100

int Nnode = 9;

typedef struct Arcnode{
    int adN;
    int weight;
    struct Arcnode *next;
}Arcnode;
Arcnode AdjacencyList[9];

int i, j;
int path[Maxsize], Lpath = 0;
int flag = 0;

int DFSnodevisited[Maxsize];
void DFSnodevisited0()
{
    for(int s = 0; s < Nnode; s++){
        DFSnodevisited[s] = 0;
    }
}
void path0()
{
    for(int s = 0; s < Nnode; s++){
        path[s] = -1;
    }
}

void FindPath(int node)
{
    path[Lpath++] = node;
    if(i == j){
        //printf("%d\n", i);
        flag = 1;
        return;
    } 
    Arcnode *Tem = AdjacencyList[node].next;
    while(Tem){
        if(Tem->adN == j){
            /*
            for(int s = 0; s < Lpath; s++){
                printf("%d ", path[s]);
            }
            printf("%d", j);
            */
            flag = 1;
            DFSnodevisited[node] = 0;
            return;
        }
        DFSnodevisited[node] = 1;
        FindPath(Tem->adN);
        path[--Lpath] = -1;
        Tem = Tem->next;
    }
    DFSnodevisited[node] = 0;
}
int main(void)
{
    AdjacencyList[0].adN = 0;
    AdjacencyList[1].adN = 1;
    AdjacencyList[2].adN = 2;
    AdjacencyList[3].adN = 3;
    AdjacencyList[4].adN = 4;
    AdjacencyList[5].adN = 5;
    AdjacencyList[6].adN = 6;
    AdjacencyList[7].adN = 7;
    AdjacencyList[8].adN = 8;
  
    Arcnode *node1 = (Arcnode *)malloc(sizeof(Arcnode));
    node1->adN = 1;
    node1->weight = 2;
    AdjacencyList[0].next = node1;
    Arcnode *node2 = (Arcnode *)malloc(sizeof(Arcnode));
    node2->adN = 2;
    node2->weight = 15;
    node1->next = node2;
    Arcnode *node3 = (Arcnode *)malloc(sizeof(Arcnode));
    node3->adN = 4;
    node3->weight = 12;
    node2->next = node3;
    node3->next = NULL;

    Arcnode *node4 = (Arcnode *)malloc(sizeof(Arcnode));
    node4->adN = 2;
    node4->weight = 6;
    AdjacencyList[1].next = node4;
    Arcnode *node12 = (Arcnode *)malloc(sizeof(Arcnode));
    node12->adN = 3;
    node4->weight = 6;
    node4->next = node12;
    node12->next = NULL;

    Arcnode *node5 = (Arcnode *)malloc(sizeof(Arcnode));
    node5->adN = 4;
    node5->weight = 8;
    AdjacencyList[2].next = node5;
    Arcnode *node6 = (Arcnode *)malloc(sizeof(Arcnode));
    node6->adN = 5;
    node6->weight = 4;
    node5->next = node6;
    node6->next = NULL;

    Arcnode *node7 = (Arcnode *)malloc(sizeof(Arcnode));
    node7->adN = 5;
    node7->weight = 3;
    AdjacencyList[3].next = node7;
    node7->next = NULL;

    Arcnode *node8 = (Arcnode *)malloc(sizeof(Arcnode));
    node8->adN = 6;
    node8->weight = 9;
    AdjacencyList[4].next = node8;
    node8->next = NULL;

    Arcnode *node9 = (Arcnode *)malloc(sizeof(Arcnode));
    node9->adN = 6;
    node9->weight = 5;
    AdjacencyList[5].next = node9;
    Arcnode *node10 = (Arcnode *)malloc(sizeof(Arcnode));
    node10->adN = 7;
    node10->weight = 10;
    node9->next = node10;
    node10->next = NULL;

    Arcnode *node11 = (Arcnode *)malloc(sizeof(Arcnode));
    node11->adN = 8;
    node11->weight = 4;
    AdjacencyList[6].next = node11;
    node11->next = NULL;
    Arcnode *node13 = (Arcnode *)malloc(sizeof(Arcnode));
    node13->adN = 8;
    node13->weight = 4;
    AdjacencyList[7].next = node13;
    node13->next = NULL;

    AdjacencyList[8].next = NULL;

    while(scanf("%d %d", &i, &j) != EOF){
        FindPath(i);
        if(flag)
            printf("T\n");
        else
            printf("F\n");
        /*
        else
            for(int i = 0; i < Lpath; i++)
                printf("%c ", path[i]);
                */
        Lpath = 0;
        flag = 0;
    }
    return 0;
}
