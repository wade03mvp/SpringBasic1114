package com.jdbc.template.tx.service;

import com.jdbc.template.tx.dao.BookDao;
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
