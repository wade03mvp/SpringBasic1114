package com.jpa.many2one;

import com.jpa.JPATemplate;
import com.jpa.entity.many2one.Customer;
import com.jpa.entity.many2one.Orders;
import org.junit.Test;

public class Create extends JPATemplate {
    @Test
    public void t1() {
        // 新增訂單的同時也建立新客戶
        Customer c1 = new Customer();
        c1.setLastName("Mary");
        Orders o1 = new Orders();
        o1.setName("Sandwish");
        Orders o2 = new Orders();
        o2.setName("Coffee");
        
        // 配置關聯關係
        o1.setCustomer(c1);
        o2.setCustomer(c1);
        
        // 執行保存動作
//        session.persist(o1);
//        session.persist(o2);
//        session.persist(c1);
        // 在@ManyToOne的關聯關係中, 若先新增 one 的一方, 就不會多出 update 語句    
        session.persist(c1);
        session.persist(o1);
        session.persist(o2);

        System.out.println("完成");
        
    }
}
