package com.practice.java.thread;

import com.practise.java.model.TaskA;
import com.practise.java.model.TaskB;

public class ThreadTest {
	
	public static void main(String[] args) {
		
		Thread t1 = new Thread(new TaskA(1));
		Thread t2 = new Thread(new TaskB());
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Finish");
	}

}
