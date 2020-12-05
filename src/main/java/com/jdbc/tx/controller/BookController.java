package com.jdbc.tx.controller;

import com.jdbc.tx.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    
    public Integer findPriceById(Integer bid) {
        return bookService.getPriceById(bid);
    }
}
