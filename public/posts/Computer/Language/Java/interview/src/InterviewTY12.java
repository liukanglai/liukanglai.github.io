import java.util.Scanner;

public class InterviewTY12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        char[] b = new char[n];
        String str = scanner.next();
        b = str.toCharArray();
        int BMax = -10000000, BMin = 10000000;
        for (int i = 0; i < n; i++) {
            if (b[i] == 'B') {
                BMax = Math.max(BMax, a[i]);
                BMin = Math.min(BMin, a[i]);
            }
        }
        int RMax = -10000000, RMin = 10000000;
        for (int i = 0; i < n; i++) {
            if (b[i] == 'R') {
                RMax = Math.max(RMax, a[i]);
                RMin = Math.min(RMin, a[i]);
            }
        }
        long m1 = (long) BMax *RMax;
        long m2 = (long) BMax *RMin;
        long m3 = (long) BMin *RMax;
        long m4 = (long) BMin *RMin;
        //System.out.println(Math.max(Math.max(Math.max(BMax*RMax, BMax*RMin), BMin*RMax), BMin*RMin));
        System.out.println(Math.max(Math.max(Math.max(m1, m2), m3), m4));
    }
}