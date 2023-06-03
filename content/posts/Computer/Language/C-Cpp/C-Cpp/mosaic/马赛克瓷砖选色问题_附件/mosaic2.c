#include <stdarg.h>
#include <stdio.h>
#include <stdlib.h>
#include <math.h>

#define HAVE_COLOR 22

void readColor(FILE *file, int integers[][3], int size);
void findColor(int have[][3], int have_size, int need[][4], int need_size);
void writefile(FILE *file, int need[][4], int size);
double variance(int x, int y, int z);

int main(void) {
    FILE *file1;
    file1 = fopen("附件1.txt", "r");
    if(file1 == NULL) {
        printf("No 附件1.txt file or open error!\n");
        return 0;
    }

    int have_color[HAVE_COLOR][3];
    readColor(file1, have_color, HAVE_COLOR);

    int need_color[10][4];
    findColor(have_color, HAVE_COLOR, need_color, 10);

    FILE *putfile1 = fopen("1.txt", "w");
    if(putfile1 == NULL) {
        printf("1.txt file or open error!, create a new file\n");
        return 0;
    }

    writefile(putfile1, need_color, 10);

    fclose(file1);
    fclose(putfile1);
    return 0;
}

void readColor(FILE *file, int integers[][3], int size){
    int i=0;
    int num;
    char first_line[100];
    fgets(first_line, 100, file); // 读入“序号,RGB”
    while(i < size) {
        fscanf(file, "%d", &num); 
        fscanf(file, "%c", &first_line[0]); 
        fscanf(file, "%c", &first_line[0]); 
        for(int j = 0; j < 3; j++){
            fscanf(file, "%d", &integers[i][j]);
            fscanf(file, "%c", &first_line[0]); 
        }
        i++;
    }
}

void findColor(int have[][3], int have_size, int need[][4], int need_size) {
    int k = 0;
    int totol = 256*256*256;
    double result[totol];
    /*
    for(int i = 0; i < totol; i++) {
        for(int j = 0; j < 4; j++) {
            result[i][j] = 0;
        }
    }
    for(int r = 0; r < 256; r++) {
        for(int g = 0; g < 256; g++) {
            for(int b = 0; b < 256; b++) {
                for(int j = 0; j < have_size; j++) {
                    result[k][0] += ((pow((have[j][0] - r), 2) + 
                        pow((have[j][1] - g), 2) + 
                        pow((have[j][2] - b), 2)) / 4.0 + 
                        3 * (variance(have[j][0] - r, have[j][1] - g, have[j][2] - b)) / 4.0);
                }
                result[k][1] = r;
                result[k][2] = g;
                result[k++][3] = b;
            }
        }
    }
    */
    k = 0;
    while(k < 10){
        int max = 0;
        int flag = 0;
        for(int i = 0; i < totol; i++) {
            if(result[i][0] >= max) {
                max = result[i][0];
                flag = i;
            }
        }
        need[k][0] = k;
        need[k][1] = result[flag][1];
        need[k][2] = result[flag][2];
        need[k][3] = result[flag][3];
        result[flag][0] = 0;
        k++;
        max = 0;
        flag = 0;
    }
}

void writefile(FILE *file, int need[][4], int size) {
    fprintf(file, "序号,瓷砖颜色\n");
    for(int i = 0; i < size; i++){
        fprintf(file,"%d,", i+1);
        fprintf(file,"(%d,",need[i][1]);
        fprintf(file,"%d,",need[i][2]);
        fprintf(file,"%d)\n",need[i][3]);
    }
}

double variance(int x, int y, int z) {
    double average = (x + y + z) / 3.0;
    return pow(x-average, 2) + pow(x-average, 2) + pow(x-average, 2);
}
