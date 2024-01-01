package com.practice.java.thread;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.practise.java.model.TaskC;

public class ThreadInvokeAllTest {

	public static void main(String[] args) {

		ExecutorService executor = Executors.newFixedThreadPool(5);

		List<Callable<String>> tasks = Arrays.asList(new TaskC(1), new TaskC(2));

		try {

			executor.invokeAll(tasks);
			System.out.println("###### All tasks are submitted.");
			executor.shutdown();

			if (!executor.awaitTermination(2, TimeUnit.SECONDS)) {
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
