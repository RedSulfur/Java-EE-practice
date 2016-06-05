package com.codewars.ejb;

import com.codewars.ejb.staff.Actor;
import com.codewars.ejb.staff.BusinessException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by sulfur on 14.03.16.
 */
@WebServlet(name = "Servlet", urlPatterns = {"/servlet"})
public class Servlet extends HttpServlet{

    @EJB
    private BeanManagedTransactionsEJB ejb;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        if (name == null) name = "Default name";

        final String transaction = request.getParameter("rollback");

        response.getWriter().write("=================================== Current state:\n\n");
        printAllActors(response);

        if ("yes".equals(transaction)) {
            response.getWriter().write("=================================== updateActorWithTransactionRollback:\n\n");
            try {
                ejb.updateActorsWithTransactionRollback(new Actor(13L,name));

            } catch (BusinessException ex) {
                response.getWriter().write("Error updateActorWithTransactionRollback: " + ex.getMessage() + "\n\n");
            }
            printAllActors(response);
        } else if (transaction.equals("no")) {
            response.getWriter().write("=================================== updateActorWithNoTransactionRollback:\n\n");
            try {
                ejb.updateActorsWithNoTransactionRollback(new Actor(13L,name));
            } catch (BusinessException ex) {
                response.getWriter().write("Error updateActorWithTransactionRollback: " + ex.getMessage() + "\n\n");
            }
            printAllActors(response);
        }

    }

    private void printAllActors(HttpServletResponse response) throws IOException {

        try {
            List<Actor> allActors = ejb.getAllActors();
            for(Actor actor : allActors){
                response.getWriter().write(actor + "\n\n");
            }
        } catch (BusinessException ex) {
            response.getWriter().write("Error updateActorWithTransactionRollback: " + ex.getMessage() + "\n\n");
        }

    }
}
