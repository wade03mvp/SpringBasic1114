package com.sb.aop;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(3)
public class ExchangeAspect {
    @Around(value = "execution(* com.sb.aop.BubbleTea.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) {
        Object result = null;
        try {
            result = joinPoint.proceed();
            //System.out.println(result);
            Integer newResult = (int)(Integer.parseInt(result + "") / 30);
            result = newResult;
        } catch (Throwable e) {
        }
        return result;
    }
}
