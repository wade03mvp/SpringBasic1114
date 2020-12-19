package com.jpa.entity.many2many;

import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name = "Fund")
public class Fund {
    @Id
    @GeneratedValue
    private Integer id;
    
    @Column
    private String name;
    
    @JoinTable(
            name = "Fund_Stock",
            joinColumns = {@JoinColumn(name = "fund_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "stock_id", referencedColumnName = "id")}
    )
    @ManyToMany(cascade = CascadeType.PERSIST)
    private Set<Stock> stocks = new LinkedHashSet<>();

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

    public Set<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(Set<Stock> stocks) {
        this.stocks = stocks;
    }
    
    
}
