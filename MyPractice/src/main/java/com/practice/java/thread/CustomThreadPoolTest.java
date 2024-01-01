package com.practice.java.thread;

import java.util.concurrent.LinkedBlockingQueue;

import com.practise.java.model.TaskA;

class CustomThreadPool {

	private final int poolSize;
	private final LinkedBlockingQueue<Runnable> queue;
	private final WorkerThread workers[];

	public CustomThreadPool(int poolSize) {
		this.poolSize = poolSize;
		this.queue = new LinkedBlockingQueue<>();
		this.workers = new WorkerThread[poolSize];

		for (int i = 0; i < poolSize; i++) {
			workers[i] = new WorkerThread();
			workers[i].start();
		}
	}

	public void execute(Runnable runnable) {
		synchronized (queue) {
			queue.add(runnable);
			queue.notify();
		}

	}

	private class WorkerThread extends Thread {

		@Override
		public void run() {
			Runnable task;
			while (true) {
				synchronized (queue) {
					while (queue.isEmpty()) {

						try {
							queue.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
					task = queue.poll();
				}
				task.run();
				System.out.println("RUN success: ");
			}
		}
	}

	public void shutdown() {
		System.out.println("Shutting down thread pool");
		for (int i = 0; i < poolSize; i++) {
			workers[i] = null;
		}
	}
}

public class CustomThreadPoolTest {

	public static void main(String[] args) {

		CustomThreadPool pool = new CustomThreadPool(2);
		for (int i = 1; i <= 5; i++) {
			TaskA a = new TaskA(i);
			pool.execute(a);
		}

		pool.shutdown();
	}

}
