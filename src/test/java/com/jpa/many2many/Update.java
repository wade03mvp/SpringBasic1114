package com.jpa.many2many;

import com.jpa.JPATemplate;
import com.jpa.entity.many2many.Fund;
import com.jpa.entity.many2many.Stock;
import java.util.List;
import org.junit.Test;

public class Update extends JPATemplate{
    // 移除成分股
    @Test
    public void t1() {
        Stock stock = (Stock)session.get(Stock.class, 2);
        List<Fund> funds = session.createQuery("from Fund f").list();
        funds.forEach(fund -> fund.getStocks().remove(stock));
        
    }
}
