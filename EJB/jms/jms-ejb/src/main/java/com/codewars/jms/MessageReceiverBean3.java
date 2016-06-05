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

@MessageDriven(name = "MDB3", activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "topic/test")
})
public class MessageReceiverBean3 implements MessageListener{

    public static final Logger log = LoggerFactory.getLogger(MessageReceiverBean3.class);

//    @PostConstruct
//    private void before() {log.debug("Bean 3 PostConstruct");}
//
//    @PreDestroy
//    private void after() {log.debug("Bean 3 PreDestroy");}

    @Resource
    MessageDrivenContext context;

    @Override
    public void onMessage(Message message) {

        if (message instanceof TextMessage) {
            try {
                Thread.sleep(1000);
                TextMessage textMessage = (TextMessage) message;
                final String text = textMessage.getText();
                if (text.contains("This is message 3") || text.contains("This is message 5") || text.contains("This is message 7")) {
                    log.debug("*** Bean 3 Throw message with text'" + text + " away...");
                    context.setRollbackOnly();
                    return;
                }
                log.debug("Bean 3 from topic: {}", text);

            } catch (InterruptedException e) {
                e.printStackTrace();
                log.error("YOU HAVE JMS EXCEPTION HERE!");
            } catch (JMSException e) {
                e.printStackTrace();
                log.error("YOU HAVE JMS EXCEPTION HERE!");
            }
        }

    }
}
