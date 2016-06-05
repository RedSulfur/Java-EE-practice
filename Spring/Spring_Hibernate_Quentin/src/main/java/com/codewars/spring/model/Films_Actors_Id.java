package com.codewars.spring.model;

import org.hibernate.annotations.Cascade;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by sulfur on 04.03.16.
 */

@Embeddable
public class Films_Actors_Id implements Serializable{

    private Actor actor;
    private Film film;

    @ManyToOne
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.DELETE})
    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    @ManyToOne
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.DELETE})
    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Films_Actors_Id other = (Films_Actors_Id) obj;
        if (this.actor != other.actor && (this.actor == null || !this.actor.equals(other.actor))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + (this.actor!= null ? this.actor.hashCode() : 0);
        return hash;
    }
}