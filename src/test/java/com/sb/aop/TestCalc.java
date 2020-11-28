package com.sb.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:aop-config.xml"})
public class TestCalc {
    
    @Test
    public void t1() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("aop-config.xml");
        Calc calc = ctx.getBean("calcImpl", Calc.class);
        System.out.println(calc.add(10, 5));
        //System.out.println(calc.div(10, 5));
    }
}
