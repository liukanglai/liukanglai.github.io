package com.google;


public class Letter {
    public static void main(String[] args) {
        System.out.println("letter a in unicode location"+(int)'a');
        int cout = 1;
        System.out.println("letter");

            if((cout/10) == 1) {
                System.out.print('\n');
                cout = 0;
            }
            else {
                System.out.printf(" ");
            }
        }
    }
