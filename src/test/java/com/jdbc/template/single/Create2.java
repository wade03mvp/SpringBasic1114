package com.jdbc.template.single;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class Create2 {
    @Test
    public void t2() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
        JdbcTemplate jdbcTemplate = ctx.getBean("jdbcTemplate", JdbcTemplate.class);
        // 多筆新增資料
        List<Object[]> args = new ArrayList<>();
        args.add(new Object[]{"張三", 20, "M"});
        args.add(new Object[]{"李四", 22, "女"});
        args.add(new Object[]{"Mary", 25, "女"});
        
        String sql = "insert into emp(name, age, sex) values(?, ?, ?)";
        
        // 批次執行
        int[] rowCounts = jdbcTemplate.batchUpdate(sql, args);
        
        // 總異動筆數
        System.out.println("總異動筆數: " + IntStream.of(rowCounts).sum());
        
    }
}
