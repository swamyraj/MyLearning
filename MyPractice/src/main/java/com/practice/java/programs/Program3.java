package com.practice.java.programs;

import java.util.Map;
import java.util.stream.Collectors;

public class Program3 {

	public static void main(String[] args) {

		// Custom input string
		String str = "MALAYALAMs";

		int count = 0;

		String reverseMain = "";
		for (int k = str.length() - 1; k >= 0; k--) {
			reverseMain = reverseMain + str.charAt(k);
		}

		
		// Outer loop iterating over input string
		for (int i = 0; i < str.length(); i++) {

			// Inner loop iterating from current starting
			// character of outer loop current starting
			// character
			for (int j = i; j < str.length(); j++) {

				String rev = "";
				// Getting the substrings
				String subString = str.substring(i, j + 1);
				for (int k = subString.length() - 1; k >= 0; k--) {
					rev = rev + subString.charAt(k);
				}
				
				  if(subString.equals(rev)) 
				  { 
					  System.out.println("palindrome : " +subString); 
					  
				  }
				 
				/*
				 * if(reverseMain.contains(subString)) { System.out.println("palindrome : "
				 * +subString); }
				 */

			}
		}

	}
}
