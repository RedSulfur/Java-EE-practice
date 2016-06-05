package com.codewars.spring.service;

import com.codewars.spring.model.Employee;

import java.util.List;

/**
 * Created by sulfur on 02.03.16.
 */
public interface EmployeeService {

    public Employee createEmployee(Employee Employee);

    public void deleteEmployee(Employee Employee);

    public Employee getEmployeeByName(String name);

    public void readOnly(String name);

    public List<Employee> getListEmployee(String name);

    public void deleteEveryMention(Employee employee);
}
