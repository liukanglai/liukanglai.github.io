#include <stdarg.h>
#include <stdio.h>
#include <stdlib.h>
#include <math.h>

#define HAVE_COLOR 22

void readColor(FILE *file, int integers[32][3], int size);
void findColor(int have[32][3], int have_size, int need[10][4], int need_size);
void writefile(FILE *file, int need[][4], int size);
double variance(int x, int y, int z);

int main(void) {
    FILE *file1;
    file1 = fopen("/home/liukanglai/Downloads/Learning-diary/Code/CLionProjects/democ/附件1.txt", "r");
    if(file1 == NULL) {
        printf("No 附件1.txt file or open error!\n");
        return 0;
    }

    int have_color[32][3];
    for(int i = 0; i < 32; i++) {
        for(int j = 0; j < 3; j++) {
            have_color[i][j] = 0;
        }
    }
    readColor(file1, have_color, HAVE_COLOR);

    int need_color[10][4];
    for(int i = 0; i < 10; i++) {
        for(int j = 0; j < 4; j++) {
            need_color[i][j] = 0;
        }
    }
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

void readColor(FILE *file, int integers[32][3], int size){
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

void findColor(int have[32][3], int have_size, int need[10][4], int need_size) {
    double distance = 0;
    double distance1 = 0;
    for(int k = 0; k < 10; k++) {
        for (int r = 0; r < 256; r++) {
            for (int g = 0; g < 256; g++) {
                for (int b = 0; b < 256; b++) {
                    for (int j = 0; j < have_size; j++) {
                        int is = 0;
                        for (int i = 0; i < have_size; i++) {
                            if (have[i][0] == r && have[i][1] == g && have[i][2] == b) {
                                is = 1;
                                break;
                            }
                        }
                        if(is) {
                            break;
                        }
                        distance1 += ((pow((have[j][0] - r), 2) +
                                       pow((have[j][1] - g), 2) +
                                       pow((have[j][2] - b), 2)) / 4.0 +
                                      3 * (variance(have[j][0] - r, have[j][1] - g, have[j][2] - b)) / 4.0);
                    }
                    if (distance1 >= distance) {
                        distance = distance1;
                        need[k][1] = r;
                        need[k][2] = g;
                        need[k][3] = b;
                    }
                    distance1 = 0;
                }
            }
        }
        distance = 0;
        have_size++;
        have[have_size-1][0] = need[k][1];
        have[have_size-1][1] = need[k][2];
        have[have_size-1][2] = need[k][3];
    }
}

void writefile(FILE *file, int need[10][4], int size) {
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
