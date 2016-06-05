package com.codewars.spring.model;

/**
 * Created by sulfur on 18.02.16.
 */
public class Eventplan {
    private int planno;
    private String notes;
    private Employee employee;

    public Eventplan() {
    }


    public Eventplan(int planno, String notes, Employee employee) {
        this.planno = planno;
        this.notes = notes;
        this.employee = employee;
    }

    public int getPlanno() {
        return planno;
    }

    public void setPlanno(int planno) {
        this.planno = planno;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString(){
        return "PlanNo = " + planno +
                ", Notes: " + notes;
    }
}
