package com.sb.proxy.dyn;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ProxyUtil {
    private Object object;

    public ProxyUtil(Object object) {
        this.object = object;
    }
    
    public Object getProxy() {
        // 獲取單前類別的類加載器, 用來加載代理對象所屬的類別
        ClassLoader loader = getClass().getClassLoader();
        // 獲取當前目標對象的所有介面的class, 目的是給代理物件來實現他的功能
        Class[] interfaces = object.getClass().getInterfaces();
        InvocationHandler h = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object result = null;
                // 前置通知
                System.out.println("前置通知:準備好紙筆來計算...");
                System.out.println("參數 : " + (args!=null ? Arrays.toString(args) : ""));
                try {
                    result = method.invoke(object, args);
                    // 返回通知
                    System.out.println("返回通知 result = " + result);
                } catch (Exception e) {
                    // 異常通知
                    System.out.println("異常通知:" + e);
                } finally {
                    // 後置通知
                    System.out.println("後置通知:將紙筆歸還原處...");    
                }
                return result;
            }
        };
        return Proxy.newProxyInstance(loader, interfaces, h);
    }
}
