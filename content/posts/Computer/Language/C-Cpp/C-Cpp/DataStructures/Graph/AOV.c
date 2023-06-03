// 1. TopologicalSorting

// 拓扑排序（topological sort）

// 顶点表示活动的网（activity on vertex network）或AOV网，


对于拓扑排序问题，所需的操作主要有：
1）判断顶点是否有前驱；
2）删除顶点和关联于该顶点的所有边。

for(i=0;i<n;i++)
{
    if every vertex has a predecessor
    {
        fprintf(stderr,"Network has a cycle.\n");
        exit(1);
    }
    pick a vertex v that has no predecessors;
    output v;
    delete v and all edges leading out of v from the netwok;
}

//  邻接表
typedef struct node
{
    int vertex;
    struct node *link;
}node;
typedef struct
{
    int count; // 有几个前边 
    struct node * link;
}hdnodes;

hdnodes graph[MAX_VERTICES];

// 函数
void topsort(hdnodes graph[],int n)
{
    int i,j,k,top;
    node *ptr;
    top=-1;
    // find the first top.
    for(i=0;i<n;i++)
    {
        if(!graph[i].count)
        {
            graph[i].count=top;
            top=i;
        }
    }
    for(i=0;i<n;i++)
    {
        if(top==-1)
        {
            fprintf(stderr,"\nNetwork has a cycle. Sort terminated.\n");
            return ;
        }
        else
        {
            j=top;
            top=graph[top].count;
            printf("%d, ",j);
            for(ptr=graph[j].link; ptr; ptr=ptr->link)
            {
                k=ptr->vertex;
                graph[k].count--;
                if(!graph[k].count)
                {
                    graph[k].count=top;
                    top=k;
                }
            }
        }
    }
}


typedef struct
{
	char vexs[N];//顶点数组
	int arcs[N][N];//邻接矩阵
}graph;

void TopoSort_matrix(graph g)
{
	int row[N]={0};//按照列来设置标志，为1表示已经输出（不再考虑），为0表示未输出。
	int v=1;//标志符，1表示已经输出（不再考虑），为0表示未输出，赋给row数组
	int i,j,k,t,m;
	for(k=0;k<N;k++)
	{
		for(j=0;j<N;j++)
		{
			if(row[j]==0)//活动j还未输出
			{
				t=1; //标识符
				for(i=0;i<N;i++)
					if(g.arcs[i][j]==1) //当前活动有入度（活动i必须在活动j之前）
					{
						t=0;
						break;
					}
				if(t==1)/ /活动j没有入度
				{
					m=j;
					break;
				}
			}
		}
		if(j!=N)
		{
			row[m]=v;
			printf("%c",g.vexs[m]);
			for(i=0;i<N;i++)
				g.arcs[m][i]=0; //将已经输出的活动所到达的下个活动的入度置为0
			v++;
		}
		else
			break;
		}
		if(v-1 < N)//当row中不是所有的元素都被赋予新值v时，说明有环存在
			printf("\n该有向图有环存在！");

}
