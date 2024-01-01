package com.practice.java.java8;

import java.util.Arrays;
import java.util.stream.Collectors;

public class IntegerToStringTest {

	public static void main(String[] args) {
		method1();
		method2();
		method3();
	}

	private static void method1() {

		Integer[] integerArray = { 1, 2, 3, 4, 5 };
		String[] stringArray = Arrays.stream(integerArray).map(o -> o.toString()).toArray(String[]::new);
		System.out.println("integer array : " + integerArray);
		System.out.println("string  array : " + stringArray);

	}

	private static void method2() {

		int[] intArray = { 1, 2, 3, 4, 5 };
		String[] stringArray = Arrays.stream(intArray).mapToObj(o -> String.valueOf(o)).toArray(String[]::new);
		// String[] stringArray =
		// Arrays.stream(intArray).mapToObj(Integer::toString).toArray(String[]::new);
		System.out.println("int array : " + intArray);
		System.out.println("string  array : " + stringArray);

	}

	private static void method3() {

		int[] intArray = { 1, 2, 3, 4, 5 };
		String str = Arrays.stream(intArray).mapToObj(Integer::toString).collect(Collectors.joining(""));

		System.out.println("str : " + str);

	}

}
