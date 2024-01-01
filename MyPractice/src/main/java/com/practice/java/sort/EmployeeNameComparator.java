package com.practice.java.sort;

import java.util.Comparator;

public class EmployeeNameComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		// return o1.getName().compareToIgnoreCase(o2.getName());

		int m = o1.getName().length();
		int n = o2.getName().length();
		if (m != n)
			return -1;
		char[] arr1 = o1.getName().toCharArray();
		char[] arr2 = o2.getName().toCharArray();
		int i = 0;
		while (i++ <= m) {
			if (arr1[i] != arr2[i]) {
				return -1;
			}
			i++;
		}
		return 0;
	}

}
