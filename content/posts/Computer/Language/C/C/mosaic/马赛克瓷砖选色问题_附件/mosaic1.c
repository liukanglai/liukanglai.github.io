#include <stdarg.h>
#include <stdio.h>
#include <stdlib.h>
#include <math.h>

#define HAVE_COLOR 22
#define IMAGE1 216
#define IMAGE2 200

void readColor(FILE *file, int integers[][3], int size);
void findColor(int have[][3], int have_size, int need[][3], int need_size, int result[]);
void writefile(FILE *file, int result[], int size);
double variance(int x, int y, int z);

int main(void) {
    FILE *file1;
    file1 = fopen("附件1.txt", "r");
    if(file1 == NULL) {
        printf("No 附件1.txt file or open error!\n");
        return 0;
    }

    FILE *file2;
    file2 = fopen("附件2.txt", "r");
    if(file2 == NULL) {
        printf("No 附件2.txt file or open error!\n");
        return 0;
    }

    FILE *file3;
    file3 = fopen("附件3.txt", "r");
    if(file3 == NULL) {
        printf("No 附件3.txt file or open error!\n");
        return 0;
    }

    int have_color[HAVE_COLOR][3];
    readColor(file1, have_color, HAVE_COLOR);

    int need_color1[IMAGE1][3];
    readColor(file2, need_color1, IMAGE1);

    int need_color2[IMAGE2][3];
    readColor(file3, need_color2, IMAGE2);


    int result1[IMAGE1], result2[IMAGE2];
    findColor(have_color, HAVE_COLOR, need_color1, IMAGE1, result1);
    findColor(have_color, HAVE_COLOR, need_color2, IMAGE2, result2);

    FILE *putfile1 = fopen("result1.txt", "w");
    if(putfile1 == NULL) {
        printf("No result1.txt file or open error!\n");
        return 0;
    }

    FILE *putfile2 = fopen("result2.txt", "w");
    if(putfile2 == NULL) {
        printf("No result2.txt file or open error!\n");
        return 0;
    }

    writefile(putfile1, result1, IMAGE1);
    writefile(putfile2, result2, IMAGE2);

    fclose(file1);
    fclose(file2);
    fclose(file3);
    fclose(putfile1);
    fclose(putfile2);
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

void findColor(int have[][3], int have_size, int need[][3], int need_size, int result[]) {
    for(int i = 0; i < need_size; i++) {
        double min = 1000000;
        double distance = 0;
        for(int j = 0; j < have_size; j++) {
            if((distance = ((pow((have[j][0] - need[i][0]), 2) + 
               pow((have[j][1] - need[i][1]), 2) + 
               pow((have[j][2] - need[i][2]), 2)) / 4.0 + 
               3 * (variance(have[j][0] - need[i][0], have[j][1] - need[i][1], have[j][2] - need[i][2])) / 4.0)) < min) {
                min = distance;
                result[i] = j;
            }
            //printf("%f %d\n", distance, j);
        }
    }
}

void writefile(FILE *file, int result[], int size) {
    fprintf(file, "序号,瓷砖颜色编号\n");
    for(int i = 0; i < size; i++){
        fprintf(file,"%d,", i+1);
        fprintf(file,"%d\n",result[i]+1);
    }
}

double variance(int x, int y, int z) {
    double average = (x + y + z) / 3.0;
    return pow(x-average, 2) + pow(x-average, 2) + pow(x-average, 2);
}
