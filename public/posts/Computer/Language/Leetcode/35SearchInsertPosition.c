int searchInsert0(int *nums, int numsSize, int target) {
  int left = 0;
  int right = numsSize - 1;
  int flag;
  while (1) {
    flag = left + (right - left) / 2;
    if (nums[flag] == target) {
      return flag;
    }
    if (flag == left ||
        flag ==
            right) { // 这有问题，结束的条件想清除，就是有相邻的两个数，一定会到小的数里面，可能是大的数，也可能没有。
      if (nums[left] < target) {
        return right;
      } else {
        return left;
      }
    }
    if (nums[flag] > target) {
      right = flag - 1;
    } else {
      left = flag + 1;
    }
  }
}
int searchInsert(int *nums, int numsSize, int target) {
  int left = 0;
  int right = numsSize - 1;
  int flag;
  while (1) {
    flag = left + (right - left) / 2;
    if (nums[flag] == target) {
      return flag;
    }
    if (flag == left) {
      if (nums[left] < target) {
        if (nums[right] < target) {
          return right + 1;
        }
        return right;
      }
      return left;
    }
    if (nums[flag] > target) {
      right = flag - 1;
    } else {
      left = flag + 1;
    }
  }
}
// 官方就是要好，1. 用>>去除。2. 判断结束条件更优
int s_searchInsert(int *nums, int numsSize, int target) {
  int left = 0, right = numsSize - 1, ans = numsSize;
  while (left <= right) {
    int mid = ((right - left) >> 1) + left;
    if (target <= nums[mid]) {
      ans = mid;
      right = mid - 1;
    } else {
      left = mid + 1;
    }
  }
  return ans;
}
