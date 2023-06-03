/*
 * =====================================================================================
 *
 *       Filename:  Putleafnodeother.c
 *
 *    Description:  others......
 *
 *        Version:  1.0
 *        Created:  11/22/2020 10:13:35 PM
 *       Revision:  none
 *       Compiler:  gcc
 *
 *         Author:  liukanglai (), 
 *        Company:  
 *
 * =====================================================================================
 */

#include <stdio.h>
#include <string.h>

void ans(int *post, int *in, int n)
{
	if(n <= 0)
		return;
	int root = post[n-1];
	int i;
	for(i = 0; i < n; i++)
	{
		if(in[i] == root)
			break;
	}
	printf(" %d", root);
	ans(post, in, i);
	ans(post + i, in + i + 1, n - i - 1);
}

int main()
{
	int post[44], in[44];
	int n, i;
	scanf("%d", &n);
	for(i = 0; i < n; i++)
		scanf("%d", &post[i]);
	for(i = 0; i < n; i++)
		scanf("%d", &in[i]);
	printf("Preorder:");
	ans(post, in, n);
	printf("\n");
	return 0;
}

/* tree
#include <stdio.h>
#include <stdlib.h>

typedef struct node
{
	int Data;
	struct node *left;
	struct node *right;
}BinTree;

BinTree * Build(int n, int *mid, int *last);
void First(BinTree *rt);

int main()
{
	int mid[44], last[44];
	int n, i;
	BinTree *rt = NULL;
	scanf("%d", &n);
	for(i = 0; i < n; i++)
		scanf("%d", &last[i]);
	for(i = 0; i < n; i++)
		scanf("%d", &mid[i]);
	rt = Build(n, mid, last);
	printf("Preorder:");
	First(rt);
	printf("\n");
	return 0;
}

void First(BinTree *rt)
{
	if(rt)
	{
		printf(" %d", rt->Data);
		First(rt->left);
		First(rt->right);
	}
}

*/
