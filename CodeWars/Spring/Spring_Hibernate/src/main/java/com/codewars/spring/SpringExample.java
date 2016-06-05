package com.codewars.spring;


import com.codewars.spring.model.Employee;
import com.codewars.spring.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Random;

/**
 * Created by sulfur on 02.03.16.
 */



public class SpringExample {

    public static final Logger log = LoggerFactory.getLogger(SpringExample.class);

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"springConfig.xml"});

        EmployeeService EmployeeService = (EmployeeService) context.getBean("EmployeeService");

//        test1(EmployeeService);
//        test2(EmployeeService);
//        test3(EmployeeService);
//        test4(EmployeeService);
        test5(EmployeeService);
//        test6(EmployeeService);
    }

    private static void test1(EmployeeService employeeService) {
        Employee employee = new Employee("Sarah Maclachclan");
        employeeService.createEmployee(employee);
    }

    private static void test2(EmployeeService employeeService) {
        Employee employee1 = new Employee("Godsmack");
        employeeService.createEmployee(employee1);


        Employee employee2 = new Employee("Disturbed");
        employeeService.createEmployee(employee2);

    }

    private static void test3(EmployeeService employeeService) {
        employeeService.readOnly("Sypher" + new Random().nextInt(1000));
    }

    private static void test4(EmployeeService employeeService) {
        Employee employee = employeeService.getEmployeeByName("Disturbed");
        employeeService.deleteEmployee(employee);
    }

    private static void test5(EmployeeService employeeService) {
        List<Employee> list = employeeService.getListEmployee("John Doe");
        for(Employee e : list){
            log.debug("Employee {},{} extracted",e.getEmp_Id(), e.getEmp_name());
        }
    }

    public static void test6(EmployeeService employeeService) {
        Employee employee = employeeService.getEmployeeByName("John Doe");
        employeeService.deleteEveryMention(employee);
    }

}
