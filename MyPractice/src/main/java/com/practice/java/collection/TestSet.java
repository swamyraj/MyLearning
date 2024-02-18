package com.practice.java.collection;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import com.practise.java.model.Employee;

public class TestSet {

	public static void main(String[] args) {

		hashSetTest();
		//linkedHashTest();
		//treeSetTest();

	}

	
	private static void hashSetTest() {
		Set<Integer> set1 = new HashSet<>();
		set1.add(50);
		set1.add(10);
		set1.add(20);
		System.out.println(set1);
		System.out.println(set1.contains(10));

		Employee e1 = new Employee("swamy", 2000, 32, null);
		Employee e2 = new Employee("swamy", 2000, 32, null);
		Set<Employee> eset = new HashSet();
		eset.add(e1);
		eset.add(e2);
		System.out.println(eset);
		
		
	}

	private static void linkedHashTest() {
		Set<Integer> set1 = new LinkedHashSet<>();
		set1.add(50);
		set1.add(10);
		set1.add(20);
		System.out.println(set1);
		System.out.println(set1.contains(10));
	}
	
	private static void treeSetTest() {
		TreeSet<Integer> set1 = new TreeSet<>();
		set1.add(50);
		set1.add(10);
		set1.add(20);
		System.out.println(set1);
		
		System.out.println(set1.ceiling(20));
		set1 = (TreeSet<Integer>) set1.descendingSet();
		System.out.println(set1);
		
		set1.pollFirst();
		System.out.println(set1);
		
		
		
	}


}
