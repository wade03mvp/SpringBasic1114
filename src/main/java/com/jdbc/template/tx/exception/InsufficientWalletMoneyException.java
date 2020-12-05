package com.jdbc.template.tx.exception;

// 錢包裡的錢不足例外
public class InsufficientWalletMoneyException extends Throwable {

    public InsufficientWalletMoneyException() {
        System.out.println("錢包裡的錢不足");
    }
    
}
