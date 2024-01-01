package com.practice.java.sort;

import java.util.Comparator;

public class EmployeeAgeComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		
		// return Integer.compare(o1.getAge(), o2.getAge());
		return o1.getAge() < o2.getAge() ? -1 : (o1.getAge() == o1.getAge() ? 0 : 1);

	}

}
