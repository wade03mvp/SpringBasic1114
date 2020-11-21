package com.sb.di3;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    
    public List<String> findAllUser() {
        return userDao.queryUsers();
    }
    
    public String findUserByName(String name) {
        List<String> users = userDao.queryUsers();
        return users.stream().filter(n -> n.equals(name)).findAny().get();
        
    }
}
