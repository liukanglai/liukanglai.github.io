package com.google;

//import java.util.Scanner;

import javax.swing.*;

public class ComputeArea {
    public static void main(String[] args) {
        final double Pi = 3.14159;
        double radius, area;
        // Step1: Read in radius
        //System.out.println("Please input the radius:");
        String TemRadius = JOptionPane.showInputDialog(null, "Please input the radius");
        /*
         Scanner sc = new Scanner(System.in);
         radius = sc.nextDouble();
         System.out.println("The radius is:"+radius);
         sc.close();
         radius = 20.0;
        */

        JOptionPane.showMessageDialog(null, "The radius is:"+TemRadius);
        radius = Integer.parseInt(TemRadius);
        // Step2: Compute area
        area = radius * radius * Pi;
        /* Step3: Display the area */
        //System.out.println("Area is " +area);
        JOptionPane.showMessageDialog(null, "The area is:"+area);
    }
}
