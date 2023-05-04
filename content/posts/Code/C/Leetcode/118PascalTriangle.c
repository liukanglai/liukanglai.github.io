/**
 * Return an array of arrays of size *returnSize.
 * The sizes of the arrays are returned as *returnColumnSizes array.
 * Note: Both returned array and *columnSizes array must be malloced, assume
 * caller calls free().
 */
#include <stdlib.h>
int** generate(int numRows, int* returnSize, int** returnColumnSizes) {
  *returnSize = numRows;
  int** columnSizes = malloc(numRows * sizeof(int*));  // 二维数组分配内存
  // 二维指针分配内存，注意这是一维数组，思考为什么要用二维指针？
  *returnColumnSizes = malloc(numRows * sizeof(int));
  for (int i = 0; i < numRows; i++) {
    (*returnColumnSizes)[i] = i + 1;
    columnSizes[i] = malloc((i + 1) * sizeof(int));
    columnSizes[i][0] = 1;
    int j = 1;
    for (; j < i; j++) {
      columnSizes[i][j] = columnSizes[i - 1][j - 1] + columnSizes[i - 1][j];
    }
    columnSizes[i][i] = 1;
  }
  return columnSizes;
}
