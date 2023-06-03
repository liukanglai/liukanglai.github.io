#include<stdio.h>

// Minimum Spanning Tree

// 1. Prim

float prim(MGraph* graph, int startVertex)
{
    float totalCost = 0;
    float lowCost[VERTEX_NUM];              // The value of lowCost[i] represents the minimum distance from vertex i to current spanning tree.
    bool treeSet[VERTEX_NUM];               // The value of treeSet[i] represents whether the vertex i has been merged into the spanning tree.

    // Initialization
    for (int i = 0; i < (graph -> vertextNum); i++)
    {
        lowCost[i] = graph -> edges[startVertex][i];        // Init all cost from i to startVertex.
        treeSet[i] = false;                                 // No vertex is in the spanning tree set at first.
    }

    treeSet[startVertex] = true;                            // Merge the startVertex into the spanning tree set.
    printf("%c ", (graph -> vex[startVertex]).info);
    for (int i = 0; i < (graph -> vertextNum); i++)
    {
        int minCost = MAX_COST;                             // MAX_COST is a value greater than any other edge weight.
        int newVertex = startVertex;

        // Find the minimum cost vertex which is out of the spanning tree set.
        for (int j = 0; j < (graph -> vertextNum); j++)
        {
            if (!treeSet[j] && lowCost[j] < minCost)
            {
                minCost = lowCost[j];
                newVertex = j;
            }
        }
        treeSet[newVertex] = true;                          // Merge the new vertex into the spanning tree set.

        /*

            Some ops, for example you can print the vertex so you will get the sequence of node of minimum spanning tree.

        */
        if (newVertex != startVertex)
        {
            printf("%c ", (graph -> vex[newVertex]).info);
            totalCost += lowCost[newVertex];
        }

        // Judge whether the cost is change between the new spanning tree and the remaining vertex.
        for (int j = 0; j < (graph -> vertextNum); j++)
        {
            if (!treeSet[j] && lowCost[j] > graph -> edges[newVertex][j])
                lowCost[j] = graph -> edges[newVertex][j];  // Update the cost between the spanning tree and the vertex j.
        }
    }
    return totalCost;
}


// 2. Kruskal's algorithm 并查集 （Union Find Set）

int findRootInSet(int array[], int x)
{
    if (array[x] < 0)
    {
        // Find the root index.
        return x;
    }
    else
    {
        // Recursively find its parent until find the root,
        // then recursively update the children node so that they will point to the root.
        return array[x] = findRootInSet(array, array[x]);
    }
}

bool unionSet(int array[], int node1, int node2)
{
    int root1 = findRootInSet(array, node1);
    int root2 = findRootInSet(array, node2);
    if (root1 == root2)
    {
        // It means they are in the same set
        return false;
    }

    // The value of array[root] is negative and the absolute value is its children numbers,
    // when merging two sets, we choose to merge the more children set into the less one.
    if (array[root1] > array[root2])
    {
        array[root1] += array[root2];
        array[root2] = root1;
    }
    else
    {
        array[root2] += array[root1];
        array[root1] = root2;
    }
    return true;
}

void Kruskal()
{
    int array[n];
	  /* 将边排序 */
	  qsort(e, n, sizeof(edge), cmp);

	  for (i = 0; i < n; i++)
	  {
	  	x = findRootInSet(array, e[i].x);
	  	y = findRootInSet(array, e[i].y);
	  	if (x != y || (!x && !y))
	  	{
	  		printf("%c - %c : %d\n", e[i].x, e[i].y, e[i].w);
	  		Union(x, y, e[i].w);
	  	}
	  }
}
