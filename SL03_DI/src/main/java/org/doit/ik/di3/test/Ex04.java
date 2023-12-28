package org.doit.ik.di3.test;

import org.doit.ik.di3.RecordViewImple3;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Ex04 {

	public static void main(String[] args) {
		// Ex02.java 복사 + 붙이기
		
		String resourceLocations = "application-context3.xml";
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(resourceLocations);
		RecordViewImple3 rvi = (RecordViewImple3)ctx.getBean("rvi");
		
		rvi.input();
		rvi.output();
		
		System.out.println("END");
	}

}
