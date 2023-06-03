// use post-order traversal and in-order to put preorder
//
// such as:
// 7
// 2 3 1 5 7 6 4
// 1 2 3 4 5 6 7

// output: Preorder: 4 1 3 2 6 5 7

#include<stdio.h>

int n;
int post[40], in[40];

void Putpreordeer(int start, int stop, int rootn)
{
    int root; // put the preorder, if there is a tree, first put the totol root, then the left root, then the right root.
    int lsubn = 0, rsubn = 0; // the number of the subtree.

    root = post[rootn];
    /*
    for(lsubn = start; lsubn <= stop; lsubn++){ // wrong!!!
        if(in[lsubn] == root){
            break;
        }
    }
    */
    for(int i = start; i <= stop; i++, lsubn++){ 
        if(in[i] == root){
            break;
        }
    }

    rsubn = stop - start - lsubn;

    printf("%d ",root);

    // end condition
    if(lsubn){
        Putpreordeer(start, start + lsubn - 1, rootn - rsubn - 1);
    }
    if(rsubn){
        Putpreordeer(start + lsubn + 1, stop, rootn -1);
    }
}

int main(void)
{

    // input
    scanf("%d", &n);
    for(int i = 0; i < n; i++){
        scanf("%d", post+i);
    }
    for(int i = 0; i < n; i++){
        scanf("%d", in+i);
    }

    printf("Preorder:");
    
    Putpreordeer(0, n-1, n-1);
    printf("\b");

    return 0;
}
