package com.sb.proxy.dyn;

public class Main {
    public static void main(String[] args) {
        ProxyUtil proxy = new ProxyUtil(new CalcImpl());
        Calc calc = (Calc)proxy.getProxy();
        System.out.println(calc.add(10, 5));
        
    }
}
