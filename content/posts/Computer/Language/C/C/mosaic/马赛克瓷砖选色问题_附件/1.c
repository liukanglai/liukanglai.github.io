#include<stdio.h>
int main(void){
    int a = 256*256*256;
    int b = 0;
    for(int i = 0; i < 256; i++){
        for(int j = 0; j < 256; j++){
            for(int k = 0; k < 256; k++){
                b++;
            }
        }
    }
    printf("%d", b);
}
