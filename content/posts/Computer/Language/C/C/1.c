// Time:2021-12-02 15:03:08
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(void) {
  int nums[] = {-4, -1, 0, 3, 10, 100};  // ja
  // int numsSize = sizeof(nums) / sizeof(nums[0]);
  // int *returnSize = (int *)malloc(sizeof(int));
  char buf[] = {'a', 'b'};
  printf("%s\n", buf);
  if (strcmp(buf + strlen(buf) - 1, "\0") != 0) {
    printf("Error: string is not null-terminated.\n");
  }
  printf("%lu\n", strlen(buf));
  char buf1[] = "abcd";
  printf("%s\n", buf1);
  if (strcmp(buf1 + strlen(buf1) - 1, "\0") != 0) {
    printf("Error: string is not null-terminated.\n");
  }
  printf("%zu\n", strlen(buf1));
  return 0;
}
