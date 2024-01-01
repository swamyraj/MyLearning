package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Employee {

	String name;
	List<Address> adresses;

	
	
	
	public Employee(String name, List<Address> adresses) {
		super();
		this.name = name;
		this.adresses = adresses;
	}




	public String getName() {
		return name;
	}





	public List<Address> getAdresses() {
		return adresses;
	}




	


	public static void main(String[] args) {
		List<Address> adresses = new ArrayList<>();
		
		Address a =new Address(123);
		Address b =new Address(345);
		adresses.add(a);
		adresses.add(b);
		
		
		final Employee e = new Employee("bob",adresses);
		System.out.println(e.getName());
		
		
		
	}
}
