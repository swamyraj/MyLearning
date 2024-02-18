package com.practice.java.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.practice.java.sort.Employee;

public class CollectionsSortingTest {
	public static void main(String[] args) {

		List<String> sList1 = Stream.of("ddd", "aaa", "bbbb").sorted().collect(Collectors.toList());
		List<String> sList2 = Stream.of("ddd", "aaa", "bbbb").sorted((o1, o2) -> o1.compareTo(o2))
				.collect(Collectors.toList());

		Employee e1 = new Employee();
		e1.setAge(40);
		e1.setName("basav");
		Employee e2 = new Employee();
		e2.setAge(50);
		e2.setName("anand");
		Employee e3 = new Employee();
		e3.setAge(30);
		e3.setName("anand");
		List<Employee> list = new ArrayList<>();
		list.add(e1);
		list.add(e2);
		list.add(e3);

		List<Employee> sList3 = Stream.of(e1, e2, e3).sorted((o1, o2) -> o1.getName().compareTo(o2.getName()))
				.collect(Collectors.toList());

		List<Employee> sList4 = Stream.of(e1, e2, e3)
				.sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getAge))
				.collect(Collectors.toList());

		Collections.sort(list, Comparator.comparing(Employee::getName).thenComparing(Employee::getAge));

		System.out.println(sList1);
		System.out.println(sList2);
		System.out.println(sList3);
		System.out.println(sList4);
		System.out.println(list);
	}

}
