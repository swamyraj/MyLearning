package com.practice.java.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReEntrantLockTest {

	public static void main(String[] args) {

		PrinterQueue queue = new PrinterQueue();

		Thread[] threads = new Thread[10];
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(new PrinterJob(queue));
		}

		for (Thread thread : threads) {
			thread.start();
		}
	}

}

class PrinterJob implements Runnable {

	private PrinterQueue printerQueue;

	public PrinterJob(PrinterQueue printerQueue) {
		this.printerQueue = printerQueue;
	}

	@Override
	public void run() {
		printerQueue.print();
	}

}

class PrinterQueue {

	private final Lock lock = new ReentrantLock();

	public void print() {
		lock.lock();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("Printing document : " + Thread.currentThread().getName());
			lock.unlock();

		}

	}

}
