//package com.google;

import java.util.Scanner;

public class ReverseOutput {
    public static void main(String[] args) {
        int TheInputNum;
        Scanner sc = new Scanner(System.in);
        TheInputNum = sc.nextInt();
        if(TheInputNum >= 100 && TheInputNum < 1000) {
            int TemNum1, TemNum2, TemNum3;
            TemNum1 = TheInputNum / 100;
            TemNum2 = (TheInputNum / 10) % 10;
            TemNum3 = TheInputNum % 10;
            if(TemNum3 != 0) {
                System.out.print(TemNum3);
            }
            if(TemNum3 != 0 || TemNum2 != 0) {
                System.out.print(TemNum2);
            }
            System.out.println(TemNum1);
            sc.close();
        }
        else {
            System.out.println("-1");
        }
    }
}
