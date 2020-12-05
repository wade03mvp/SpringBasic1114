package com.jdbc.template.tx.dao;

import com.jdbc.template.tx.exception.InsufficientBookStock;
import com.jdbc.template.tx.exception.InsufficientWalletMoneyException;
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
    
    // 查詢錢包餘額
    public Integer getWalletMoney(Integer wid) {
        String sql = "select money from wallet where wid = ?";
        Object[] args = {wid};
        return jdbcTemplate.queryForObject(sql, args, Integer.class);
    }
    
    // 查詢書籍庫存
    public Integer getBookStock(Integer bid) {
        String sql = "select amount from stock where bid = ?";
        Object[] args = {bid};
        return jdbcTemplate.queryForObject(sql, args, Integer.class);
    }
    
    // 修改庫存 Stock
    public void updateStock(Integer bid) throws InsufficientBookStock {
        Integer amount = getBookStock(bid);
        if(amount <= 0) {
            throw new InsufficientBookStock();
        }
        String sql = "update stock set amount = amount - 1 where bid=?";
        jdbcTemplate.update(sql, bid);
    }
    
    // 修改錢包 Wallet
    public void updateWallet(Integer wid, Integer bid) throws InsufficientWalletMoneyException {
        Integer price = getPrice(bid);
        Integer money = getWalletMoney(wid);
        if(money < price) {
            throw new InsufficientWalletMoneyException();
        }
        String sql = "update wallet set money = money - ? where wid=?";
        jdbcTemplate.update(sql, price, wid);
    }
}
