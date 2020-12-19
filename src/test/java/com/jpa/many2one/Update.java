package com.jpa.many2one;

import com.jpa.JPATemplate;
import com.jpa.entity.many2one.Customer;
import com.jpa.entity.many2one.Orders;
import org.junit.Test;

public class Update extends JPATemplate {
    @Test
    public void t1() {
        // 將 Cake, id = 5 改成 Cookie
        Orders o1 = (Orders)session.get(Orders.class, 5);
        o1.setName("Cookie");
        
        // 執行保存動作
        // 因為 o1 已經是永續物件, 所以不用再下達 update 指令
        //session.update(o1);

        System.out.println("完成");
        
    }
}
