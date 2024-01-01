package com.practice.java.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.practise.java.model.TaskA;

public class ThreadAwaitTerminationTest {

public static void main(String[] args) {
		
		ExecutorService executor = Executors.newFixedThreadPool(5);
		
		for (int i = 1; i <= 10; i++) {
			executor.submit(new TaskA(i));
			
		}
		System.out.println("###### All tasks are submitted.");

		executor.shutdown();
		
		try {
			
			if(!executor.awaitTermination(2, TimeUnit.SECONDS)) {
				System.out.println("hii");
				executor.shutdownNow();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			executor.shutdownNow();
		}
		

		System.out.println("###### All tasks are completed.");
		
		
	}
}
