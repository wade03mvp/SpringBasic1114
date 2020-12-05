package com.jdbc.tx.service;

import com.jdbc.tx.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    private BookDao bookDao;
    
    public Integer getPriceById(Integer bid) {
        return bookDao.getPrice(bid);
    }
}
