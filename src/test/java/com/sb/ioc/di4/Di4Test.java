package com.sb.ioc.di4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:beans-config3.xml"})
public class Di4Test {
    @Autowired
    private LoginService loginService;
    @Test
    public void t1() {
        System.out.println(loginService.check("john", "1234"));
    }
}
