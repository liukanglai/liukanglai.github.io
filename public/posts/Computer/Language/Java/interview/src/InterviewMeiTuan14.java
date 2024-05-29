import java.util.Scanner;

public class InterviewMeiTuan14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] can = new int[n];
        // 1 2 3
        for (int i = 0; i < n; i++) {
            can[i] = scanner.nextInt();
        }
        int[] have = new int[n];
        // 1 1 2
        for (int i = 0; i < n; i++) {
            have[i] = scanner.nextInt();
        }
        int[] power = new int[n];
        // 1 2 5
        for (int i = 0; i < n; i++) {
            power[i] = scanner.nextInt();
        }
        // 注意一点：只用给一个杯子加水就可得到最小法力值，没有说给多个杯子都加水的。
        int[][] minPower = new int[n][2]; // 每一个杯子两个变量，一个是加满水所用的最小法力值，一个是给哪个杯子加水，记录此杯子。

        minPower[0][0] = (can[0] - have[0]) * power[0];
        minPower[0][1] = 0;
        for (int i = 1; i < n; i++) {
            int selfPower = (can[i] - have[i]) * power[i];
            int otherPower = minPower[i - 1][0] + (can[i] - have[i]) * power[minPower[i - 1][1]];
            if (selfPower < otherPower) {
                minPower[i][0] = selfPower;
                minPower[i][1] = i;
            } else {
                minPower[i][0] = otherPower;
                minPower[i][1] = minPower[i - 1][1];
            }
        }

        int pos = scanner.nextInt();
        System.out.println(minPower[pos][0]);
    }
}
