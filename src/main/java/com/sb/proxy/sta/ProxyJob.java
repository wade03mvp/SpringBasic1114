package com.sb.proxy.sta;

public class ProxyJob implements Job {
    private Job job;

    public ProxyJob(Job job) {
        this.job = job;
    }
    
    @Override
    public void work() {
        System.out.println("前置通知:戴口罩");
        job.work(); // 執行工作
        System.out.println("後置通知:勤洗手");
    }
    
}
