package com.practice.java.dsa.sort;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		int arr[] = { 64, 34, 25, 12, 22, 11, 90 };
		bubbleSort1(arr);
		bubbleSort2(arr);
	}

	private static void bubbleSort1(int[] arr) {
		System.out.println(Arrays.toString(arr));

		for (int i = 0; i < arr.length - 1; i++) {
			// System.out.println(Arrays.toString(arr));
			for (int j = i + 1; j < arr.length - 1; j++) {

				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}

			}

		}
		System.out.println(Arrays.toString(arr));
	}

	private static void bubbleSort2(int[] arr) {
		System.out.println(Arrays.toString(arr));
		for (int i = 0; i < arr.length - 1; i++) {
			boolean swapped = false;
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					swapped = true;
				}
			}
			// If no two elements were
			// swapped by inner loop, then break
			if (swapped == false)
				break;
		}
		System.out.println(Arrays.toString(arr));
	}
}
