import java.util.Scanner;

public class InterviewTY11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long sum = 1;
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                sum += 1;
            } else {
                sum *= 2;
            }
            sum = sum %1000000007;
        }
        System.out.println(sum%1000000007);
    }
}