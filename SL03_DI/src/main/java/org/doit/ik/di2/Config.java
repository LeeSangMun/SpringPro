package org.doit.ik.di2;

import org.doit.ik.di.RecordImple;
import org.doit.ik.di.RecordViewImple;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// application-context.xml === 자바클래스 설정 파일
// p 85
@Configuration
public class Config {
	@Bean
	public RecordImple record() {
		return new RecordImple();
	}
	
	/*
	@Bean
	public RecordViewImple rvi() {
		return new RecordViewImple(record());
	}
	*/
	
	@Bean(name = "rvi")
	public RecordViewImple getRecordViewImple() {
		RecordViewImple rvi = new RecordViewImple();
		rvi.setRecord(record());
		return rvi;
	}
}
