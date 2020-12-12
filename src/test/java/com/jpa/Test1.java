package com.jpa;

import com.jpa.entity.Customer;
import org.junit.Test;

public class Test1 extends JPATemplate {
    @Test
    public void t1() {
        Customer c1 = new Customer();
        c1.setLastName("Tom");
        System.out.println(c1);
        session.persist(c1); // 將 customer 臨時物件存入到資料表中
        System.out.println(c1);
        c1.setLastName("Mary");
        System.out.println(c1);
    }
}
