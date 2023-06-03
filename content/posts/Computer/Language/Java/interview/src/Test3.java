/*
输入第一行包含一个正整数n，表示魔法石的数量
（1<=n<=100000)
输入第二行包含n个正整数，表示n块魔法石正面铭刻的魔法阵种类，由于魔法书上记载的魔法阵数量太多，所以魔法阵编号可能是从1到10^9的任何一个正整数
输入第三行包含n个正整数，表示n块魔法石反而正面铭刻的魔法阵种类，魔法阵编号同样在1到10^9之间
数字间两两有空格隔开

 */

import java.util.Scanner;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;

// 记录一个问题，对象值和类型值，这个hash中要插入一个新的对象，而不能用原来的对象！
public class Test3 {
    public static void main(S[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        HashMap<Integer, int[]> map = new HashMap<>();
        int key = 0; // key 表示种类
        int[] tem = new int[]{1, 0}; // 表示正面数，反面数
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            key = scanner.nextInt();
            if (map.containsKey(key)) {
                int[] newTem = map.get(key);
                newTem[0]++;
                map.put(key, newTem);
                if (newTem[0] >= n / 2.0) {
                    set.add(key);
                }
            } else {
                int [] newTem = new int[]{1,0};
                map.put(key, newTem);
            }
        }
        for (int i = 0; i < n; i++) {
            key = scanner.nextInt();
            if (map.containsKey(key)) {
                int[] newTem = map.get(key);
                newTem[1]++;
                map.put(key, newTem);
                if ((newTem[0] + newTem[1]) >= n / 2.0) {
                    set.add(key);
                }
            } else {
                int[] newTem = new int[]{0, 1};
                map.put(key, newTem);
            }
        }
        if (set.size() == 0) {
            System.out.println(-1);
            return;
        }
        Iterator<Integer> iterator = set.iterator();
        int min = n;
        // 这里需要修改一下，开始时是都正面朝上。
        while (iterator.hasNext()) {
            key = iterator.next();
            tem = map.get(key);
            if (tem[0] > n / 2.0 || tem[1] > n / 2.0) {
                System.out.println(0);
                return;
            }
            int turn = (int) Math.ceil(n/2.0 - Math.max(tem[0], tem[1]));
            // Math.floor, Math.round
            min = Math.min(min, turn);
        }
        /*
        System.out.println("Alice's age is " + map.get("Alice"));
        System.out.println("The map contains Bob: " + map.containsKey("Bob"));
        System.out.println("The map contains a value of 42: " + map.containsValue(42));
        System.out.println("The map size is: " + map.size());
         */
        System.out.println(min);
    }
}
