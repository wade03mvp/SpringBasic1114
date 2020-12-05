package com.jdbc.template.single;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class Query {
    private ClassPathXmlApplicationContext ctx;
    private JdbcTemplate jdbcTemplate;
    
    @Before
    public void before() {
        ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
        jdbcTemplate = ctx.getBean("jdbcTemplate", JdbcTemplate.class);
    }
        
    @Test
    public void t1() {
        getById(1);
    }
    
    // 單筆查詢
    private void getById(Integer id) {
        String sql = "select id, name, age, sex, ct from emp where id=?";
        Object[] args = {id};
        // mapper 對應
        RowMapper<Emp> rm = new RowMapper<Emp>() {
            @Override
            public Emp mapRow(ResultSet rs, int i) throws SQLException {
                Emp emp = new Emp();
                emp.setId(rs.getInt("id"));
                emp.setName(rs.getString("name"));
                emp.setAge(rs.getInt("age"));
                emp.setSex(rs.getString("sex"));
                emp.setCt(rs.getDate("ct"));
                return emp;
            }
        };
        Emp emp = jdbcTemplate.queryForObject(sql, args, rm);
        System.out.println(emp);
    }
    
    @After
    public void after() {
        ctx.close();
    }
    
}
