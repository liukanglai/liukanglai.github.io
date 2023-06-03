
import java.util.Scanner;

public class InterviewJD11 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    /*
    while (scanner.hasNextInt()) {
      int b = scanner.nextInt();
    }

     */
    String str1 = scanner.next();
    String str2 = scanner.next();
    String str11;
    String str12;
    int str111;
    int str112;
    int min= 10000;
    int sum = 0;
    for (int i = 0; i < 4; i++) {
      str11 = str1.substring(i, i + 1);
      str12 = str2.substring(i, i + 1);
      str111 = Integer.parseInt(str11);
      str112 = Integer.parseInt(str12);
      int width = str111 - str112;
      if (width < 0) {
        width = str112 - str111;
        if (width < (10 - str112 + str111)) {
          min = width;
        } else {
          min = 10 - str112 + str111;
        }
        sum += min;
      } else {
        if (width < (10 - str111 + str112)) {
          min = width;
        } else {
          min = 10 - str111 + str112;
        }
        sum += min;
      }
    }
    System.out.println(sum);
  }

}
