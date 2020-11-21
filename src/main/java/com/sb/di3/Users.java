package com.sb.di3;

// 資料源

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component // 相當於 <bean id="users" ...
@Scope(value = "singleton") 
public class Users {
    private List<String> names;
    public Users() {
        names = new ArrayList<>();
        names.add("Tom");names.add("John");names.add("Mary");names.add("Jean");
    }
    
    public List<String> getNames() {
        return names;
    }

    @Override
    public String toString() {
        return "Users{" + "names=" + names + '}';
    }
    
}
