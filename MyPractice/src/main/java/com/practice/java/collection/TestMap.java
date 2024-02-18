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

	
	// balanced binary tree - red black tree
	private static void treeMapTest() {
		TreeMap<Integer, String> map1 = new TreeMap<>();
		map1.put(10,"aa");
		map1.put(30,"cc");
		map1.put(20,"bb");
		map1.put(60,"bb");
		map1.put(40,"bb");
		map1.put(50,"bb");
		System.out.println(map1);
		
		NavigableMap<Integer,String> descMap = map1.descendingMap();
		System.out.println(descMap);
		System.out.println();
		//map1.pollFirstEntry();
		//System.out.println(descMap);
		System.out.println("Ceiling key : "+map1.ceilingKey(30));
		System.out.println("floor key : "+map1.floorKey(30));
		System.out.println();
		System.out.println("Head map : "+map1.headMap(30));
		System.out.println("Head map desc: "+descMap.headMap(30));
		
		System.out.println("tail map : "+map1.tailMap(30));
		
	
		
	}

}
