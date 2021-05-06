#include <stdio.h>
#include <omp.h>
int main() {
#pragma omp parallel for
    for(int i = 0 ; i < 10 ; ++i){
        printf("Hello, World! by %d\n",i);
    }
    return 0;
}

