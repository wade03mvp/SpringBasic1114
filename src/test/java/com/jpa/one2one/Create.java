package com.jpa.one2one;

import com.jpa.JPATemplate;
import com.jpa.entity.one2one.Boss;
import com.jpa.entity.one2one.Company;
import org.junit.Test;

public class Create extends JPATemplate {
    @Test
    public void t1() {
        Boss boss = new Boss();
        boss.setName("John");
        Boss boss2 = new Boss();
        boss2.setName("Mary");
        Company company = new Company();
        company.setName("A");
        Company company2 = new Company();
        company2.setName("B");
        
        // 配置關聯
        company.setBoss(boss);
        company2.setBoss(boss2);
        // 因為在 Boss 中有加入 mappedby="boss"
        // 所以下列關聯配置可以不用設定
        //boss.setCompany(company);
        //boss2.setCompany(company2);
        
        // 保存
        session.persist(company);
        session.persist(company2);
        // 在 Company 有加上 CascadeType = PERSIST (聯集新增) 
        // 所以下列方法可以省略不寫
        // session.persist(boss);
        // session.persist(boss2);
        
        
    }
}

