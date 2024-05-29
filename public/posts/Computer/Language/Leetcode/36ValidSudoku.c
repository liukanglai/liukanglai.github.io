// Copyright [2023] <name>

#include "uthash.h"
int isValid(char c) {
  if (c > 49 && c < 58) {
    return 1;
  }
  return 0;
}
bool isValidSudoku0(char** board, int boardSize, int* boardColSize) {
  int repetition_row[10] = {0};
  int repetition_col[10] = {0};
  for (int i = 0; i < 9; i++) {
    for (int j = 0; j < 9; j++) {
      if (isValid(board[i][j])) {
        int num = board[i][j] - '0';
        if (repetition_row[num] == 0) {
          repetition_row[num] = 1;
        } else {
          return 0;
        }
      }
      if (isValid(board[j][i])) {
        int num = board[j][i] - '0';
        if (repetition_col[num] == 0) {
          repetition_col[num] = 1;
        } else {
          return 0;
        }
      }
    }
    memset(repetition_row, 0, sizeof(repetition_row));
    memset(repetition_col, 0, sizeof(repetition_row));
  }
  return 1;
}

struct hashTable {
  int key;
  int val[81];
  int num;
  UT_hash_handle hh;
};

struct hashTable* hashtable;

struct hashTable* find(int ikey) {
  struct hashTable* tmp;
  HASH_FIND_INT(hashtable, &ikey, tmp);
  return tmp;
}

void insert(int ikey, int ival) {
  struct hashTable* it = find(ikey);
  if (it == NULL) {
    struct hashTable* tmp = malloc(sizeof(struct hashTable));
    tmp->key = ikey, tmp->val[0] = ival, tmp->num = 1;
    HASH_ADD_INT(hashtable, key, tmp);
  } else {
    it->val[(it->num)++] = ival;
  }
}
bool isValidSudoku(char** board, int boardSize, int* boardColSize) {
  hashtable = NULL;
  for (int i = 0; i < boardSize; i++) {
    for (int j = 0; j < boardColSize[0]; j++) {
      if (board[i][j] != '.') {
        int num = board[i][j] - '0';
        struct hashTable* it = find(num);
        if (it != NULL) {
          for (int k = 0; k < it->num; k++) {
            int val = it->val[k];
            if (val / 10 == i || val % 10 == j ||
                (val / 30 == i / 3 && val % 10 / 3 == j / 3)) {
              return 0;
            }
          }
        }
        insert(num, i * 10 + j);
      }
    }
  }
  return 1;
}

// 好啊，逆向思维？
bool s_isValidSudoku(char** board, int boardSize, int* boardColSize) {
  int rows[9][9];
  int columns[9][9];
  int subboxes[3][3][9];

  memset(rows, 0, sizeof(rows));
  memset(columns, 0, sizeof(columns));
  memset(subboxes, 0, sizeof(subboxes));
  for (int i = 0; i < 9; i++) {
    for (int j = 0; j < 9; j++) {
      char c = board[i][j];
      if (c != '.') {
        int index = c - '0' - 1;
        rows[i][index]++;
        columns[j][index]++;
        subboxes[i / 3][j / 3][index]++;
        if (rows[i][index] > 1 || columns[j][index] > 1 ||
            subboxes[i / 3][j / 3][index] > 1) {
          return 0;
        }
      }
    }
  }
  return 1;
}
