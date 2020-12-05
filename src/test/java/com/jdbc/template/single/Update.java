package com.jdbc.template.single;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class Update {
    @Test
    public void t1() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
        JdbcTemplate jdbcTemplate = ctx.getBean("jdbcTemplate", JdbcTemplate.class);
        // 修改
        String sql = "update emp set sex = ? where sex = ?";
        int rowCount = jdbcTemplate.update(sql, "F", "女");
        System.out.println("修改異動筆數: " + rowCount);
    }
}
