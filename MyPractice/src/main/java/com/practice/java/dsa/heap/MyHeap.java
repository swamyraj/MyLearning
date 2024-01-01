package com.practice.java.dsa.heap;

import java.util.Arrays;

//			10
//	 	20       30
//  40     50  60   70

// parent = (i-1)/2;
//left child = 2*i+1;
//right child = 2*i+2;
public class MyHeap {

	int arr[] = new int[10];
	int size;

	public void add(int value) {
		arr[size] = value;
		int index = size;
		int parent = (index - 1) / 2;

		while (parent >= 0 && arr[parent] > arr[index]) {

			int temp = arr[parent];
			arr[parent] = arr[index];
			arr[index] = temp;

			int i = parent;
			index = parent;
			parent = (i - 1) / 2;
		}
		size++;
	}

	public int remove(){
		int max = arr[0];
		arr[0] = arr[size-1];
		arr[size-1]=0;
		size--;
		minHeapify(0);
		return max;
	}
	
	private void minHeapify(int index) {
		int l = 2 * index + 1;
		int r = 2 * index + 2;
		int smallest = index;
		if (l < size && arr[l] < arr[smallest]) {
			smallest = l;
		}
		if (r < size && arr[r] < arr[smallest]) {
			smallest = r;
		}
		if (smallest != index) {
			int temp = arr[smallest];
			arr[smallest] = arr[index];
			arr[index] = temp;
			minHeapify(smallest);
		}
	}

	public static void main(String[] args) {

		MyHeap m = new MyHeap();
		m.add(30);
		m.add(20);
		m.add(10);
		System.out.println(Arrays.toString(m.arr));
		m.add(5);
		m.add(15);
		System.out.println(Arrays.toString(m.arr));
		m.remove();
		System.out.println(Arrays.toString(m.arr));
	}
}
