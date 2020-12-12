package com.jdbc.template.mapper.entity;

import java.util.Date;

public class Invoice {
    private Integer id;
    private Date invdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getInvdate() {
        return invdate;
    }

    public void setInvdate(Date invdate) {
        this.invdate = invdate;
    }

    @Override
    public String toString() {
        return "Invoice{" + "id=" + id + ", invdate=" + invdate + '}';
    }

    
}
