package com.practice.java.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadCallableJava8 {

	public static void main(String[] args) {

		Callable<String> c1 = () -> {
			Thread.currentThread().setName("Runnable  1");
			System.out.println("I am from " + Thread.currentThread().getName());
			return "returned value from callble 1";
		};
		Callable<String> c2 = () -> {
			Thread.currentThread().setName("Runnable  2");
			System.out.println("I am from " + Thread.currentThread().getName());
			Thread.sleep(3000);
			return "returned value from callble 2";
		};
		Callable<String> c3 = () -> {
			Thread.currentThread().setName("Runnable  3");
			System.out.println("I am from " + Thread.currentThread().getName());
			return "returned value from callble 3";
		};
		
		
		
		try {
			
			ExecutorService service  = Executors.newFixedThreadPool(2);
			Future<String>  f1= service.submit(c1);
			Future<String>  f2= service.submit(c2);
			Future<String>  f3= service.submit(c3);
			
			System.out.println(f1.isDone() +".."+ f1.get());
			System.out.println(f2.isDone() +".."+ f2.get());
			System.out.println(f3.isDone() +".."+ f3.get());
			
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
