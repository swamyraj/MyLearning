package com.practice.java.utility;

public class MathTest {

	public static void main(String[] args) {
		
		int x=232;
		int firstDigit = Math.floorDiv(x, 100);
		//int secondDigit = Math.floorMod(x, 100);
		int secondDigit = Math.floorDiv(Math.floorMod(x, 100), 10);
		int thirdDigit = Math.floorMod(Math.floorMod(x, 100), 10);
		int sum = firstDigit+secondDigit+thirdDigit;
		
		System.out.println("SUM : "+sum);
		calculateSumOfDigitsInString("2a3a5");
	}
	
	
	public static void calculateSumOfDigitsInString(String str) {
		int sum = str.chars().filter(i -> Character.isDigit(i)).map(i -> Character.getNumericValue(i)).reduce(0,
				(result, i) -> result + i);
		System.out.println("sum : " + sum);
	}
}
