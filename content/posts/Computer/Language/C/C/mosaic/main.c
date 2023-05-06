#include <stdio.h>
#include <math.h>

int main() {
    int num = 3;
    int Num;
    //printf("Hello, World!\n");
    FILE *file = fopen("/home/liukanglai/1.txt", "w+");

    fscanf(file, "%d", &num);
    printf("%d\n", num);
    fprintf(file, "%d", num);
    //fprintf(file, "hello");
    int b = pow(1, 2);
    printf("%d", b);



    fclose(file);
    return 0;
}