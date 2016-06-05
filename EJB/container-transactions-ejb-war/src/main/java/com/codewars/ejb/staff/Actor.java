package com.codewars.ejb.staff;

import java.io.Serializable;

/**
 * Created by sulfur on 16.03.16.
 */
public class Actor implements Serializable {

    private Long id;
    private String name;

    public Actor(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}