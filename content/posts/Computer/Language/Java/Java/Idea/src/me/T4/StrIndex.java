package me.T4;

import java.util.*;

public class StrIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s, t;
		Scanner sc = new Scanner(System.in);
		s = sc.nextLine();
		t = sc.next();
		int max = 0;
	for (int i = 0; i < s.length(); i++) {
		     if (i <= s.length() - t.length()) {
		        if (s.regionMatches(true, i, t, 0, t.length())) {
		          max = i > max ? i : max;
		 	}  
		 }
	}
	
	System.out.println(max);
		
	}
}
