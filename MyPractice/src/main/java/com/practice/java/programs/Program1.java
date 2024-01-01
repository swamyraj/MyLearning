package com.practice.java.programs;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Program to sort the number in asc and desc,then minus to reduce the till 6174
 * and print the number of iteration it takes to reach 6174
 *
 * input will be any 4 digit number
 *
 */
public class Program1 {

	public static void main(String[] args) {
		int number = 3872;
		// int number = 6972;

		int numberOfIteration = 0;
		System.out.println("number : " + number);

		while (number != 6174) {
			number = method1(number);
			System.out.println("number : " + number);
			numberOfIteration++;
		}

		System.out.println("Number of iteration took to match 6174 number : " + numberOfIteration);
	}

	private static int method1(int num) {

		String number = String.valueOf(num);
		int len = number.length();
		int[] digits = new int[len];
		int i = 0;
		while (num != 0) {
			int digit = num % 10;
			digits[i++] = digit;
			num = num / 10;
		}
		sort(digits, "ASC");
		String numberASC = Arrays.stream(digits).mapToObj(o -> Integer.toString(o)).collect(Collectors.joining(""));
		System.out.println("sorted number in ASC : " + numberASC);

		sort(digits, "DESC");
		String numberDESC = Arrays.stream(digits).mapToObj(o -> Integer.toString(o)).collect(Collectors.joining(""));
		System.out.println("sorted number in DESC : " + numberDESC);

		return Integer.valueOf(numberDESC) - Integer.valueOf(numberASC);
	}

	// simple bubble sort
	private static void sort(int[] arr, String flag) {
		for (int i = 0; i < arr.length - 1; i++)
			for (int j = i + 1; j < arr.length; j++) {

				if (flag.equals("ASC")) {

					if (arr[i] > arr[j]) {
						int tmp = arr[j];
						arr[j] = arr[i];
						arr[i] = tmp;
					}
				} else if (flag.equals("DESC")) {

					if (arr[i] < arr[j]) {
						int tmp = arr[j];
						arr[j] = arr[i];
						arr[i] = tmp;
					}
				}
			}
	}
}
