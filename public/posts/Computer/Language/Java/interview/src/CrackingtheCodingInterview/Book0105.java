package CrackingtheCodingInterview;

// 空字符！
public class Book0105 {
    public boolean oneEditAway(String first, String second) {
        int dis = first.length() - second.length();
        if (dis == 0) {
            int change = 1;
            for (int i = 0; i < first.length(); i++) {
                if (first.charAt(i) != second.charAt(i)) {
                    if (change != 1) {
                        return false;
                    }
                    change = 0;
                }
            }
            return true;
        }
        if (dis == 1) {
            int change = 1;
            int j = 0;
            for (int i = 0; i < second.length(); i++) {
                if (first.charAt(j) != second.charAt(i)) {
                    if (change != 1) {
                        return false;
                    }
                    change = 0;
                    i--;
                }
                j++;
            }
            return true;
        }
        if (dis == -1) {
            int change = 1;
            int j = 0;
            for (int i = 0; i < first.length(); i++) {
                if (first.charAt(i) != second.charAt(j)) {
                    if (change != 1) {
                        return false;
                    }
                    change = 0;
                    i--;
                }
                j++;
            }
            return true;
        }
        return false;
    }
    // 你能一次完成三次检查吗？
}
