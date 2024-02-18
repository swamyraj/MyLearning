package com.practice.java.top.programs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//backtracking algorithm

// remove duplicates from array first if any
//remove negative if any
//consider only unique combination...
public class combinationSum {

	public static void main(String[] args) {

		int[] arr = { 2, 3, 6, 7 ,5};
		int target = 7;
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();

		// System.out.println(backTrack(arr, target, 0, list, result));
		//printSumPresent();
		System.out.println(combinationSum(arr, target, 0, list, result));
	}

	// 7-2=5{2}, 5-2=3{2,2}, 3-2=1{2,2,2} ,1-2=-1 stop
	public static List<List<Integer>> backTrack(int[] arr, int target, int index, List<Integer> list,
			List<List<Integer>> result) {
		if (target < 0) {
			return null;
		}
		if (target == 0) {

			// only distinct
			// if (list.size() == list.stream().distinct().count()) {
			// result.add(new ArrayList<>(list));
			// }
			// includes duplicates
			result.add(new ArrayList<>(list));
		}
		for (int i = index; i < arr.length-1; i++) {
			int newTarget = target - arr[i];
			list.add(arr[i]);
			backTrack(arr, newTarget, i, list, result);
			list.remove(list.size() - 1);
		}
		return result;

	}

	private static void printSumPresent() {
		int[] arr = { 2, 5, 6, 7, 3, 4 };
		int target = 7;
		Set<Integer> set = new HashSet<>();
		for (int i : arr) {
			int temp = target - i;
			if (!set.contains(temp)) {
				set.add(i);
			} else {
				System.out.println("sum present : " + i + " " + temp);
			}
		}

	}

	private static List<List<Integer>> combinationSum(int[] arr, int target, int index, List<Integer> list,
			List<List<Integer>> result) {
		if (target < 0) {
			return null;
		}
		if (target == 0)

		{
			result.add(new ArrayList<>(list));
		}
		for (int i = index; i < arr.length; i++) {
			int newTarget = target - arr[i];
			list.add(arr[i]);
			combinationSum(arr, newTarget, i, list, result);
			list.remove(list.size()-1);
		}
		return result;
	}
}
