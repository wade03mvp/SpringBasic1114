package com.jpa.many2one;

import com.jpa.JPATemplate;
import com.jpa.entity.many2one.Orders;
import org.junit.Test;

public class Delete2 extends JPATemplate {
    @Test
    public void t1() {
        // 透過游離物件刪除
        Orders o1 = new Orders();
        o1.setId(2);
        // o1.setName("XXX"); 若要不設定, 則 nullable = true 需移除
        session.delete(o1);
        
        System.out.println("完成");
        
    }
}
