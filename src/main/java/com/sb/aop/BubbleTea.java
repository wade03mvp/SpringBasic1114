package com.sb.aop;

import org.springframework.stereotype.Component;

@Component
public class BubbleTea {
    private final int price = 55;
    public int buy(int amount) {
        return amount * price;
    }
}
