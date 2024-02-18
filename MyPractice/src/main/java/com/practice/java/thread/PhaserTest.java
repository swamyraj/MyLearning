package com.practice.java.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Phaser;

public class PhaserTest {

	public static void main(String[] args) {
		Phaser p = new Phaser(4);
		p.register();

		Runnable r1 = () -> {

			try {
				p.arriveAndAwaitAdvance();
				System.out.println(Thread.currentThread().getName() + " Arrived parties : " + p.getArrivedParties());

				Thread.sleep(3000);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				p.arriveAndDeregister();
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
