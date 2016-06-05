package com.codewars.ejb;

/**
 * Created by sulfur on 16.03.16.
 */

import com.codewars.ejb.staff.Actor;
import com.codewars.ejb.staff.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.ejb.*;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by sulfur on 16.03.16.
 */

@Stateless
@LocalBean
@TransactionManagement(value = TransactionManagementType.CONTAINER)
public class ContainerManagedTransactionsEJB {

    static final Logger log = LoggerFactory.getLogger(ContainerManagedTransactionsEJB.class);

    @Resource(mappedName = "java:/DB-java-ee", type = DataSource.class)
    private DataSource dataSource;

    @TransactionAttribute(value = TransactionAttributeType.REQUIRED)
    public List<Actor> getAllActors() throws BusinessException {
        List<Actor> actors = new LinkedList<>();
        try(Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement =  connection.prepareStatement("SELECT actor_id,actor_name FROM films.actors");
            ResultSet rs = preparedStatement.executeQuery();
            log.debug("AutoCommit AllActors: {}", connection.getAutoCommit());

            while (rs.next()) {
                actors.add(new Actor(rs.getLong(1), rs.getString(2)));
            }
            return actors;
        } catch (SQLException ex) {
            log.error("{}: {}, :", ex.getClass().getCanonicalName(), ex.getMessage());
            throw new BusinessException(ex);
        }
    }

    @TransactionAttribute(value = TransactionAttributeType.REQUIRED)
    public void updateActorWithTransaction(Actor actor) throws BusinessException {

        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("update films.actors set actor_name = ? where actor_id = ?");
            preparedStatement.setString(1,actor.getName());
            preparedStatement.setLong(2,actor.getId());
            final int updateCount = preparedStatement.executeUpdate();
            log.debug("UpdateCount WithTransaction: {}", updateCount);
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            log.error("{}: {}", ex.getClass().getCanonicalName(), ex.getMessage());
            throw new BusinessException(ex.getMessage());
        }
        throw new BusinessException("Manual transaction rollback");
    }

    @TransactionAttribute(value = TransactionAttributeType.NOT_SUPPORTED)
    public void updateActorWithNoTransaction(Actor actor) throws BusinessException {

        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("update films.actors set actor_name = ? where actor_id = ?");
            preparedStatement.setString(1,actor.getName());
            preparedStatement.setLong(2, actor.getId());
            final int updateCount = preparedStatement.executeUpdate();
            log.debug("UpdateCount WithNoTransaction: {}", updateCount);
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            log.error("{}: {},", getClass().getCanonicalName(), ex.getMessage());
            throw new BusinessException(ex.getMessage());
        }
        throw new BusinessException("Manual transaction rollback");
    }
}

