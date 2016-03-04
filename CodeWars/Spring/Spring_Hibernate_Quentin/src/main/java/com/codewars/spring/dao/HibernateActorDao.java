package com.codewars.spring.dao;

import com.codewars.spring.model.Actor;
import com.codewars.spring.model.Film;
import com.codewars.spring.model.Films_Actors;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by sulfur on 04.03.16.
 */
public class HibernateActorDao implements ActorDao{

    @Autowired
    SessionFactory sessionFactory;

    public HibernateActorDao() {
    }

    @Override
    public <E> Long createEntity(E e) {
        Long r = (Long) sessionFactory.getCurrentSession().save(e);
        return r;
    }

    @Override
    public void createBinding(Films_Actors films_actors) {
        sessionFactory.getCurrentSession().save(films_actors);
    }

    @Override
    public List<Actor> getListActors(String name) {
        return null;
    }

    @Override
    public void deleteEveryMention(Actor actor) {

    }

    @Override
    public Actor getActorByName(String name) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("from Actor a where a.actorName = :name")
                .setParameter("name", name);
//        query.setParameter(0,name);
        return (Actor) query.uniqueResult();
    }

    @Override
    public Film getFilmByName(String name) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("from Film f where f.filmName = :name")
                .setParameter("name", name);
//        query.setParameter(0,name);
        return (Film) query.uniqueResult();
    }

    @Override
    public void updateActor(Actor actor) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("update Actor set films_actors = :films_actors" +
                " where actorId = :actorId");
        query.setParameter("films_actors", actor.getFilms_actors());
        query.setParameter("actorId", actor.getActorId());
    }
}
