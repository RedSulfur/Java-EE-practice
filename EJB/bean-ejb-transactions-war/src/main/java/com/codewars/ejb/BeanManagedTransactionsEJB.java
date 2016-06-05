package com.codewars.ejb;


import com.codewars.ejb.staff.Actor;

import com.codewars.ejb.staff.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.ejb.*;
import javax.sql.DataSource;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by sulfur on 14.03.16.
 */


@Stateless
@LocalBean
@TransactionManagement(value = TransactionManagementType.BEAN)
public class BeanManagedTransactionsEJB {

    private Logger log = LoggerFactory.getLogger(BeanManagedTransactionsEJB.class);

    @Resource(mappedName = "java:/DB-java-ee", type = DataSource.class)
    private DataSource dataSource;

    @Resource(mappedName = "java:comp/UserTransaction")
    private UserTransaction transaction;

    public List<Actor> getAllActors()throws BusinessException {
        List<Actor> actors = new LinkedList<>();
        try {
            transaction.begin();
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT actor_id,actor_name FROM films.actors");
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                actors.add(new Actor(rs.getLong(1),rs.getString(2)));
            }
            transaction.commit();
            rs.close();
            preparedStatement.close();
            connection.close();
            return actors;

        } catch (Exception ex) {
            log.error("{}: {}",ex.getClass().getCanonicalName(), ex.getMessage());

            try {
                transaction.rollback();
            } catch (SystemException e) {
                log.error("{}: {}", ex.getClass().getCanonicalName(), ex.getMessage());
            }
            throw new BusinessException(ex);
        }
    }

    public void updateActorsWithTransactionRollback(Actor actor) throws BusinessException {

        try {
            transaction.begin();
            Connection connection = dataSource.getConnection();

            log.debug("Autocommit with transaction rollback: {}", connection.getAutoCommit());

            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE films.actors set actor_name = ? WHERE actor_id = ?");
            preparedStatement.setString(1,actor.getName());
            preparedStatement.setLong(2, actor.getId());
            final int updateCount = preparedStatement.executeUpdate();
            log.debug("UpdateCount with transaction rollback: {}", updateCount);
            preparedStatement.close();
            transaction.rollback();
            connection.close();

        } catch (Exception ex) {
            log.error("{}: {}", ex.getClass().getCanonicalName(), ex.getMessage());
            try {
                transaction.rollback();
            } catch (SystemException e) {
                e.printStackTrace();
            }
            throw new BusinessException(ex.getMessage());
        }

    }

    public void updateActorsWithNoTransactionRollback(Actor actor) throws BusinessException {

        try {
            transaction.begin();
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE films.actors SET actor_name = ? WHERE actor_id = ?");
            preparedStatement.setString(1,actor.getName());
            preparedStatement.setLong(2,actor.getId());
            final int updateCount = preparedStatement.executeUpdate();
            log.debug("UpdateCount with transaction rollback: {}", updateCount);
            preparedStatement.close();
            transaction.commit();
            connection.close();
        } catch (Exception ex) {
            log.error("{}: {}", ex.getClass().getCanonicalName(), ex.getMessage());
            try {
                transaction.rollback();
            } catch (SystemException e) {
                e.printStackTrace();
            }
            throw new BusinessException(ex.getMessage());

        }

    }

}
