package com.codewars.hibernate;


import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.List;

import java.util.List;

/**
 * Created by sulfur on 21.02.16.
 */

public class HibernateManyToOne {

    public static final Logger log = LoggerFactory.getLogger(HibernateManyToOne.class);

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

//        create();

        get();

//        load();

//        getVsLoad();

//        update();

//        delete();

  /*      Session s = sessionFactory.getCurrentSession();
        s.beginTransaction();*/

       /* Criteria criteria = s.createCriteria(Eventplan.class);
        List <Eventplan> eventplanList = criteria.list();


        for (Eventplan eventplan : eventplanList){
            log.debug("event id: {}", eventplan.getEvent_id());
            log.debug("event class: {}", eventplan.getClass().getCanonicalName());
            log.debug("event note: {}", eventplan.getNote());
            log.debug("event employee class: {}", eventplan.getEmployee().getClass().getCanonicalName());
            log.debug("event employee id: {}", eventplan.getEmployee().getEmp_Id());
            log.debug("event employee name: {}", eventplan.getEmployee().getEmp_name());
            log.debug("");
        }*/


   /*     List<Employee> employeeList = s.createQuery("from Employee ").list();

        for (Employee e : employeeList) {
            log.debug("Employee name: {}", e);
            for (Eventplan eventplan : e.getEventplanList()) {
                log.debug("     Event information: {}", eventplan);
            }
        }*/

     /*   Employee HiberTest = new Employee("TestEmployee");
        s.save(HiberTest);

        Eventplan eventplan = new Eventplan();
        eventplan.setNote("Will this work? - NO!");
        eventplan.setEmployee(HiberTest);
        s.save(eventplan);*/


      /*  s.getTransaction().commit();
        log.debug("Transaction committed");*/

        destroy();

    }

    private static void create() {
        log.info("==============CREATE=================");
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Employee employee = new Employee("Derek Stylez");
        session.save(employee);
        session.getTransaction().commit();
        id = employee.getEmp_Id();
    }

    private static void get() {
        log.info("==============GET=================");
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
//        Employee employee = (Employee) session.get(Employee.class, new Integer(100));
        Query query = session.getNamedQuery("getEmpById").setInteger("emp_Id",100);
        Employee employee = (Employee)query.uniqueResult();
        log.info("Employee : {}", employee);
        log.info("\n");
        for(Eventplan eventplan : employee.getEventplanList()) {
            log.debug("Eventplan : {}", eventplan);
        }
        session.getTransaction().commit();
    }
/*

    From the output it’s clear that get() returns the object by fetching it from database or
    from hibernate cache whereas load() just returns the reference of an object that might not
    actually exists, it loads the data from database or cache only when you access other properties of the object.

*/

    /*

    In session.get(), Hibernate will hit the database to retrieve the Stock object and put it as a reference
    to StockTransaction. However, this save process is extremely high demand, there may be thousand or million
    transactions per hour, do you think is this necessary to hit the database to retrieve the Stock object everything
    save a stock transaction record? After all you just need the Stock’s Id as a reference to StockTransaction.

  */


    /*
       In session.load(), Hibernate will not hit the database (no select statement in output) to retrieve the Stock
       object, it will return a Stock proxy object – a fake object with given identify value. In this scenario, a proxy
       object is enough for to save a stock transaction record.

    */
    private static void load() {
        log.info("==============LOAD=================");
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Employee employee = (Employee) session.load(Employee.class, new Integer(100));
        log.info("Employee : {}", employee);
        log.info("\n");
        for(Eventplan eventplan : employee.getEventplanList()) {
            log.debug("Eventplan : {}", eventplan);
        }
        session.getTransaction().commit();
    }


    private static void getVsLoad() {
        log.info("==============GET_VS_LOAD=================");
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        Employee employee = (Employee) session.get(Employee.class, new Integer(100));
        Eventplan eventplan1 = new Eventplan();
        eventplan1.setNote("Play Guitar");
        eventplan1.setEmployee(employee);
        session.save(eventplan1);

        log.info("====================******====================");

        employee = (Employee) session.load(Employee.class, new Integer(100));
        Eventplan eventplan2 = new Eventplan();
        eventplan2.setNote("Read book");
        eventplan2.setEmployee(employee);
        id = session.save(eventplan2);

        session.getTransaction().commit();
    }

    private static void update() {
        log.info("==============UPDATE=================");
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Eventplan eventplan = (Eventplan) session.load(Eventplan.class, new Integer(299));
        eventplan.setNote("Java Developing");
        session.saveOrUpdate(eventplan);
        log.info("eventplan = {}", eventplan);

        session.getTransaction().commit();
    }

    private static void delete() {
        log.info("==============DELETE=================");
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Eventplan eventplan = (Eventplan) session.load(Eventplan.class, new Integer(4));

        session.delete(eventplan);

        session.getTransaction().commit();
    }


}



