
import java.util.Scanner;

public class InterviewMeiTuan11 {
    /*
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        // 1 2 4 2 5
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        // 1 - 2 * 4 /
        String str;
        scanner.nextLine();
        str = scanner.nextLine();
        int pos = 0;
        String op;
        float[] sum = new float[m];
        for (int i = 0; i < m; i++) {
            pos = Integer.parseInt(str.substring(i * 4, i * 4 + 1));
            op = str.substring(i * 4 + 2, i * 4 + 3);
            for (int j = 0; j < n; j++) {
                if (j == pos - 1) {
                    if (op.equals("+")) {
                        sum[i] += (num[j] + num[j + 1]);
                    } else if (op.equals("-")) {
                        sum[i] += (num[j] - num[j + 1]);
                    } else if (op.equals("*")) {
                        sum[i] += (num[j] * num[j + 1]);
                    } else if (op.equals("/")) {
                        sum[i] += (((float)num[j] / num[j + 1]));
                    }
                    j += 1;
                } else {
                    sum[i] += num[j];
                }
            }
        }
        for (int i = 0; i < m; i++) {
            // 四舍五入？
            if(sum[i]*100%10 >=5){

                System.out.printf("%.1f", sum[i]+0.1);
            }else {
                System.out.printf("%.1f", sum[i]);

            }
            System.out.print(' ');
        }
    }

     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        // 1 2 4 2 5
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        // 1 - 2 * 4 /
        int pos = 0;
        String op;
        float[] sum = new float[m]; // 改为double，。。。。。。
        int all = 0;
        for (int i = 0; i < n; i++) {
            all += num[i];
        }
        // 时间太长
        for (int i = 0; i < m; i++) {
            pos = scanner.nextInt();
            op = scanner.next();
            int j = pos - 1;
            if (op.equals("+")) {
                sum[i] = all;
            } else if (op.equals("-")) {
                sum[i] = all - num[j] - num[j+1];
                sum[i] += (num[j] - num[j + 1]);
            } else if (op.equals("*")) {
                sum[i] = all - num[j] - num[j+1];
                sum[i] += (num[j] * num[j + 1]);
            } else if (op.equals("/")) {
                sum[i] = all - num[j] - num[j+1];
                sum[i] += (((float) num[j] / num[j + 1]));
            }
        }
        for (int i = 0; i < m; i++) {
            System.out.printf("%.1f", sum[i]);
            System.out.print(' ');
        }
    }

}
