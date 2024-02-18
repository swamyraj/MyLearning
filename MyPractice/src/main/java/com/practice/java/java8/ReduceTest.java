package com.practice.java.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class ReduceTest {

	public static void main(String[] args) {
		String str="google";
		String result1 = Stream.of(str.split("")).reduce("", (result, character) -> character + result);
		System.out.println("result1 : " + result1);
		
		Optional<String> result2 = Stream.of(str.split("")).reduce((result, character) -> character + result);
		System.out.println("result2 : " + result2.get());
		
		Supplier<Stream<Integer>>  intStream = ()->Stream.of(1,2,3);
		
		System.out.println(intStream.get().reduce(10, Integer::sum).intValue());
		System.out.println(intStream.get().reduce(10,(a,b)->a*b, (a,b)->a+b));
		
		List<String> letters = Arrays.asList("a", "b", "c", "d", "e");
		System.out.println(letters.stream().reduce((a,b)->a.toUpperCase()+b.toUpperCase()).get());
		
		String s1 = "abcde";
		System.out.println(s1.chars().mapToObj(i -> String.valueOf((char) i))
				.reduce((a, b) -> a.toUpperCase() + b.toUpperCase()).get());
		
		
		
		
		
		
		
	}
	

}
