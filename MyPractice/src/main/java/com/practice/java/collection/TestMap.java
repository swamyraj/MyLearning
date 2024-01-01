package com.practice.java.collection;

import java.util.NavigableMap;
import java.util.TreeMap;

public class TestMap {

	public static void main(String[] args) {
		hashMapTest();
		linkedHashMapTest();
		treeMapTest();
	}

	private static void hashMapTest() {
		// TODO Auto-generated method stub

	}

	private static void linkedHashMapTest() {
		// TODO Auto-generated method stub

	}

	private static void treeMapTest() {
		TreeMap<String, Integer> map1 = new TreeMap<>();
		map1.put("aa", 10);
		map1.put("cc", 30);
		map1.put("bb", 20);
		System.out.println(map1);
		NavigableMap<String, Integer> descMap = map1.descendingMap();
		System.out.println(descMap);
		map1.pollFirstEntry();
		System.out.println(descMap);
		
	}

}
