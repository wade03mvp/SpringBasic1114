package com.jdbc.template.mapper;

import com.jdbc.template.mapper.entity.Invoice;
import com.jdbc.template.mapper.entity.Item;
import com.jdbc.template.mapper.entity.ItemProduct;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class Test2 {
    ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
    JdbcTemplate jdbcTemplate = ctx.getBean("jdbcTemplate", JdbcTemplate.class);
    
    // 手動進行 Item 關聯配置
    class ItemMapper implements RowMapper<Item>{
        @Override
        public Item mapRow(ResultSet rs, int i) throws SQLException {
            // 配置 Item 屬性
            Item item = new Item();
            item.setId(rs.getInt("id")); // 注入 id
            item.setAmount(rs.getInt("amount")); // 注入 amount
            // 注入 product 的步驟
            Integer ipid = rs.getInt("ipid"); // 得到 ipid (商品的id)
            String sql_1 = "SELECT * FROM ITEMPRODUCT WHERE id=?";
            ItemProduct product = jdbcTemplate.queryForObject(
                    sql_1, 
                    new BeanPropertyRowMapper<>(ItemProduct.class),
                    ipid);
            item.setProduct(product); // 注入 product
            // 注入 invoice 的步驟
            Integer invid = rs.getInt("invid"); // 得到 invid (發票的id)
            String sql_2 = "SELECT * FROM INVOICE WHERE id=?";
            Invoice invoice = jdbcTemplate.queryForObject(
                    sql_2, 
                    new BeanPropertyRowMapper<>(Invoice.class),
                    invid);
            item.setInvoice(invoice); // 注入 invoice
            
            return item;
        }
    };
    
    @Test
    public void t2() {
        String sql = "SELECT * FROM ITEM";
        List<Item> items = jdbcTemplate.query(sql, new ItemMapper());
        System.out.println(items);
    }
}
