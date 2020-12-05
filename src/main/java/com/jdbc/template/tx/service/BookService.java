package com.jdbc.template.tx.service;

import com.jdbc.template.tx.dao.BookDao;
import com.jdbc.template.tx.exception.InsufficientBookStock;
import com.jdbc.template.tx.exception.InsufficientWalletMoneyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {
    @Autowired
    private BookDao bookDao;
    
    public Integer getPriceById(Integer bid) {
        return bookDao.getPrice(bid);
    }
    
    @Transactional(
            propagation = Propagation.REQUIRED,
            isolation = Isolation.REPEATABLE_READ,
            timeout = 3,
            rollbackFor = {InsufficientWalletMoneyException.class, InsufficientBookStock.class}
    )
    public void buyOne(Integer wid, Integer bid) throws InsufficientWalletMoneyException, InsufficientBookStock {
        bookDao.updateStock(bid); // 修改庫存
        //int x = 10/0;
//        try {
//            Thread.sleep(4000);
//        } catch (Exception e) {
//        }
        bookDao.updateWallet(wid, bid); // 修改錢包
    }
}
