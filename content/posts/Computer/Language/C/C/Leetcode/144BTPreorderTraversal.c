/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
/**
 * Note: The returned array must be malloced, assume caller calls free().
 */

struct TreeNode {
  int val;
  struct TreeNode* left;
  struct TreeNode* right;
};

int ret[100];
int* preorderTraversal0(struct TreeNode* root, int* returnSize) {
  if (root == NULL) {
    return NULL;
  }
  ret[(*returnSize)++] = root->val;
  if (root->left != NULL) {
    preorderTraversal(root->left, returnSize);
  }
  if (root->right != NULL) {
    preorderTraversal(root->right, returnSize);
  }
  return ret;
}

// 不要用全局变量，使用递归可再定义一个函数！！！
void preorder(struct TreeNode* root, int* res, int* resSize) {
  if (root == NULL) {
    return;
  }
  res[(*resSize)++] = root->val;
  preorder(root->left, res, resSize);
  preorder(root->right, res, resSize);
}

int* s_preorderTraversal0(struct TreeNode* root, int* returnSize) {
  int* res = malloc(sizeof(int) * 2000);
  *returnSize = 0;
  preorder(root, res, returnSize);
  return res;
}

// 迭代 int* preorderTraversal(struct TreeNode* root, int* returnSize) {
  int* res = malloc(sizeof(int) * 2000);
  *returnSize = 0;
  if (root == 0) {
    return res;
  }
  // 存储右节点
  struct TreeNode** node = malloc(sizeof(struct TreeNode*) * 2000);
  int node_len = 0;
  struct TreeNode* now = root;
  while (1) {
    res[(*returnSize)++] = now->val;
    if (now->left != 0) {
      if (now->right != 0) {
        node[node_len++] = now->right;
      }
      now = now->left;
    } else if (now->right != 0) {
      now = now->right;
    } else {
      if (node_len == 0) {
        break;
      }
      now = node[--node_len];
    }
  }
  return res;
}

int* s_preorderTraversal(struct TreeNode* root, int* returnSize) {
  int* res = malloc(sizeof(int) * 2000);
  *returnSize = 0;
  if (root == NULL) {
    return res;
  }

  struct TreeNode* stk[2000];
  struct TreeNode* node = root;
  int stk_top = 0;
  while (stk_top > 0 || node != NULL) {
    while (node != NULL) {
      res[(*returnSize)++] = node->val;
      stk[stk_top++] = node;
      node = node->left;
    }
    node = stk[--stk_top];
    node = node->right;
  }
  return res;
}

// Morris 遍历
int* preorderTraversal(struct TreeNode* root, int* returnSize) {
  int* res = malloc(sizeof(int) * 2000);
  *returnSize = 0;
  if (root == NULL) {
    return res;
  }

  struct TreeNode *p1 = root, *p2 = NULL;

  while (p1 != NULL) {
    p2 = p1->left;
    if (p2 != NULL) {
      while (p2->right != NULL && p2->right != p1) {
        p2 = p2->right;
      }
      if (p2->right == NULL) {
        res[(*returnSize)++] = p1->val;
        p2->right = p1;
        p1 = p1->left;
        continue;
      } else {
        p2->right = NULL;
      }
    } else {
      res[(*returnSize)++] = p1->val;
    }
    p1 = p1->right;
  }
  return res;
}
