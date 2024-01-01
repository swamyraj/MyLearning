package com.practice.java.java8;

public interface InterfaceTest {

	static String producer() {
	    return "N&F Vehicles";
	}
	
	static boolean isLegal() {
	    return true;
	}

	
	default String getOverview() {
	    return "ATV made by " + producer();
	}
	
	
	
}
