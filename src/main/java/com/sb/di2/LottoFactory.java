package com.sb.di2;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import org.springframework.beans.factory.FactoryBean;

public class LottoFactory implements FactoryBean<Lotto>{

    @Override
    public Lotto getObject() throws Exception {
        Lotto lotto = new Lotto();
        Set<Integer> nums = new LinkedHashSet<>();
        Random r = new Random();
        while (nums.size() < 5) {            
            nums.add(r.nextInt(39) + 1);
        }
        lotto.setNums(nums);
        return lotto;
    }

    @Override
    public Class<?> getObjectType() {
        return Lotto.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
    
}
