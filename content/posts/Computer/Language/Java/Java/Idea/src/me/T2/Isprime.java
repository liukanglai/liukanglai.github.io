//package com.me;

import java.util.Scanner;

public class Isprime {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        if(n == 0 || n == 1) {
            System.out.println("0");
        }
        else {
            if (isPrime(n)) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }
    }
    private static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
