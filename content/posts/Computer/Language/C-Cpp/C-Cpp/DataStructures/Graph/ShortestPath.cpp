
// 1. dijkstra
void dijkstra(MGraph* graph, int startVertexIndex)
{
    // For storing the minimum cost from the arbitrary node to the start vertex.
    float minCostToStart[VERTEX_NUM];
    // For marking whether the node is in the set.
    int set[VERTEX_NUM];
    // Initialization
    for(int i = 0; i < VERTEX_NUM; i++) {
        minCostToStart[i] = graph->edges[i][startVertexIndex];
        set[i] = 0;
    }
    // Add the start vertex into the set.
    set[startVertexIndex] = 1;
    int minNodeIndex = startVertexIndex;
    for (int count = 1; count < VERTEX_NUM; count++){
        int minCost = MAX_COST;
        // Find the adjacent node which is nearest to the startVertexIndex.
        for (int i = 0; i < VERTEX_NUM; i++) {
            if (!set[i] && minCostToStart[i] < minCost)
            {
                minCost = minCostToStart[minNodeIndex];
                minNodeIndex = i;
            }
        }
        // Add the proper node into the set
        set[minNodeIndex] = 1;
        // After the new node is added into the set, update the minimum cost of each node which is out of the set.
        for (int i = 0; i < VERTEX_NUM; i++) {
            if (!set[i] && (graph -> edges[i][minNodeIndex]) < MAX_COST) {
                // The new cost of each node to source = the cost of new added node to source + the cost of node i to new added node.
                float newCost = minCostToStart[minNodeIndex] + graph -> edges[i][minNodeIndex];
                if (newCost < minCostToStart[i])
                    minCostToStart[i] = newCost;
            }
        }
    }
    printf("The cost of %c to each node:\n", (graph -> vex[startVertexIndex]).info);
    for (int i = 0; i < VERTEX_NUM; i++) {
        if (i != startVertexIndex)
            printf("-----> %c : %f\n", (graph -> vex[i]).info, minCostToStart[i]);
    }
}


//2. 多源最短路径算法——弗洛伊德算法（Floyd Algorithm）

void floyd(MGraph* graph)
{
    float minCost[VERTEX_NUM][VERTEX_NUM];          // Store the distance between any two nodes.
    int path[VERTEX_NUM][VERTEX_NUM];               // Store the intermediate node between the two nodes.
    int i, j, k;

    // Initialization
    for (i = 0; i < VERTEX_NUM; i++)
    {
        for (j = 0; j < VERTEX_NUM; j++)
        {
            minCost[i][j] = graph -> edges[i][j];
            path[i][j] = -1;
        }
    }

    // Find if there is another k node, it makes the distance dis[i][k] + dis[k][j] < dis[i][j];
    for (k = 0; k < VERTEX_NUM; k++)
        for (i = 0; i < VERTEX_NUM; i++)
            for (j = 0; j < VERTEX_NUM; j++)
            {
                if (minCost[i][j] > minCost[i][k] + minCost[k][j])
                {
                    minCost[i][j] = minCost[i][k] + minCost[k][j];
                    path[i][j] = k;
                }
            }

    for (i = 0; i < VERTEX_NUM; i++)
        for (j = 0; j < VERTEX_NUM; j++)
        {
            if (i != j && minCost[i][j] != MAX_COST)
                printf("%c ---> %c, the minimum cost is %f\n", (graph -> vex[i]).info, (graph -> vex[j]).info, minCost[i][j]);
        }
}



