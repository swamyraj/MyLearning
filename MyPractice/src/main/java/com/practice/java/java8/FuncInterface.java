package com.practice.java.java8;

@FunctionalInterface
public interface FuncInterface {

	void abstractFunc(int x,int y);

	default void normalFunc() {
		System.out.println("Im normal function");
	}

}