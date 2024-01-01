package com.practise.java.model;

public class Employee{
	
	private String name;
	private double salary;
	private int age;
	private Address address;
	
	public Employee(String name, double salary, int age, Address address) {
		super();
		this.name = name;
		this.salary = salary;
		this.age = age;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	
}