package com.practise.java.model;

import java.util.Random;
import java.util.concurrent.Callable;

public class TaskC implements Callable<String> {

	private Integer jobNum;

	public TaskC() {

	}

	public TaskC(Integer index) {
		this.jobNum = index;
	}

	@Override
	public String call() throws Exception {

		try {

			Thread.currentThread().setName(TaskC.class.getName());
			Thread.sleep(new Random().nextInt(1000));
			System.out.println(jobNum + " : I am from " + Thread.currentThread().getName());

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "finished " + jobNum;
	}

}
