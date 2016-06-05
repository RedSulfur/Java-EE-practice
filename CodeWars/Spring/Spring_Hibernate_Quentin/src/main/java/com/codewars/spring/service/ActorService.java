package com.codewars.spring.service;

import com.codewars.spring.model.Actor;
import com.codewars.spring.model.Film;
import com.codewars.spring.model.Films_Actors;

import java.util.List;

/**
 * Created by sulfur on 04.03.16.
 */
public interface ActorService {

    public void createActor(Actor actor);

    public void createFilm(Film film);

    public void createBinding(Films_Actors films_actors);

    public void readOnly(String name);

    public List<Actor> getListActors(String name);

    public void deleteEveryMention(Actor actor);

    public Actor getActorByName(String name);

    public Film getFilmByName(String name);

    public void updateActor(Actor actor);

}
