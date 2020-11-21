package com.sb.di3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Scope(value = "singleton")
public class UserDao {
    
    @Autowired
    private Users users;
    
    public UserDao() {
        System.out.println("建立 UserDao...");
    }
    public Users queryUsers() {
        return users;
    }
    
}
