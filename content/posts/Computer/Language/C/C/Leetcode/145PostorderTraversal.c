struct TreeNode {
  int val;
  struct TreeNode* left;
  struct TreeNode* right;
};

void postorder(struct TreeNode* root, int* returnSize, int* ret) {
  if (root == 0) {
    return;
  }
  postorder(root->left, returnSize, ret);
  postorder(root->right, returnSize, ret);
  ret[(*returnSize)++] = root->val;
}
int* postorderTraversal0(struct TreeNode* root, int* returnSize) {
  int* ret = malloc(sizeof(int) * 100);
  *returnSize = 0;
  postorder(root, returnSize, ret);
  return ret;
}

int* postorderTraversal(struct TreeNode* root, int* returnSize) {
  *returnSize = 0;
  int* res = malloc(sizeof(int) * 100);
  struct TreeNode** stk = malloc(sizeof(struct TreeNode*) * 100);
  int top = 0;
  while (root != 0 || top > 0) {
    while (root != 0) {
      stk[top++] = root;
      root = root->left;
    }
    root = stk[top - 1];
    if (root->right == 0) {
      top--;
      res[(*returnSize)++] = root->val;
      root = root->right;
    } else {
      root = root->right;
      stk[top - 1]->right = 0;
    }
  }
  return res;
}
