package com.practice.java.array;
import java.util.HashMap;
import java.util.Map;

public class FindDuplicate {

	public static void main(String[] args) {

		int[] arr = { 1, 1, 2, 2, 1, 2 , 4, 5, 3, 3, 3,3 };

		Map<Integer, String> map = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {

			if (map.containsKey(arr[i])) {
				String s = map.get(arr[i]);
				String[] strArr = s.split("_");
				int count = Integer.valueOf(strArr[0]);
				int index = Integer.valueOf(strArr[1]);
				count++;
				map.put(arr[i], count + "_" + index);

			} else {
				map.put(arr[i], "1_" + i);
			}
		}
		for (Map.Entry<Integer, String> entry : map.entrySet()) {
			String s = entry.getValue();
			String[] strArr = s.split("_");
			int count = Integer.valueOf(strArr[0]);
			int index = Integer.valueOf(strArr[1]);
			if (count > 1) {
				System.out.println("key : "+entry.getKey()+" , count : " + count+" , First index :" + index);
				
			}

		}

	}
}
