package CrackingtheCodingInterview;

// 关于最后的跳出，有问题，很多小细节都有问题
public class Book0106 {
    public static String compressString(String S) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            char char1 = S.charAt(i);
            int count = 1;
            sb.append(char1);
            int j = i+1;
            for (; j < S.length(); j++) {
                char char2 = S.charAt(j);
                if (char1 == char2) {
                    count++;
                } else {
                    break;
                }
            }
            i = j - 1;
            sb.append(count);
        }
        if (S.length() <= sb.length()) {
            return S;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(compressString("aabcccccaa"));
    }
}
