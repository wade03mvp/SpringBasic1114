package com.jdbc.template.mapper;

import com.jdbc.template.mapper.dao.InvoiceDao;
import com.jdbc.template.mapper.entity.Item;
import com.jdbc.template.mapper.entity.ItemProduct;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:jdbc-config.xml"})
public class Test4 {

    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    public void t4() {
        // 測試 invoiceDao
        System.out.println("測試 invoiceDao.queryItems()");
        List<Item> items = invoiceDao.queryItems();
        //System.out.println(items);

        // 1. 每一張發票有那些商品?
        System.out.println("1. 每一張發票有那些商品");
        Map<Integer, List<Item>> map1 = items.stream()
                .collect(groupingBy(item -> item.getInvoice().getId(), Collectors.toList()));
        //System.out.println(map1);
        map1.keySet()
                .stream()
                .forEach(id -> System.out.println("發票號碼:" + id + "\n\t"
                + "項目:" + map1.get(id)
                        .stream()
                        .map(item -> item.getProduct().getText())
                        .collect(toList()))
                );

        // 2. 每一張發票有幾件商品?
        System.out.println("2. 每一張發票有幾件商品");
        System.out.println(
                items.stream().collect(groupingBy(item -> item.getInvoice().getId(), Collectors.counting()))
        );

        // 3. 每一張發票價值多少?
        System.out.println("3. 每一張發票價值多少");
        Map<Integer, Integer> map3 = items.stream()
                .collect(groupingBy(item -> item.getInvoice().getId(),
                        Collectors.summingInt(item -> item.getAmount() * item.getProduct().getPrice())));
        System.out.println(map3);

        // 4. 每一樣商品各賣了多少錢?
        System.out.println("4. 每一樣商品各賣了多少錢");
        Map<String, Integer> map4 = items.stream()
                .collect(groupingBy(item -> item.getProduct().getText(),
                        Collectors.summingInt(item -> item.getAmount() * item.getProduct().getPrice())));
        System.out.println(map4);

        // 5. 哪一件商品賣得錢最多?
        System.out.println("5. 哪一件商品賣得錢最多");
        System.out.println(
                map4.entrySet().stream()
                        .max(Comparator.comparing(entry -> entry.getValue()))
                        .get()
        );

        // 6. 哪一張發票價值最高（請練習看看）?
        System.out.println("6. 哪一張發票價值最高");
        System.out.println(
                map3.entrySet().stream()
                        .max(Comparator.comparing(entry -> entry.getValue()))
                        .get()
        );

        // 7. 每件商品的剩餘庫存
        System.out.println("7. 每件商品的剩餘庫存");
        List<ItemProduct> products = invoiceDao.queryProducts();
        System.out.println(products);
        System.out.println(
                products.stream()
                    .collect(groupingBy(p -> p.getText(), Collectors.summingInt(p -> { 
                        Integer inventory = p.getInventory();
                        Integer sold = items.stream()
                                .filter(item -> item.getProduct().getId() == p.getId()) 
                                .mapToInt(item -> item.getAmount())
                                .sum();
                                
                        return  inventory - sold;
                    })))
        );
        
        // 8. 每件商品的剩餘庫存(SQL版)
        System.out.println("8. 每件商品的剩餘庫存(SQL版)");
        System.out.println(invoiceDao.queryProductInventory());
    }
}
