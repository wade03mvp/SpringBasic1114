package com.jpa.twoway;


import com.jpa.JPATemplate;
import com.jpa.entity.twoway.Dept;
import com.jpa.entity.twoway.Emp;
import org.junit.Test;

public class Create extends JPATemplate {
    @Test
    public void t1() {
        Dept dept = new Dept();
        dept.setName("IT");
        Emp e1 = new Emp();
        e1.setName("John");
        Emp e2 = new Emp();
        e2.setName("Mary");
        
        // 建立雙向關聯關係
        e1.setDept(dept);
        e2.setDept(dept);
        dept.getEmps().add(e1);
        dept.getEmps().add(e2);
        
        // 保存資料
        session.persist(dept);
        session.persist(e1);
        session.persist(e2);
        
        
    }
}
