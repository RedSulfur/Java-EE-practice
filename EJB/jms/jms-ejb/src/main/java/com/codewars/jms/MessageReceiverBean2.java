package com.codewars.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;


/**
 * Created by sulfur on 18.03.16.
 */


@MessageDriven(name = "MDB2", activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/test")
})
public class MessageReceiverBean2 implements MessageListener{

    public static final Logger log = LoggerFactory.getLogger(MessageReceiverBean2.class);

//    @PostConstruct
//    private void before() {log.debug("Bean 2 PostConstruct");}
//
//    @PreDestroy
//    private void after() {log.debug("Bean 2 PreDestroy");}

    @Resource
    private MessageDrivenContext context;


    @Override
    public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            try {
                Thread.sleep(2000);
                TextMessage textMessage = (TextMessage) message;

                final String text = textMessage.getText();
                log.debug("Bean 2 from queue: {}", text);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
                log.error("YOU HAVE JMS EXCEPTION HERE!");
            } catch (JMSException e) {
                e.printStackTrace();
                log.error("YOU HAVE JMS EXCEPTION HERE!");
            }
        }

    }


}

