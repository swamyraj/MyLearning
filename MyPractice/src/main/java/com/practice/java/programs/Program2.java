package com.practice.java.programs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Program2 {

	public static void main(String[] args) {

		// find multiplication of numbers
		mutliplyNumbers();
		
		sumNumber();

		// find the common word from both the array
		findCommonWords();

		// find longest word
		findLongestWord();

	}

	private static void mutliplyNumbers() {

		Integer[] input = { 1, 2, 3, 4, 5 };

		// normal
		int result = 1;
		for (int i = 0; i < input.length; i++) {
			result = result * input[i];
		}
		System.out.println("from normal loop : " + result);

		// from stream
		Stream<Integer> stream = Arrays.stream(input);
		System.out.println("from stream : " + stream.reduce(1, (res, n) -> res * n).intValue());
		
		

	}
	
	private static void sumNumber() {

		Integer[] input = { 1, 2, 3, 4, 5 };

		// normal
		int result = 1;
		for (int i = 0; i < input.length; i++) {
			result = result + input[i];
		}
		System.out.println("from normal loop : " + result);

		// from stream
		Stream<Integer> stream = Arrays.stream(input);
		System.out.println("from stream : " + stream.reduce(1, (res, n) -> res + n).intValue());
		

	}

	private static void findCommonWords() {

		String[] arr1 = { "abc", "cat", "food", "egg" };
		String[] arr2 = { "abc", "egg" };

		// normal way
		Set<String> set = new HashSet<String>();
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				if (arr1[i].equalsIgnoreCase(arr2[j])) {
					set.add(arr1[i]);
				}
			}
		}
		System.out.println("from normal loop : " + set);

		// from stream
		List<String> list1 = Arrays.asList(arr1);
		List<String> list2 = Arrays.asList(arr2);

		
		
		
		Set<String> set1 = list1.stream().filter(o -> list2.contains(o)).collect(Collectors.toSet());
		System.out.println("from stream : " + set1);
	}

	private static void findLongestWord() {

		List<String> words = Arrays.asList("GFG", "Geeks", "for", "GeeksQuiz", "GeeksforGeeks");

		Optional<String> longestWord = words.stream()
				.reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2);
		System.out.println("Longest word : " + longestWord.get());
	}
}
