package com.codewars;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by sulfur on 20.03.16.
 */

@WebServlet(name = "GetInfo1", urlPatterns = {"/GetInfo1"})
public class GetInfo1 extends HttpServlet{

    public static final String parameterSession = "parameterSession";
    public static final String parameterContext = "parameterContext";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String param = request.getParameter("parameter");
        HttpSession session = request.getSession(true);
        session.setAttribute(parameterSession,param);

        getServletContext().setAttribute(parameterContext,param);

        getServletContext().getRequestDispatcher("/GetInfo2").forward(request,response);
    }
}
