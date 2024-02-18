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

	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + ", age=" + age + "]";
	}
	
	@Override
	public int hashCode() {
		return name.hashCode()+Integer.hashCode(age);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this==obj)return true;
		if(obj==null || getClass() != obj.getClass())return false;
		Employee e = (Employee)obj;
		if(e.getName().equals(name) && e.getAge()== age) return true;
		return false;
	}
}