package com.jdbc.template.tx.controller;

import com.jdbc.template.tx.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    
    public Integer findPriceById(Integer bid) {
        return bookService.getPriceById(bid);
    }
    
    public void buy(Integer wid, Integer bid) {
        bookService.buyOne(wid, bid);
    }
    
}
