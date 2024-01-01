package com.practice.java.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapTest {

	public static void main(String[] args) {
		method1();
	}

	private static void method1() {
		// making the arraylist object of List of Integer
		List<List<Integer>> number = new ArrayList<>();

		// adding the elements to number arraylist
		number.add(Arrays.asList(1, 2));
		number.add(Arrays.asList(3, 4));
		number.add(Arrays.asList(5, 6));
		number.add(Arrays.asList(7, 8));

		System.out.println("List of list-" + number);

		List<Integer> list1 = number.stream().flatMap(list -> list.stream()).collect(Collectors.toList());
		System.out.println(list1);
	}

}
