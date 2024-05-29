import java.util.Arrays;
import java.util.Scanner;

public class NowCoderIO {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /* 1
        while (scanner.hasNext()){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println(a+b);
        }

         */
        /* 2
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println(a+b);
        }
         */
        /*
        while (true){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if(a == 0 && b == 0){
                break;
            }
            System.out.println(a+b);
        }
         */
        // 7!
        while (scanner.hasNextLine()) {
            String[] num = scanner.nextLine().split(" ");
            int sum = 0;  // 每一轮要将sum重置一下
            for (int i = 0; i < num.length; i++) {
                sum += Integer.parseInt(num[i]);
            }
            System.out.println(sum);
        }
        // 8!
        int n = scanner.nextInt();
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = scanner.next();

        }
        Arrays.sort(str);
        for (int i = 0; i < str.length - 1; i++) {
            // 如何消除结尾空格？
            System.out.print(str[i] + " ");
        }
        System.out.println(str[str.length - 1]);
        // 9 和 10!
        while (scanner.hasNextLine()) {
            // 最后一个字符串后面有没有空格不重要，以“ ”分割就行了
            String[] array = scanner.nextLine().split(",");
            // 排序
            Arrays.sort(array);
            for (int i = 0; i < array.length - 1; i++) {
                System.out.print(array[i] + ",");
            }
            System.out.println(array[array.length - 1]); ///避免最后多个 结尾空格

        }
        // 11
        while (scanner.hasNextLong()){
            Long a = scanner.nextLong();
            Long b = scanner.nextLong();
            System.out.println(a+b);
        }
    }
}
