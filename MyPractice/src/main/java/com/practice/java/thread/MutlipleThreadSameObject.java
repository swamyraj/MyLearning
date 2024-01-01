package com.practice.java.thread;

import com.practise.java.model.TaskA;

public class MutlipleThreadSameObject {

public static void main(String[] args) {
		TaskA task = new TaskA(1);
		Thread t1 = new Thread(task);
		Thread t2 = new Thread(task);
		
		t1.start();
		t2.start();
		
		
		System.out.println("Finish : "+Thread.activeCount());
		
		Object x = 1;
		Object y = "1";
		if(x == y) {
			System.out.println("hii");
		}
		
		String m = "a";
		String n = "a";
		if(m.equals(n)) {
			System.out.println("hello");
		}
	}
}
