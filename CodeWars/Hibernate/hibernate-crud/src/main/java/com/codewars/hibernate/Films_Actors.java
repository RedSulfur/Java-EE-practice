package com.codewars.hibernate;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by sulfur on 26.02.16.
 */

@Entity
@Table(name = "films_actors")
public class Films_Actors implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actor_ident")
    private Long actorId;

    @Column(name = "film_id")
    private Long filmId;

    @Column(name = "actorrole")
    private String role;

    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY, targetEntity = Actor.class)
    @JoinColumn(name = "actor_ident")
    private Actor actor;

    public Films_Actors() {
    }

    public Films_Actors(String role) {
//        this.filmId = filmId;
        this.role = role;
    }

    public Long getActorId() {
        return actorId;
    }

    public void setActorId(Long actorId) {
        this.actorId = actorId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return actorId +
                ", " + role;
    }
}
