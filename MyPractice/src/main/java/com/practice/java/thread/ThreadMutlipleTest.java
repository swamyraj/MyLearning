package com.practice.java.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.practise.java.model.TaskA;

public class ThreadMutlipleTest {

	public static void main(String[] args) {
		
		ExecutorService executor = Executors.newFixedThreadPool(5);

		List<Future<?>> futures = new ArrayList<>();

		for (int i = 1; i <= 10; i++) {
			Future<?> f = executor.submit(new TaskA(i));
			futures.add(f);
		}
		System.out.println("###### All tasks are submitted.");

		for (Future<?> f : futures) {
		  try {
			  
			//waits for all tasks to complete
			f.get();
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

		System.out.println("###### All tasks are completed.");
		
		
	}
}
