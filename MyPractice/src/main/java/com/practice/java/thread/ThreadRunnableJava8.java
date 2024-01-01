package com.practice.java.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadRunnableJava8 {

	public static void main(String[] args) {

		Runnable r1 = () -> {
			Thread.currentThread().setName("Runnable  1");
			System.out.println("I am from " + Thread.currentThread().getName());

		};
		Runnable r2 = () -> {
			Thread.currentThread().setName("Runnable  2");
			System.out.println("I am from " + Thread.currentThread().getName());
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		};
		Runnable r3 = () -> {
			Thread.currentThread().setName("Runnable  3");
			System.out.println("I am from " + Thread.currentThread().getName());

		};

		try {

			ExecutorService service = Executors.newFixedThreadPool(2);
			Future<?> f1 = service.submit(r1);
			Future<?> f2 = service.submit(r2);
			Future<?> f3 = service.submit(r3);

			System.out.println(f1.isDone() + ".." + f1.get());
			System.out.println(f2.isDone() + ".." + f2.get());
			System.out.println(f3.isDone() + ".." + f3.get());

			service.shutdown();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
