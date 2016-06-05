package com.codewars.spring.integration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;

/**
 * Created by sulfur on 11.03.16.
 */

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        MessageChannel transformationChannel = context.getBean("inputChannel", MessageChannel.class);

        transformationChannel.send(new GenericMessage<String>("<application xmlns=\"http://spring-integration.codewars.com\"><name>Porter</name><age>12</age></application>"));
    }
}