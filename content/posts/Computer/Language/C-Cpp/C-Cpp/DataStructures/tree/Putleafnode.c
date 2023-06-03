/*
 * =====================================================================================
 *
 *       Filename:  Putleafnode.c
 *
 *    Description:  
 *
 *        Version:  1.0
 *        Created:  11/21/2020 09:21:40 PM
 *       Revision:  none
 *       Compiler:  gcc
 *
 *         Author:  liukanglai (), 
 *        Company:  
 *
 * =====================================================================================
 */


#include<stdio.h>
#include<ctype.h>

int Findroot(char s[][2], int n)
{
    int a[n]; // judge whether a node has father

    for(int i = 0; i < n; i++){
        a[i] = 0;
    }

    for(int i = 0; i < n; i++){
        if(isdigit(s[i][0])) a[s[i][0] - '0'] = 1;
        if(isdigit(s[i][1])) a[s[i][1] - '0'] = 1;
    }
    for(int i = 0; i < n; i++){
        if(!a[i]) return i;
    }
    return -1;
}

void Findorder(char s[][2], int* order, int n, int start, int stop) // like queue...
{
    if(isdigit(s[order[start]][0])) order[stop++] = s[order[start]][0] - '0';
    if(isdigit(s[order[start]][1])) order[stop++] = s[order[start]][1] - '0';

    if(start == n-1) return;

    Findorder(s, order, n, start+1, stop);

}

void Putleafnode(char s[][2], int* order, int n)
{
    for(int i = 0; i < n; i++){
        if(!isdigit(s[order[i]][0]) && !isdigit(s[order[i]][1])){
            printf("%d ", order[i]);
        }
    }
}

int main(void)
{
    int n;
    
    scanf("%d", &n);

    char tree[n][2];

    for(int i = 0; i < n; i++){
        getchar(); // eliminate CR
        tree[i][0] = getchar();
        getchar(); // eliminate space
        tree[i][1] = getchar();
    }

    int root = Findroot(tree, n);

    int order[n];
    order[0] = root;
    int start = 0, stop = 1;

    Findorder(tree, order, n, start, stop);
    
    Putleafnode(tree, order, n); 
    printf("\b");

    return 0;
}
