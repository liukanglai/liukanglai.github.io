#include <stdio.h>

int main(int argc, char *argv[]) {
  int n;
  scanf("%d", &n);
  long sum = 1;
  for (int i = 2; i <= n; i++) {
    if (i % 2 == 0) {
      sum += 1;
    } else {
      sum *= 2;
    }
  }
  printf("%ld", sum % 1000000007);
}
