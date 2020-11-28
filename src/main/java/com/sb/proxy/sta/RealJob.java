package com.sb.proxy.sta;

public class RealJob implements Job {

    @Override
    public void work() {
        System.out.println("發傳單");
    }
    
}
