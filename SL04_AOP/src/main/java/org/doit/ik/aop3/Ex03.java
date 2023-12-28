package org.doit.ik.aop3;

import org.doit.ik.aop.Calculator;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Ex03 {

	public static void main(String[] args) {
		// p 204 스프링 AOP
		// 1. Calculator 인터페이스 + - * /
		// 2. CalculatorImpl 클래스 구현
		// 3. Ex01.java 
		
		// sc/main
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("application-context3.xml");
		//Calculator calc = ctx.getBean("calc", Calculator.class);
		Calculator calc = ctx.getBean("calcProxy", Calculator.class);
		System.out.println(calc.add(3, 4));
		//System.out.println(calc.sub(3, 4));
		
		System.out.println("END");
	}

}

// [스프링 3가지 AOP 구현 방식]
// 1) 스프링 API를 이용한 AOP 구현
// 		org.doit.ik.aop2 패키지
//      org.doit,ik.aop2.advice 패키지
//				ㄴ LogPrintAroundAdvice
