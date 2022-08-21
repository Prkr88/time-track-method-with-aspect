package com.aspectDemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class BasicAspectAccess {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// intercept before method start
	@Before("com.aspectDemo.aspect.CommonJoinPointConfig.beanContainingDao()")
	public void before(JoinPoint joinPoint) {
		//in addition you can check if the method is allowed for the user.
		logger.info("before execution for {}", joinPoint);
	}

	// intercept after method start
	@After("execution(* com.aspectDemo.business.*.*(..))")
	public void after(JoinPoint joinPoint) {
		logger.info("after execution of {}", joinPoint);
	}

	// intercept after method start
	@AfterReturning("execution(* com.aspectDemo.business.*.*(..))")
	public void afterReturning(JoinPoint joinPoint) {
		logger.info("after returning of {}", joinPoint);
	}

	@Around("com.aspectDemo.aspect.CommonJoinPointConfig.trackTimeAnnotation()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		long startTime = System.currentTimeMillis();

		Object o  = joinPoint.proceed();

		long timeTaken = System.currentTimeMillis() - startTime;
		logger.info("Time Taken by {} is {}ms", joinPoint, timeTaken);
		return o;
	}
}

