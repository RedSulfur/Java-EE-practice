package com.codewars.spring.service;

import com.codewars.spring.dao.EmployeeDao;
import com.codewars.spring.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sulfur on 02.03.16.
 */

@Transactional
public class EmployeeServiceImpl implements EmployeeService{

    EmployeeDao employeeDao;

    private Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public EmployeeServiceImpl() {
    }

    @Override
    @Transactional
    public Employee createEmployee(Employee employee) {
        int id = employeeDao.createEmployee(employee);
        log.debug("Employee {} with an id {} created...", employee.getEmp_name(), id);
        return employee;
    }

    @Override
    public List<Employee> getListEmployee(String name) {
        return employeeDao.getListEmployee(name);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        employeeDao.deleteEmployee(employee);
        log.debug("Employee : {} deleted...", employee.getEmp_name());
    }

    @Override
    public void deleteEveryMention(Employee employee){
        employeeDao.deleteEveryMention(employee);
    }

    @Override
    public Employee getEmployeeByName(String name) {
        return employeeDao.getEmployeeByName(name);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
    public void readOnly(String name) {
        // write operation
        employeeDao.createEmployee(new Employee(name));
//        emcreateEmployee(new Employee(name));
        //read operation
        employeeDao.getEmployeeByName(name);
    }
}
