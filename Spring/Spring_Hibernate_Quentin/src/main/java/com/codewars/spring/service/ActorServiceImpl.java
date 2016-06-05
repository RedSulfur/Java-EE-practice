package com.codewars.spring.service;

import com.codewars.spring.dao.ActorDao;
import com.codewars.spring.model.Actor;
import com.codewars.spring.model.Film;
import com.codewars.spring.model.Films_Actors;
import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sulfur on 04.03.16.
 */
public class ActorServiceImpl implements ActorService{

    ActorDao actorDao;

    private Logger log = LoggerFactory.getLogger(ActorServiceImpl.class);

    public void setActorDao(ActorDao actorDao) {
        this.actorDao = actorDao;
    }

    @Override
    @Transactional
    public void createActor(Actor actor) {
        Long id = actorDao.createEntity(actor);
//        Long id = actorDao.createActor(actor);
        log.debug("Actor {} with an id {} created...", actor.getActorName(), id);
    }

    @Override
    @Transactional
    public void createFilm(Film film) {
        Long id = actorDao.createEntity(film);
//        Long id = actorDao.createFilm(film);
        log.debug("Film {} with an id {} created...", film.getFilmName(), id);
    }

    @Override
    @Transactional
    public void createBinding(Films_Actors films_actors) {
        actorDao.createBinding(films_actors);
        log.debug("Actor {} was starring in a film {} as {}...", films_actors.getPk().getActor(),
                films_actors.getPk().getFilm(), films_actors.getRole());
    }

    @Override
    @Transactional
    public Actor getActorByName(String name) {
        return actorDao.getActorByName(name);
    }

    @Override
    @Transactional
    public Film getFilmByName(String name) {
        return actorDao.getFilmByName(name);
    }

    @Override
    @Transactional
    public void updateActor(Actor actor) {
        actorDao.updateActor(actor);
    }

    @Override
    public void readOnly(String name) {

    }

    @Override
    public List<Actor> getListActors(String name) {
        return null;
    }

    @Override
    @Transactional
    public void deleteEveryMention(String name) {
        actorDao.deleteEveryMention(name);
    }


}
