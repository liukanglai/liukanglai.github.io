#include<stdio.h>
#include<stdlib.h>
#define Maxsize 100

int Nnode = 7;

typedef struct Arcnode{
    int adjVex;
    int adN;
    int weight;
    struct Arcnode *next;
}Arcnode;
Arcnode AdjacencyList[7];

int i, j;
char I, J;
int path[Maxsize], Lpath = 0;
int Npath = 0;

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
    if(AdjacencyList[node].adjVex == J){
        for(int s = 0; s < Lpath; s++){
            printf("%c ", AdjacencyList[path[s]].adjVex);
        }
        printf("%c\n", J);
        Npath++;
        //return;
    } 
    DFSnodevisited[node] = 1;
    Arcnode *Tem = AdjacencyList[node].next;
    while(Tem){
        if(!DFSnodevisited[Tem->adN])
            FindPath(Tem->adN);
        //path[--Lpath] = -1;
        Tem = Tem->next;
    }
    DFSnodevisited[node] = 0;
}
int main(void)
{
    AdjacencyList[0].adjVex = 'a';
    AdjacencyList[1].adjVex = 'b';
    AdjacencyList[2].adjVex = 'c';
    AdjacencyList[3].adjVex = 'd';
    AdjacencyList[4].adjVex = 'e';
    AdjacencyList[5].adjVex = 'f';
    AdjacencyList[6].adjVex = 'g';

    Arcnode *node1 = (Arcnode *)malloc(sizeof(Arcnode));
    node1->adjVex = 'c';
    node1->adN = 2;
    node1->weight = 2;
    AdjacencyList[0].next = node1;
    Arcnode *node2 = (Arcnode *)malloc(sizeof(Arcnode));
    node2->adjVex = 'b';
    node2->adN = 1;
    node2->weight = 15;
    node1->next = node2;
    Arcnode *node3 = (Arcnode *)malloc(sizeof(Arcnode));
    node3->adjVex = 'd';
    node3->adN = 3;
    node3->weight = 12;
    node2->next = node3;
    node3->next = NULL;

    Arcnode *node4 = (Arcnode *)malloc(sizeof(Arcnode));
    node4->adjVex = 'e';
    node4->adN = 4;
    node4->weight = 6;
    AdjacencyList[1].next = node4;
    node4->next = NULL;

    Arcnode *node5 = (Arcnode *)malloc(sizeof(Arcnode));
    node5->adjVex = 'e';
    node5->adN = 4;
    node5->weight = 8;
    AdjacencyList[2].next = node5;
    Arcnode *node6 = (Arcnode *)malloc(sizeof(Arcnode));
    node6->adjVex = 'f';
    node6->adN = 5;
    node6->weight = 4;
    node5->next = node6;
    node6->next = NULL;

    Arcnode *node7 = (Arcnode *)malloc(sizeof(Arcnode));
    node7->adjVex = 'g';
    node7->adN = 6;
    node7->weight = 3;
    AdjacencyList[3].next = node7;
    node7->next = NULL;

    Arcnode *node8 = (Arcnode *)malloc(sizeof(Arcnode));
    node8->adjVex = 'g';
    node8->adN = 6;
    node8->weight = 9;
    AdjacencyList[4].next = node8;
    node8->next = NULL;

    Arcnode *node9 = (Arcnode *)malloc(sizeof(Arcnode));
    node9->adjVex = 'd';
    node9->adN = 3;
    node9->weight = 5;
    AdjacencyList[5].next = node9;
    Arcnode *node10 = (Arcnode *)malloc(sizeof(Arcnode));
    node10->adjVex = 'g';
    node10->adN = 6;
    node10->weight = 10;
    node9->next = node10;
    node10->next = NULL;

    Arcnode *node11 = (Arcnode *)malloc(sizeof(Arcnode));
    node11->adjVex = 'b';
    node11->adN = 1;
    node11->weight = 4;
    AdjacencyList[6].next = node11;
    node11->next = NULL;

    while(scanf("%c %c", &I, &J) != EOF){
        for(int k = 0; k < Nnode; k++){
            if(AdjacencyList[k].adjVex == I){
                i = k;
                break;
            }
        }
        FindPath(i);
        printf("%d\n", Npath);
        /*
        else
            for(int i = 0; i < Lpath; i++)
                printf("%c ", path[i]);
        */
        Lpath = 0;
    }
    return 0;
}
   
