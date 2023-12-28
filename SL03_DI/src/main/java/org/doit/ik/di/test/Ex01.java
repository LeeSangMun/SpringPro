package org.doit.ik.di.test;

import org.doit.ik.di.RecordImple;
import org.doit.ik.di.RecordViewImple;

public class Ex01 {

	public static void main(String[] args) {
		System.out.println("Hello World");
		// p 59 스프링 컨테이너
		/*
		 * 1. org.doit.ik.di 패키지
		 * 	ㄴ Record.java 인터페이스
		 * 	ㄴ RecordImple.java 클래스
		 * 	ㄴ RecordView.java 인터페이스
		 * 	ㄴ RecordViewImple.java 클래스
		 * 
		 */
		
		RecordImple record = new RecordImple();
		
		// 생성자 통한 DI
		// RecordViewImple rvi = new RecordViewImple(record);
		
		RecordViewImple rvi = new RecordViewImple();
		rvi.setRecord(record);
		
		// RecordViewImple rvi = new RecordViewImple(new RecordImple());
		rvi.input();
		rvi.output();
		
		System.out.println("END");
		
		// 스프링에서처럼 설정파일 + 스프링컨텍스트 : 객체생성 + 조립
	}

}
