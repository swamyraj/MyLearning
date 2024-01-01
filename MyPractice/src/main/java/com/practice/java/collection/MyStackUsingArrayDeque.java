package com.practice.java.collection;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.EmptyStackException;

public class MyStackUsingArrayDeque<T> {

	private Deque<T> dequeue;

	MyStackUsingArrayDeque() {
		dequeue = new ArrayDeque<>();
	}

	public void push(T element) {
		dequeue.push(element);
	}

	public T pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return dequeue.pop();
	}

	public T peek() {
		if (dequeue.isEmpty()) {
			throw new EmptyStackException();
		}
		return dequeue.peek();
	}

	public int size() {
		return dequeue.size();
	}

	public boolean isEmpty() {
		return dequeue.isEmpty();
	}

	public static void main(String[] args) {
		MyStackUsingArrayDeque<Integer> stack = new MyStackUsingArrayDeque<>();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);

		System.out.println(stack.dequeue);
		System.out.println(stack.size());

		System.out.println("popped element: " + stack.pop());

		System.out.println(stack.dequeue);
		System.out.println(stack.size());

		System.out.println("popped element: " + stack.pop());

		System.out.println(stack.dequeue);
		System.out.println(stack.size());
	}

}
