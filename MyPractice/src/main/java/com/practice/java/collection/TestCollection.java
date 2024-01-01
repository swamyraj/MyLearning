package com.practice.java.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestCollection {

	public static void main(String[] args) {
		try {
			List<Integer> immutableList = Collections.emptyList();
			immutableList.add(1);// throws UnsupportedOperationException as list is immutable
			// ystem.out.println(immutableList);
		} catch (Exception e) {
			System.out.println("exception : " + e.getMessage());
		}

		List<Integer> intList = new ArrayList<Integer>();
		Collections.addAll(intList, 4, 5);
		System.out.println(intList);

		List<Integer> synchronizedList = Collections.synchronizedList(intList);

		try {
			List<Integer> singleTonList = Collections.singletonList(1);
			singleTonList.add(2);
			System.out.println(singleTonList);
		} catch (Exception e) {
			System.out.println("exception : " + e.getMessage());
		}

	}
}
