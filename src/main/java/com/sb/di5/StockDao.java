package com.sb.di5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository(value = "stock")
public class StockDao implements Dao{
    private List<Map<String, String>> stocks;
    {
        stocks = new ArrayList<>();
        stocks.add(new HashMap<String, String>(){
                {
                    put("symbol", "2330.TW");
                    put("shares", "3000");
                }
        });
        stocks.add(new HashMap<String, String>(){
                {
                    put("symbol", "1101.TW");
                    put("shares", "2000");
                }
        });
    }
    @Override
    public List<Map<String, String>> query() {
        return stocks;
    }
    
}
