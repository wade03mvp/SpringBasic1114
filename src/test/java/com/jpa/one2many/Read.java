package com.jpa.one2many;

import com.jpa.JPATemplate;
import com.jpa.entity.one2many.Bookshelf;
import java.util.stream.Stream;
import org.junit.Test;

public class Read extends JPATemplate {
    @Test
    public void t1() {
        Bookshelf bookshelf = (Bookshelf)session.get(Bookshelf.class, 1);
        // 查詢書櫃名
        System.out.println("書櫃名: " + bookshelf.getName());
        // 書櫃中有幾本書 ?
        System.out.println("書櫃中有幾本書: " + bookshelf.getBooks().size());
        System.out.println("完成");
        
    }
}
