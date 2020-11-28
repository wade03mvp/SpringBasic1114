package com.sb.ioc.di3;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope(value = "prototype")
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
