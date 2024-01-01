package com.practice.java.dsa.sort;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int arr[] = { 38, 27, 43, 10 };
		mergeSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	private static void mergeSort(int[] arr, int left, int right) {

		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(arr, left, mid);
			mergeSort(arr, mid + 1, right);
			merge(arr, left, mid, right);
		}
	}

	// 0,1,2 3,4,5
	private static void merge(int[] arr, int left, int mid, int right) {
		int n1 = mid - left + 1;
		int n2 = right - mid;
		int[] leftArray = new int[n1];
		int[] rightArray = new int[n2];

		// System.arraycopy(arr, left, leftArray, 0, n1);
		// System.arraycopy(arr, mid + 1, rightArray, 0, n2);
		for (int i = 0; i < n1; i++) {
			leftArray[i] = arr[left + i];
		}
		for (int j = 0; j < n2; j++) {
			rightArray[j] = arr[mid + 1 + j];
		}

		int i = 0, j = 0, k = left;
		while (i < n1 && j < n2) {
			if (leftArray[i] <= rightArray[j]) {
				arr[k] = leftArray[i];
				i++;
			} else {
				arr[k] = rightArray[j];
				j++;
			}
			k++;
		}
		while (i < n1) {
			arr[k] = leftArray[i];
			i++;
			k++;
		}
		while (j < n2) {
			arr[k] = rightArray[j];
			j++;
			k++;
		}

	}

}
