package org.doit.ik.di4.test;

import org.doit.ik.di4.RecordViewImple4;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Ex05 {
	public static void main(String[] args) {
		// Ex02.java 복사 + 붙이기

		String resourceLocations = "application-context4.xml";
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(resourceLocations);
		RecordViewImple4 rvi = (RecordViewImple4) ctx.getBean("recordViewImple4");

		rvi.input();
		rvi.output();

		System.out.println("END");
	}
}
