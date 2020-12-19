package lab.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clubs")
public class Club {
    @Id
    @GeneratedValue
    private Integer id;
    
    @Column
    private String name;

    public Club() {
    }

    public Club(String name) {
        this.name = name;
    }
 
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
}
