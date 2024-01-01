package com.practice.java.thread;

public class ObjectLevelLockTest {

}

class DemoClass {
	public synchronized void demoMethod() {
		System.out.println("");
	}
}

class DemoClass1 {

	public void demoMethod() {
		synchronized (this) {
			System.out.println("");
		}
	}
}

class DemoClass2 {
	private final Object lock = new Object();

	public void demoMethod() {
		synchronized (lock) {

		}
	}

}
