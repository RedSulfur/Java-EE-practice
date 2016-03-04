package com.codewars.hibernate;


import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by sulfur on 22.02.16.
 */
@Entity
@Table(name = "films")
public class Film implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id")
    private Long filmId;

    @Column(name = "film_name")
    private String filmName;

    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name = "films_actors",
    joinColumns = @JoinColumn(name = "film_id"),
    inverseJoinColumns = @JoinColumn(name = "actor_ident"))
    private Set<Actor> actorsList;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "film")
    private List<Films_Actors> films_actors;

    public List<Films_Actors> getFilms_actorsList() {
        return films_actors;
    }

    public void setFilms_actorsList(List<Films_Actors> films_actors) {
        this.films_actors = films_actors;
    }

    public Long getFilmId() {
        return filmId;
    }

    public void setFilmId(Long filmId) {
        this.filmId = filmId;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public Set<Actor> getActorsList() {
        return actorsList;
    }

    public void setActorsList(Set<Actor> actorsList) {
        this.actorsList = actorsList;
    }

    public void addActor(Actor actor) {
        if (actorsList== null) {
            actorsList = new HashSet<Actor>();
        }
        actorsList.add(actor);
    }

    @Override
    public String toString() {
        return "Film{" +
                "f_id=" + filmId +
                ", f_name='" + filmName +
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
        final Film other = (Film) obj;
        if (this.filmId != other.filmId && (this.filmId == null || !this.filmId.equals(other.filmId))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + (this.filmId != null ? this.filmId.hashCode() : 0);
        return hash;
    }
}
