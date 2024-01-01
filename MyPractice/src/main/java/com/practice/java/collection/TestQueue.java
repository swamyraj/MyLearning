package com.practice.java.collection;

import java.util.ArrayDeque;
import java.util.PriorityQueue;

public class TestQueue {

	public static void main(String[] args) {

		arraydequeTest();
		priorityQueueTest();
	}

	private static void priorityQueueTest() {
		PriorityQueue<String> list1 = new PriorityQueue<String>();

		list1.add("first");
		list1.add("second");
		list1.add("aith");

		System.out.println(list1);
		System.out.println(list1.remove());

		System.out.println(list1.peek());
		System.out.println(list1.poll());

		System.out.println(list1.isEmpty());
		System.out.println(list1.comparator());
	}

	private static void arraydequeTest() {

		ArrayDeque<Integer> queue = new ArrayDeque<>();

		queue.add(1);

		System.out.println(queue.size());

		System.out.println((0 - 1) & (16 - 1));
		System.out.println(-1 & 15);

	}

}
