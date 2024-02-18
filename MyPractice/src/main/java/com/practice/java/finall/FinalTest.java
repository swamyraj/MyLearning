package com.practice.java.finall;

public class FinalTest {
	public static void main(String[] args) {
		MyFinal f =new MyFinal("bob", 1);
		System.out.println(f.getName());
	}
}

final class MyFinal{
	
	String name;
	int age;
	public MyFinal(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	
	
}
