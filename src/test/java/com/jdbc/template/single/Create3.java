package com.jdbc.template.single;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

public class Create3 {
    @Test
    public void t3() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
        JdbcTemplate jdbcTemplate = ctx.getBean("jdbcTemplate", JdbcTemplate.class);
        
        // 多筆新增資料(使用 Emp 物件)
        List<Emp> emps = Arrays.asList(
                new Emp("Tom", 30, "M"),
                new Emp("Helen", 40, "F")
        );
        
        String sql = "insert into emp(name, age, sex) values(?, ?, ?)";
        
        // 配置參數
        BatchPreparedStatementSetter setter = new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Emp emp = emps.get(i); // i 指的是 emps 集合的 index
                ps.setString(1, emp.getName()); 
                ps.setInt(2, emp.getAge());
                ps.setString(3, emp.getSex());
            }

            @Override
            public int getBatchSize() {
                return emps.size();
            }
        };
        
        // 批次執行
        int[] rowCounts = jdbcTemplate.batchUpdate(sql, setter);
        
        // 總異動筆數
        System.out.println("總異動筆數: " + IntStream.of(rowCounts).sum());
        
    }
}
