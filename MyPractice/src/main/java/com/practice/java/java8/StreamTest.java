package com.practice.java.java8;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {

	public static void main(String[] args) {
		InterfaceTest.producer();
		
		
		Stream<String> stream1 = Stream.of("Hi","hello","hw u");
		stream1.filter(o->o.contains("Hi")).forEach(System.out::println);
		int[] arr = new int[]{1,2,3,4,5};
		IntStream intgerArray = Arrays.stream(arr);
		
		Stream.Builder<String> builder= Stream.builder();
		Stream<String> builderStream = builder.add("1").add("2").build();
		
		Stream.iterate(2, (Integer n )->n*n).limit(5).forEach(System.out::println);
		
		
		
		String str = "geeksforgeeks";
		char c = 'e';
		System.out.println(str.chars().filter(o -> o == c).count());

		char arrr[] = str.toCharArray();
		int countArr = 0;
		for (char d : arrr) {
			if (d == c) {
				countArr++;
			}else {
				
			}
		}
		System.out.println(" countArr : " + countArr);
      
      StringBuilder builder1 = new StringBuilder();
      for (int i = arrr.length; i > 0; i--) {
    	  builder1.append(arrr[i]);
      }
      System.out.println( " builder1 : " +builder1.toString());    
        
		
		
	}
	
}
