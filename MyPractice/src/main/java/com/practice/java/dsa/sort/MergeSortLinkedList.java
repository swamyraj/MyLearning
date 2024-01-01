package com.practice.java.dsa.sort;

import java.util.LinkedList;
import java.util.List;

public class MergeSortLinkedList {

	public static void main(String[] args) {

		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(38);
		list.add(47);
		list.add(43);
		list.add(10);
		mergSort(list, 0, list.size() - 1);

		System.out.println(list);
	}

	private static void mergSort(LinkedList<Integer> list, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergSort(list, left, mid);
			mergSort(list, mid + 1, right);
			merge(list, left, mid, right);
		}
	}

	private static void merge(LinkedList<Integer> list, int left, int mid, int right) {
		List<Integer> leftList = new LinkedList<Integer>();
		List<Integer> rightList = new LinkedList<Integer>();
		int n1 = mid - left + 1;
		int n2 = right - mid;
		System.out.println("list : " + list);
		System.out.println("left : " + left + ", mid : " + mid + ", right : " + right);
		System.out.println("n1 : " + n1 + ", n2 : " + n2);

		for (int i = 0; i < n1; i++) {
			leftList.add(list.get(left + i));
		}
		for (int i = 0; i < n2; i++) {
			rightList.add(list.get(mid + 1 + i));
		}

		System.out.println("leftList : " + leftList);
		System.out.println("rightList : " + rightList);
		
		int i = 0;
		int j = 0;
		int k = left;
		while (i < n1 && j < n2) {
			if (leftList.get(i) <= rightList.get(j)) {
				list.set(k, leftList.get(i));
				i++;
			} else {
				list.set(k, rightList.get(j));
				j++;
			}
			k++;
		}
		while (i < n1) {
			list.set(k, leftList.get(i));
			i++;
			k++;
		}
		while (j < n2) {
			list.set(k, rightList.get(j));
			j++;
			k++;
		}

	}

}
