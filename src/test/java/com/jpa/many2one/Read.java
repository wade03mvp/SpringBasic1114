package com.jpa.many2one;

import com.jpa.JPATemplate;
import com.jpa.entity.many2one.Orders;
import java.util.List;
import org.junit.Test;

public class Read extends JPATemplate {
    @Test
    public void t1() {
        // 單筆查詢
        Orders o1 = (Orders)session.get(Orders.class, 1);
        System.out.println(o1);
        // 多筆查詢
        // "From 類別名稱 變數"
        List<Orders> orderses = session.createQuery("From Orders o").list();
        System.out.println(orderses);
    }
}
