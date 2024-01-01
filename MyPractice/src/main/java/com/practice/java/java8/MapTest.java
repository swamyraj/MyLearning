package com.practice.java.java8;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class MapTest {

	
	public static void main(String[] args) {
		
		
		Map<Integer,String> map = new HashMap<>();
		
		map.put(1, "swamy");
		map.put(2, "raj");
		map.put(3, "bob");
		map.put(4, "pop");
		
		Set<Integer> keys = map.keySet();
		System.out.println(keys);
		keys.remove(1);
		System.out.println(keys);
		System.out.println(map);
		
		Collection<String> coll= map.values();
		System.out.println(coll);
		coll.remove("pop");
		System.out.println(coll);
		System.out.println(map);
		
		Set<Map.Entry<Integer, String>>  set = map.entrySet();
		
		List<Entry<Integer, String>> intList= set.stream().filter(o->o.getKey()==2).collect(Collectors.toList());
		System.out.println(intList);
		
		Set<Integer> set1 = set.stream().map(o->o.getKey()).collect(Collectors.toSet());
		System.out.println(set1);
		
		for (Map.Entry<Integer, String> entry : set) {
			System.out.println(entry.getKey()+"..."+entry.getValue());
			
		}
		
		
		
		
		
		
	}
	
	
	
}
