package com.practice.java.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

	public static void main(String[] args) {
		CyclicBarrier cb = new CyclicBarrier(3,()-> {
			
			System.out.println(Thread.currentThread().getName()+" All previous tasks are completed");
		});
		
		Runnable r1= ()->{
			
			try {
				System.out.println(Thread.currentThread().getName() + 
			              " is waiting");
				cb.await();
				System.out.println(Thread.currentThread().getName() + 
			              " is released");
			} catch (InterruptedException | BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		};
		Thread t1 = new Thread(r1, "T1"); 
		Thread t2 = new Thread(r1, "T2"); 
		Thread t3 = new Thread(r1, "T3"); 
		
		if (!cb.isBroken()) { 
	        t1.start(); 
	        t2.start(); 
	        t3.start(); 
	    }


	}
}


