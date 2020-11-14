package com.sb.di;

import org.junit.Test;

public class Test1 {
    @Test
    public void t1() {
        Student s1 = new Student();
        s1.setName("John");
        s1.setAge(18);
        System.out.println(s1);
    }
}
