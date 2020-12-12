package com.jpa;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
    @Test
    public void t1() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("jpa-config.xml");
        SessionFactory sessionFactory = ctx.getBean("sessionFactory", SessionFactory.class);
        Session session = sessionFactory.openSession();
        System.out.println(session);
        session.close();
        sessionFactory.close();
        
    }
}
