package com.jdbc.template.mapper.dao;

import com.jdbc.template.mapper.entity.Item;
import com.jdbc.template.mapper.entity.ItemProduct;
import java.util.List;
import java.util.Map;
import org.simpleflatmapper.jdbc.spring.JdbcTemplateMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

@Repository
public class InvoiceDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public List<Item> queryItems() {
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
        return items;
    }
    
    public List<ItemProduct> queryProducts() {
        return jdbcTemplate.query("SELECT * FROM ITEMPRODUCT", 
                                  new BeanPropertyRowMapper<>(ItemProduct.class));
    }
    
    // 查詢最新庫存 (庫存 - 已賣出的數量)
    public List<Map<String, Object>> queryProductInventory() {
        String sql = "SELECT ip.TEXT, \n" +
                     "       ip.INVENTORY - (SELECT sum(amount) FROM ITEM WHERE ipid=ip.id GROUP BY ipid) as INVENTORY\n" +
                     "FROM ITEMPRODUCT ip";
        return jdbcTemplate.queryForList(sql);
    }
}
