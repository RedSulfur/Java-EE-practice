package com.love2code.springdemo;


import com.love2code.spring.interfaces.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

        Coach theCoach = context.getBean("myCoach", Coach.class);

        Coach alphaCoach = context.getBean("myCoach", Coach.class);

        /**
         * check if the variables point to the same object
         */
        boolean result = (theCoach == alphaCoach);

        System.out.println("\nVariables point to the same object:" + result);

        System.out.println("\nMemory location for theCoach: "+ theCoach);

        System.out.println("\nMemory location for alphaCoach: " + alphaCoach);

        context.close();
    }

}
