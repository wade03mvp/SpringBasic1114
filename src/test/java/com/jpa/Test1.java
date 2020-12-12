package com.jpa;

import com.jpa.entity.Customer;
import org.junit.Test;

public class Test1 extends JPATemplate {
    @Test
    public void t1() {
        //create();
        //update();
        //update2();
        update3();
    }
    
    private void update3() {
        Customer c1 = new Customer();
        c1.setId(2);
        c1.setLastName("Happy");
        System.out.println(c1); // c1 是游離物件
        session.merge(c1); // 手動更新資料
        
    }
    
    private void update2() {
        Customer c1 = new Customer();
        c1.setId(1);
        c1.setLastName("JoJo");
        System.out.println(c1); // c1 是游離物件
        session.update(c1); // 手動更新資料
        //c1.setLastName("Helen"); // c1 是永續物件
    }
    
    private void update() {
        Customer c1 = (Customer)session.get(Customer.class, 1);
        System.out.println(c1);
        c1.setLastName("John");
        System.out.println(c1);
    }
    
    private void create() {
        Customer c1 = new Customer();
        c1.setLastName("Tom");
        System.out.println(c1); // c1 是臨時物件
        session.persist(c1); // 將 customer 臨時物件存入到資料表中
        System.out.println(c1); // c1 是永續物件
        c1.setLastName("Mary");
        System.out.println(c1);
    }
}
