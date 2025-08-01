package com.devlumi.mreview.aop;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Log4j2
@Component
public class LogAspect {
  @Before("execution(* *..*.ReviewController.*(..))")
  public void beforeLog(JoinPoint joinPoint) {
    log.info("-------------------- "+joinPoint.getSignature().getName());
    Arrays.stream(joinPoint.getArgs()).forEach(log::info);
  }
}
