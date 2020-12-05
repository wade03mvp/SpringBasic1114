package com.jdbc.template.single;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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
        getById2(1);
        getTotalRowCount();
        queryAll();
        queryBySexAndMoreThenAge("F", 20);
        getAvgOfAge();
    }
    
    // 單筆查詢 1 - 欄位手動對應
    private void getById(Integer id) {
        String sql = "select id, name, age, sex, ct from emp where id=?";
        Object[] args = {id};
        // 手動 mapper 對應
        RowMapper<Emp> rm = new RowMapper<Emp>() {
            @Override
            public Emp mapRow(ResultSet rs, int i) throws SQLException {
                Emp emp = new Emp();
                emp.setId(rs.getInt("id"));
                emp.setName(rs.getString("name"));
                emp.setAge(rs.getInt("age"));
                emp.setSex(rs.getString("sex"));
                //emp.setCt(rs.getDate("ct")); // 只有日期
                emp.setCt(rs.getTimestamp("ct")); // 日期 +  時間
                return emp;
            }
        };
        Emp emp = jdbcTemplate.queryForObject(sql, args, rm);
        System.out.println(emp);
    }
    
    // 單筆查詢 2 - 欄位自動對應
    private void getById2(Integer id) {
        String sql = "select id, name, age, sex, ct from emp where id=?";
        Object[] args = {id};
        // 自動 mapper 對應
        RowMapper<Emp> rm = new BeanPropertyRowMapper<>(Emp.class);
        Emp emp = jdbcTemplate.queryForObject(sql, args, rm);
        System.out.println(emp);
    }
    
    // 查詢單筆 3 - 資料總筆數
    private void getTotalRowCount() {
        String sql = "select count(*) from emp";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println("資料總筆數: " + count);
    }
    
    // 查詢多筆 1 - 全部查詢
    private void queryAll() {
        String sql = "select id, name, age, sex, ct from emp";
        RowMapper<Emp> rm = new BeanPropertyRowMapper<>(Emp.class);
        List<Emp> emps = jdbcTemplate.query(sql, rm);
        System.out.println(emps);
    }
    
    // 查詢多筆 2 - 條件查詢
    private void queryBySexAndMoreThenAge(String sex, Integer age) {
        String sql = "select id, name, age, sex, ct from emp where sex = ? and age >= ?";
        RowMapper<Emp> rm = new BeanPropertyRowMapper<>(Emp.class);
        List<Emp> emps = jdbcTemplate.query(sql, rm, sex, age);
        System.out.println(emps);
    }
    
    // 查詢平均年齡
    private void getAvgOfAge() {
        String sql = "select avg(age) from emp";
        Integer avgOfAge = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println("平均年齡: " + avgOfAge);
    }
    
    // 查詢男女的平均年齡各為多少
    private void getAvgOfAgeBySex() {
        // 隨堂練習
        
    }
    
    @After
    public void after() {
        ctx.close();
    }
    
}
