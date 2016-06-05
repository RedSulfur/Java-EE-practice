package com.codewars.spring.dao;

import com.codewars.spring.model.Actor;
import com.codewars.spring.model.Film;
import com.codewars.spring.model.Films_Actors;

import java.util.List;

/**
 * Created by sulfur on 04.03.16.
 */
public interface ActorDao {

    public <E> Long createEntity(E e);

    public void createBinding(Films_Actors films_actors);

    public List<Actor> getListActors(String name);

    public void deleteEveryMention(Actor actor);

    public Actor getActorByName(String name);

    public Film getFilmByName(String name);

    public void updateActor(Actor actor);
}
