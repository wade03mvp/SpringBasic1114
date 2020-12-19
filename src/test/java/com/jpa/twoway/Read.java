package com.jpa.twoway;

import com.jpa.JPATemplate;
import com.jpa.entity.twoway.Dept;
import com.jpa.entity.twoway.Emp;
import java.util.List;
import org.junit.Test;

public class Read extends JPATemplate {
    @Test
    public void t1() {
        // 查詢每一位員工隸屬哪一個部門
        List<Emp> emps = session.createQuery("from Emp e").list();
        emps.stream().forEach(emp -> System.out.println(emp.getName() + " --> " + emp.getDept().getName()));
        
        // 查詢每一個部門有哪些員工們
        List<Dept> depts = session.createQuery("from Dept d").list();
        depts.stream().forEach(dept -> {
            // 印出部門名稱
            System.out.println(dept.getName() + " --> ");
            // 印出該部門裡所有員工
            dept.getEmps().stream().forEach(emp -> System.out.print(emp.getName() + " "));
            System.out.println();
        });
    }
}
