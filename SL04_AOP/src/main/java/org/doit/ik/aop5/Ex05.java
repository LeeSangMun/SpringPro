package org.doit.ik.aop5;

import org.doit.ik.aop.Calculator;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Ex05 {

	public static void main(String[] args) {
		// p211 XML 스키마 기반의 AOP 구현 방식
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("application-context5.xml");
		//Calculator calc = ctx.getBean("calc", Calculator.class);
		Calculator calc = ctx.getBean("calc5", Calculator.class);
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
