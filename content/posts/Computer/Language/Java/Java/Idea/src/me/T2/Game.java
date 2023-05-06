//package com.me;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        char a, b, c;
        char number;
        Scanner sc = new Scanner(System.in);
        number = sc.next().charAt(0);
        for(a = 'x'; a <= 'z'; a++) {
            for(b = 'x'; b <= 'z'; b++) {
                if(a != b) {
                    for(c = 'x'; c <= 'z'; c++) {
                        if(a != c && b != c) {
                            if(a != 'x' && c != 'x' && c != 'z') {
                                switch (number) {
                                    case 'a': System.out.println(a); break;
                                    case 'b': System.out.println(b); break;
                                    case 'c': System.out.println(c); break;
                                    default: {
                                        if(number == a) {
                                            System.out.println('a');
                                        }
                                        if(number == b){
                                            System.out.println('b');
                                        }
                                        if(number == c){
                                            System.out.println('c');
                                        }
                                    }
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
        sc.close();
    }
}
