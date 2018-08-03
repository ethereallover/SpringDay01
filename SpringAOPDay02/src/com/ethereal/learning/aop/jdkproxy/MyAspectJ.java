package com.ethereal.learning.aop.jdkproxy;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspectJ {
	
	public void methodBefore(JoinPoint joinPoint){
		System.out.println("前置通知:"+joinPoint.getSignature().getName());
	}
	
	public void methodAfter(JoinPoint joinPoint,Object result){
		System.out.println("后置通知:"+joinPoint.getSignature().getName()+",返回值:"+result);
	}
	
	public Object methodAround(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("环绕前:"+joinPoint.getSignature().getName());
		Object proceed = joinPoint.proceed();
		System.out.println("环绕后:"+joinPoint.getSignature().getName());
		return proceed;
	}
	
	public void methodException(JoinPoint joinPoint,Throwable throwable){
		System.out.println("抛出异常通知："+joinPoint.getSignature().getName()+",异常信息："+throwable.getMessage());
	}
	
	public void methodFinal(JoinPoint joinPoint){
		System.out.println("最终通知："+joinPoint.getSignature().getName());
	}
}
