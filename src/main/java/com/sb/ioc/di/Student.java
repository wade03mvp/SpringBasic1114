package com.sb.ioc.di;

public class Student {
    private String name;
    private Integer age;
    private Teacher teacher;

    public Student() {
        System.out.println("學生建構子1");
    }

    public Student(String name, Integer age) {
        System.out.println("學生建構子2");
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Student{" + "name=" + name + ", age=" + age + ", teacher=" + (teacher==null?"":teacher.getName()) + '}';
    }

    
    
}
