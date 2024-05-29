
import java.util.Scanner;

public class InterviewMeiTuan23 {
    public static int minCost(int n, int m, int s, int[] a) {
        int[][] maxValues = new int[n][n];
        int[][] minValues = new int[n][n];

        for (int i = 0; i < n; i++) {
            maxValues[i][i] = minValues[i][i] = a[i];
            for (int j = i + 1; j < n; j++) {
                maxValues[i][j] = Math.max(maxValues[i][j - 1], a[j]);
                minValues[i][j] = Math.min(minValues[i][j - 1], a[j]);
            }
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int k = 1; k <= m && i - k >= 0; k++) {
                int cost = k * ((maxValues[i - k][i - 1] + minValues[i - k][i - 1]) / 2) + s;
                dp[i] = Math.min(dp[i], dp[i - k] + cost);
            }
        }

        return dp[n];
    }
    static class A{
        long final_cost = 100000000;
        int n;
        int m;
        int s;
        int[] num;
        A(int n, int m , int s, int[] num){
            this.n = n;
            this.m = m;
            this.s = s;
            this.num = num;
        }
        void cmpCost(long cost, int have){
            if(have == 0){
                final_cost = Math.min(cost, final_cost);
            }
            for (int i = 1; i <= m; i++) {
                if(i > have){
                    break;
                }
                else {
                    int u = 0;
                    int v = 10000000;
                    for (int j = n-have; j < n-have+i; j++) {
                        u = Math.max(u, num[j]);
                        v = Math.min(v, num[j]);
                    }
                    cmpCost(cost+ (long) (i * Math.floor((u+v)/2.0)+s) , have-i);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int s = scanner.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = scanner.nextInt();
        }
        A a = new A(n, m,s,num);
        a.cmpCost(0, n);
        System.out.println(a.final_cost);
    }
}
