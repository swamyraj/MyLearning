package com.practice.java.dsa.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class HeapSort {

	public static void main(String[] args) {
		
		
		int[] arr ={ 1, 23, 12, 9, 30, 2, 50 };
	
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		for (int i : arr) {
			minHeap.add(i);
		}
		int i=0;
		while(!minHeap.isEmpty()) {
			arr[i] = minHeap.poll();
			i++;
		}
		System.out.println(Arrays.toString(arr));
	}
}
