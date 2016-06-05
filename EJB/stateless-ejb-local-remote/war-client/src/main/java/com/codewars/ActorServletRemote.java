package com.codewars;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by sulfur on 13.03.16.
 */
@WebServlet(name = "ActorServletRemote", urlPatterns = {"/actorServletRemote"})
public class ActorServletRemote extends HttpServlet{

    private static final Logger log = LoggerFactory.getLogger(ActorServletRemote.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.trace("Servlet ActorServlet doGet begin");

        ActorEJBRemote actorEJBRemote;

        try {
            Context context = new InitialContext();
            actorEJBRemote = (ActorEJBRemote) context.lookup("java:global/ear-ejb/war-ejb-1.0-SNAPSHOT/ActorEJB!com.codewars.ActorEJBRemote");
        } catch (NamingException e) {
            log.error("Error while creating JNDI context: {}", e.getMessage());
            throw new ServletException("Error while creating JNDI context");
        }

        log.debug("actorEJBRemote class: {}", actorEJBRemote == null ? "EJB not initialized" : actorEJBRemote.getClass().getCanonicalName());

        List<Actor> actors = actorEJBRemote.getActors();

        log.debug("Actors returned by EJB: {}", actors);

        request.setAttribute("actorClass", actors.get(0).getClass().getCanonicalName());
        request.setAttribute("beanClass", actorEJBRemote.getClass().getCanonicalName());
        request.setAttribute("interface", "remote");
        request.setAttribute("actors", actors);

        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        log.trace("Servlet ActorServlet doGet end");

    }
}
