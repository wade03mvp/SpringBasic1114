package com.jdbc.template.tx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    // 查詢書價
    public Integer getPrice(Integer bid) {
        String sql = "select price from book where bid = ?";
        Object[] args = {bid};
        return jdbcTemplate.queryForObject(sql, args, Integer.class);
    }
    
    // 修改庫存 Stock
    public void updateStock(Integer bid) {
        String sql = "update stock set amount = amount - 1 where bid=?";
        jdbcTemplate.update(sql, bid);
    }
    
    // 修改錢包 Wallet
    public void updateWallet(Integer wid, Integer bid) {
        Integer price = getPrice(bid);
        String sql = "update wallet set money = money - ? where wid=?";
        jdbcTemplate.update(sql, price, wid);
    }
}
