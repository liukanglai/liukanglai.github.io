package me.T3;

import java.util.Scanner;

/**
 * @author liukanglai
 * @date 4/5/21 - 8:01 PM
 */
public class 长方形 {

    double length, width, height, S, L;

    public 长方形(Scanner sc) {
        this.length = sc.nextDouble();
        this.width = sc.nextDouble();
        this.height = sc.nextDouble();
    }
    public 长方形(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }
    public 长方形() {
        this.length = 10;
        this.width = 10;
        this.height = 10;
    }
    protected void setBox(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    protected double getArea() {
        return 2 * (length * height + length * width + height * width);
    }

    protected double getL() {
        return length * width * height;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        长方形 一个矩形1 = new 长方形();
        长方形 一个矩形2 = new 长方形(10, 10, 10);
        //长方形 一个矩形3 = new 长方形(sc);
        一个矩形1.setBox(10, 10 ,10);
        一个矩形1.S = 一个矩形1.getArea();
        一个矩形1.L = 一个矩形1.getL();
        System.out.println("长: "+一个矩形1.length+" 宽: "+一个矩形1.width+" 高: "+一个矩形1.height+" 面积: "+一个矩形1.S+" 体积: "+一个矩形1.L);
        sc.close();
    }
}
