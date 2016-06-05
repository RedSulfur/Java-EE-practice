package com.codewars.spring;

import com.codewars.spring.model.Actor;
import com.codewars.spring.model.Film;
import com.codewars.spring.model.Films_Actors;
import com.codewars.spring.service.ActorService;
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

        ActorService actorService = (ActorService) context.getBean("actorService");

//        createActor(actorService);
//        createFilm(actorService);
//        participateActor(actorService,"Dylan O'Brien","Kill Bill","Set some role here");
        deleteEveryMention(actorService, "Dylan O'Brien");
//        test5(actorService);
//        test6(actorService);
    }


    private static void createActor(ActorService actorService) {
//        Actor actor = new Actor("Sarah Maclachclan");
        Actor actor = new Actor("Dylan O'Brien");
        actorService.createActor(actor);
    }

    private static void createFilm(ActorService actorService) {
        Film film = new Film("Soul in shambles");
        actorService.createFilm(film);
    }

    private static void participateActor(ActorService actorService, String actorName, String filmName, String role) {
        Actor actor = actorService.getActorByName(actorName);
        Film film = actorService.getFilmByName(filmName);
        Films_Actors films_actors = new Films_Actors();
        films_actors.setActor(actor);
        films_actors.setFilm(film);
        films_actors.setRole(role);
//        films_actors.setRole("Reside in the abyss of despair");

        actorService.createBinding(films_actors);
    }

    private static void deleteEveryMention(ActorService actorService, String name) {
        actorService.deleteEveryMention(name);
    }

   /* private static void test1(EmployeeService employeeService) {
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
    }*/

}