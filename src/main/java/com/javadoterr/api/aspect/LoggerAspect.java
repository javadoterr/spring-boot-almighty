package com.javadoterr.api.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {
	
	private static Logger logger = LogManager.getLogger(LoggerAspect.class);
	
	@Pointcut(value = "execution(* com.javadoterr.api.*.*.*(..))")
	private void generalPointCut() {
		
	}
	
	
	@AfterThrowing(pointcut = "generalPointCut() throws Exception", throwing = "ex")
	public void exceptionLog(JoinPoint joinPoint, Exception ex) throws Exception{
		logger.error(joinPoint.getTarget().getClass().getSimpleName()
				+" : "+joinPoint.getSignature().getName()+" : "+ ex.getMessage());
	}
	
	
	
	@Before("generalPointCut()")
	public void infoLog(JoinPoint joinPoint) {
		logger.info(joinPoint.getTarget().getClass().getSimpleName()
				+" : "+joinPoint.getSignature().getName());
	}
	
	
	
	

}
