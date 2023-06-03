#include<stdio.h>
#include<stdlib.h>
#define Maxsize 100

int Nnode;

typedef struct Arcnode{
    int adjVex;
    int weight;
    struct Arcnode *next;
}Arcnode;
Arcnode AdjacencyList[7];

int i, j;

int DFSnodevisited[Maxsize];
void DFSnodevisited0()
{
    for(int s = 0; s < Nnode; s++){
        DFSnodevisited[s] = 0;
    }
}
int DFS(int node)
{
    if(DFSnodevisited[node]){
        return 0;
    }
    if(node == j) return 1; // ............... if i = j!!
    Arcnode *Tem = AdjacencyList[node].next;
    while(Tem){
        if(Tem->adjVex == j) return 1; // more fast, if find j, no need to recursion 
        DFSnodevisited[node] = 1;
        if(DFS(Tem->adjVex)){
            return 1;
        }
        Tem = Tem->next;
    }
    return 0;
}
/*
int BFSnodevisited[Maxsize];
void BFSnodevisited0()
{
    for(int s = 0; s < Nnode; s++){
        BFSnodevisited[s] = 0;
    }
}
int BFSqueue[Maxsize];
int start = 0, end = 0;
void enBFSqueue(int node)
{
    BFSqueue[end++] = node;
}
int outBFSqueue()
{
    return BFSqueue[start++];
}
int BFS(int node)
{
    enBFSqueue(node);
    while(start < end){
        int k = outBFSqueue();
        if(AdjacencyList[k].adjVex == j){
            return 1;
        }
        BFSnodevisited[k] = 1;
        Arcnode *Tem = &AdjacencyList[k];
        while(Tem->next){
            if(Tem->next->adjVex == j) return 1; // can judge without this, but use it more efficiently.
            if(BFSnodevisited[Tem->next->adjVex]) enBFSqueue(Tem->next->adjVex);
            Tem = Tem->next;
        }
    }
    return 0;
}
*/

int main(void)
{
    Nnode = 6;

    Arcnode *node1 = (Arcnode *)malloc(sizeof(Arcnode));
    node1->adjVex = 2;
    AdjacencyList[1].next = node1;
    Arcnode *node2 = (Arcnode *)malloc(sizeof(Arcnode));
    node2->adjVex = 4;
    node1->next = node2;
    node2->next = NULL;

    Arcnode *node3 = (Arcnode *)malloc(sizeof(Arcnode));
    node3->adjVex = 5;
    AdjacencyList[2].next = node3;
    node3->next = NULL;

    Arcnode *node4 = (Arcnode *)malloc(sizeof(Arcnode));
    node4->adjVex = 6;
    AdjacencyList[3].next = node4;
    Arcnode *node5 = (Arcnode *)malloc(sizeof(Arcnode));
    node5->adjVex = 5;
    node4->next = node5;
    node5->next = NULL;

    Arcnode *node6 = (Arcnode *)malloc(sizeof(Arcnode));
    node6->adjVex = 2;
    AdjacencyList[4].next = node6;
    node6->next = NULL;

    Arcnode *node7 = (Arcnode *)malloc(sizeof(Arcnode));
    node7->adjVex = 4;
    AdjacencyList[5].next = node7;
    node7->next = NULL;

    Arcnode *node8 = (Arcnode *)malloc(sizeof(Arcnode));
    node8->adjVex = 6;
    AdjacencyList[6].next = node8;
    node8->next = NULL;

    while(scanf("%d %d", &i, &j) != EOF){
        DFSnodevisited0();
        if(DFS(i)){
            printf("1\n");
        }
        else{
            printf("0\n");
        }
    }
        /*
    DFSnodevisited0();
    if(BFS(i)){
        printf("Yes\n");
    }
    else{
        printf("NO\n");
    }
    */
    return 0;
}
