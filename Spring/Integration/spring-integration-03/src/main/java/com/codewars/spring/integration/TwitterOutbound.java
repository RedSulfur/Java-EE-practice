package com.codewars.spring.integration;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;

import java.util.Calendar;

public class TwitterOutbound {

    public static void main(String[] args) {


        ApplicationContext context = new ClassPathXmlApplicationContext("/twitter-outbound.xml", TwitterOutbound.class);

        MessageChannel input = context.getBean("twitterOutbound", MessageChannel.class);

        Message message = new GenericMessage(Calendar.getInstance().getTime()+" @ New Message from Skilled Monster using Spring Integration Module");

        input.send(message);
    }
}