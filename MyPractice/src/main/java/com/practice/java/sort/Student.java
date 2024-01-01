package com.practice.java.sort;

public class Student implements Comparable<Student> {

	int age;
	String name;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Student o) {

		return name.compareToIgnoreCase(o.getName());
		
	}

}
