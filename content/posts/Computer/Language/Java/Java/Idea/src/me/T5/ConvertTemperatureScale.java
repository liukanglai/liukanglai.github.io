package me.T5;

import javax.swing.*;

import static javax.swing.JOptionPane.showInputDialog;

/**
 * @author liukanglai
 * @date 4/14/21 - 3:25 PM
 */

public class ConvertTemperatureScale {
    public static void main(String[] args) {
        double fahrenheit, celsius;
        for(int i = 0; i < 1;) {
            String input_string = JOptionPane.showInputDialog(null, "Please input a fahrenheit:");
            try {
                fahrenheit = Integer.parseInt(input_string);
                celsius = convert(fahrenheit);
                JOptionPane.showMessageDialog(null, "The celsius is:" + celsius);
                i++;
            } catch (NumberFormatException e) {
                System.out.println("输入不是有效温度值");
                System.out.println(e.getMessage());
                //e.printStackTrace();
            } finally {
                //System.out.println(1);
            }
        }
    }
    static double convert(double fahrenheit) {
        return 5 * (fahrenheit - 32) / 9;
    }
}