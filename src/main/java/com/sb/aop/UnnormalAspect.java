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
public class UnnormalAspect {
    @Around(value = "execution(* com.sb.aop.Bmi.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) {
        Object result = null;
        try {
            result = joinPoint.proceed();
            Double value = Double.parseDouble(result + "");
            if(value > 23 || value <= 18) {
                // 將人名印出
                System.out.println(joinPoint.getArgs()[2]);
            }
        } catch (Throwable e) {
        }
        return result;
    }
}
