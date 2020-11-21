package com.sb.di4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    private List<Map<String, String>> users;
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
//        Optional<Map<String, String>> opt = users.stream()
//                .filter(map -> map.get("username").equals(username) && 
//                               map.get("password").equals(password))
//                .findFirst();
//        return opt.isPresent();

        return users.stream()
                .filter(map -> map.get("username").equals(username) && 
                               map.get("password").equals(password))
                .findFirst()
                .isPresent();
    }
    
}
