package com.sb.proxy.dyn;

import com.sb.proxy.sta.Job;
import com.sb.proxy.sta.RealJob;

public class Main2 {
    public static void main(String[] args) {
        ProxyUtil proxy = new ProxyUtil(new RealJob());
        Job job = (Job)proxy.getProxy();
        job.work();
    }
}
