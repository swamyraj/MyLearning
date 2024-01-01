package com.practice.java.design.pattern;

public class SingletonDesginPattern {

	private static SingletonDesginPattern instance;

	private SingletonDesginPattern() {

	}

	public SingletonDesginPattern getInstance() {
		if (instance == null) {
			synchronized (SingletonDesginPattern.class) {
				if (instance == null) {
					instance = new SingletonDesginPattern();
				}
			}
		}
		return instance;
	}
	
	
	//OR
	
	private static class SingletonDesginPatternHelper {
		private static final SingletonDesginPattern INSTANCE = new SingletonDesginPattern();
	}

	public SingletonDesginPattern getInstance1() {
		return SingletonDesginPatternHelper.INSTANCE;
	}
}
