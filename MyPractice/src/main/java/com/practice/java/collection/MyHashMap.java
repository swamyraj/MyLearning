package com.practice.java.collection;

import java.util.Arrays;

/**
 * https://www.devglan.com/java8/hashmap-custom-implementation-java
 *
 * @param <K>
 * @param <V>
 */
public class MyHashMap<K, V> {

	private static final int DEFAULT_CAPACITY = 16;
	private int size;
	Node<K, V>[] table;

	@SuppressWarnings("unchecked")
	public MyHashMap() {
		table = new Node[DEFAULT_CAPACITY];

	}

	public void put(K key, V value) {

		ensureCapacity();
		int index = calculateIndex(getHashCode(key));
		//System.out.println("index : "+index);
		Node<K, V> newNode = new Node<K, V>(key, value);

		if (table[index] == null) {
			table[index] = newNode;
		} else {
			Node<K, V> previous = null;
			Node<K, V> current = table[index];
			while (current != null) {
				if (current.getKey().equals(key)) {
					current.setValue(value);
					break;
				}
				previous = current;
				current = current.next;
			}
			if (previous != null) {
				previous.next = newNode;
			}
		}
		size++;
	}

	private void ensureCapacity() {
		if (table.length == size) {
			int newLength = (int) (table.length * 0.75);
			Arrays.copyOf(table, newLength);
		}

	}

	public int size() {
		return size;
	}

	private int getHashCode(K key) {
		if (key == null)
			return 0;
		return key.hashCode();
	}

	private int calculateIndex(int hashcode) {
		return (table.length - 1) & hashcode;
	}

	public V get(K key) {
		int index = calculateIndex(getHashCode(key));
		//System.out.println("index get : "+index);
		Node<K, V> current = table[index];
		while (current != null) {
			if (current.getKey() == key || (key != null && key.equals(current.getKey()))) {
				return current.getValue();
			}
			current = current.next;
		}
		return null;
	}

	public void display() {
		for (int i = 0; i < table.length; i++) {
			Node<K, V> node = table[i];
			while (node != null) {
				System.out.println("key: " + node.getKey() + " , value: " + node.getValue());
				node = node.next;
			}
		}
	}

	static class Node<K, V> {
		K key;
		V value;
		Node<K, V> next;

		public Node(K key, V value) {
			super();
			this.key = key;
			this.value = value;
		}

		public K getKey() {
			return key;
		}

		public V getValue() {
			return value;
		}

		public void setValue(V value) {
			this.value = value;
		}

	}

	public static void main(String[] args) {
		MyHashMap<String, Integer> map = new MyHashMap<>();
		System.out.println("map lenght: "+map.table.length);
		map.put("aa", 10);
		map.put("bbb", 20);
		map.put("cccc", 30);
		map.put(null, 40);
		map.display();
		System.out.println(map.get("aa"));
		System.out.println(map.get("ccccc"));
		System.out.println(map.get(null));
		System.out.println(map.size());
		System.out.println("map lenght: "+map.table.length);
	}
}
