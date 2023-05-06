package com.me;

public class Money {
    public static void main(String[] args) {
        int cock, hen, chick;
        for(chick = 0; chick < 100; chick += 3) {
            for(cock = 0; cock < 20; cock++) {
                hen = 100 - cock - chick;
                if(hen < 0)
                    return;
                if((5*cock + 3*hen +chick/3) == 100) {
                    System.out.print("公鸡: "+cock);
                    System.out.print(" 母鸡: "+hen);
                    System.out.print(" 小鸡: "+chick+"\n");
                }
            }
        }
    }
}
