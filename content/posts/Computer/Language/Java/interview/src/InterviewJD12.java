
import java.util.Scanner;

public class InterviewJD12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        String str1;
        String str2;
        String str3;
        int sum = 0;
        for (int i = 0; i < str.length() - 1; i++) {
            str1 = str.substring(i, i + 1);
            str2 = str.substring(i + 1, i + 2);
            if (str1.equals(str2)) {
                if(i != str.length()-2) {
                    str3 = str.substring(i + 2, i + 3);
                    if (str1.equals(str3)) {
                        i++;
                    }
                }
                sum++;
                i++;
            }
        }
        System.out.println(sum);
    }
}
