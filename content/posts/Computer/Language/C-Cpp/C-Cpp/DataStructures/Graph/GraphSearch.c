#include<stdio.h>


// Search

// 1. DFS深度优先搜索（depth-first search）

// adjlist

// recursion
void dfsRecursion(AdjListGraph* graph, int startVertexIndex, bool visit[])
{
    printf("%c ", (graph -> adjList[startVertexIndex]).info);
    visit[startVertexIndex] = true;
    EdgeNode* edgeIndex = (graph -> adjList[startVertexIndex]).firstEdge;
    while (edgeIndex != NULL)
    {
        if (visit[edgeIndex -> toAdjVex] == false)
            dfsRecursion(graph, edgeIndex -> toAdjVex, visit);
        edgeIndex = edgeIndex -> next;
    }
}

// stack
void dfsNonRecursion(AdjListGraph* graph, int startVertextIndex, bool visit[])
{
    linked_stack* stack = NULL;
    init_stack(&stack);

    // Visit the start vertex.
    printf("%c ", (graph -> adjList[startVertextIndex]).info);
    visit[startVertextIndex] = true;
    EdgeNode* edgeNode = (graph -> adjList[startVertextIndex]).firstEdge;
    if (edgeNode != NULL)
        push(stack, edgeNode);
    while (!isEmptyStack(stack))
    {
        edgeNode = ((EdgeNode*)pop(stack)) -> next;
        while (edgeNode != NULL && !visit[edgeNode -> toAdjVex])
        {
            printf("%c ", (graph -> adjList[edgeNode -> toAdjVex]).info);
            visit[edgeNode -> toAdjVex] = true;
            push(stack, edgeNode);
            edgeNode = (graph -> adjList[edgeNode -> toAdjVex]).firstEdge;
        }
    }
}


// 邻接矩阵


// 邻接矩阵结构（无向图）
typedef struct {
    VertexType vexs[MAXVEX]; // 顶点表
    EdgeType arc[MAXVEX][MAXVEX]; // 边表
    int numNodes, numEdges; // 图的顶点数、边数
} MGraph;

// 访问标志的数组
int visited[MAXVEX];

void DFS(MGraph G, int i) {
    int j; // 用于遍历元素

    visited[i] = TRUE; // 记录该下标的元素已被访问

    printf("%c ", G.vexs[i]); // 打印该位置的顶点值

    // 遍历图中的顶点
    for (j = 0; j < G.numNodes; j++) {
        // 顶点i到顶点j有边相连，并且顶点j未被访问过
        if (G.arc[i][j] == 1 && !visited[j]) {
            DFS(G, j); // 对顶点j进行访问
        }
    }
}

void DFSTraverse(MGraph G) {
    int i; // 用于遍历元素

    // 初始化设置所有顶点都没被访问过
    for (i = 0; i < G.numNodes; i++) {
        visited[i] = FALSE;
    }

    // 遍历顶点i
    for (i = 0; i < G.numNodes; i++) {
        // 如果顶点i未被访问过
        if (!visited[i]) {
            DFS(G, i); // 访问顶点i
        }
    }
}



// 2. BFS

void BFS(AdjListGraph* graph, int startVertexIndex, bool visit[])
{
    // Loop queue initialization.
    LoopQueue loopQ;
    loopQ.front = 0;
    loopQ.rear = 0;
    LoopQueue* loopQueue = &loopQ;
    enqueue(loopQueue, &(graph -> adjList[startVertexIndex]));
    printf("%c ", (graph -> adjList[startVertexIndex]).info);
    visit[startVertexIndex] = true;
    while (!isEmpty(loopQueue))
    {
        VertexNode* vertexNode = dequeue(loopQueue);
        EdgeNode* edgeNode = vertexNode -> firstEdge;
        while(edgeNode != NULL)
        {
            if (visit[edgeNode -> toAdjVex] == false)
            {
                printf("%c ", (graph -> adjList[edgeNode -> toAdjVex]).info);
                visit[edgeNode -> toAdjVex] = true;
                enqueue(loopQueue, &(graph -> adjList[edgeNode -> toAdjVex]));
            }
            edgeNode = edgeNode -> next;
        }
    }
}




// 矩阵
//
// 循环队列顺序存储结构
typedef struct {
    int data[MAXSIZE]; // 用于存值的数组
    int front; // 头指针
    int rear; // 尾指针，若队列不空，指向队尾元素的下一个位置
}Queue;

int InitQueue(Queue *Q) {
    Q->front = Q->rear=  0; // 队头和队尾指针都指向0
    return 1;
}

int QueueEmpty(Queue Q) {
    if (Q.front == Q.rear) { // 队头等于队尾指针，队列为空
        return TRUE;
    } else {
        return FALSE;
    }
}

Status EnQueue(Queue *Q, int e) {
    // 队列已满，插入失败
    if ((Q->rear + 1) % MAXSIZE == Q->front) {
        return ERROR;
    }

    // 将元素e插入队尾
    Q->data[Q->rear] = e;

    // 设置队尾指针指向下一个位置，若到最后则转向头部
    Q->rear = (Q->rear + 1) % MAXSIZE;
    return OK;
}

int DeQueue(Queue *Q, int *e) {
    // 对头指针等于对尾指针，此时队列为空，出队失败
    if (Q->front == Q->rear) {
        return 0;
    }

    // 将队头元素的值赋给元素e
    *e = Q->data[Q->front];

    // 设置队头指针指向下一个位置，若到最后则转向头部
    Q->front = (Q->front + 1) % MAXSIZE;
    return 1;
}


void BFSTraverse(MGraph G) {
    int i, j; // 用于遍历元素
    Queue Q; // 队列

    // 初始设置图的所有顶点都没被访问过
    for (i = 0; i < G.numNodes; i++) {
        visited[i] = FALSE;
    }

    InitQueue(&Q); // 初始化队列

    // 对每一个顶点做循环
    for (i = 0; i < G.numNodes; i++) {
        if (!visited[i]) { // 该顶点未被访问过，进行处理
            visited[i] = TRUE; // 设置该顶点i已被访问

            printf("%c ", G.vexs[i]); // 打印该顶点i的值

            EnQueue(&Q, i); // 将该顶点i入队

            // 当队列非空时，进行循环
            while (!QueueEmpty(Q)) {
                DeQueue(&Q, &i); // 将队头元素出队，赋值给i

                // 遍历当前节点以外的节点j
                for (j = 0; j < G.numNodes; j++) {
                    // 若顶点j与当前节点存在边，并且未被访问过
                    if (G.arc[i][j] == 1 && !visited[j]) {
                        visited[j] = TRUE; // 设置顶点j已被访问
                        printf("%c ", G.vexs[j]); // 打印顶点j的值

                        EnQueue(&Q, j); // 将顶点j入队
                    }
                }
            }
        }
    }
}


