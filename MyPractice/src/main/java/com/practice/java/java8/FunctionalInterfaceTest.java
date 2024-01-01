package com.practice.java.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;




public class FunctionalInterfaceTest {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		FuncInterface ff = (i,j)-> System.out.println(i*j);
		ff.abstractFunc(10,10);
		
		//provided by JDK
		Predicate<String> checkLength = t->t.length()>5;
		Predicate<String> checkLength2 = t->t.contains("s");
		
		
		System.out.println(checkLength.test("hi"));
		System.out.println(checkLength.negate().test("HI"));
		System.out.println("predicate and condition check : "+checkLength.and(checkLength2).test("hellomrs"));
		
		IntPredicate ip = t->t*t>0;
		System.out.println("Int predicate test : "+ip.test(10));
		
		
		
		List<String> list = Arrays.asList("Aa", "Bb", "Cc", "Dd", "Ab", "Bc");

		Predicate<String> startsWithA = s -> s.startsWith("A");
		Predicate<String> startsWithB = s -> s.startsWith("B");
		Predicate<Boolean> startsWithC = (s) -> 2>1;
		

		List<String> items = list.stream()
		  .filter(startsWithA.or(startsWithB))
		  .collect(Collectors.toList());

		System.out.println(items);
		items.forEach(s->System.out.println(s));
		
		
		Collections.sort(list, (o1,o2)->o1.compareToIgnoreCase(o2));
		list.forEach(s->System.out.println(s));
		
		TreeSet<Integer> h =  new TreeSet<>();
		h.add(850);
        h.add(235);
        h.add(1080);
        h.add(15);
        h.add(5);
        System.out.println("Elements of the TreeSet after" + 
                                        " sorting are: " + h);
		
		

        TreeMap<Integer, String> m = 
                   new TreeMap<Integer, String>((o1, o2) -> (o1 > o2) ? 
                                               -1 : (o1 < o2) ? 1 : 0);
        m.put(1, "Apple");
        m.put(4, "Mango");
        m.put(5, "Orange");
        m.put(2, "Banana");
        m.put(3, "Grapes");
        System.out.println("Elements of the TreeMap " + 
                             "after sorting are : " + m);
		
		
		User u1 =new User();
		User u2 =new User();
		
		Consumer<User> user1 = t->System.out.println(" Hi : "+t.getName());
		Consumer<User> user2 = t->System.out.println("Hello : "+t.getName());
		Consumer<User> user12 = user1.andThen(user2);
		
		u1.setName("swamy");
		u2.setName("raj");
		user1.accept(u1);
		user2.accept(u2);
		user12.accept(u1);
		
		List<Integer> list1 = Arrays.asList(1, 2);
		IntStream ddd= list1.stream().mapToInt(i->i*2);
		
		
		
		
		BiConsumer<Integer, Integer> bi = (i,j)->System.out.println("i+j = "+i+j);
		bi.accept(10, 20);
		
		//Supplier<String> s = t->return "l";
		Function<Integer, String> f = t -> t*2 +" : mutlipied by 2";
		System.out.println(f.apply(10));
		
		UnaryOperator<String> uo = t->t+"...";
		System.out.println(uo.apply("im unary operator"));
		
		BiFunction<Integer, Integer, String> bif = (i,j)->i*j + " multiply";
		System.out.println(bif.apply(10, 30));
		
		BinaryOperator<Integer> bo=(i,j)->i*j;
		System.out.println(bo.apply(50, 50));
		
		
		
		
		
		Thread.currentThread().setName("myThread");
		Runnable r = () -> {
			System.out.println("IM from thread");
			System.out.println(Thread.currentThread().getName() + " is running");
		};
		r.run();

		Thread t = new Thread(r);
		t.start();
		
		
		String str = "abc";
		System.out.println((str != null) && (!str.equals(""))
		            && (str.chars().allMatch(Character::isLetter)));
		
		
	}
}
