package com.practice.java.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentTest {

	public static void main(String[] args) {
		Student s1 = new Student();
		s1.setAge(10);
		s1.setName("swamy");
		
		Student s2 = new Student();
		s2.setAge(10);
		s2.setName("abc");
		
		List<Student> list = new ArrayList<Student>();
		list.add(s1);
		list.add(s2);
		
		Collections.sort(list);
		list.stream().forEach(s->System.out.println(s.getName()));
	}
}

