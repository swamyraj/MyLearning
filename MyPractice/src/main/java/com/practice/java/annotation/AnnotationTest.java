package com.practice.java.annotation;

import java.lang.reflect.Field;
import java.util.Arrays;

public class AnnotationTest{

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		
		EmployeeEntity e = new EmployeeEntity();
		
		e.setId(10L);
		System.out.println(Arrays.toString(e.getClass().getAnnotations()));
		System.out.println(Arrays.toString(e.getClass().getDeclaredAnnotations()));
		
		System.out.println(Arrays.toString(e.getClass().getDeclaredFields()));
		
		for (Field field : e.getClass().getDeclaredFields()) {
			MyFieldAnnotation m = field.getAnnotation(MyFieldAnnotation.class);
			System.out.println("type : "+m.type()+" name : "+m.name());
			
			field.setAccessible(true);
			 Object value = field.get(e); 
	         System.out.println("field value: " + value); 
		}
		
	}
	
	
	
}