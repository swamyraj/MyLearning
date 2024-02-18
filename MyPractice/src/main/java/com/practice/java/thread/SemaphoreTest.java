package com.practice.java.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;

import com.practise.java.model.TaskA;

public class SemaphoreTest {

	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(2);

		Runnable r1 = () -> {

			try {semaphore.acquire();
				System.out.println(Thread.currentThread().getName() + " Available permit : " + semaphore.availablePermits());
				System.out.println(Thread.currentThread().getName() + " Number of threads waiting to acquire: " + semaphore.getQueueLength());

				System.out.println(Thread.currentThread().getName() + " is waiting");
				
				Thread.sleep(3000);
				System.out.println(Thread.currentThread().getName() + " is released");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				semaphore.release();
			}

		};

		ExecutorService executor = Executors.newFixedThreadPool(5);
		List<Future<?>> futures = new ArrayList<>();

		for (int i = 1; i <= 3; i++) {
			Future<?> f = executor.submit(r1);
			futures.add(f);
		}

	}
}
