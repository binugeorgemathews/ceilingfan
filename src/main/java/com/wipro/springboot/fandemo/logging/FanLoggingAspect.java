package com.wipro.springboot.fandemo.logging;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class FanLoggingAspect {
	
	
	private Logger myLogger= Logger.getLogger(getClass().getName());
	
	@Pointcut("execution (* com.wipro.springboot.fandemo.controller.*.*(..))")
	private void forContollerPackage() {
		
	}
	
	@Pointcut("execution (* com.wipro.springboot.fandemo.entity.*.*(..))")
	private void forHelperPackage() {
		
	}
	
	
	@Pointcut("execution (* com.wipro.springboot.fandemo.rest.*.*(..))")
	private void forRestPackage() {
		
	}

	@Pointcut("forContollerPackage() || forHelperPackage() || forRestPackage()")
	private void forAppFlow() {
		
	}
	
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		
		String theMethod= theJoinPoint.getSignature().toShortString();
		
		myLogger.info("=============>> in @Before calling method"+ theMethod);
		
		Object[] args = theJoinPoint.getArgs();
		
		for(Object tempArg: args ) {
			myLogger.info("=============>> arguments"+ tempArg);
		}
		
		
	}
	
	
	@AfterReturning(
			pointcut="forAppFlow()",
			returning="theResult"
			
			)
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
		
String theMethod= theJoinPoint.getSignature().toShortString();
		
		myLogger.info("=============>> in @After calling method"+ theMethod);
		
		Object[] args = theJoinPoint.getArgs();
		

			myLogger.info("=============>> results :"+ theResult.toString());
		
	}
	
}


