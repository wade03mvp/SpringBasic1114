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
        
        Teacher t1 = ctx.getBean("t1", Teacher.class);
        System.out.println(t1);
        Teacher t2 = ctx.getBean("t2", Teacher.class);
        System.out.println(t2);
        
        Student s6 = ctx.getBean("s6", Student.class);
        System.out.println(s6);
        Student s7 = ctx.getBean("s7", Student.class);
        System.out.println(s7);
        Student s8 = ctx.getBean("s8", Student.class);
        System.out.println(s8);
        
        CourseSet c1 = ctx.getBean("c1", CourseSet.class);
        System.out.println(c1);
        
        School school = ctx.getBean(School.class);
        System.out.println(school);
        
        ctx.close();
    }
}
