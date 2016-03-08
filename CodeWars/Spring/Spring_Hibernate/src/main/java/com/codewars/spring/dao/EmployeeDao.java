package com.codewars.spring.dao;

import com.codewars.spring.model.Employee;

import java.util.List;

/**
 * Created by sulfur on 02.03.16.
 */
public interface EmployeeDao {
    
    public Integer createEmployee(Employee Employee);

    public void deleteEmployee(Employee Employee);

    public Employee getEmployeeByName(String name);

    public List<Employee> getListEmployee(String name);

    public void deleteEveryMention(Employee employee);

}
