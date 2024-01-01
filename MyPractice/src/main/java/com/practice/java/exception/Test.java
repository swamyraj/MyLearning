package com.practice.java.exception;

public class Test {

	void check() throws CustomException {
		System.out.println("check");
	}

	public static void main(String[] args) {
		Test t = new Test();
		t.check();
	}
}
