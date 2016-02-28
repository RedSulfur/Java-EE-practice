package com.codewars.hibernate;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by sulfur on 28.02.16.
 */

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "CacheForRegion")
@Table(name = "employee")
public class Employee implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empno")
    private Long empNo;

    @Column(name = "empname")
    private String empName;

    public Employee() {
    }

    public Employee(String empName) {
        this.empName = empName;
    }

    public Long getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Long empNo) {
        this.empNo = empNo;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    @Override
    public String toString() {
        return empNo +
                ": '" + empName;
    }
}
