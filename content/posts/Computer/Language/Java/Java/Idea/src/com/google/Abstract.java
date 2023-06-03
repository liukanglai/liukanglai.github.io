package com.google;

/**
 * @author liukanglai
 * @date 4/4/21 - 10:09 AM
 */
public class Abstract {
    public static void main(String[] args) {

        Home my = new Room();
        my.Put();
    }

}

abstract class Home {
    void Put() {
        System.out.println('1');
    }

}

class Room extends Home {

}