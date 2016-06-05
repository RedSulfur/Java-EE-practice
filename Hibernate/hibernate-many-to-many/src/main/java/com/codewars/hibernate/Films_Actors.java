package com.codewars.hibernate;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by sulfur on 25.02.16.
 */


@Entity
@Table(name = "films_actors")
@AssociationOverrides({
        @AssociationOverride(name = "pk.actor",
        joinColumns = @JoinColumn(name = "actor_ident")),
        @AssociationOverride(name = "pk.film",
        joinColumns = @JoinColumn(name = "film_id"))
})
public class Films_Actors implements Serializable{

    private Films_Actors_Id pk = new Films_Actors_Id();
    private String role;

    public Films_Actors() {
    }

    @EmbeddedId
    public Films_Actors_Id getPk() {
        return pk;
    }

    public void setPk(Films_Actors_Id pk) {
        this.pk = pk;
    }

    @Transient
    public Actor getActor() {
        return getPk().getActor();
    }

    public void setActor(Actor actor) {
        getPk().setActor(actor);
    }

    @Transient
    public Film getFilm() {
        return getPk().getFilm();
    }

    public void setFilm(Film film) {
        getPk().setFilm(film);
    }

    @Column(name = "actorrole")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Films_Actors other = (Films_Actors) obj;
        if (this.getPk() != other.getPk() && (this.getPk() == null || !this.getPk().equals(other.getPk()))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + (this.getPk() != null ? this.getPk().hashCode() : 0);
        return hash;
    }
}



















