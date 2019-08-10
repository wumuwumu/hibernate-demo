package cn.sciento.hibernate.simple.dao;

import lombok.Data;

import javax.persistence.*;

//@Data
@Entity
@Table(name = "sys_employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToOne(targetEntity = Boss.class)
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
}
