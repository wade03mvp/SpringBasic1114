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
@Order(2)
public class DiscountAspect {
    @Around(value = "execution(* com.sb.aop.BubbleTea.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) {
        Object result = null;
        try {
            result = joinPoint.proceed();
            int amount = Integer.parseInt(joinPoint.getArgs()[0] + "");
            if(amount >= 10) {
                Integer newResult = (int)(Integer.parseInt(result + "") * 0.9);
                result = newResult;
            }
        } catch (Throwable e) {
        }
        return result;
    }
}
