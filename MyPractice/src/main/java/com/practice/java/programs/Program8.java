package com.practice.java.programs;

public class Program8 {

	public static void main(String[] args) {
		int[] array= {1,2,3,4,5,6};
		int target = 2;
		
		int start=0;
		int end=array.length-1;
		int mid=0;
		while(start<=end) {
			mid = (start+end)/2;
			if(array[mid] == target) {
				System.out.println("found value at position : " +mid);
				break;
			}
			else if (target < array[mid]){
				end=mid-1;
			}else {
				start=mid+1;
			}
		}
	}
}
