package com.codewars.hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by sulfur on 22.02.16.
 */

@Entity
@Table(name = "actors")
public class Actor implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actor_id", unique = true, nullable = false)
    private Long actorId;

    @Column(name = "actor_name")
    private String actorName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.actor", cascade = CascadeType.ALL)
    private Set<Films_Actors> films_actors = new HashSet<Films_Actors>(0);

    public Actor() {
    }

    public Actor(String actorName) {
        this.actorName = actorName;
    }

    public Long getActorId() {
        return this.actorId;
    }

    public void setActorId(Long actorId) {
        this.actorId = actorId;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }


    public Set<Films_Actors> getFilms_actors() {
        return films_actors;
    }

    public void setFilms_actors(Set<Films_Actors> films_actors) {
        this.films_actors = films_actors;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "a_id=" + actorId +
                ", a_name='" + actorName +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Actor other = (Actor) obj;
        if (this.actorId != other.actorId && (this.actorId == null || !this.actorId.equals(other.actorId))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + (this.actorId != null ? this.actorId.hashCode() : 0);
        return hash;
    }

}
