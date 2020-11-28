package com.sb.aop;

import org.springframework.stereotype.Component;

@Component
public class Bmi {
    public Double calc(Double h, Double w, String name) {
        return w / Math.pow(h/100, 2);
    }
}
