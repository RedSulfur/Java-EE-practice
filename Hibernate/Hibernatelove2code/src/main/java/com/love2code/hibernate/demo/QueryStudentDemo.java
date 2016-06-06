package com.love2code.hibernate.demo;


import com.love2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

public class QueryStudentDemo {

    private static ServiceRegistry serviceRegistry;
    private static SessionFactory sessionFactory;

    public static void init() {

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml").addAnnotatedClass(Student.class);
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);

    }

    public static void destroy() {
        StandardServiceRegistryBuilder.destroy(serviceRegistry);
    }


    public static void displayStudents(List<Student> list) {

        for (Student tempStudent :
                list) {
            System.out.println(tempStudent);
        }
    }


    public static void main(String[] args) {

        init();

        Session session = sessionFactory.getCurrentSession();
        try {

            session.beginTransaction();

            List<Student> list = session.createQuery("from Student").list();

//            displayStudents(list);

            list = session.createQuery("from Student s where s.lastName = 'Doe' OR s.lastName = 'Myers'").list();

//            displayStudents(list);

            list = session.createQuery("from Student s where s.email like '%@gmail.com'").list();

            displayStudents(list);

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            destroy();

        }

    }

}
