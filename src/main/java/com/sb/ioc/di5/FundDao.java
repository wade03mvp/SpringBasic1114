package com.sb.ioc.di5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository(value = "fund")
public class FundDao implements Dao{
    private List<Map<String, String>> funds;
    {
        funds = new ArrayList<>();
        funds.add(new HashMap<String, String>(){
                {
                    put("symbol", "A");
                    put("shares", "5000");
                }
        });
        funds.add(new HashMap<String, String>(){
                {
                    put("symbol", "B");
                    put("shares", "4000");
                }
        });
    }
    @Override
    public List<Map<String, String>> query() {
        return funds;
    }
    
}
