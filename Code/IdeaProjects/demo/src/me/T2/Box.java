package com.me;

public class Box {
    public static void main(String[] args) {
        int red, yellow, black, white;
        for(red = 1; red <=4; red++) {
            for(yellow = 1; yellow <=4; yellow++) {
                for(black = 1; black <= 4; black++) {
                    for(white = 1; white <= 4; white++) {
                        int[] sum = {red, yellow, black, white};
                        int flag = 0;
                        for(int i = 0; i < 4; i++) {
                            for(int j = i+1; j < 4; j++) {
                                if(sum[i] == sum [j])
                                    flag = 1;
                            }
                        }
                        if(flag == 0) {
                            if((black == 1 ^ yellow == 2) && (black == 2 ^ white == 3) && (red == 2 ^ white == 4)) {
                                System.out.println("red in: "+red);
                                System.out.println("yellow in: "+yellow);
                                System.out.println("black in: "+black);
                                System.out.println("white in: "+white);
                                return;
                            }
                        }
                    }
                }
            }
        }
    }
}
