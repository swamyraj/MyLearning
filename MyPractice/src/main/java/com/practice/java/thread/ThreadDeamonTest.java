package com.practice.java.thread;

import com.practise.java.model.TaskA;

/**
 *Creation: JVM creates Daemon threads, whereas an application creates its own user threads.
 *Usage: Daemon threads provide service to the user threads and always run in the background, whereas user threads are used for foreground and I/O tasks of an application.
 *Priority: Daemon threads are low-priority threads, whereas user threads are of high priority.
 *JVM Behavior: JVM does not wait for daemon threads execution to complete, whereas JVM waits till the execution of the user thread is finished.
 *Life Cycle: The daemon threads’ lifecycle depends on user threads, whereas user threads have an independent lifecycle.
 *Termination: All the daemon threads are terminated once the last user thread has been terminated, irrespective of the daemon thread’s position at that time, whereas user threads are terminated after completing their corresponding jobs.
 *
 *
 */
public class ThreadDeamonTest {

	
	public static void main(String[] args) {
		
		//not possible to set deamon for main thread
		//Thread.currentThread().setDaemon(true);
		
		Thread t1 = new Thread(new TaskA(1));
		t1.setDaemon(true);
		t1.start();
	}
}
