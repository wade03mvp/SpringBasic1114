package com.jpa.one2many;

import com.jpa.JPATemplate;
import com.jpa.entity.one2many.Book;
import com.jpa.entity.one2many.Bookshelf;
import org.junit.Test;

public class Create extends JPATemplate {
    @Test
    public void v1() {
        Book b1 = new Book();
        b1.setName("Java雲端");
        b1.setPrice(500);
        
        Book b2 = new Book();
        b2.setName("Python數據分析");
        b2.setPrice(400);
        
        Bookshelf bookshelf = new Bookshelf();
        bookshelf.setName("程式類");
        
        // 建立關聯關係
        bookshelf.getBooks().add(b1);
        bookshelf.getBooks().add(b2);
        
        // 保存資料
        // 在進行 OneToMany 單向時最後都會 update 外鍵(bookshelf_id)資料
        session.persist(bookshelf);
        session.persist(b1);
        session.persist(b2);
        
        System.out.println("完成");
        
        
    }
}
