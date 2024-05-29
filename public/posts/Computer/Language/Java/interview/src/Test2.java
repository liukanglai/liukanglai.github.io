import java.util.Scanner;

public class Test2 {
  // 1. 注意要把前后的计算分开想，这样简化了，不要一上来就考虑全面，分治。
  // 2. 注意动态规划的实质：重复子问题，后面用到了前面的结果。
  public static void main(S[] args) {
    Scanner scanner = new Scanner(System.in);
    int num = scanner.nextInt();
    int[] nums = new int[num];
    int[] prev = new int[num + 1];
    prev[0] = 0;
    int[] next = new int[num + 1];
    next[num] = 0;
    // 先考虑前异常
    for (int i = 0; i < num; i++) {
      nums[i] = scanner.nextInt();
      if (nums[i] >= 0) {
        prev[i + 1] = prev[i] + 1;
      } else
        prev[i + 1] = prev[i];
    }
    // 后异常
    for (int i = num - 1; i >= 0; i--) {
      if (nums[i] <= 0) {
        next[i] = next[i + 1] + 1;
      } else
        next[i] = next[i + 1];
    }
    int min = num;
    for (int i = 0; i <= num; i++) {
      min = Math.min((prev[i] + next[i]), min);
    }
    System.out.println(min);
  }
}
