package com.sb.di;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
    @Test
    public void t1() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans-config.xml");
        Student s1 = (Student)ctx.getBean("s1");
        //Student s1 = ctx.getBean(Student.class); // 此方法在配置文件中只能有一個配置
        System.out.println(s1);
        Student s2 = ctx.getBean("s2", Student.class);
        System.out.println(s2);
        Student s3 = ctx.getBean("s3", Student.class);
        System.out.println(s3);
        Student s4 = ctx.getBean("s4", Student.class);
        System.out.println(s4);
        Student s5 = ctx.getBean("s5", Student.class);
        System.out.println(s5);
        ctx.close();
    }
}
