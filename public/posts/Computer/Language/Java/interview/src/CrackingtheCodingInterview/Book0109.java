package CrackingtheCodingInterview;

public class Book0109 {
    public boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) { // s1 = "", s2 = ""
            return true;
        }
        int k = 0;
        for (int i = 0; i < s1.length(); i++) {
            int j = i;
            while (s2.charAt(k++) == s1.charAt((j++) % s1.length()) && k < s2.length()) ;
            if (k == s2.length() && s2.charAt(k - 1) == s1.charAt((j - 1) % s1.length())) {
                return true;
            }
            k = 0;
        }
        return false;
    }
}
