package com.practice.java.thread;

public class ClassLevelLock {

}

class DemoClass4 {
	public static synchronized void method1() {

	}

}

class DemoClass5 {
	public void method1() {
		synchronized (DemoClass5.class) {

		}
	}
}

class DemoClass6 {

	private static final Object object = new Object();

	public void method1() {
		synchronized (object) {

		}
	}

}