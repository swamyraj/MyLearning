package com.practice.java.staatic;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class StaticTest {
	// Create a static variable and initialize it 0.
	static int x = 0; // It will get memory only once and retain its value.

	int y = 10;

	// Declare a constructor.
	StaticTest() {
		System.out.println("inside static block");
		y++;
		x++; // It will increment the static variable by 1 for each object creation.
	}

	// Declare an instance method.
	void display() {
		System.out.println(x);
		System.out.println(y);
	}

	public static void main(String[] args) {

		// System.out.println(y); // not possible
		StaticTest c1 = new StaticTest();
		c1.display();
		StaticTest c2 = new StaticTest();
		c2.display();
		StaticTest c3 = new StaticTest();
		c3.display();

		int[] array = new int[] { 2, 3, 4, 6, 4, 6, 8 };
		// x=10
		// a+b=x ... x-a=b??
		// a=2,a=3,a=4
		int target = 10;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		// Map<String,Integer> results = new HashMap<Integer, Integer>();
		Set<String> set = new HashSet<>();

		for (int i = 0; i < array.length; i++) {
			if (map.containsKey(target - array[i])) {

				set.add(i + "_" + map.get(target - array[i]));
			}

			map.put(array[i], i);

		}
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + "___" + entry.getValue());
		}

		System.out.println(set);

	}
}