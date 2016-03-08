package com.codewars.hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * Created by sulfur on 26.02.16.
 */
public class HibernateCRUD {

    public static final Logger log = LoggerFactory.getLogger(HibernateCRUD.class);

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

    static Serializable id;

    public static void main(String[] args) {
        init();

        create();
//
//        get();
//        load();
//
//        getVsLoad();
//
//        update();
//        delete();

        destroy();
    }

    private static void create() {
        log.info("==============CREATE=================");
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Films_Actors films_actors = new Films_Actors("Standartenführer Hans Landa");
        session.save(films_actors);
        session.getTransaction().commit();
    }

}
