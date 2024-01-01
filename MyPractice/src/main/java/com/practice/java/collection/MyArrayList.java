package com.practice.java.collection;

import java.util.Arrays;

public class MyArrayList<T> {

	private static final int DEFAULT_CAPACITY = 3;
	Object[] array;
	private int size;

	public MyArrayList() {
		this.array = new Object[DEFAULT_CAPACITY];
		this.size = 0;
	}

	public void add(T element) {
		ensureCapacity();
		array[size] = element;
		size++;
	}

	private void ensureCapacity() {

		if (size == array.length) {
			System.out.println("size:" + size + " , array length : " + array.length);
			int newSize = array.length * 2;
			array = Arrays.copyOf(array, newSize);
		}
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public T get(int index) {
		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return (T) array[index];
	}

	public void remove(int index) {
		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException();
		}
		System.arraycopy(array, index + 1, array, index, size - index - 1);
		array[size - 1] = null;
		size--;// decrement size
	}

	public static void main(String[] args) {
		MyArrayList<Integer> list = new MyArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);

		System.out.println("is list empty: " + list.isEmpty());
		System.out.println("list size    : " + list.size());
		System.out.println("first element: " + list.get(0));

		list.remove(0);
		System.out.println(Arrays.toString(list.array));
		System.out.println("list size after removal : " + list.size());
		list.remove(1);
		System.out.println(Arrays.toString(list.array));
		System.out.println("list size after removal : " + list.size());
	}

}
