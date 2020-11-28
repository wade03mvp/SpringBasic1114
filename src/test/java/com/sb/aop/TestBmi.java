package com.sb.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:aop-config.xml"})
public class TestBmi {
    
    @Test
    public void t1() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("aop-config.xml");
        Bmi bmi = ctx.getBean("bmi", Bmi.class);
        System.out.println(bmi.calc(170.0, 60.0, "John"));
        System.out.println(bmi.calc(150.0, 65.0, "Mary"));
        System.out.println(bmi.calc(180.0, 55.0, "Ton"));
        System.out.println(bmi.calc(160.0, 45.0, "Helen"));
        
        
    }
}
