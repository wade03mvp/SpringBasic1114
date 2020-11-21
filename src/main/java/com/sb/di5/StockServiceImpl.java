package com.sb.di5;

import java.util.List;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class StockServiceImpl implements StockService {
    @Autowired
    @Qualifier("stock")
    private Dao sDao;
    
    @Autowired
    @Qualifier("fund")
    private Dao fDao;
    
    @Override
    public List findPortfolio() {
        // 合併列表
        List list = Stream.concat(sDao.query().stream(), fDao.query().stream())
                .collect(toList());
        return list;
    }
    
}
