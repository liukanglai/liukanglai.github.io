/*
  小美正在整理桌子上的一排装饰品。小美对待装饰品摆放方式的审美角度很奇特，她认为高度相差比较大的装饰品放在相邻位置会很难看，她想对这一排装饰品进行整理，可以交换任意两个装饰品的位置任意多次。假设当前从左到右n个装饰品的高度分别为h1,h2,...,hn，那么当前这一排装饰品的丑陋值为，其中|x|为x的绝对值。小美想最小化她的装饰品的丑陋值，请你帮她排一下顺序。

       形式化地来讲，有一长为n的序列a1,a2,...,an，你可以任意次数地进行交换，每次交换都可以选择任意两个不同的数i,j,交换ai,aj的位置。假设经过若干次交换后，序列变为h1,h2,...,hn，其丑陋值为 ，你需要找出一种交换方式，使得最终序列{hn}的丑陋值最小化。你不需要输出具体交换方式，只需要输出最终的{hn}序列的丑陋值即可。
 */
import java.util.Arrays;
import java.util.Scanner;

public class InterviewMeiTuan12 {
    public static void main(String[] args) {

        /*
        int[] numbers = {5, 2, 8, 1, 3};
        Arrays.sort(numbers);
        System.out.println("排序后的整数数组： " + Arrays.toString(numbers));

         */

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = scanner.nextInt();
        }
        int [] sort = new int[n];
        sort = Arrays.stream(num).sorted().toArray();
        int sum = 0;
        for (int i = 1; i < n; i++) {
            if((sort[i] - sort[i-1] >= 0)){
                sum += sort[i] - sort[i-1];
            }else {
                sum += sort[i-1] - sort[i];
            }
        }
        System.out.print(sum);
        // System.out.print(' ');
    }
}
