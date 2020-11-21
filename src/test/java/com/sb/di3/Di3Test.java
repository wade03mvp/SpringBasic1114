package com.sb.di3;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Di3Test {
    @Test
    public void t1() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans-config3.xml");
        UserController uc = ctx.getBean("userController", UserController.class);
        System.out.println(uc.queryAll());
        System.out.println(uc.get("Tom"));      
        
    }
}
