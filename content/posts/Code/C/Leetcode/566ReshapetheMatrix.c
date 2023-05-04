/**
 * Return an array of arrays of size *returnSize.
 * The sizes of the arrays are returned as *returnColumnSizes array.
 * Note: Both returned array and *columnSizes array must be malloced, assume
 * caller calls free().
 */

#include <stdlib.h>
int** matrixReshape(int** mat, int matSize, int* matColSize, int r, int c,
                    int* returnSize, int** returnColumnSizes);
int main() {
  int mat[2][2] = {{1, 2}, {3, 4}};
  int matSize = 2;
  int matColSize[2] = {2, 2};
  int r = 1, c = 4;
  int returnSize = 0;
  int** returnColumnSizes = (int**)malloc(r * sizeof(int*));
  matrixReshape(mat, matSize, matColSize, r, c, &returnSize, returnColumnSizes);
}

// 各个函数参数都看不懂啊。。。
int** matrixReshape0(int** mat, int matSize, int* matColSize, int r, int c,
                     int* returnSize, int** returnColumnSizes) {
  if (r * c == matSize * matColSize[0]) {
    // int (*a)[2]=(int(*)[2])malloc(sizeof(int)*3*2);
    *returnSize = r;
    *returnColumnSizes = (int*)malloc(sizeof(int) * r);
    int** columnSizes = (int**)malloc(r * sizeof(int*));
    int R = 0, C = 0;
    for (int i = 0; i < r; i++) {
      (*returnColumnSizes)[i] = c;
      columnSizes[i] = (int*)malloc(sizeof(int) * c);
    }
    for (int i = 0; i++; i < matSize) {  // ?????????
      for (int j = 0; j++; j < matColSize[0]) {
        if (C == c) {
          R++;
          C = 0;
        }
        columnSizes[R][C++] = mat[i][j];
      }
    }
    return columnSizes;
  }
  *returnSize = matSize;
  *returnColumnSizes = matColSize;
  return mat;
}
int** matrixReshape(int** mat, int matSize, int* matColSize, int r, int c,
                    int* returnSize, int** returnColumnSizes) {
  if (r * c == matSize * matColSize[0]) {
    // int (*a)[2]=(int(*)[2])malloc(sizeof(int)*3*2);
    *returnSize = r;
    *returnColumnSizes = (int*)malloc(sizeof(int) * r);
    int** columnSizes = (int**)malloc(r * sizeof(int*));
    int R = 0, C = 0;
    for (int i = 0; i < r; i++) {
      (*returnColumnSizes)[i] = c;
      columnSizes[i] = (int*)malloc(sizeof(int) * c);
    }
    for (int i = 0; i < matSize; i++) {  // ?????????
      for (int j = 0; j < matColSize[0]; j++) {
        if (C == c) {
          R++;
          C = 0;
        }
        columnSizes[R][C++] = mat[i][j];
      }
    }
    return columnSizes;
  }
  *returnSize = matSize;
  *returnColumnSizes = matColSize;
  return mat;
}
int** s_matrixReshape(int** nums, int numsSize, int* numsColSize, int r, int c,
                      int* returnSize, int** returnColumnSizes) {
  int m = numsSize;
  int n = numsColSize[0];
  if (m * n != r * c) {
    *returnSize = numsSize;
    *returnColumnSizes = numsColSize;
    return nums;
  }
  *returnSize = r;
  *returnColumnSizes = malloc(sizeof(int) * r);
  int** ans = malloc(sizeof(int*) * r);

  for (int i = 0; i < r; i++) {
    (*returnColumnSizes)[i] = c;
    ans[i] = malloc(sizeof(int) * c);
  }
  for (int x = 0; x < m * n; ++x) {
    ans[x / c][x % c] = nums[x / n][x % n];
  }
  return ans;
}
