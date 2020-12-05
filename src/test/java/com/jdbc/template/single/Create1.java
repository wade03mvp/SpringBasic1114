package com.jdbc.template.single;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class Create1 {
    @Test
    public void t1() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
        JdbcTemplate jdbcTemplate = ctx.getBean("jdbcTemplate", JdbcTemplate.class);
        // 新增資料
        String sql = "insert into emp(name, age, sex) values(?, ?, ?)";
        int rowCount = jdbcTemplate.update(sql, "Vincent", 18, "F");
        System.out.println("新增異動筆數: " + rowCount);
        
    }
}
