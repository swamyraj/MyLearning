package com.practice.java.collection;

import java.util.Stack;

/**
 * Queue using two stacks
 *
 * @param <T>
 */
public class MyQueueUsingTwoStacks<T> {

	private Stack<T> stack1 = new Stack<>();
	private Stack<T> stack2 = new Stack<>();

	public void enQueue(T item) {
		stack1.push(item);
	}

	public T dequeue() {

		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		if (!stack2.isEmpty()) {
			return stack2.pop();
		} else {
			return null;
		}

	}

	public boolean isEmpty() {
		return stack1.isEmpty() && stack2.isEmpty();
	}

	public int size() {
		return stack1.size() + stack2.size();
	}

	public static void main(String[] args) {

		MyQueueUsingTwoStacks<Integer> q = new MyQueueUsingTwoStacks<>();
		q.enQueue(1);
		q.enQueue(2);
		System.out.println(q.dequeue());
		q.enQueue(3);
		System.out.println(q.dequeue());

	}

}
