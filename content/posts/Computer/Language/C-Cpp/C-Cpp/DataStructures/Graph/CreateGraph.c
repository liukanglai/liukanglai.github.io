#include<stdio.h>

// Create Graph

// 1. AdjacencyList 邻接表适用于稀疏图（边的数量远远小于顶点的数量）


typedef struct EdgeNode
{
    int toAdjVex;                               // The index of vertex array which this edge points to.
    float weight;                               // The edge weight.
    struct EdgeNode *next;                      // The next edge, note that it only means the next edge also links to the vertex which this edge links to.
}EdgeNode;

typedef struct VertexNode
{
    VERTEX_DATA_TYPE info;                      // The vertex info,.
    struct EdgeNode* firstEdge;                 // The first edge which the vertex points to.
}VertexNode;

typedef struct
{
    VertexNode adjList[VERTEX_NUM];             // Adjacency list, which stores the all vertexes of the graph.
    int vertextNum;                             // The number of vertex.
    int edgeNum;                                // The number of edge.
}AdjListGraph;

// 2. AdjacencyMatrix 邻接矩阵适用于稠密图（边的数量比较多），它的抽象描述如下： 上图是个无向无权图，仅用0、1来表示两个顶点是否相连，当然，通常做法是将边的权值来代替1，用一个十分大的数字（如∞）来代替0，表示不相连。

typedef struct 
{
    int number;
    VERTEX_DATA_TYPE info;
}Vertex;

typedef struct
{
    float edges[VERTEX_NUM][VERTEX_NUM];        // The value of this two dimensional array is the weight of the edge.
    int vertextNum;                             // The number of vertex.
    int edgeNum;                                // The number of edge.
    Vertex vex[VERTEX_NUM];                     // To store vertex.
}MGraph;

// 3. OrthogonalList

#define  MAX_VERTEX_NUM 20
#define  InfoType int  // 图中弧包含信息的数据类型
#define  VertexType int

typedef struct ArcBox{
    int tailvex,headvex; // 弧尾、弧头对应顶点在数组中的位置下标
    struct ArcBox *hlik,*tlink; // 分别指向弧头相同和弧尾相同的下一个弧
    InfoType *info; // 存储弧相关信息的指针
}ArcBox;

typedef struct VexNode{
    VertexType data;//顶点的数据域
    ArcBox *firstin,*firstout;//指向以该顶点为弧头和弧尾的链表首个结点
}VexNode;

typedef struct {
    VexNode xlist[MAX_VERTEX_NUM];//存储顶点的一维数组
    int vexnum,arcnum;//记录图的顶点数和弧数
}OLGraph;

int LocateVex(OLGraph * G,VertexType v){
    int i = 0;
    //遍历一维数组，找到变量v
    for (; i<G->vexnum; i++) {
        if (G->xlist[i].data==v) {
            break;
        }
    }
    //如果找不到，输出提示语句，返回 -1
    if (i > G->vexnum) {
        printf("no such vertex.\n");
        return -1;
    }
    return i;
}
//构建十字链表函数
void CreateDG(OLGraph *G){
    //输入有向图的顶点数和弧数
    scanf("%d,%d",&(G->vexnum),&(G->arcnum));
    //使用一维数组存储顶点数据，初始化指针域为NULL
    for (int i=0; i<G->vexnum; i++) {
        scanf("%d",&(G->xlist[i].data));
        G->xlist[i].firstin=NULL;
        G->xlist[i].firstout=NULL;
    }
    //构建十字链表
    for (int k=0;k<G->arcnum; k++) {
        int v1,v2;
        scanf("%d,%d",&v1,&v2);
        //确定v1、v2在数组中的位置下标
        int i=LocateVex(G, v1);
        int j=LocateVex(G, v2);
        //建立弧的结点
        ArcBox * p=(ArcBox*)malloc(sizeof(ArcBox));
        p->tailvex=i;
        p->headvex=j;
        //采用头插法插入新的p结点
        p->hlik=G->xlist[j].firstin;
        p->tlink=G->xlist[i].firstout;
        G->xlist[j].firstin=G->xlist[i].firstout=p;
    }
}

// 4. AdjacencyMulti-list

typedef enum {unvisited,visited}VisitIf;    //边标志域

typedef struct EBox{
    VisitIf mark;                           //标志域
    int ivex,jvex;                          //边两边顶点在数组中的位置下标
    struct EBox * ilink,*jlink;             //分别指向与ivex、jvex相关的下一个边
    InfoType *info;                         //边包含的其它的信息域的指针
}EBox;

typedef struct VexBox{
    VertexType data;                        //顶点数据域
    EBox * firstedge;                       //顶点相关的第一条边的指针域
}VexBox;

typedef struct {
    VexBox adjmulist[MAX_VERTEX_NUM];//存储图中顶点的数组
    int vexnum,degenum;//记录途中顶点个数和边个数的变量
}AMLGraph;


