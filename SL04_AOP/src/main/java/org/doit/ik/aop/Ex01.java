package org.doit.ik.aop;

public class Ex01 {

	public static void main(String[] args) {
		// p 204 스프링 AOP
		// 1. Calculator 인터페이스 + - * /
		// 2. CalculatorImpl 클래스 구현
		// 3. Ex01.java 
		
		Calculator calc = new CalculatorImpl();
		System.out.println(calc.add(4, 2));
		System.out.println(calc.sub(4, 2));
		System.out.println(calc.mult(4, 2));
		System.out.println(calc.div(4, 2));
		
		System.out.println("END");
	}

}

// [스프링 3가지 AOP 구현 방식]
// 1) 스프링 API를 이용한 AOP 구현
// 		opr.doit.it.aop2 패키지
