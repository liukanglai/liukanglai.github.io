#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(void) {
  int** ret = malloc(sizeof(int*));
  *ret = malloc(sizeof(int) * 2);
  **ret = 1;
  *(*ret + 1) = 2;
  printf("%d\n", sizeof(ret));
  printf("%d\n", sizeof(*ret));
  printf("%d\n", (*ret));
  printf("%d\n", (**ret));
  free(ret);
  return 0;
}
