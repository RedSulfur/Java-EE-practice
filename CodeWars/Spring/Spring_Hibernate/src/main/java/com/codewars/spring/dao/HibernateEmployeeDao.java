package com.codewars.spring.dao;

import com.codewars.spring.model.Employee;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by sulfur on 02.03.16.
 */
public class HibernateEmployeeDao implements EmployeeDao{

    @Autowired
    SessionFactory sessionFactory;

    public HibernateEmployeeDao() {
    }

    @Override
    public Integer createEmployee(Employee employee) {
        Integer r = (Integer) sessionFactory.getCurrentSession().save(employee);
        return r;
    }

    @Override
    public void deleteEmployee(Employee employee) {
        sessionFactory.getCurrentSession().delete(employee);
    }

    @Override
    public Employee getEmployeeByName(String name) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("from Employee e where e.emp_name = :name")
                .setParameter("name", name);
//        query.setParameter(0,name);
        return (Employee) query.uniqueResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Employee> getListEmployee(String name) {
        List<Employee> empList = sessionFactory.getCurrentSession()
                .createCriteria(Employee.class)
                .add(Restrictions.like("emp_name", name))
                .list();
        return empList;
    }

    @Override
    public void deleteEveryMention(Employee employee) {
        sessionFactory.getCurrentSession()
                .createQuery("delete from Employee where empname = :name")
                .setParameter("name", employee.getEmp_name()).executeUpdate();
    }
}
