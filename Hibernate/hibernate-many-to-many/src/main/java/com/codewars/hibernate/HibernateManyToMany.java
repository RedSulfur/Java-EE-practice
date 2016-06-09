package com.codewars.hibernate;


/**
 * Created by sulfur on 22.02.16.
 */

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class HibernateManyToMany {

    public static final Logger log = LoggerFactory.getLogger(HibernateManyToMany.class);
    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;

    private static void init() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    private static void destroy() {
        StandardServiceRegistryBuilder.destroy(serviceRegistry);
    }


    public static void main(String[] args) {
        init();

        Session s = sessionFactory.getCurrentSession();
        s.beginTransaction();

//        insertEntity();

//        deleteEntity();

/*
        List<Film> filmList = s.createCriteria(Film.class).list();
        for (Film film : filmList) {
            log.debug("");
            log.debug("Film: {}", film);
            for (Actor actor : film.getActorsList()) {
                log.debug("Actor: {}", actor);
            }
        }*/

        /*List<Film> filmList = s.createCriteria(Film.class).list();
        for(Film film : filmList){
            for (Actor actor : film.getActorsList()){
                for (Films_Actors info : actor.getFilms_actorsList()) {
                    info.getRole();
                }
            }
        }*/

        List<Film> filmList = s.createCriteria(Film.class).list();
        for(Film film : filmList){
            log.debug("\n");
            log.debug("Film title: {}", film.getFilmName());
            for (Films_Actors info : film.getFilms_actors()){
                log.debug("Actor name: {}, Actor role: {}", info.getActor().getActorName(), info.getRole());
                }
        }

        s.getTransaction().commit();

        log.debug("Transaction committed");

        destroy();

}

    public static void deleteEntity() {

        Session session = sessionFactory.getCurrentSession();

        Actor actor = (Actor) session.load(Actor.class, new Long(11));

        session.delete(actor);

    }

    private static void insertEntity() {
        Session session = sessionFactory.getCurrentSession();

        Actor actor = new Actor();
        actor.setActorName("Evolved Hibernate");

        Film film1 = new Film("My new test");
        session.save(film1);

        Films_Actors films_actors = new Films_Actors();
        films_actors.setActor(actor);
        films_actors.setFilm(film1);
        films_actors.setRole("To display understanding");

        actor.getFilms_actors().add(films_actors);

        session.save(actor);

      /*  Film newFilm = new Film();
        newFilm.setFilmName("Test Film");
        session.save(newFilm);

        Actor oldActor = new Actor();
        oldActor.setActorName("Paul Calderón");
        session.save(oldActor);
        newFilm.addActor(oldActor);
        session.save(newFilm);*/
    }


    private SessionFactory getSessionFactory(){

        Configuration configuration=new Configuration().configure();
        SessionFactory sessionFactory=configuration.buildSessionFactory(
        new StandardServiceRegistryBuilder()
        .applySettings(configuration.getProperties())
        .build()
        );
        return sessionFactory;

        }
}
