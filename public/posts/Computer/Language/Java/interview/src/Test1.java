
// https://blog.csdn.net/qq_36178962/article/details/126193767
import java.util.Scanner;

public class Test1 {
  public static void main(S[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    // nextFloat();
    // scanner.nextDouble();
    // scanner.next(); for String
    // scanner.nextLine(); // 读取一行输入并获取字符串
    for (int i = 0; i < n; i++) {
      int A = scanner.nextInt(), B = scanner.nextInt();
      System.out.println(calcgift(A, B));
    }
    scanner.close();
  }

  public static int calcgift(int A, int B) {
    return Math.min(Math.min(A, B), (A + B) / 3);
  }
}
