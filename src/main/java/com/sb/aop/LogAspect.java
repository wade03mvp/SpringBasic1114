package com.sb.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1) // 放入正整數, 數字越小越先執行 (預設是 int 的最大值)
public class LogAspect {
    
    // 前置通知
    @Before(value = "execution(public int com.sb.aop.CalcImpl.*(int, int))")
    public void before() {
        System.out.println("AOP 前置通知");
    }
}
