package CrackingtheCodingInterview;

import java.util.HashMap;
import java.util.Map;

// 位向量？？？抄一下代码，感受感受。
public class Book0104 {
    public boolean canPermutePalindrome(String s) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            String str1 = s.substring(i, i + 1);
            if (hashMap.containsKey(str1)) {
                hashMap.put(str1, hashMap.get(str1) + 1);
            } else {
                hashMap.put(str1, 1);
            }
        }
        int flag = 0;
        for (HashMap.Entry<String, Integer> entry : hashMap.entrySet()) {
            Integer value = entry.getValue();
            if (value % 2 != 0) {
                if (flag == 0) {
                    flag = 1;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
