package com.love2code.hibernate.demo;


import com.love2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class UpdateStudentDemo {

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

            int studentId = 104;
            session.beginTransaction();

            System.out.println("Getting student with an id : " + studentId);

            Student myStudent = session.get(Student.class, studentId);

            System.out.println("Updating student");

            myStudent.setFirstName("Robert");

            session.getTransaction().commit();

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            System.out.println("Update email for all students");

            session.createQuery("update Student set email='somestring@gmail.com'").executeUpdate();

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            destroy();
        }


    }

}
