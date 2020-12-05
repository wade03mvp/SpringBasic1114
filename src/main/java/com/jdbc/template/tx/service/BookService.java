package com.jdbc.template.tx.service;

import com.jdbc.template.tx.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {
    @Autowired
    private BookDao bookDao;
    
    public Integer getPriceById(Integer bid) {
        return bookDao.getPrice(bid);
    }
    
    @Transactional
    public void buyOne(Integer wid, Integer bid) {
        bookDao.updateStock(bid); // 修改庫存
        int x = 10/0;
        bookDao.updateWallet(wid, bid); // 修改錢包
    }
}
