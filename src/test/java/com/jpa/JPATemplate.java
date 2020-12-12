package com.jpa;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Before;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JPATemplate {
    private ClassPathXmlApplicationContext ctx;
    private SessionFactory sessionFactory; // 連線工廠
    private Session session; // 連線物件
    private Transaction trans; // 交易物件
    
    @Before
    public void before() {
        ctx = new ClassPathXmlApplicationContext("jpa-config.xml");
        sessionFactory = ctx.getBean("sessionFactory", SessionFactory.class);
        session = sessionFactory.getCurrentSession();
        trans = session.beginTransaction(); // 取得交易管理物件並開始
    }
    
    public void end() {
        trans.commit(); // 提交
        session.close();
        sessionFactory.close();
        ctx.close();
    }
}
