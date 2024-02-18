package com.demo.auth.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	
	@Before(value = "* com.demo.auth.TestController.*(..)")
	public void beforeAdvice(JoinPoint joinPoint) {
		System.out.println("i am AOP boss");
	}
}
