package com.codewars;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sulfur on 19.03.16.
 */
@WebServlet(name = "Source", urlPatterns = {"/sourceServlet"})
public class SourceServlet extends HttpServlet{


    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        if(request.getParameter("redirect") != null) {
            response.sendRedirect("targetServlet");
        } else {
            getServletContext().getRequestDispatcher("/targetServlet").forward(request,response);
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
