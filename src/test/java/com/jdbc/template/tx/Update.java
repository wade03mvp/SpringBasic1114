package com.jdbc.template.tx;

import org.junit.Test;

public class Update extends TestTemplate {
    @Test
    public void t1() {
        bookController.buy(1, 1);
        bookController.buy(1, 2);
    }
}
