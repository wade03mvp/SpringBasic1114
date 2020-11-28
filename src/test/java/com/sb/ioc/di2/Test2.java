package com.sb.ioc.di2;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {
    @Test
    public void t2() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans-config2.xml");
        Lotto lotto1 = ctx.getBean("lotto", Lotto.class);
        System.out.println(lotto1);
        Lotto lotto2 = ctx.getBean("lotto", Lotto.class);
        System.out.println(lotto2);
        
        Dice dice1 = ctx.getBean("dice", Dice.class);
        System.out.println(dice1);
        
        Dice dice2 = ctx.getBean("dice2", Dice.class);
        System.out.println(dice2);
        
        ctx.close();
    }
}
