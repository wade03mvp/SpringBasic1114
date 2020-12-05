package com.jdbc.template.tx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public Integer getPrice(Integer bid) {
        String sql = "select price from book where bid = ?";
        Object[] args = {bid};
        return jdbcTemplate.queryForObject(sql, args, Integer.class);
    }
    
}
