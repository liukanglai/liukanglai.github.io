import java.util.Scanner;

public class InterviewMeiTuan13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] beauty = new int[n];
        int[] op = new int[m];
        for (int i = 0; i < m; i++) {
            op[i] = scanner.nextInt();
        }
        int[] x = new int[m];
        for (int i = 0; i < m; i++) {
            x[i] = scanner.nextInt();
        }
        int[] y = new int[m];
        for (int i = 0; i < m; i++) {
            y[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            if(op[i] == 1){
                int sum = 0;
                for (int j = x[i]-1; j < y[i]; j++) {
                    sum += beauty[j];
                }
                System.out.print(sum);
                System.out.print(' ');
            }
            if(op[i] == 0){
                beauty[x[i]-1] = y[i];
            }
        }
    }
}
