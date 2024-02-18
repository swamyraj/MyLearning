package com.practice.java.annotation;

public class EmployeeEntity {

	@MyFieldAnnotation(name = "employeeId", type = Long.class,isPrimaryKey = true)
	private Long id;
	
	@MyFieldAnnotation(name = "employeeName", type = String.class)
	private String name;
	
	@MyFieldAnnotation(name = "employeeAge", type = Integer.class)
	private int age;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
}

