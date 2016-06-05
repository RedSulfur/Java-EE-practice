package com.codewars.hibernate;

import javax.persistence.*;
import java.sql.Date;


/**
 * Created by sulfur on 21.02.16.
 */

@Entity
@Table(name = "eventplan")
public class Eventplan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "planno")
    private Integer event_id;

    @Column(name = "notes", nullable = true)
    private String note;

    @Column(name = "workdate")
    private Date date;

    @Column(name = "notes")
    private String notes;

    @Column(name = "activity")
    private String activity;

    /*
    PERSIST is create new records from object in the database.
    DELETE is, well, delete.
    MERGE, for existing objects, to merge the existing data in the table with the data in my object. (sync to database)
    REFRESH is to refresh the data in the object. Perhaps there was a change on the database which needs to be synced. (sync from database)
    */
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
//    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "empno", nullable = true)
    private Employee employee;

    public Eventplan() {
    }

    public Eventplan(Integer event_id, String note, Employee employee) {
        this.event_id = event_id;
        this.note = note;
        this.employee = employee;
    }

    public Integer getEvent_id() {
        return event_id;
    }

    public void setEvent_id(Integer event_id) {
        this.event_id = event_id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    @Override
    public String toString() {
        return "event_id=" + event_id +
                ", note='" + note;
    }
}
