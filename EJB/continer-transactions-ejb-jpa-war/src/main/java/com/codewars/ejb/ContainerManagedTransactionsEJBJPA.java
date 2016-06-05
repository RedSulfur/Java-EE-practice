package com.codewars.ejb;

import com.codewars.ejb.entity.Actor;
import com.codewars.ejb.exception.BusinessException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by sulfur on 17.03.16.
 */

@Stateless
@LocalBean
@TransactionManagement(value = TransactionManagementType.CONTAINER)
public class ContainerManagedTransactionsEJBJPA {

    @PersistenceContext(unitName = "persistence")
    private EntityManager entityManager;

    private CriteriaBuilder criteriaBuilder;

    @PostConstruct
    public void init() { criteriaBuilder = entityManager.getCriteriaBuilder();}

    @PreDestroy
    public void destroy() {criteriaBuilder = null;}

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public List<Actor> getAllActors(){

        /*
        The query will return instances of the Actor entity, so the type of the query
        is specified when the CriteriaQuery object is created to create a typesafe query.
        */
        CriteriaQuery<Actor> criteria = criteriaBuilder.createQuery(Actor.class);
        /*
        The FROM clause of the query is set, and the root of the query specified,
        by calling the from method of the query object:
        */
        criteria.from(Actor.class);
        /*
        The SELECT clause of the query is set by calling the
        select method of the query object and passing in the query root:
        */

        /*
        The query object is now used to create a TypedQuery<T> object
        that can be executed against the data source. The modifications to
        the query object are captured to create a ready-to-execute query:
        */
        TypedQuery<Actor> query = entityManager.createQuery(criteria);
        return query.getResultList();
    }

    @TransactionAttribute(value = TransactionAttributeType.REQUIRED)
    public void updateActorWithTransaction(Actor actor) throws BusinessException {
        entityManager.merge(actor);
        entityManager.flush();
        throw new BusinessException("Manual transaction rollback");
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public void updateActorWithNoTransaction(Actor actor) throws BusinessException {
        entityManager.merge(actor);
        entityManager.flush();
        throw new BusinessException("Manual transaction rollback");
    }


}
