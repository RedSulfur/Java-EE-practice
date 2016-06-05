package com.codewars.spring.model;

import java.util.List;

/**
 * Created by sulfur on 18.02.16.
 */
public class Employee {
    private List<Eventplan> eventplans;
    private int empno;
    private String empname;

    public Employee() {
    }

    public Employee(int empno, String empname) {
        this.empno = empno;
        this.empname = empname;
    }

    public List<Eventplan> getEventplans() {
        return eventplans;
    }

    public void setEventplans(List<Eventplan> eventplans) {
        this.eventplans = eventplans;
    }

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    @Override
    public String toString(){
        return "Employee's name: " + empname +
                ", Employee's number: " + empno +
                ", his plans >>>> "  + eventplans;

    }
}
