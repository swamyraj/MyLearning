package com.practice.java.top.programs;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author sliding window algorithm
 *
 *         Time Complexity: O(n), Since each character is processed by the left
 *         and right pointers exactly once. Auxiliary Space: O(1)
 */
public class LongestSubStringWithourRepeatedChars {

	public static void main(String[] args) {

		String str = "geeksforgeeks";
		// String str = "bbb";

		if (str.length() == 0)
			System.out.println("");
		if (str.length() == 1) {
			System.out.println("str" + str);
		}
		int i = 0, j = 0;
		Set<Character> set = new LinkedHashSet<>();
		while (j < str.length()) {
			if (!set.contains(str.charAt(j))) {
				set.add(str.charAt(j));
				j++;
			} else {
				set.remove(str.charAt(j));
				i++;
			}
			System.out.println(set);
		}
		System.out.println(set);
	}
}
