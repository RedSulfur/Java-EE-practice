package com.codewars.hibernate;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by sulfur on 25.02.16.
 */


@Entity
@Table(name = "films_actors")
public class Films_Actors implements Serializable{

    @Id
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "film_id")
    private Film film;

    @Id
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "actor_ident")
    private Actor actor;

    @Column(name = "actorrole")
    private String role;

    public Films_Actors() {
    }

    public Films_Actors(String role) {
        this.role = role;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
