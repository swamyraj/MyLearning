package com.practise.java.model;

import java.util.Random;

public class TaskA implements Runnable {

	private Integer jobNum;

	public TaskA() {

	}

	public TaskA(Integer index) {
		this.jobNum = index;
	}

	@Override
	public void run() {

		try {
			
			Thread.currentThread().setName(TaskA.class.getName());
			Thread.sleep(new Random().nextInt(1000));
			System.out.println(jobNum + " : I am from " + Thread.currentThread().getName());
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
