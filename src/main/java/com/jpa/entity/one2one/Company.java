package com.jpa.entity.one2one;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Company")
public class Company {
    @Id
    @GeneratedValue
    private Integer id;
    
    @Column
    private String name;
    
    // 建立 Company 時 Boss 也一併被建立
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "boss_id")
    private Boss boss;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boss getBoss() {
        return boss;
    }

    public void setBoss(Boss boss) {
        this.boss = boss;
    }
    
    
    
}
