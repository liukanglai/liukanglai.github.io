package CrackingtheCodingInterview;

// 判定是否互为字符重排。给定两个字符串,请编写程序,确定其中一个字符串的字符重新排列后,能否变成另一个字符串。

// 1. 定义？
// 2. 定义？
// 1. 定义？
// 1. 定义？

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Book0102 {
    public boolean CheckPermutationSort(String s1, String s2) {
        char[] charArray1 = s1.toCharArray();
        char[] charArray2 = s2.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);
        if (Arrays.equals(charArray1, charArray2)) {
            return true;
        }
        return false;
    }

    public boolean CheckPermutation(String s1, String s2) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char char1 = s1.charAt(i);
            if (hashMap.containsKey(String.valueOf(char1))) {
                hashMap.put(String.valueOf(char1), hashMap.get(String.valueOf(char1)) + 1);
            } else {
                hashMap.put(String.valueOf(char1), 1);
            }
        }
        for (int i = 0; i < s2.length(); i++) {
            char char1 = s2.charAt(i);
            if (hashMap.containsKey(String.valueOf(char1))) {
                if (hashMap.get(String.valueOf(char1)) == 0) { // 可优化，考虑字符长度！
                    return false;
                }
                hashMap.put(String.valueOf(char1), hashMap.get(String.valueOf(char1)) - 1);
            } else {
                return false;
            }
        }
        for (HashMap.Entry<String, Integer> entry : hashMap.entrySet()) {
            Integer value = entry.getValue();
            if(value != 0){
                return false;
            }
        }
        return true;
    }
}
