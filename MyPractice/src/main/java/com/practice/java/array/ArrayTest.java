package com.practice.java.array;

import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;

public class ArrayTest {

	public static void main(String[] args) {
		
		Integer[] intArray = new Integer[] {8,6,4,7,5,3,2,1};
		System.out.println(intArray.length);
		
		//Arrays.sort(intArray);
		//System.out.println(Arrays.toString(intArray));
		
		//Arrays.sort(intArray,0,3);
		//System.out.println(Arrays.toString(intArray));
		
		//Arrays.parallelSort(intArray);
		//System.out.println(Arrays.toString(intArray));
		
		//Arrays.parallelPrefix(intArray,(x,y)->x+y);
		//System.out.println(Arrays.toString(intArray));
		
		Arrays.parallelSetAll(intArray,(i)->intArray[i]/2);
		System.out.println(Arrays.toString(intArray));
				
		//Arrays.sort(intArray);
		System.out.println(Arrays.binarySearch(intArray,3));
		
		// returns ArrayList implementation
		List<Integer> intList= Arrays.asList(intArray);
		System.out.println(intList);
		
		Integer[] intArrayCopy1 =Arrays.copyOf(intArray, 4);
		System.out.println(Arrays.toString(intArrayCopy1));
		
		Integer[] intArrayCopy2 =Arrays.copyOfRange(intArray, 4,6);
		System.out.println(Arrays.toString(intArrayCopy2));
		
		System.out.println(Arrays.equals(new int[] {1,2},new int[] {1,2}));
		System.out.println(Arrays.equals(new int[] {1,2},new int[] {1,3}));
		
		Spliterator<Integer> intSplitIterator = Arrays.spliterator(intArray);
		intSplitIterator.forEachRemaining(i->System.out.print(i*i));
		System.out.println();
		Arrays.stream(intArray).forEach(i->System.out.print(i*i));
		System.out.println();
		
		Integer[] intArray2 = new Integer[10];
		//Integer[] intArray2 = new Integer[] {1,2,3};
		Arrays.fill(intArray2, 100);
		System.out.println(Arrays.toString(intArray2));
		
		Arrays.fill(intArray2, 5,9,50);
		System.out.println(Arrays.toString(intArray2));
		
		
		
		
		
		System.out.println();
		String[] strArray = new String[] {"CC","BB","AA","aa","ZZ","bb","XX"};
		//Arrays.sort(strArray);
		System.out.println(Arrays.toString(strArray));
		
		//Arrays.sort(strArray, String.CASE_INSENSITIVE_ORDER);
		System.out.println(Arrays.toString(strArray));
		
		//Arrays.parallelSort(strArray, String.CASE_INSENSITIVE_ORDER);
		System.out.println(Arrays.toString(strArray));

		//Arrays.parallelSort(strArray,0,3, String.CASE_INSENSITIVE_ORDER);
		System.out.println(Arrays.toString(strArray));

		Arrays.parallelPrefix(strArray,(x,y)->x+y);
		System.out.println(Arrays.toString(strArray));
		
	}
}
