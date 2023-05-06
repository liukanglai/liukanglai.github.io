#include <stdlib.h>
#include <string.h>
struct TreeNode {
  int val;
  struct TreeNode* left;
  struct TreeNode* right;
};

int** levelOrder(struct TreeNode* root, int* returnSize,
                 int** returnColumnSizes) {
  int* ret = malloc(sizeof(int) * 2001);
  *returnColumnSizes = malloc(sizeof(int) * 2001);
  memset(*returnColumnSizes, 0, sizeof(returnColumnSizes));
  *returnSize = 0;
  if (root == 0) {
    return 0;
  }
  struct TreeNode* queue[2001];
  int front = 0, end = 0;
  int level[2001] = {0};  // 记录每个节点的层次
  queue[front++] = root, level[front - 1] = 0;
  while (end != front) {
    root = queue[end++];
    if (root->left != 0) {
      queue[front++] = root->left;
      level[front - 1] = level[end - 1] + 1;
    }
    if (root->right != 0) {
      queue[front++] = root->right;
      level[front - 1] = level[end - 1] + 1;
    }
    ret[(*returnSize)++] = root->val;
    (*returnColumnSizes)[level[end - 1]]++;
  }
  *returnSize = level[end - 1] + 1;  // 这个数值是行数，而不是总大小！！！
  int** res = malloc(sizeof(int*) * (*returnSize));
  int k = 0;
  for (int i = 0; i < *returnSize; i++) {
    res[i] = malloc(((*returnColumnSizes)[i]) * sizeof(int));
    for (int j = 0; j < (*returnColumnSizes[i]); j++) {
      res[i][j] = ret[k++];
    }
  }
  return res;
}

int main(void) {
  struct TreeNode root;
  struct TreeNode left;
  root.val = 3;
  root.right = &left;
  root.left = &left;
  left.val = 9;
  left.right = 0;
  left.left = 0;
  int returnSize = 0;
  int* returnColumnSizes;
  levelOrder(&root, &returnSize, &returnColumnSizes);
}
