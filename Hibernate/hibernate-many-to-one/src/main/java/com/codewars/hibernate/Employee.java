package com.codewars.hibernate;

import org.hibernate.annotations.*;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

/**
 * Created by sulfur on 21.02.16.
 */

@NamedQueries({
        @NamedQuery(
                name = "getEmpById",
                query = "from Employee e where e.emp_Id = :emp_Id"
        )
})
@Entity
@Table(name = "employee")
public class Employee implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empno")
    private int emp_Id;

    @Column(name = "empname")
    private String emp_name;

    @Column(name = "department")
    private String dept;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @OneToMany (cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "employee")
    private List<Eventplan> eventplanList;

    public Employee() {
    }

    public Employee(String emp_name) {
        this.emp_name = emp_name;
    }

    public int getEmp_Id() {
        return emp_Id;
    }

    public void setEmp_Id(int emp_Id) {
        this.emp_Id = emp_Id;
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

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "emp_Id=" + emp_Id +
                ", emp_name='" + emp_name;
    }
}
