package com.practice.java.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompletableFutureTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		CompletableFuture<Void> cf1 = CompletableFuture.runAsync(() -> System.out.println("I am from runAsync"));
		System.out.println(cf1.isDone());
		CompletableFuture<Integer> cf2 = CompletableFuture.supplyAsync(() -> 2 * 1);
		System.out.println(cf1.isDone());

		CompletableFuture<String> c1 = test1();
		System.out.println(c1.get());
		CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello");
		CompletableFuture<String> f1 = future.thenApply(s -> s + " World");
		System.out.println(f1.get());
		f1.thenAccept(s->System.out.println(s));
		CompletableFuture<String> f2 = f1.thenCompose(s->CompletableFuture.supplyAsync(()->s+" India"));
		System.out.println(f2.get());
		
		CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(f1,f2);
		System.out.println(combinedFuture.get());
		
		String combined = Stream.of(f1,f2).map(CompletableFuture::join).collect(Collectors.joining());
		System.out.println("combined : "+combined);
		
		//String name = "swamy";
		String name = null;
		CompletableFuture<String> f5 = CompletableFuture.supplyAsync(() -> {
			if (name == null) {
				throw new RuntimeException();
			}
			return "Hello " + name;
		}).handle((s, t) -> (s != null ? s : "Hello stranger"+t.getMessage()));
		System.out.println(f5.get());

		ForkJoinPool pool = new ForkJoinPool(4);
		ForkJoinTask<String> f6 = pool
				.submit(() -> Stream.of("Hiiiiiii ", "Hellooo").parallel().reduce("", (s1, s2) -> s1 + s2));
		System.out.println(f6.get());
		pool.shutdown();
		
	}

	public static CompletableFuture<String> test1() {
		CompletableFuture<String> completableFuture = new CompletableFuture<>();
		Executors.newCachedThreadPool().submit(() -> {
			Thread.sleep(1000);
			completableFuture.complete("Hello");
			return null;
		});
		return completableFuture;

	}
}
