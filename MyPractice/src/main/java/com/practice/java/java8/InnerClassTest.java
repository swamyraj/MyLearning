package com.practice.java.java8;

public class InnerClassTest {

	
	class InnerCalss{
		public void display(){
			System.out.println("hi");
		}
	}
	
	InnerClassTest t =new InnerClassTest();
	InnerClassTest.InnerCalss c= t.new InnerCalss();
	
	
}
