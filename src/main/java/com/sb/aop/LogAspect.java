package com.sb.aop;

import java.util.Arrays;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1) // 放入正整數, 數字越小越先執行 (預設是 int 的最大值)
public class LogAspect {
    // 切點(PointCut) + 公用表達式
    @Pointcut(value = "execution(* com.sb.aop.*.*(..))")
    public void cut(){}
    
    // 前置通知
    //@Before(value = "execution(public int com.sb.aop.CalcImpl.calc(int, int))")
    //@Before(value = "execution(public int com.sb.aop.CalcImpl.*(int, int))")
    //@Before(value = "execution(public int com.sb.aop.CalcImpl.*(..))")
    //@Before(value = "execution(public int com.sb.aop.*.*(..))")
    //@Before(value = "execution(* com.sb.aop.*.*(..))")
    //@Before(value = "execution(* *.*(..))")
    @Before(value = "cut()")
    public void before(JoinPoint joinPoint) {
        // 方法名稱
        String methodName = joinPoint.getSignature().getName();
        // 方法參數
        Object[] args = joinPoint.getArgs();
        System.out.println("AOP 前置通知 : " + methodName + ", " + Arrays.toString(args));
    }
    
    // 後置通知 : 無論是否有例外拋出都會執行 (作用在 finally)
    @After(value = "cut()")
    public void after() {
        System.out.println("AOP 後置通知");
    }
    
    // 返回通知
    @AfterReturning(value = "cut()", returning = "result")
    public void afterReturning(Object result) {
        System.out.println("AOP 返回通知 : " + result);
    }
    
    // 異常通知
    @AfterThrowing(value = "cut()", throwing = "e")
    public void afterThrowing(Exception e) {
        System.out.println("AOP 異常通知 : " + e);
    }
    
    // 環繞通知
    @Around(value = "cut()")
    public Object around(ProceedingJoinPoint joinPoint) {
        Object result = null;
        // 前置
        System.out.println("環繞通知-前置:");
        try {
            // 返回
            result = joinPoint.proceed();
            System.out.println("環繞通知-返回:" + result);
        } catch (Throwable e) {
            // 異常
            System.out.println("環繞通知-異常:" + e);
        } finally {
            // 後置
            System.out.println("環繞通知-後置:" );
        }
        // 若 interfcae Calc 方法的返回型別是 int, 所以不可返回 null
        //return result == null ? 0 : result;
        return result;
    }
    
}
