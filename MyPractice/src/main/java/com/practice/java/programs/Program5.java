package com.practice.java.programs;

/**
 * count the number of iteration to merge the N number boxes of 2 values
 * 
 *  input=6
 *  output=5
 *
 */
public class Program5 {

	public static void main(String[] args) {
		
		int n=11;
		int i=2;
		int count=0;
		while(n==0) {
			
			if(n%i == 0) {
				n=n/i;
				count=count+n;
			}else if(n%i != 0) {
				n=n/i;
				System.out.println("n:"+n);
				count=count+n;
			}
		}
		
	}
	
}
