package com.codewars.spring.model;

import javax.persistence.*;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by sulfur on 22.02.16.
 */
@Entity
@Table(name = "films", catalog = "films")
public class Film implements Serializable{

    private Long filmId;
    private String filmName;
    private Set<Films_Actors> films_actors = new HashSet<Films_Actors>(0);

    public Film() {
    }

    public Film(String filmName) {
        this.filmName = filmName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id")
    public Long getFilmId() {
        return filmId;
    }

    public void setFilmId(Long filmId) {
        this.filmId = filmId;
    }

    @Column(name = "film_name")
    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "pk.film")
    public Set<Films_Actors> getFilms_actors() {
        return films_actors;
    }

    public void setFilms_actors(Set<Films_Actors> films_actors) {
        this.films_actors = films_actors;
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
