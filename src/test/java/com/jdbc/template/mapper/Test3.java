package com.jdbc.template.mapper;

import com.jdbc.template.mapper.entity.Item;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.simpleflatmapper.jdbc.spring.JdbcTemplateMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:jdbc-config.xml"})
public class Test3 {
    
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void t1() {
        // SimpleFlatMapper
        String sql = "SELECT im.ID, im.AMOUNT,\n"
                + "       inv.ID as invoice_id, inv.INVDATE as invoice_invdate,\n"
                + "       ip.id as product_id, ip.TEXT as product_text, ip.PRICE as product_price, ip.INVENTORY as product_inventory\n"
                + "FROM ITEM im, INVOICE inv, ITEMPRODUCT ip\n"
                + "WHERE im.IPID = ip.ID AND im.INVID = inv.ID";
        ResultSetExtractor<List<Item>> mapper = JdbcTemplateMapperFactory
                .newInstance()
                .addKeys("id")
                .newResultSetExtractor(Item.class);
        List<Item> items = jdbcTemplate.query(sql, mapper);
        System.out.println(items);
    }
}
