package com.practise.java.model;

public class TaskB implements Runnable {

	@Override
	public void run() {
		Thread.currentThread().setName(TaskB.class.getName());
		System.out.println("I am from " + Thread.currentThread().getName());
	}

}
