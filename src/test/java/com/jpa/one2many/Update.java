package com.jpa.one2many;

import com.jpa.JPATemplate;
import com.jpa.entity.one2many.Bookshelf;
import java.util.stream.Stream;
import org.junit.Test;

public class Update extends JPATemplate {
    // 從書櫃中去改變某一本書的價格 ?
    @Test
    public void t1() {
        Bookshelf bookshelf = (Bookshelf)session.get(Bookshelf.class, 1);
        // 原價再增加 10%
        bookshelf.getBooks().stream().forEach(book -> {
            int price = (int)(book.getPrice() * 1.1);
            book.setPrice(price);
        });
        
        System.out.println("完成");
        
    }
}
