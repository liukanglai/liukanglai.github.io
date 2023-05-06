package com.google;

import java.util.Scanner;

public class NarcissisticNumber {
        public static void main(String[] args) {
            int TheEndNum;
            Scanner sc = new Scanner(System.in);
            TheEndNum = sc.nextInt();
            int TheStartNum = 100;
            for(; TheStartNum <= TheEndNum; TheStartNum++) {
                int TemNum1, TemNum2, TemNum3;
                TemNum1 = TheStartNum / 100;
                TemNum2 = (TheStartNum / 10) % 10;
                TemNum3 = TheStartNum % 10;
                if(TheStartNum == (Math.pow(TemNum1,3) + Math.pow(TemNum2,3) + Math.pow(TemNum3,3))) {
                    System.out.println(TheStartNum);
                }
            }
        }
}
