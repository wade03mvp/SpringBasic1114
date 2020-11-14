package com.sb.di;

// 套課

import java.util.List;

public class CourseSet {
    private String name; // 套課名
    private List<String> cls; // 課程內容, Ex:[Java, JavaWb, SSH, Android]

    public CourseSet() {
    }

    public CourseSet(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getCls() {
        return cls;
    }

    public void setCls(List<String> cls) {
        this.cls = cls;
    }

    @Override
    public String toString() {
        return "CourseSet{" + "name=" + name + ", cls=" + cls + '}';
    }
    
    
}
