package com.jpa.one2many;

import com.jpa.JPATemplate;
import com.jpa.entity.one2many.Bookshelf;
import java.util.stream.Stream;
import org.junit.Test;

public class Delete extends JPATemplate {
    
    @Test
    public void t1() {
        Bookshelf bookshelf = (Bookshelf)session.get(Bookshelf.class, 1);
        session.delete(bookshelf);
        System.out.println("完成");
        
    }
}
