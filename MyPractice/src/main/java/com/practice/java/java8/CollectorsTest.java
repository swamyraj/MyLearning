package com.practice.java.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.practise.java.model.Employee;

public class CollectorsTest {

	public static void main(String[] args) {

		List<String> list = Arrays.asList("Geeks", "for", "gfg", "GeeksforGeeks", "GeeksQuiz", "for");

		List<Employee> empList = new ArrayList<Employee>();
		List<Integer> intList = Arrays.asList(1,2,3,4,5,6,6);
		
		Employee e1 = new Employee("swamy", 15000.00, 32, null);
		Employee e2 = new Employee("raj", 35000.00, 33, null);
		Employee e3 = new Employee("alice", 20000.00, 20, null);
		empList.add(e1);
		empList.add(e2);
		empList.add(e3);

		List<String> nameList = empList.stream().map(o -> o.getName()).collect(Collectors.toList());
		System.out.println("nameList : " + nameList);

		Set<String> nameSet = empList.stream().map(o -> o.getName()).collect(Collectors.toSet());
		System.out.println("nameSet : " + nameSet);

		LinkedList<String> nameLinkedList = empList.stream().map(o -> o.getName())
				.collect(Collectors.toCollection(LinkedList::new));
		System.out.println("nameLinkedList : " + nameLinkedList);

		Long count = empList.stream().mapToInt(o -> o.getAge()).count();
		System.out.println("count : " +count);

		
		
		Optional<Integer> max = intList.stream().collect(Collectors.maxBy(Comparator.naturalOrder()));
		System.out.println("max : " + max.get());
		
		Optional<Integer> min = intList.stream().collect(Collectors.minBy(Comparator.naturalOrder()));
		System.out.println("min : " + min.get());
		
		Double averagingDouble = intList.stream().collect(Collectors.averagingDouble(i->i));
		System.out.println("averagingDouble : " + averagingDouble);
		
		Double averagingInt = intList.stream().collect(Collectors.averagingInt(i->i*2));
		System.out.println("averagingInt : " + averagingInt);
		
		Double averagingLong = intList.stream().collect(Collectors.averagingLong(i->i*2));
		System.out.println("averagingLong : " + averagingLong);
		
		List<Integer> unmodifiableList = intList.stream()
				.collect(Collectors.collectingAndThen(Collectors.toList(), Collections::<Integer>unmodifiableList));
		Set<Integer> unmodifiableSet = intList.stream()
				.collect(Collectors.collectingAndThen(Collectors.toSet(), Collections::<Integer>unmodifiableSet));
		List<Integer> unmodifiableList1 = intList.stream()
				.collect(Collectors.collectingAndThen(Collectors.toCollection(LinkedList::new), Collections::<Integer>unmodifiableList));
		//unmodifiableList.add(10); // this fails
		System.out.println("unmodifiableList : " + unmodifiableList);
		
		Long countOfEmployee = empList.stream().filter(e->e.getAge()>30).collect(Collectors.counting());
		System.out.println("countOfEmployee of age greater than 30 : " + countOfEmployee);
		
		Map<Object, List<Integer>>  map1= intList.stream().collect(Collectors.groupingBy(i->i));
		System.out.println("map1");
		map1.forEach((k,v)->System.out.println("K : "+k + " V : "+v));
		
		Map<Object, Long>  map2= intList.stream().collect(Collectors.groupingBy(i->i,Collectors.counting()));
		System.out.println("map2");
		map2.forEach((k,v)->System.out.println("K : "+k + " V : "+v));
		
		Map<Object, Long>  map3= intList.stream().collect(Collectors.groupingBy(i->i,Collectors.counting()));
		System.out.println("map3");
		map3.forEach((k,v)->System.out.println("K : "+k + " V : "+v));
		
		list.stream().mapToInt(str -> str.length()).forEach(System.out::println);
		double averageLengthOfString = list.stream().mapToInt(str -> str.length()).average().getAsDouble();
		System.out.println("averageLengthOfString : " + averageLengthOfString);

	}
}
