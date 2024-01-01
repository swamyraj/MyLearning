package com.practice.java.collection;

import java.util.HashMap;

/**
 * backed by HashMap and doesn't provide get method , if you need to access
 * value using key ,use HashMap
 *
 * @param <E>
 */
public class MyHashSet<E> {

	private HashMap<E, Object> map;
	private static final Object DUMMY = new Object();

	public boolean add(E element) {
		return map.put(element, DUMMY) == null;
	}

	public void remove(E element) {
		map.remove(element);
	}

}
