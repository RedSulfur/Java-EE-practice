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
@Table(name = "actors")
public class Actor implements Serializable{

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "actor_id")
    private Long actorId;

    @Column(name = "actor_name")
    private String actorName;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "actor")
    private List<Films_Actors> films_actors;

    @ManyToMany (cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            fetch = FetchType.LAZY, mappedBy = "actorsList")
    private Set<Film> filmlist;

    public List<Films_Actors> getFilms_actorsList() {
        return films_actors;
    }

    public void setFilms_actorsList(List<Films_Actors> films_actors) {
        this.films_actors = films_actors;
    }

    public Long getActorId() {
        return actorId;
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

    public Set<Film> getFilmlist() {
        return filmlist;
    }

    public void setFilmlist(Set<Film> filmlist) {
        this.filmlist = filmlist;
    }

    public void addFilm(Film film) {
        if (filmlist == null) {
            filmlist = new HashSet<Film>();
        }
        filmlist.add(film);
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
