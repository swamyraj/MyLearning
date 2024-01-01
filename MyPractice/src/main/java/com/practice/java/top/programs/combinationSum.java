package com.practice.java.top.programs;

import java.util.ArrayList;
import java.util.List;

//backtracking algorithm

// remove duplicates from array first if any
//remove negative if any
//consider only unique combination...
public class combinationSum {

	public static void main(String[] args) {

		int[] arr = { 2, 3, 6, 7 };
		int target = 7;
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();

		System.out.println(backTrack(arr, target, 0, list, result));

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
		for (int i = index; i < arr.length; i++) {
			int newTarget = target - arr[i];
			list.add(arr[i]);
			backTrack(arr, newTarget, i, list, result);
			list.remove(list.size() - 1);
		}
		return result;

	}

}
