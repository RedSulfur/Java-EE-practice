package com.codewars.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by sulfur on 28.02.16.
 */

/*
1 - level - Session level
2 level - Session Factory, pluggable
*/

//    Кэш 1-го уровня работает на уровне сессии

    /*
    Пока мы используем одну сессиию, у неё есть свой кэш 1го уровня.
    Если мы в 1ой сессии запросили определенные обьекты, то они будут помещены
    в кэш 1го уровня, и когда нам, работая с этой же hibernate сессией,
    понадобятся уже известные обьекты, они будут взяты именно
    из этого кэша 1го уровня именно этой сессии
    */

    /*
    Если мы из другой сессии делаем запрос, в котором есть точно такие же
    обьекты, которые у нас уже есть, но в рамках другой сессии,то они будут
    нам недоступны и будут заново возращаться из базы данных
    */

public class HibernateSecondLevelCache {

    private static final Logger log = LoggerFactory.getLogger(HibernateSecondLevelCache.class);

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

        // Делаем дважды для демонстрации - SELECT вызывается один раз или два
        // в зависимости от настроек кэша

        checkQuery(sessionFactory);
        log.info("====================================================");
        checkQuery(sessionFactory);

        // Делаем дважды для демонстрации - SELECT вызывается один раз или два
        // в зависимости от настроек кэша
//        checkOne(sessionFactory);
//        checkOne(sessionFactory);

        // Обращение к статистике только при включенном кэше
//        showStatistics(sessionFactory);
//        showStatistics(sessionFactory);

        destroy();
    }

   private static void checkQuery(SessionFactory sessionFactory) throws HibernateException {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query createQuery = session.createQuery("from Employee");
        // Если не ставить кэширование, то запрос будет дважды
        // И обязательно в hibernate.cfg.xml дожно быть установлено
        // <property name="cache.use_query_cache">true</property>
        // Если включить без кэша - то интересный эффект


       /*
       В кэш запросов, записываются сам запрос (select), а
       в качестве значения будет идентификаторы результатов (не все поля
       обьектов employee, а только его идентификаторы)
       */

       /*
       Employee будут выбираться в соответствии с их идентификаторами (по
       одному запросу на каждый идентификатор), полученными
       из кэша запросов, куда они были помещены при первом запуске checkQuery
       */

        createQuery.setCacheable(true);
        List<Employee> regionList1 = createQuery.list();
        for (Employee e : regionList1) {
            log.info("Employee: {}", e);
        }
        session.getTransaction().commit();
    }

    private static void checkOne(SessionFactory sessionFactory) {

        Session session = sessionFactory.getCurrentSession();

        log.info("session hash : {}", session.hashCode());

        session.beginTransaction();
//        В момент получения обьекта он будет помещен в кэш 1го уровня
        Employee e = (Employee) session.get(Employee.class, 1L);
        log.info("Employee: {}", e);
        session.getTransaction().commit();
    }

    private static void showStatistics(SessionFactory sessionFactory) {
        if (sessionFactory.getStatistics().getSecondLevelCacheStatistics("CacheForRegion") != null) {
            Map ce = sessionFactory.getStatistics().getSecondLevelCacheStatistics("CacheForRegion").getEntries();

            for (Iterator en = ce.keySet().iterator(); en.hasNext(); ) {
                Object key = en.next();
                Object value = ce.get(key);
                log.info("Key: {}", key);
                log.info("Value: {}", value);
            }
        } else {
            log.info("No statistics for second level");
        }
    }

}
