package com.sb.di3;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class UserController {
    @Autowired
    private UserService userService;
    
    public List<String> queryAll() {
        return userService.findAllUser();
    }
    
    public String get(String name) {
        return userService.findUserByName(name);
    }
    
}
