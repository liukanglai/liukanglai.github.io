import java.util.HashMap;

public class InterviewGF12 {
        public String findLetterPairs (String str) {
            // write code here
            int[] a = new int[27];
            char[] b = new char[27];
            int flag = 1;
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                //String st = str.substring(i, i+1);
                char st = str.charAt(i);
                if(st >= 'A'  && st <= 'Z'){
                    int pos = st-'A';
                    if(a[pos] == 1){
                        a[pos] = -1;
                        if(flag == 1){
                            flag = 0;
                            s.append("true ");
                        }
                        s.append(b[pos]);
                    }else if(a[pos] == 0){
                        a[pos] = 1;
                        b[pos] = st;
                    }
                }else if(st >= 'a' && st <='z'){
                    int pos = st-'a';
                    if(a[pos] == 1){
                        a[pos] = -1;
                        if(flag == 1){
                            flag = 0;
                            s.append("true ");
                        }
                        s.append(b[pos]);
                    }else if(a[pos] == 0){
                        a[pos] = 1;
                        b[pos] = st;
                    }
                }
            }
            if(flag == 1){
                return "false";
            }
            else
                return s.toString();
        }

    public static void main(String[] args) {
        InterviewGF12 a = new InterviewGF12();
        System.out.println(a.findLetterPairs("你你好好A1133aa"));
        int x = 20;
        int y = 5;
        System.out.println(x+y+"j"+(x+y)+y);
    }
}
