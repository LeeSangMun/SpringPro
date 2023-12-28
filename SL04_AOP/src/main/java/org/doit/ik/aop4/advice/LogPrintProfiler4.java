package org.doit.ik.aop4.advice;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component("logPrintProfiler4")
public class LogPrintProfiler4 {
	// 3. AfterAdvice p221
	public void afterFinally(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		Log log = LogFactory.getLog(this.getClass());
		log.info("<<< " + methodName + "() : LogPrintProfiler4.afterFinally 가 호출됨... ");
	}

	// 2. BeforeAdvice p217
	public void before(JoinPoint joinPoint) throws Throwable {
		String methodName = joinPoint.getSignature().getName();
		Log log = LogFactory.getLog(this.getClass());
		log.info(">>> " + methodName + "() : LogPrintProfiler4.before 가 호출됨... ");
	}

	// 1. AroundAdvice p222
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable {
		String methodName = joinPoint.getSignature().toShortString();

		Log log = LogFactory.getLog(this.getClass());
		log.info("> " + methodName + "() start.");
		StopWatch sw = new StopWatch();
		sw.start();

		// 핵심 관심 사항.
		Object result = joinPoint.proceed(); // calc.add()

		sw.stop();

		log.info("> " + methodName + "() end.");
		log.info("> " + methodName + "() 처리 시간 :  " + sw.getTotalTimeMillis() + "ms");

		return result;
	}
}
