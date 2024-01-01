package com.example.demo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(5, 5, 3, 4, 6, 4,1,1,8,2);
		int[] arr = new int[]{5, 1, 3, 4, 6, 4,1,1,8,2};
		//getDuplet(10, list);
		getDupletOptimize(10, arr);
	}

	static void getDuplet(Integer x, List<Integer> list) {
		System.out.println("SUM="+x);
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				int sum = list.get(i) + list.get(j);
				if (sum == x) {
					System.out.println("DUPLET : (" + list.get(i) + "+" + list.get(j) + ")");
				}
			}
		}

	}
	
	public static int[] getDupletOptimize(int target,int[] array) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap();
        // n iterations
        for (int index = 0; index < array.length; index++) {
            // constant
            if (map.containsKey(target - array[index])) {
                result[1] = index;
                // constant
                result[0] = map.get(target - array[index]);
                System.out.println(result);
                return result;
            }
            // constant
            map.put(array[index], index);
            System.out.println(map);
        }
        return result;
    }

}
