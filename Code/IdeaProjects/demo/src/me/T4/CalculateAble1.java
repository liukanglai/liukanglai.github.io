package me.T4;

import java.util.*;

public class CalculateAble1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double radius;
		Scanner sc = new Scanner(System.in);
		radius = sc.nextDouble();
		CalculateAble2 circle = new CalculateAble2();
		circle.radius = radius;
		circle.getArea();
		sc.close();
	}

}

class CalculateAble2 implements CalculateAble {
	double radius;
	public double getArea() {
		double PI = 3.14, area;
		area = PI * radius * radius;
		System.out.print("Circle Area=");
		System.out.println(area);
		
		return area;
	}


}