package com.codewars;

/**
 * Created by sulfur on 13.03.16.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ActorServletLocal", urlPatterns = {"/actorServletLocal"})
public class ActorServletLocal extends HttpServlet{

    public static final Logger log = LoggerFactory.getLogger(ActorServletLocal.class);

    @EJB(lookup = "java:global/ear-ejb/war-ejb-1.0-SNAPSHOT/ActorEJB!com.codewars.ActorEJBLocal")
    private ActorEJBLocal actorEJBLocal;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        log.trace("Servlet ActorServlet doGet begin");
        log.debug("ActorEJBLocal class: {}", actorEJBLocal == null ? "EJB not initialized" : actorEJBLocal.getClass().getCanonicalName());

        List<Actor> actors = actorEJBLocal.getActors();

        log.debug("Actors returned by EJB: {}", actors);

        request.setAttribute("actorClass", actors.get(0).getClass().getCanonicalName());
        request.setAttribute("beanClass", actorEJBLocal.getClass().getCanonicalName());
        request.setAttribute("interface", "local");
        request.setAttribute("actors", actors);

        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        log.trace("Servlet ActorServlet doGet end");

    }
}
