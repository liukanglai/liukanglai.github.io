//cosx = 1 - x2/2! + x4/4! - x6/6! + ... + (-1)nx2n/(2n)!
package me.T4;

import java.util.*;

public class GetCos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double x;
		int n;
		Scanner sc = new Scanner(System.in);
		x = sc.nextDouble();
		n = sc.nextInt();
		if(n == 0) {
			System.out.println("1.00000000");
		}
		else {
			double cosx = 1;
			for(int i = 1; i <= n; i++) {
				double factorial = 1;
			
				for(int j = 2*i; j > 0; j--) {
					factorial *= j;
				}
				cosx += ((Math.pow(-1, i)) * (Math.pow(x, 2*i))) / factorial;
				//System.out.println(factorial);
			}
			System.out.printf("%.8f", cosx);
		}
		sc.close();
	}

}


