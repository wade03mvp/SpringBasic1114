package com.jpa.many2many;

import com.jpa.JPATemplate;
import com.jpa.entity.many2many.Fund;
import com.jpa.entity.many2many.Stock;
import org.junit.Test;

public class Create extends JPATemplate {
    @Test
    public void t1() {
        // 建立股票
        Stock s1 = new Stock("2330.TW");
        Stock s2 = new Stock("2317.TW");
        Stock s3 = new Stock("3008.TW");
        Stock s4 = new Stock("1101.TW");
        Stock s5 = new Stock("1402.TW");
        // 建立基金
        Fund f1 = new Fund("高科技基金");
        Fund f2 = new Fund("穩健型基金");
        // 建立關聯
        f1.getStocks().add(s1);
        f1.getStocks().add(s2);
        f1.getStocks().add(s3);
        f2.getStocks().add(s1);
        f2.getStocks().add(s4);
        f2.getStocks().add(s5);
        // 保存 (注意 ! 有配置聯集新增 cascade = CascadeType.PERSIST)
        session.persist(f1);
        session.persist(f2);
        
    }
}
