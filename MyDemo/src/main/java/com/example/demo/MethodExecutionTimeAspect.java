package com.example.demo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MethodExecutionTimeAspect {

	@Around("@annotation(LogExecutionTime)")
	public Object logExecutionTime(ProceedingJoinPoint jointPoint) throws Throwable {
		long start = System.currentTimeMillis();
		Object proceed = jointPoint.proceed();
		long time = System.currentTimeMillis() - start;
		System.out.println(jointPoint.getSignature() + " Executed in " + time + " ms");
		return proceed;
	}
}
