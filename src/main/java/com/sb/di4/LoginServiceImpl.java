package com.sb.di4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoginServiceImpl implements LoginService {
    List<Map<String, String>> users;
    {
        users = new ArrayList<>();
        users.add(new HashMap<String, String>(){
            {
                put("username", "john");
                put("password", "1234");
            }
        });
        users.add(new HashMap<String, String>(){
            {
                put("username", "mary");
                put("password", "5678");
            }
        });
        
    }
    
    @Override
    public boolean check(String username, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
