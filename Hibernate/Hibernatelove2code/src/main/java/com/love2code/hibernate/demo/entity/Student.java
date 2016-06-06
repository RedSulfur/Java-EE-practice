package com.love2code.hibernate.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    /**
     * This part maps the field to the database columns.
     *
     * @param id represents a primary key for our {@link Student} class
     *           that is related to an actual primary key {@code id} from
     *           the database
     * Id annotation tells Hibernate, that this given field is a primary key
     * and this field maps to a column in a database table, and that column name
     * is id.
     */
    @Id
    /**
     * tells hibernate how to perform generation, to use a given strategy for
     * generating an id
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    /**
     * define non arg constructor
     */
    public Student() {
    }

    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
