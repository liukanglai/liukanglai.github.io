package me.T3;

import javax.swing.*;
import java.util.Random;
import java.util.Scanner;

/**
 * @author liukanglai
 * @date 4/5/21 - 8:59 PM
 */
public class DiceNumberGame {
    public static void main(String[] args) {
        Game toss_a_dice = new Game();
        toss_a_dice.throw1();
        toss_a_dice.guess();
        toss_a_dice.putResult();
    }
}

class Game {
    int v = 1, num;

    void throw1() {
        double number = Math.random() * 6;
        if(number < 1) {
            v = 1;
        }
        else if(number < 2) {
            v = 2;
        }
        else if(number < 3) {
            v = 3;
        }
        else if(number < 4) {
            v = 4;
        }
        else if(number < 5) {
            v = 5;
        }
        else if(number < 6) {
            v = 6;
        }
    }

    void guess() {
        String tem_num = JOptionPane.showInputDialog(null, "Guess a number:");
        num = Integer.parseInt(tem_num);
    }

    void putResult() {
        if(num > v) {
            System.out.println("大了");
        }
        else if(num == v) {
            System.out.println("猜测成功");
        }
        else if(num < v) {
            System.out.println("小了");
        }
        System.out.println("正确结果："+v);
    }
}
