package com.jdbc.template.single;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class Delete {
    @Test
    public void t1() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
        JdbcTemplate jdbcTemplate = ctx.getBean("jdbcTemplate", JdbcTemplate.class);
        // 刪除
        String sql = "delete from emp where id = ?";
        int rowCount = jdbcTemplate.update(sql, 6);
        System.out.println("刪除異動筆數: " + rowCount);
    }
}
