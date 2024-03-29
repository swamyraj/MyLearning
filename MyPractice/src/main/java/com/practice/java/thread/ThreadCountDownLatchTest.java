package com.practice.java.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * https://howtodoinjava.com/java/multi-threading/when-to-use-countdownlatch-java-concurrency-example-tutorial/
 *
 */
public class ThreadCountDownLatchTest {

	// List of service checkers
	private static List<BaseHealthChecker> _services;

	// This latch will be used to wait on
	private static CountDownLatch _latch;

	public static boolean checkExternalServices() throws Exception {
		// Initialize the latch with number of service checkers
		_latch = new CountDownLatch(3);

		// All add checker in lists
		_services = new ArrayList<BaseHealthChecker>();
		_services.add(new NetworkHealthChecker(_latch));
		_services.add(new CacheHealthChecker(_latch));
		_services.add(new DataBaseHealthChecker(_latch));

		// Start service checkers using executor framework
		Executor executor = Executors.newFixedThreadPool(_services.size());

		for (final BaseHealthChecker v : _services) {
			executor.execute(v);
		} 

		// Now wait till all services are checked
		_latch.await();

		// Services are file and now proceed startup
		for (final BaseHealthChecker v : _services) {
			if (!v.isServiceUp()) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		try {
			ThreadCountDownLatchTest.checkExternalServices();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
