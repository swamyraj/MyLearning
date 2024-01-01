package com.practice.java.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestList {

	public static void main(String[] args) {
		arrayListTest();
		linkedListTest();
	}

	public static void arrayListTest() {
		List<Integer> intList = new ArrayList<Integer>();
		intList.add(1);
		intList.remove(0);
	}

	public static void linkedListTest() {

		List<Integer> list = new LinkedList<Integer>();
		list.add(10);
		list.add(20);
		list.add(30);
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		list.remove(0);
		System.out.println(list);

		System.out.println();

		LinkedList<String> list1 = new LinkedList<String>();
		list1.push("first");
		list1.push("second");
		list1.push("third");

		System.out.println(list1);
		System.out.println(list1.getFirst());
		System.out.println(list1.getLast());
		System.out.println();
		System.out.println(list1.peek());
		System.out.println(list1.peekFirst());
		System.out.println(list1.peekLast());
		System.out.println();
		System.out.println(list1.isEmpty());
		System.out.println(list1.pollFirst());
		System.out.println(list1);

		LinkedList<Integer> list2 = new LinkedList<>();

		list2.addFirst(10);
		list2.addFirst(20);
		list2.addFirst(30);
		list2.addFirst(40);
		list2.addFirst(50);
		list2.addLast(60);
		list2.addLast(70);
		// list2.display();
		System.out.println(list2);

		System.out.println(list2.getFirst());
		System.out.println(list2.getLast());

	}
}
