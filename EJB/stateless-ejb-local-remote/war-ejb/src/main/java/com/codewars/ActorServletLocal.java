package com.codewars;

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

/**
 * Created by sulfur on 12.03.16.
 */

    @WebServlet(name = "ActorServletLocal", urlPatterns = {"/actorServletLocal"})
    public class ActorServletLocal extends HttpServlet {

        private static final Logger log = LoggerFactory.getLogger(ActorServletLocal.class);

        @EJB
        private ActorEJBLocal actorEJBLocal;

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            log.trace("Servlet ActorServlet doGet begin");
            log.debug("ActorEJBLocal class: {}", actorEJBLocal == null ? "EJB not initialized" : actorEJBLocal.getClass().getCanonicalName());

            List<Actor> actors = actorEJBLocal.getActors();

            log.debug("Actors returned by EJB: {}", actors);

            request.setAttribute("actorClass", actors.get(0).getClass().getCanonicalName());
            request.setAttribute("beanClass", actorEJBLocal.getClass().getCanonicalName());
            request.setAttribute("actors", actors);

            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            log.trace("Servlet ActorServlet doGet end");
        }

        public ActorEJBLocal getActorEJBLocal() {
            return actorEJBLocal;
        }

        public void setActorEJBLocal(ActorEJBLocal actorEJBLocal) {
            this.actorEJBLocal = actorEJBLocal;
        }
    }

