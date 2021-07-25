package com.wipro.springboot.fandemo.logging;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
/**
 * 
 * @author binu
 *AOP Class implemented for logging
 */
@Aspect
@Component
public class FanLoggingAspect {
	
	
	private Logger myLogger= Logger.getLogger(getClass().getName());
	/**
	 * method annotated for logging Controller package
	 */
	@Pointcut("execution (* com.wipro.springboot.fandemo.controller.*.*(..))")
	private void forContollerPackage() {
		
	}
	/**
	 * method annotated for logging Helper package
	 */
	@Pointcut("execution (* com.wipro.springboot.fandemo.entity.*.*(..))")
	private void forHelperPackage() {
		
	}
	
	/**
	 * method annotated for logging Rest package
	 */
	@Pointcut("execution (* com.wipro.springboot.fandemo.rest.*.*(..))")
	private void forRestPackage() {
		
	}
	/**
	 * method annotated for grouping all package annotations
	 */
	@Pointcut("forContollerPackage() || forHelperPackage() || forRestPackage()")
	private void forAppFlow() {
		
	}
	/**
	 * Before method annotated for logging entry into different methods and its arguments
	 * @param theJoinPoint
	 */
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		
		String theMethod= theJoinPoint.getSignature().toShortString();
		
		myLogger.info("=============>> in @Before calling method"+ theMethod);
		
		Object[] args = theJoinPoint.getArgs();
		
		for(Object tempArg: args ) {
			myLogger.info("=============>> arguments"+ tempArg);
		}
		
		
	}
	
	/**
	 * After Return method annotated for logging exit from different methods
	 * @param theJoinPoint
	 * @param theResult
	 */
	@AfterReturning(
			pointcut="forAppFlow()",
			returning="theResult"
			
			)
public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
		
       String theMethod= theJoinPoint.getSignature().toShortString();
		
		myLogger.info("=============>> in @After calling method"+ theMethod);
		
		myLogger.info("=============>> results :"+ theResult.toString());
		
	}
	
}


