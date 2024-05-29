
import java.util.Scanner;

public class InterviewMeiTuan21 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int m = scanner.nextInt();
    int a = scanner.nextInt();
    int[][][] table = new int[n][m][a];
    String str;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        str = scanner.next();
        for (int k = 0; k < a; k++) {
          table[i][j][k] = Integer.parseInt(str.substring(k,k+1));
        }
      }
    }
    int change = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        for (int k = 0; k < a; k++) {
          if(table[i][j][k] != table[(i+1)%n][(j+1)%m][k]){
            change++;
          }
        }
      }
    }
    System.out.println(change);
  }
}
