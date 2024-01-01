package com.practice.java.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeTest {

	public static void main(String[] args) {
		Employee e1 = new Employee();
		e1.setAge(100);
		e1.setName("swamy");
		
		Employee e2 = new Employee();
		e2.setAge(20);
		e2.setName("abc");
		
		List<Employee> list = new ArrayList<Employee>();
		list.add(e1);
		list.add(e2);
		
		Collections.sort(list, (o1,o2)->o1.getName().compareToIgnoreCase(o2.getName()));
		
		//Collections.sort(list,new EmployeeAgeComparator());
		//list.stream().forEach(s->System.out.println(s.getName()));
		
		//Collections.sort(list,new EmployeeNameComparator());
		list.stream().forEach(s->System.out.println(s.getName()));
	}
}
