package com.sb.di;

import java.util.Set;

public class Teacher {
    private String name;
    private Set<Student> students;
    
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

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Teacher{" + "name=" + name + ", students=" + students + '}';
    }
    
    
    
}
