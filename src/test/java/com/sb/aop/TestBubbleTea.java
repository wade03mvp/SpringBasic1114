package com.sb.aop;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBubbleTea {
    @Test
    public void t1() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("aop-config.xml");
        BubbleTea tea = ctx.getBean("bubbleTea", BubbleTea.class);
        System.out.println(tea.buy(5));
        
    }
}
