package com.love2code.hibernate.demo;


import com.love2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class ReadStudentDemo {

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

        try {

            System.out.println("Creating new student object");
            Student theStudent = new Student("Oliver", "Saxon", "oli@gmail.com");
            session.beginTransaction();
            System.out.print("Saving the student");
            System.out.println(theStudent);
            session.save(theStudent);
            session.getTransaction().commit();

            System.out.println("Saved student. Generated id: " + theStudent.getId());

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            System.out.println("\nGetting student with an id " + theStudent.getId());
            Student myStudent = session.get(Student.class, theStudent.getId());
            System.out.println("Get complete: " + myStudent);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            destroy();
        }


    }

}
