// The API isBadVersion is defined for you.
bool isBadVersion(int version);

int firstBadVersion_time_long(int n) {
  if (n == 1) {
    return 1;
  }
  long flag = n / 2; // int 太小
  long end = n;
  while (1) {
    if (isBadVersion(flag)) {
      if (isBadVersion(
              flag -
              1)) { // 时间太长？没有处理左端，还是测试用例误导了我，以为只要测试一边？其实和2分查找没什么不一样。。。
        flag = flag / 2;
        end = flag - 1;
      } else {
        return flag;
      }
    } else {
      // flag = (flag + end) / 2; // 无限重复，flag 要后移
      if (flag == end - 1) {
        return end;
      }
      flag = (flag + 1 + end) / 2;
    }
  }
  // return n;
}

int firstBadVersion(int n) {
  if (n == 1) {
    return 1;
  }
  int left = 1; // 不能是0，还是要 long
  int right = n;
  while (1) {
    int flag = (left + right) / 2;
    if (isBadVersion(flag)) {
      // right = flag - 1; // 错误，可能flag就是，不要-1；
      right = flag;
    } else {
      left = flag + 1;
    }
    if (left == right) {
      return left;
    }
  }
}

// 为什么它不要是long，就可以。。。中位数的计算！！！
int s_firstBadVersion(int n) {
  int left = 1, right = n;
  while (left < right) {                 // 循环直至区间左右端点相同
    int mid = left + (right - left) / 2; // 防止计算时溢出
    if (isBadVersion(mid)) {
      right = mid; // 答案在区间 [left, mid] 中
    } else {
      left = mid + 1; // 答案在区间 [mid+1, right] 中
    }
  }
  // 此时有 left == right，区间缩为一个点，即为答案
  return left;
}
