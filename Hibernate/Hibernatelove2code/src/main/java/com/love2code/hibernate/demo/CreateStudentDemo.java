package com.love2code.hibernate.demo;


import com.love2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class CreateStudentDemo {

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

    public static void main(String[] args) {

        init();

        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();

        System.out.println("Create a new student object");
        Student tempStudent = new Student("Paul", "Wall", "email@gmail.com");

        System.out.println("Saving the student");
        session.save(tempStudent);

        session.getTransaction().commit();

        destroy();

    }

}
