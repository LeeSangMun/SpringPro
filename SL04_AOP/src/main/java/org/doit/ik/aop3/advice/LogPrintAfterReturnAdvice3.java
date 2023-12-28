package org.doit.ik.aop3.advice;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.stereotype.Component;

// 후 advice + 예외발생 X
@Component
public class LogPrintAfterReturnAdvice3 implements AfterReturningAdvice {

	@Override
	public void afterReturning(
			Object returnValue // 결과값
			, Method method    // 메서드
			, Object[] args    // 매개변수
			, Object target    // 실제 객체
			) throws Throwable {
		String methodName = method.getName();
		
		Log log = LogFactory.getLog(this.getClass());
		
		log.info("<< " + methodName + "() : LogPrintAfterReturnAdvice 호출됨...");
	}

}
