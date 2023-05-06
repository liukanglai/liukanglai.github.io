void setZeroes(int** matrix, int matrixSize, int* matrixColSize) {
  int col[matrixColSize[0]];
  memset(col, 0, sizeof(col));
  for (int i = 0; i < matrixSize; i++) {
    for (int j = 0; j < matrixColSize[0]; j++) {
      if (matrix[i][j] == 0) {
        for (int k = 0; k < matrixColSize[0]; k++) {
          if (matrix[i][k] == 0) {
            col[k] = 1;
          } else {
            matrix[i][k] = 0;
          }
        }
        break;
      }
    }
  }
  for (int j = 0; j < matrixColSize[0]; j++) {
    if (col[j] == 1) {
      for (int k = 0; k < matrixSize; k++) {
        if (matrix[k][j] == 0) {
        }
        matrix[k][j] = 0;
      }
    }
  }
}

// 借用空间！
void s_setZeroes(int** matrix, int matrixSize, int* matrixColSize) {
  int m = matrixSize;
  int n = matrixColSize[0];
  int flag_col0 = false;
  for (int i = 0; i < m; i++) {
    if (!matrix[i][0]) {
      flag_col0 = true;
    }
    for (int j = 1; j < n; j++) {
      if (!matrix[i][j]) {
        matrix[i][0] = matrix[0][j] = 0;
      }
    }
  }
  for (int i = m - 1; i >= 0; i--) {
    for (int j = 1; j < n; j++) {
      if (!matrix[i][0] || !matrix[0][j]) {
        matrix[i][j] = 0;
      }
    }
    if (flag_col0) {
      matrix[i][0] = 0;
    }
  }
}
