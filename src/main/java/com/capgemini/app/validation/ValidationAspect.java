package com.capgemini.app.validation;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ValidationAspect {

	private static Logger logger = Logger.getLogger(ValidationAspect.class.getName());
	
	@Before("execution(* com.capgemini.app.calculator.*.*(..))")
	public void log()
	{
		logger.info("Before the method:");
	}
	
	@After("execution(* com.capgemini.app.calculator.*.*(..))")
	public void log1()
	{
		logger.info("After the method:");
	}
	
	@Around("execution(* com.capgemini.app.calculator.*.*(..))")
	public Object log2(ProceedingJoinPoint pjp) throws Throwable
	{
		logger.info("Before the method:");
		Object value = pjp.proceed();
		logger.info("After the method:");
		return value;
	}
	
	@AfterReturning(pointcut="execution(* com.capgemini.app.calculator.*.*(..))",returning="retval")
	public void log3(Integer retval)
	{
		logger.info(""+retval);
	}
	
	@AfterThrowing(pointcut="execution(* com.capgemini.app.calculator.*.*(..))",throwing="ex")
	public void log4(Exception ex)
	{
		logger.info(""+ex);
	}
}
