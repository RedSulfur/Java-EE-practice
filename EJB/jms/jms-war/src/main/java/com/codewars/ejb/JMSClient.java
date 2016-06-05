package com.codewars.ejb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.jms.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sulfur on 18.03.16.
 */
@WebServlet(name = "JMSClient", urlPatterns = "/jmsClient")
public class JMSClient extends HttpServlet{

    private Logger log = LoggerFactory.getLogger(JMSClient.class);

    @Resource(mappedName = "java:/ConnectionFactory")
    ConnectionFactory connectionFactory;

    @Resource(mappedName = "java:/queue/test")
    private Queue queue;

    @Resource(mappedName = "java:/topic/test")
    private Topic topic;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        log.debug("Servlet started");

        final String destination = request.getParameter("dest");
        if ("queue".equals(destination)) {
            sendMessageToQueue();
        } else if ("topic".equals(destination)){
            sendMessageToTopic();
        } else {
            response.getWriter().write("'dest' parameter need to be provided. queue/topic");
        }
        log.debug("Servlet finished!");
    }

    public void sendMessageToTopic() {
        try {
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer messageProducer = session.createProducer(topic);
            TextMessage message = session.createTextMessage();

            for (int i = 0; i < 10; i++) {
                message.setText("This is message " + (i + 1) + ". " + System.currentTimeMillis());
                log.debug("Sending message: " + message.getText());
                messageProducer.send(message);
                log.debug("message sent");
            }
            messageProducer.close();
            session.close();
            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
    }

    public void sendMessageToQueue() {
        try {
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer messageProducer = session.createProducer(queue);
            TextMessage message = session.createTextMessage();

            for (int i = 0; i < 10; i++) {
                message.setText("This is message " + (i + 1) + ". " + System.currentTimeMillis());
                log.debug("Sending message: " + message.getText());
                messageProducer.send(message);
                log.debug("message sent");
            }
            messageProducer.close();
            session.close();
            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
    }
}
