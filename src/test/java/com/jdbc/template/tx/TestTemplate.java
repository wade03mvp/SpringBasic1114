package com.jdbc.template.tx;

import com.jdbc.template.tx.controller.BookController;
import org.junit.After;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestTemplate {
    protected ClassPathXmlApplicationContext ctx;
    protected JdbcTemplate jdbcTemplate;
    protected BookController bookController;
    
    @Before
    public void before() {
        ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
        jdbcTemplate = ctx.getBean("jdbcTemplate", JdbcTemplate.class);
        bookController = ctx.getBean("bookController", BookController.class);
    }
    
    @After
    public void after() {
        ctx.close();
    }
}
