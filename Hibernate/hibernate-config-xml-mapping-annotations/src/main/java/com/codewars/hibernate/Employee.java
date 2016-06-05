package com.codewars.hibernate;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by sulfur on 21.02.16.
 */


@Entity
@Table(name = "employee")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empno")
    private Long emp_id;

    @Column(name = "empname", nullable = true)
    private String emp_name;

    public Employee() {
    }

    public Employee(String emp_name) {
        this.emp_name = emp_name;
    }

    public Long getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(Long emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    @Override
    public String toString() {
        return emp_id + ", " + emp_name;
    }
}
