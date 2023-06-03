package CrackingtheCodingInterview;

// 1.1 判定字符是否唯一。实现一个算法,确定一个字符串的所有字符是否全都不同。假使不允许使用额外的数据结构,又该如何处理?

// 1. 上面的字符串是 ASCII 字符串还是 Unicode 字符串
// 2. 使用位向量?
// 3. 找出时间复杂度为O(NlogN)的算法?


// use str.charAt(i); !!!

import java.util.HashMap;
import java.util.Scanner;

public class Book0101 {
    public static boolean isUniqueHash(String str) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            String str1 = str.substring(i, i + 1);
            if (hashMap.containsKey(str1)) {
                return false;
            } else {
                hashMap.put(str1, 1);
            }
        }
        return true;
    }

    public static boolean isUniqueNoSpace(String str) {
        for (int i = 0; i < str.length(); i++) {
            String str1 = str.substring(i, i + 1);
            for (int j = i + 1; j < str.length(); j++) {
                String str2 = str.substring(j, j + 1);
                if (str1.equals(str2)) {
                    return false;
                }
            }
        }
        return true;
    }

    boolean isUniqueChars(String str) {
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) {
                return false;
            }
            checker |= (1 << val);
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(isUniqueHash(str));
    }
}
