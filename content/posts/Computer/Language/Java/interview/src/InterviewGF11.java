import java.util.Arrays;

public class InterviewGF11 {
    public String toBase36(long num, String strPre) {
        // write code here
        int mod = 0;
        int[] str = new int[8];
        int i = str.length - 1;
        while (num > 0 && i >=0) {
            mod = (int) (num % 36);
            num /= 36;
            if(mod < 10){
                str[i--] = (char) mod;
            }
            else {
                int st = ('A' + mod-10);
                str[i--] = st;
            }
        }
        StringBuilder s = new StringBuilder(strPre);
        for (int j = 0; j < 8; j++) {
            if(str[j] < 9){
                s.append(str[j]);
            }else
            s.append((char)str[j]);
        }
        System.out.println(s);
        return s.toString();
    }

    public static void main(String[] args) {
        InterviewGF11 a = new InterviewGF11();
        a.toBase36(10000, "20220101");
    }
}
