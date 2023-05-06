struct TreeNode {
  int val;
  struct TreeNode* left;
  struct TreeNode* right;
};

void inorder(struct TreeNode* root, int* returnSize, int* ret) {
  if (root == 0) {
    return;
  }
  inorder(root->left, returnSize, ret);
  ret[(*returnSize)++] = root->val;
  inorder(root->right, returnSize, ret);
}
int* inorderTraversal0(struct TreeNode* root, int* returnSize) {
  int* ret = malloc(sizeof(int) * 100);
  *returnSize = 0;
  inorder(root, returnSize, ret);
  return ret;
}

// 迭代
int* inorderTraversal(struct TreeNode* root, int* returnSize) {
  int* res = malloc(sizeof(int) * 100);
  *returnSize = 0;

  // 存储根节点
  struct TreeNode** node = malloc(sizeof(struct TreeNode*) * 100);
  int node_len = 0;
  struct TreeNode* now = root;
  while (1) {
    while (now != 0) {
      node[node_len++] = now;
      now = now->left;
    }
    while (1) {
      if (node_len == 0) {
        return res;
      }
      now = node[--node_len];
      res[(*returnSize)++] = now->val;
      if (now->right != 0) {
        now = now->right;
        break;
      }
    }
  }
}

// 学习
int* s_inorderTraversal(struct TreeNode* root, int* returnSize) {
  *returnSize = 0;
  int* res = malloc(sizeof(int) * 501);
  struct TreeNode** stk = malloc(sizeof(struct TreeNode*) * 501);
  int top = 0;
  while (root != NULL || top > 0) {
    while (root != NULL) {
      stk[top++] = root;
      root = root->left;
    }
    root = stk[--top];
    res[(*returnSize)++] = root->val;
    root = root->right;
  }
  return res;
}
