// Time:2021-12-02 15:03:08
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(void) {
  int a = 1;
  int nums[] = {-4, -1, 0, 3, 10, 100};  // ja
  int numsSize = sizeof(nums) / sizeof(nums[0]);
  int *returnSize = (int *)malloc(sizeof(int));
  char buf[] = {'a'};
  printf("%s\n", buf);
  printf("%d\n", (int)strlen(buf));
  char buf1[] = "abcd";
  printf("%s\n", buf1);
  return 0;
}
