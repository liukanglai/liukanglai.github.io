package com.google;

import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.StringTokenizer;

/**
 * @author liukanglai
 * @date 4/3/21 - 11:09 AM
 */
public class StringTurn {
    public static void main(String[] args) {
        String str = "Test";
        String str1 = "Test1";
        int str_length = str.length();
        str.toLowerCase(Locale.ROOT);
        str.toUpperCase(Locale.ROOT);
        str.equals(str1);
        str.compareTo(str);
        str.equalsIgnoreCase(str);
        int x = Integer.parseInt(str);
        float y = Float.parseFloat(str);
        String str2 = String.valueOf(x);
        String str3 = String.valueOf(y);
        byte[] z = str.getBytes(StandardCharsets.UTF_8);
        //String(byte[], int offset, int length);
        int g = str.charAt('e');
        String str4 = str1.substring(2,4);
        str4 = str.concat(str);
        String s = "I, love, you";
        StringTokenizer st = new StringTokenizer(s, ",");
        while (st.hasMoreElements()){
            String st1 = (String) st.nextToken();
            System.out.println(str1);

        }

    }
}
