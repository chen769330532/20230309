package com.example.demo.TestAop;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAspect {

	@Pointcut("execution(public * com.example.demo.TestAop.Test.*Aop(..))")
	public void pointcut() {
	}

	@Before("pointcut()")
	public void test() {
		System.out.println(1);
	}

	@After("pointcut()")
	public void test2() {
		System.out.println(2);
	}

	@AfterReturning("pointcut()")
	public void test4() {
		System.out.println(4);
	}

	@Around("@annotation(com.example.demo.TestAop.MyAnnotation)")
	public String test4(ProceedingJoinPoint joinPoint) {
		System.out.println("执行了获取注解的方法");
		System.out.println("******拦截前的逻辑******");

		Signature signature = joinPoint.getSignature();
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		Annotation[] annotations = methodSignature.getMethod().getAnnotations();
		for (int i = 0; i < annotations.length; i++) {
			if (annotations[i] instanceof MyAnnotation) {
				System.out.println("输出对应的注解:" + annotations[i]);
			}
		}

		System.out.println("获取方法上的所有注解:" + Arrays.toString(annotations));
		MyAnnotation annotation = methodSignature.getMethod().getAnnotation(MyAnnotation.class);
		int id = annotation.id();
		System.out.println("方法注解上的id值:" + id);

		System.out.println("目标方法名为:" + signature.getName());
		System.out.println("目标方法所属类的简单类名:" + signature.getDeclaringType().getSimpleName());
		System.out.println("目标方法所属类的类名:" + signature.getDeclaringTypeName());
		System.out.println("目标方法声明类型:" + Modifier.toString(signature.getModifiers()));
		Object[] args = joinPoint.getArgs();
		for (int i = 0; i < args.length; i++) {
			System.out.println("第" + (i + 1) + "个参数为:" + args[i]);
		}

		System.out.println("被代理的对象:" + joinPoint.getTarget());
		System.out.println("代理对象自己:" + joinPoint.getThis());
		String args1 = "";
		try {
			args1 = (String) joinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("拦截的注解的参数：");
		return args1;
	}

	@Around("pointcut()")
	public String test3(ProceedingJoinPoint pjp) {
		String proceed = "";
		try {
			proceed = (String) pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println(3);
		return proceed;
	}

}
