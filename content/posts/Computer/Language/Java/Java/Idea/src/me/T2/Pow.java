//package com.me;

import java.util.Scanner;

public class Pow {
    public static void main(String[] args) {
        int a, b;
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        double c = Math.pow(a,b);
        if(c < 1 && c > -1)
            System.out.println(c);
        else
            System.out.println((int)c);
        sc.close();
    }
}
