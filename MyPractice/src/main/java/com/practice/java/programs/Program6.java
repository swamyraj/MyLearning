package com.practice.java.programs;

import java.util.ArrayList;
import java.util.List;

/**
 * Formatting output with printf
 *
 */
public class Program6 {

	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>(100);
		System.out.println(list.size());
		list.add(0, 1);
		System.out.println(list.size());
		list.add(1, 1);
		System.out.println(list.size());
		list.add(4, 2);
	}
}
