package com.practice.java.collection;

import java.util.Arrays;

public class MyQueueUsingArray<T> {

	private Object[] array;
	int size;

	MyQueueUsingArray(){
		array = new Object[10];
		size=0;
	}
	
	public void offer(T element) {
		ensureCapacity();
		array[size] = element;
		size++;
	}

	public T poll() {
		if (size == 0) {
			throw new IndexOutOfBoundsException();
		}
		T t = (T) array[0];
		System.arraycopy(array, 1, array, 0, size-1);
		array[size-1] = null;
		size--;
		return t;
	}

	private void ensureCapacity() {

		if (size == array.length) {
			System.out.println("size:" + size + " , array length : " + array.length);
			int newSize = array.length * 2;
			array = Arrays.copyOf(array, newSize);
		}
	}

	public static void main(String[] args) {
		MyQueueUsingArray<Integer> queue = new MyQueueUsingArray<>();
		queue.offer(10);
		queue.offer(20);
		queue.offer(30);
		queue.offer(40);
		queue.offer(50);
		System.out.println(Arrays.toString(queue.array));
		System.out.println(queue.poll());
		System.out.println(Arrays.toString(queue.array));
		System.out.println(queue.poll());
		System.out.println(Arrays.toString(queue.array));
		System.out.println(queue.array.length);
		System.out.println(queue.size);

	}
}
