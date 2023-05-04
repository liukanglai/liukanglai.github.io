#include <ctype.h>
#include <stdio.h>

int search(int *nums, int numsSize, int target);

int main() {
  int nums[10000];
  char c;
  int numsSize = 0;
  int target = 0;
  while ((c = getchar()) != '\n') {
    if (isdigit(c)) {
      // 负数存不进去？
      ungetc(c, stdin); // 将c送回输入流
      scanf("%d", &nums[numsSize++]);
    }
  }
  for (int i = 0; i < numsSize; i++) {
    printf("%d ", nums[i]);
  }
  printf("\nPlease input the target: ");
  scanf("%d", &target);
  printf("%d", search(nums, numsSize, target));
  return 0;
}

int search(int *nums, int numsSize, int target) {
  int flag;
  int left = 0;
  int right = numsSize;
  while (1) {
    flag = (left + right) / 2;
    if (nums[flag] == target) {
      return flag;
    }
    if (flag == left || flag == right) {
      return -1;
    }
    if (nums[flag] > target) {
      right = flag;
    } else {
      left = flag;
    }
  }
}
// 到了35题，才彻底想清楚2分查找的结束条件。。。
int search1(int *nums, int numsSize, int target) {
  int flag;
  int left = 0;
  int right = numsSize;
  while (1) {
    flag = (left + right) / 2;
    if (nums[flag] == target) {
      return flag;
    }
    if (flag ==
        left) { // flag不可能等于right，但这里不用判断target是否是right的值，因为right一开始是下标+1，规避了错误
      return -1;
    }
    if (nums[flag] > target) {
      right = flag;
    } else {
      left = flag;
    }
  }
}
int search2(int *nums, int numsSize, int target) {
  int flag;
  int left = 0;
  int right = numsSize - 1;
  while (1) {
    flag = (left + right) / 2;
    if (nums[flag] == target) {
      return flag;
    }
    if (flag == left) { // 这里必须判断right
      if (nums[right] == target) {
        return right;
      }
      return -1;
    }
    if (nums[flag] > target) {
      right = flag - 1;
    } else {
      left = flag + 1;
    }
  }
}

// 主要是循环判断的条件，绕了我好久。。。
/* class Solution {
public:
    int search(vector<int>& nums, int target) {
        int left = 0, right = nums.size() - 1;
        while(left <= right){
            int mid = (right - left) / 2 + left; // why???中位数的计算。。。
            int num = nums[mid];
            if (num == target) {
                return mid;
            } else if (num > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
};
 */
