package cn.sciento.hibernate.simple.dao;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

//@Data
@Entity
@Table(name = "sys_boss")
public class Boss {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(cascade={CascadeType.ALL})
    private Set<Employee> employeeSet;

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

    public Set<Employee> getEmployeeSet() {
        return employeeSet;
    }

    public void setEmployeeSet(Set<Employee> employeeSet) {
        this.employeeSet = employeeSet;
    }
}
