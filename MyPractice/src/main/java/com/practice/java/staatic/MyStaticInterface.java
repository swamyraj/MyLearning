package com.practice.java.staatic;

public interface MyStaticInterface {

	// cannot override static methods
	public static void staticTest() {
		System.out.println("staticTest");
	}

	public default void defaultTest() {
		System.out.println("defaultTest");
	}

	public void mytest();
}

abstract class MyAbstract implements MyStaticInterface {
	
	public MyAbstract() {
		System.out.println("MyAbstract : constructor");
	}

	@Override
	public void defaultTest() {
		System.out.println("MyAbstract : defaultTest");
		MyStaticInterface.super.defaultTest();
	}

	// cannot override static methods
	public void staticTest() {
		System.out.println("MyAbstract : staticTest");
	}

	public static void abstractTest() {
		System.out.println("MyAbstract : abstractTest");
	}
}

class MyStatic extends MyAbstract {
	
	@Override
	public void defaultTest() {
		// TODO Auto-generated method stub
		super.defaultTest();
	}
	
	//@Override
	public void abstractTest1() {
		System.out.println("MyStatic : abstractTest");
	}
	
	//@Override
	public void mytest() {
		System.out.println("MyStatic : mytest");
	}

	public static void testA() {
		System.out.println("Hii");
	}

	public static void main(String[] args) {
		MyStaticInterface i1 = new MyStatic();
		i1.mytest();
		i1.defaultTest();
		MyStaticInterface.staticTest();

		MyStatic i2 = new MyStatic();
		i2.abstractTest();
		i2.defaultTest();
		i2.mytest();
		i2.staticTest();
		i2.testA();
	}
}