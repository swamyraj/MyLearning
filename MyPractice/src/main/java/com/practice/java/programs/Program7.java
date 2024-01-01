package com.practice.java.programs;

/**
 * Left shift and right shift operator
 *	
 *	 1024 512 256 128 64 32 16 8 4 2 1
 *
 *	2 =   10
 *	3 =   11
 *	4 =   100
 *	5 =   101
 *	6 =   110
 *	7 =   111
 *	8 =   1000
 *	9 =   1001
 *	10 =  1010
 */
public class Program7 {
	static byte i;
	static short j;
	static int k;
	static long l;
	static boolean m;
	static char n;
	static float o;
	static double p;
	static String q;
	static long creditCardNumber = 1234_5678_9012_3456L;//valid after java 7 , we can use underscore b/n numbers
	static long socialSecurityNumber = 999_99_9999L;
	
	
	public static void main(String[] args) {
		//printDefaultValuesForPrimitives();
		//printNumbersfromDifferentFormat();
		printBinaryofAnyNumber();
		//printBinaryofAnyNumberWithRecursive(10);
		//printBinaryofAnyNumberWithIterative(10);
		//bitwiseAnd();
		//bitwiseOr();
		//bitwiseXor();
		//bitwiseNot();
		//leftShift();
		//rightShift();
	}
	
	
	private static void bitwiseNot() {
		int x=10;int y=11;
		
		System.out.println("Binary of "+x+" : "+ Integer.toBinaryString(x));
		System.out.println("Binary of "+y+" : "+ Integer.toBinaryString(y));
		System.out.println("~x : " + ~x);
		System.out.println("~y : " + ~y);
	}


	private static void bitwiseXor() {
		
		int x=10;int y=11;
		System.out.println("Binary of "+x+" : "+ Integer.toBinaryString(x));
		System.out.println("Binary of "+y+" : "+ Integer.toBinaryString(y));
		System.out.println("x ^ y : " + (x ^ y));
		
		x=10; y=12;
		System.out.println("Binary of "+x+" : "+ Integer.toBinaryString(x));
		System.out.println("Binary of "+y+" : "+ Integer.toBinaryString(y));
		System.out.println("x ^ y : " + (x ^ y));
	}


	private static  void printDefaultValuesForPrimitives() {
		
		System.out.println(i);
		System.out.println(j);
		System.out.println(k);
		System.out.println(l);
		System.out.println(m);
		System.out.println(n); //'\u0000'
		System.out.println(o);
		System.out.println(p);
		System.out.println(q);
		System.out.println(creditCardNumber);
		
		
	}

	/**
	 *  Decimal: Base 10, whose digits consists of the numbers 0 through 9; this is the number system you use every day
		Hexadecimal: Base 16, whose digits consist of the numbers 0 through 9 and the letters A through F
		Binary: Base 2, whose digits consists of the numbers 0 and 1 (you can create binary literals in Java SE 7 and later)
	 */
	private static void printNumbersfromDifferentFormat() {
		int i = 10;
		int j = 0b101;
		int k = 0x123F;
		System.out.println("decimal : i : "+ i);
		System.out.println("binary represenation : j : "+ j);
		System.out.println("hexadecimal represenation : k : "+ k);
	}

	private static void printBinaryofAnyNumber() {
		int x = 10;
		System.out.println(Integer.toBinaryString(x));//uses two's complement
		System.out.println(Integer.toString(x,2));//for other compliments
		System.out.println(Integer.toString(x,3));
	}

	private static void printBinaryofAnyNumberWithRecursive(int num) {

		if (num > 1) {
			printBinaryofAnyNumberWithRecursive(num / 2);
		}
		System.out.print(num % 2);
	}
	
	private static void printBinaryofAnyNumberWithIterative(int num) {
		StringBuilder result = new StringBuilder();
		for (int i = 4; i >0; i--) {
			int mask = 1 << i;
			System.out.println("mask : "+mask);
			result.append((num & mask) != 0 ? "0" : "1");
		}
		System.out.println("result 1: "+result);		
	}

	
	public static void bitwiseAnd() {
		int x=10;int y=11;
		System.out.println("Binary of "+x+" : "+ Integer.toBinaryString(x));
		System.out.println("Binary of "+y+" : "+ Integer.toBinaryString(y));
		System.out.println("x & y : " + (x & y));
		
		x=10; y=12;
		System.out.println("Binary of "+x+" : "+ Integer.toBinaryString(x));
		System.out.println("Binary of "+y+" : "+ Integer.toBinaryString(y));
		System.out.println("x & y : " + (x & y));
		
	}
	
	public static void bitwiseOr() {
		
		
		int x=10;int y=11;
		System.out.println("Binary of "+x+" : "+ Integer.toBinaryString(x));
		System.out.println("Binary of "+y+" : "+ Integer.toBinaryString(y));
		System.out.println("x | y : " + (x | y));
		
		x=20; y=10;
		System.out.println("Binary of "+x+" : "+ Integer.toBinaryString(x));
		System.out.println("Binary of "+y+" : "+ Integer.toBinaryString(y));
		System.out.println("x | y : " + (x | y));
	}

	public static void leftShift() {
		System.out.println(10 << 1);
		System.out.println(10 << 2);
		System.out.println(10 << 3);
		System.out.println(10 << 4);
		System.out.println(10 << 5);
	}
	
	public static void rightShift() {
		System.out.println(10 >> 1);
		System.out.println(10 >> 2);
		System.out.println(10 >> 3);
		System.out.println(10 >> 4);
		System.out.println(10 >> 5);
	}
	
}
