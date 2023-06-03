package CrackingtheCodingInterview;

import java.util.Stack;

// 优化！
public class Book0103 {
    public String replaceSpaces(String S, int length) {
        char[] charArray = S.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (charArray[i] == ' ') {
                sb.append('%');
                sb.append('2');
                sb.append('0');
            } else {
                sb.append(charArray[i]);
            }
        }
        // 将 StringBuilder 对象转换为字符串并输出
        return sb.toString();
    }
}