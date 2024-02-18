package com.practice.java.programs;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Program4 {

	public static void main(String[] args) {
		// reverseString();
		// joinTest();
		// reverseStringUsingStreams();
		// printStringStartsWithGivenLetter();
		// charToUpperCase();
		// findRepeatedCharsAndCount();
		// findRepeatedCharsAndCountUsingStreams();
		// findUniqueCharsUsingStreams();
		// findUniqueCharsUsingStreams();
		// findNthNonReperatedCharacter();
		// findUniqueWordUsingStreams();

	}

	private static void reverseString() {
		String str = "google";
		StringBuilder builder = new StringBuilder();
		for (int i = str.length() - 1; i >= 0; i--) {
			builder.append(str.charAt(i));
		}
		System.out.println("reversed string : " + builder.toString());
	}

	private static void joinTest() {
		String str[] = { "google", "merck", "tcs" };

		String result1 = Arrays.asList(str).stream().collect(Collectors.joining());
		System.out.println("result1 : " + result1);

		String result2 = Arrays.asList(str).stream().collect(Collectors.joining("-"));
		System.out.println("result2 : " + result2);

		String result3 = Arrays.asList(str).stream().collect(Collectors.joining(",", "[", "]"));
		System.out.println("result3 : " + result3);
	}

	private static void reverseStringUsingStreams() {
		String str = "google";
		
		IntStream.range(1, str.length()).forEach(i -> System.out.println(i));

		String result1 = Arrays.stream(str.split("")).sorted((s1, s2) -> -1).collect(Collectors.joining());
		System.out.println("result1 : " + result1);

		StringBuilder result2 = new StringBuilder("");
		Stream.of(str.split("")).forEach(c -> result2.insert(0, c));
		System.out.println("result2 : " + result2);

		String[] strArray = str.split("");
		String result3 = IntStream.range(0, str.length()).mapToObj(i -> {
			return strArray[str.length() - 1 - i];
		}).collect(Collectors.joining(""));
		System.out.println("result3 : " + result3);

		String str1 = "abcd.efg.qwerty";
		String[] strArray1 = str1.split("\\.");
		String result4 = Arrays.stream(strArray1).map(o -> {
			return IntStream.range(0, o.length()).mapToObj(i -> {
				return o.split("")[o.length() - 1 - i];
			}).collect(Collectors.joining(""));
		}).collect(Collectors.joining("."));
		System.out.println("result4 : " + result4);

		String result5 = Stream.of(str.split("")).reduce("", (result, character) -> character + result);
		System.out.println("result5 : " + result5);

		String result6 = IntStream.range(0, str.length()).boxed().sorted(Collections.reverseOrder())
				.map(i -> String.valueOf(str.charAt(i))).collect(Collectors.joining());
		System.out.println("result6 : " + result6);

		IntStream.range(0, str.length()).forEach(i -> System.out.print(str.charAt(str.length() - 1 - i)));
		System.out.println();
		
		Stream.of(str.split("")).reduce("",(result,i)->i+result);
		

	}

	private static void printStringStartsWithGivenLetter() {
		String[] stringArray = new String[] { "Hi", "Hello", "bobby" };

		Stream<String> s1 = Arrays.stream(stringArray);
		List<String> list = s1.filter(s -> s.startsWith("H")).collect(Collectors.toList());
		list.stream().forEach(System.out::println);

	}

	/**
	 * convert 1st,2nd,last character to uppercase
	 */
	private static void charToUpperCase() {
		String str = "bobby";
		char[] charArray = str.toCharArray();
		charArray[0] = Character.toUpperCase(charArray[0]);
		charArray[1] = Character.toUpperCase(charArray[1]);
		charArray[charArray.length - 1] = Character.toUpperCase(charArray[charArray.length - 1]);
		System.out.println("string in upppercase : " + String.valueOf(charArray));

	}

	private static void findRepeatedCharsAndCount() {
		String s = "bobbybaby";
		char[] charArrayA = s.toCharArray();
		char[] charArrayB = s.toCharArray();

		Map<Character, Integer> mapA = new LinkedHashMap<Character, Integer>();
		Map<Character, Integer> mapB = new LinkedHashMap<Character, Integer>();
		for (char i : charArrayA) {
			int count = 0;
			for (char j : charArrayB) {
				if (i == j) {
					count++;
					mapA.put(i, count);
				}
			}
		}

		StringBuilder builder = new StringBuilder();
		for (Entry<Character, Integer> m : mapA.entrySet()) {
			if (m.getValue() == 1) {
				builder.append(m.getKey());
			} else {
				mapB.put(m.getKey(), m.getValue());
			}
		}
		System.out.println("non repeated character string : " + builder.toString());

		for (Entry<Character, Integer> m : mapB.entrySet()) {
			System.out.println("repeated character : " + m.getKey() + ", count : " + m.getValue());
		}
	}

	private static void findRepeatedCharsAndCountUsingStreams() {
		String str = "bobbybaby";
		Map<Object, Long> result = str.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(c -> c, Collectors.counting()));
		result.forEach((k, v) -> {
			if (v > 1) {
				System.out.println("from streams : repeated character : " + k + ", count : " + v);
			}
		});

		int a[] = { 1, 2, 4, 4, 2, 5 };
		Map<Object, Long> map = Arrays.stream(a).mapToObj(i -> i)
				.collect(Collectors.groupingBy(i -> i, Collectors.counting()));
		map.forEach((k, v) -> {
			if (v > 1) {
				System.out.println("from streams : repeated character : " + k + ", count : " + v);
			}
		});

	}

	private static void findUniqueCharsUsingStreams() {
		String str = "bobbyy";

		Map<Object, Long> result = str.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()));
		result.forEach((k, v) -> {
			if (v == 1) {
				System.out.println("from streams : unique character result: " + k);
			}
		});

		String result1 = str.chars().distinct().mapToObj(c -> String.valueOf((char) c)).collect(Collectors.joining());
		System.out.println("from streams : unique character result1: " + result1);

	}

	// Nth non repeated character
	private static void findNthNonReperatedCharacter() {
		String s = "abbbcd";
		int n = 1;
		Character character = (Character) s.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(i -> i, LinkedHashMap::new, Collectors.counting())).entrySet().stream()
				.filter(e -> e.getValue() == 1).skip(n).findFirst().map(e -> e.getKey()).orElse('\0');
		System.out.println("character: " + character);
	}

	private static void findUniqueWordUsingStreams() {
		String s = "red green white blue red white black";
		// Output: green, blue, black

		Map<Object, Long> map = Arrays.stream(s.split(" ")).map(e -> e)
				.collect(Collectors.groupingBy((k -> k), Collectors.counting()));

		map.forEach((k, v) -> {
			if (v == 1) {
				System.out.println("from streams : unique word: " + k);
			}
		});

	}

}
