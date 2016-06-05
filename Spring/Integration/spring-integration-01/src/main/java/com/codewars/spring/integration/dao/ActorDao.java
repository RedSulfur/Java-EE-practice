package com.codewars.spring.integration.dao;

import com.codewars.spring.integration.model.Actor;
import com.codewars.spring.integration.model.Film;
import com.codewars.spring.integration.model.Films_Actors;

import java.util.List;

/**
 * Created by sulfur on 04.03.16.
 */
public interface ActorDao {

    public <E> Long createEntity(E e);

    public void createBinding(Films_Actors films_actors);

    public List<Actor> getListActors(String name);

    public void deleteEveryMention(String name);

    public Actor getActorByName(String name);

    public Film getFilmByName(String name);

    public void updateActor(Actor actor);
}
