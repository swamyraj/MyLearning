package com.practice.java.array;

public class TwoDArrayTest {

	public static void main(String[] args) {
		int[][] arr = new int[2][3];
		
		System.out.println(arr.length);
		
		arr[1][1] = 20;
		System.out.println(arr[1][1]);
		System.out.println(arr[1][2]);
		
		System.out.println("length of rows: "+arr.length);
		System.out.println("length of columns : "+arr[0].length);
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				System.out.print(arr[i][j]);
				System.out.print("  ");
			}
			System.out.println("\n");
		}
		
	}
}
