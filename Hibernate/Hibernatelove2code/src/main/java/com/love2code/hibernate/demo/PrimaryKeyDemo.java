package com.love2code.hibernate.demo;


import com.love2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class PrimaryKeyDemo {

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

            session.beginTransaction();

            System.out.println("Creating 3 student objects");
            Student student1 = new Student("John", "Doe", "john@gmail.com");
            Student student2 = new Student("Mike", "Myers", "mike@gmail.com");
            Student student3 = new Student("Dexter", "Morgan", "dexter@gmail.com");

            /**
             * if you want to change a next value for your auto_increment
             * you should provide the next line of code in sql editor
             * {@code select setval('schema-name.sequence-name', <new-value>);}
             * for <PostgreSQL>
             *
             * and {@code ALTER TABLE schema-name.table-name AUTO_INCREMENT=<new value>}
             * for <MySQL>
             *
             * {@code TRUNCATE} quickly removes all rows from a set of tables.
             *
             */

            System.out.println("Saving students");
            session.save(student1);
            session.save(student2);
            session.save(student3);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        destroy();

    }

}
