package com.codewars.spring.model;

import javax.persistence.*;
import java.util.List;


/**
 * Created by sulfur on 21.02.16.
 */

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empno")
    private int emp_id;
    @Column(name = "empname")
    private String emp_name;
    @OneToMany (cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "employee")
    private List<Eventplan> eventplanList;

    public Employee() {
    }

    public Employee(String emp_name) {
        this.emp_name = emp_name;
    }

    public int getEmp_Id() {
        return emp_id;
    }

    public void setEmp_Id(int emp_Id) {
        this.emp_id = emp_Id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public List<Eventplan> getEventplanList() {
        return eventplanList;
    }

    public void setEventplanList(List<Eventplan> eventplanList) {
        this.eventplanList = eventplanList;
    }

    @Override
    public String toString() {
        return "emp_Id=" + emp_id +
                ", emp_name='" + emp_name;
    }
}