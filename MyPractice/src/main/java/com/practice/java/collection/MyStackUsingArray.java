package com.practice.java.collection;

import java.util.Arrays;
import java.util.EmptyStackException;

public class MyStackUsingArray<T> {

	private static final int DEFAULT_CAPACITY = 10;
	private int size;
	private Object[] array;

	MyStackUsingArray() {
		this.array = new Object[DEFAULT_CAPACITY];
		this.size = 0;
	}

	public void push(T element) {
		ensureCapacity();
		array[size] = element;
		size++;

	}

	private void ensureCapacity() {

		if (size == array.length) {
			System.out.println("size:" + size + " , array length : " + array.length);
			System.out.println("Increasing the capacity");
			int newSize = array.length * 2;
			array = Arrays.copyOf(array, newSize);
		}
	}

	public T pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}

		T element = (T) array[size - 1];
		array[size - 1] = null;
		size--;
		return element;
	}

	public T peek() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return (T) array[size - 1];
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public static void main(String[] args) {
		MyStackUsingArray<Integer> stack = new MyStackUsingArray<>();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);

		System.out.println(Arrays.toString(stack.array));
		System.out.println(stack.size());

		System.out.println("popped element: " + stack.pop());

		System.out.println(Arrays.toString(stack.array));
		System.out.println(stack.size());

		System.out.println("popped element: " + stack.pop());

		System.out.println(Arrays.toString(stack.array));
		System.out.println(stack.size());
	}
}
