package com.practice.java.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Program9 {

	public static void main(String[] args) {
		
		int[] a = {5,	6,	2,	3,	4,	9};
		int[] b = {11,	23,	14,	33,	29,	30};
		
		int n=333;
		boolean result = IntStream.range(0, a.length).map(i->a[i]+b[i]).anyMatch(i->i==n);
		System.out.println("result : "+result);
		//IntStream.of(result).forEach(System.out::println);
		
		
		
		String x[] = {"frogged","egged","fridged","edged","sledged"};
		String y = "ed";
		String finalStr = String.join("",x);
		System.out.println("finalStr: "+finalStr);
		int index=0;int count=0;
		List<Integer> indices=new ArrayList();
		while((index=finalStr.indexOf(y, index))!=-1) {
			count++;
			index++;
			indices.add(index);
			
		}
		
		finalStr = String.join("", x);
		index=0;
		while((index=finalStr.indexOf(y, index))!= -1) {
			count++;
			index++;
		}
		
		
		
		
		  System.out.println("Total occurrences of a substring in the given string: " + count);
	        System.out.println("Indices of substring are: "+indices);
		
	}
	
	
	public static void m1(String[] args) {  
        int[] array1 = {1, 2, 3};  
        int[] array2 = {4, 5, 6, 7};  
        int[] sumArray = new int[Math.max(array1.length, array2.length)];  
        for (int i = 0; i < sumArray.length; i++) {  
            int num1 = (i < array1.length) ? array1[i] : 0;  
            int num2 = (i < array2.length) ? array2[i] : 0;  
            sumArray[i] = num1 + num2;  
        }  
        // Printing the sumArray  
        System.out.print("Sum Array: ");  
        for (int num : sumArray) {  
            System.out.print(num + " ");  
        }  
    }  
}
