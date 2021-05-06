package me.T3;

import java.util.*;
public class ComString {

    public static void main(String[] args) {
        String Str1, Str2;

        Scanner sc = new Scanner(System.in);
        Str1 = sc.next();
        Str2 = sc.next();
        char[] str1 = Str1.toCharArray(), str2 = Str2.toCharArray(), str3 = new char[202];
        sc.close();
        str_bin(str1, str2, str3);
        System.out.print(str3);
    }
    static void str_bin(char str1[], char str2[], char str3[]) {

        for(int i = 0, j = 0,z = 0; z < str1.length + str2.length; ) {
            if(i >= str1.length) {
                str3[z++] = str2[j++];
            }
            else if(j >= str2.length) {
                str3[z++] = str1[i++];
            }
            else {
                if(str2[j] < str1[i]) {
                    str3[z++] = str2[j++];
                }
                else {
                    str3[z++] = str1[i++];
                }
            }
        }

    }
}
