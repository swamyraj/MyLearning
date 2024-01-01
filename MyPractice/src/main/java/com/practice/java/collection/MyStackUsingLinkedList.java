package com.practice.java.collection;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class MyStackUsingLinkedList<T> {

	private LinkedList<T> list;

	MyStackUsingLinkedList() {
		list = new LinkedList<>();
	}

	public void push(T element) {
		list.addFirst(element);
		//OR list.push(element);
	}

	public T pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return list.removeFirst();
		//OR : return list.pop();
	}

	public T peek() {
		if (list.isEmpty()) {
			throw new EmptyStackException();
		}
		return list.getFirst();
		// OR : return list.peek();
	}

	public int size() {
		return list.size();
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}

	public static void main(String[] args) {
		MyStackUsingLinkedList<Integer> stack = new MyStackUsingLinkedList<>();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);

		System.out.println(stack.list);
		System.out.println(stack.size());

		System.out.println("popped element: " + stack.pop());

		System.out.println(stack.list);
		System.out.println(stack.size());

		System.out.println("popped element: " + stack.pop());

		System.out.println(stack.list);
		System.out.println(stack.size());
	}
}
