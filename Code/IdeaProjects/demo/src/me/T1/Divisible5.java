//package com.google;

import java.util.Scanner;

public class Divisible5 {
    public static void main(String[] args) {
        int TheInputNum;
        Scanner sc = new Scanner(System.in);
        TheInputNum = sc.nextInt();
        if(TheInputNum % 5 == 0) {
            System.out.println("yes");
        }
        else {
            System.out.println("no");
        }
    }
}
