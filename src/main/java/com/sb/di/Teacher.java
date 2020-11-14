package com.sb.di;

public class Teacher {
    private String name;

    public Teacher() {
        System.out.println("老師建構子1");
    }

    public Teacher(String name) {
        System.out.println("老師建構子2");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void init() {
        System.out.println("聘請老師");
    }
    
    public void destroy() {
        System.out.println("老師退休");
    }
    
    @Override
    public String toString() {
        return "Teacher{" + "name=" + name + '}';
    }
    
}
