package com.jpa.one2many;

import com.jpa.JPATemplate;
import com.jpa.entity.one2many.Bookshelf;
import java.util.stream.Stream;
import org.junit.Test;

public class Delete extends JPATemplate {
    
    @Test
    public void t1() {
        Bookshelf bookshelf = (Bookshelf)session.get(Bookshelf.class, 1);
        // 若有設定 cascade = CascadeType.REMOVE 可以聯集刪除(多的一方也都會刪除)
        // 若沒有設定 cascade = CascadeType.REMOVE 多的一方仍會保留資料, 只是外鍵內容 = null
        session.delete(bookshelf);
        System.out.println("完成");
        
    }
}
