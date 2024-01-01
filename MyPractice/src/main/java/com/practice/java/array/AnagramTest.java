package com.practice.java.array;

import java.util.Arrays;

public class AnagramTest {

	public static void main(String[] args) {
		
		String s1= "race";
		String s2 = "care";
		
		if(s1.length()==s2.length()) {
			
			char[] charArray1 = s1.toCharArray();
		      char[] charArray2 = s2.toCharArray();
		      
			Arrays.sort(charArray1);
		    Arrays.sort(charArray2);
			System.out.println(Arrays.equals(charArray1, charArray2));
		}
		
	}
}
