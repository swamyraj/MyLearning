package com.practice.java.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class OptionalTest {

	public String getPlainString(String s) {
		return s;
	}

	public Optional<String> getString(String s) {
		return Optional.of(s);
	}

	public static void main(String[] args) throws Exception {
		OptionalTest t = new OptionalTest();

		Optional<String> emptyOpt = Optional.empty();
		Optional<String> optional = Optional.of("non empty me");
		
		List l = null;
		//List l = Collections.emptyList()
		Optional<List> optionalList = Optional.ofNullable(l);
		
		System.out.println("optionalList present?? "+Optional.ofNullable(optionalList).isPresent());
		
		List optionalList1 = optionalList.orElseGet(()->Arrays.asList("dd","ss"));
		System.out.println("optionalList: "+optionalList);
		System.out.println("optionalList1: "+optionalList1);
		
		
		Optional.ofNullable(t.getPlainString("hello")).ifPresent(s -> System.out.println(s));

		String d = Optional.ofNullable(t.getPlainString(null)).orElse("Im default value");
		System.out.println(d);

		String e = Optional.ofNullable(t.getPlainString(null)).orElseGet(() -> "Im from  orElseGet");
		System.out.println(e);

		System.out.println("is present check : " + Optional.ofNullable(t.getPlainString(null)).isPresent());
		System.out.println("is present check : " + Optional.ofNullable(t.getPlainString(".....")).isPresent());

		Optional.ofNullable(t.getPlainString(".....")).ifPresent(s -> {
			System.out.println("if present test");
		});

		Optional.ofNullable(t.getPlainString("IAM")).filter(s -> s.equals("IAM")).ifPresent(s -> {
			System.out.println("IAM equals");
		});

		Optional.ofNullable(t.getPlainString("IAM")).filter(s -> s.equals("IAM NOT")).ifPresent(s -> {
			System.out.println("IAM equals IMA NOT");
		});

		Optional.ofNullable(t.getPlainString("Hello.....")).map(s -> s.concat("map concatinated")).ifPresent(s -> {
			System.out.println(s);
		});

		Optional.ofNullable(t.getPlainString("Hello.....")).flatMap(s -> Optional.of(s.concat("flat map concatinated")))
				.ifPresent(s -> {
					System.out.println(s);
				});

		Optional<String> s1 = t.getString("hiiii");
		Optional.ofNullable(s1).orElseThrow(() -> new Exception());
		System.out.println(s1);

		Optional<String> s2 = t.getString(null);
		Optional.ofNullable(s2).orElseThrow(() -> new Exception());
		System.out.println(s2);
		
		
		ConcurrentHashMap.newKeySet();
		

	}
}
