import java.util.HashMap;
import java.util.Scanner;

public class InterviewMeiTuan22 {
    static int n;
    static int x;
    static int y;
    static int[] node;
    static int max = 0;

    static void maxLength(int from, int length) {
        for (int i = 0; i < n - 1; i++) {
            if (node[i] == from + 1) {
                if (from == x - 1) {
                    maxLength(y - 1, length + 1);
                    break;
                }
                if (from == y - 1) {
                    maxLength(x - 1, length + 1);
                    break;
                }
                maxLength(i + 1, length + 1);
            }
        }
        max = Math.max(length, max);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        node = new int[n-1];
        for (int i = 0; i < n - 1; i++) {
            node[i] = scanner.nextInt();
        }
        x = scanner.nextInt();
        y = scanner.nextInt();
        maxLength(0, 0);
        System.out.println(max);
    }
}
