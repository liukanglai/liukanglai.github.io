//package com.me;

import java.util.Scanner;

public class ReciprocalPositive {
    public static void  main(String[] args) {
        long positive;
        Scanner sc = new Scanner(System.in);
        positive = sc.nextLong();
        if(positive == 0)
            System.out.println(0);
        while(positive > 0) {
            System.out.print(positive%10);
            positive /= 10;
        }
        sc.close();
    }
}
