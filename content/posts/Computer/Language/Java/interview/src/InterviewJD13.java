
import java.util.Scanner;

public class InterviewJD13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        String str1;
        int rNum = 0;
        int eNum = 0;
        int dNum = 0;
        int aNum = 0;
        for (int i = 0; i < str.length(); i++) {
            str1 = str.substring(i, i + 1);
            if (str1.equals("r")) {
                rNum++;
            } else if (str1.equals("e")) {
                eNum++;
            } else if (str1.equals("d")) {
                dNum++;
            } else {
                aNum++;
            }
        }
        if (str.length() % 3 != 0) {
            System.out.println(0);
        } else {
            int max1 = Math.max(rNum, Math.max(eNum, dNum));
            int min1 = Math.min(rNum, Math.min(eNum, dNum));
            int mid = 0;
            if (rNum > eNum) {
                if (eNum > dNum) {
                    mid = eNum;
                } else {
                    if (rNum > dNum) {
                        mid = dNum;
                    } else {
                        mid = rNum;
                    }
                }
            } else {
                if (rNum > dNum) {
                    mid = rNum;
                } else {
                    if (eNum > dNum) {
                        mid = dNum;
                    } else {
                        mid = eNum;
                    }
                }
            }
            if (max1 > (mid + min1 + aNum) / 2) {
                System.out.println(0);
            } else if (max1 == (mid + min1 + aNum) / 2) {
                if (mid == min1) {
                    int num = 1;
                    int num1 = 1;
                    for (int i = aNum; i > mid; i--) {
                        num *= i;
                    }
                    for (int i = 1; i < mid + 1; i++) {
                        num1 *= i;
                    }
                    num /= num1;
                    System.out.println(num);
                }
            } else {
                int other = str.length() - max1 * 3;
                if (mid == min1) {
                    int num = 1;
                    int num1 = 1;
                    for (int i = aNum; i > mid; i--) {
                        num *= i;
                    }
                    for (int i = 1; i < mid + 1; i++) {
                        num1 *= i;
                    }
                    num /= num1;
                    System.out.println(num);
                } else {
                    System.out.println(other / 3 + 1); //
                }
            }
        }
    }
}