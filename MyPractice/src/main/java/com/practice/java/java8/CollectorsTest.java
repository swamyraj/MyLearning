package com.practice.java.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.practise.java.model.Employee;



public class CollectorsTest {

	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("Geeks", "for", "gfg","GeeksforGeeks", "GeeksQuiz"); 
		
		List<Employee> empList = new ArrayList<Employee>();
		List<Integer> intList = new ArrayList<>();
		
		Employee e1=new Employee("swamy", 15000.00, 32, null);
		Employee e2=new Employee("raj", 35000.00, 33, null);
		empList.add(e1);
		empList.add(e2);
		
		List<String> nameList= empList.stream().map(o->o.getName()).collect(Collectors.toList());
		System.out.println("nameList : "+nameList);
		
		Long count= empList.stream().mapToInt(o->o.getAge()).count();
		System.out.println(count);
		
		list.stream().mapToInt(str->str.length()).forEach(System.out::println);
		double averageLengthOfString = list.stream().mapToInt(str->str.length()).average().getAsDouble();
		System.out.println("averageLengthOfString : "+averageLengthOfString);
		
		
		
		
	}
}
