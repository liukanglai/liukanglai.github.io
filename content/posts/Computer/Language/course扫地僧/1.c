#include <stdio.h>

int* f() {
  static int a = 10;
  return &a;
}

int main(int argc, char* argv[]) {
  printf("%d\n", *f());
  *(f()) = 20;
  printf("%d\n", *f());
  return 0;
}
