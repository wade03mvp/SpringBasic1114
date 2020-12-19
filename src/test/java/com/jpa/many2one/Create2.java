package com.jpa.many2one;

import com.jpa.JPATemplate;
import com.jpa.entity.many2one.Customer;
import com.jpa.entity.many2one.Orders;
import org.junit.Test;

public class Create2 extends JPATemplate {
    @Test
    public void t1() {
        // Mary, id = 7 的客戶要加購 Cake
        Customer c1 = (Customer)session.get(Customer.class, 7);
        Orders o1 = new Orders();
        o1.setName("Cake");
        
        // 配置關聯關係
        o1.setCustomer(c1);
        
        // 執行保存動作
        session.persist(o1);

        System.out.println("完成");
        
    }
}
