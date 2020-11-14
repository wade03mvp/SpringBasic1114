package com.sb.di;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
    @Test
    public void t1() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans-config.xml");
        //Student s1 = (Student)ctx.getBean("s1");
        Student s1 = ctx.getBean(Student.class);
        System.out.println(s1);
        ctx.close();
    }
}
