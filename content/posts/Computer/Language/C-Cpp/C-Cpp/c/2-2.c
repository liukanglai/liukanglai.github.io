// Time:2022-09-08 14:27:47
#include <math.h>
#include <stdio.h>

int main(void) {
  int nCases, i;
  scanf("%d", &nCases);
  for (i = 0; i < nCases; i++) {
    char begin[5], end[5]; //用 begin 和 end 分别存储棋子的起止位置。
    scanf("%s %s", begin, end);
    int x, y; //用 x 和 y 分别存储起止位置之间 x 方向和 y 方向上的距离。
    x = abs(begin[0] - end[0]);
    y = abs(begin[1] - end[1]);
    if (x == 0 && y == 0)
      printf("0 0 0 0\n"); //起止位置相同,所有棋子都走 0 步。
    else {
      if (x < y)
        printf("%d", y);
      // 王的步数
      else
        printf("%d", x);
      if (x == y || x == 0 || y == 0)
        printf(" 1"); // 后的步数
      else
        printf(" 2");
      if (x == 0 || y == 0)
        printf(" 1"); // 车的步数
      else
        printf(" 2");
      if (abs(x - y) % 2 != 0)
        printf(" Inf\n"); // 象的步数
      else if (x == y)
        printf(" 1\n");
      else
        printf(" 2\n");
    }
  }
}
