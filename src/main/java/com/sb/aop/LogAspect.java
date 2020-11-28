package com.sb.aop;

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
    public void before() {
        System.out.println("AOP 前置通知");
    }
}
