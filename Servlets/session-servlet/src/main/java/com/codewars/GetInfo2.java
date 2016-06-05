package com.codewars;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sulfur on 20.03.16.
 */
@WebServlet(name = "GetInfo2", urlPatterns = {"/GetInfo2"})
public class GetInfo2 extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    /*
        Значение сессии уникально для каждого сеанса, а значение,
        которое лежит в ServletContext - общее для всех
    */

        String contextParam = (String) getServletContext().getAttribute(GetInfo1.parameterContext);
        String sessionParam = (String) request.getSession(true).getAttribute(GetInfo1.parameterSession);

        request.setAttribute("contextParam",contextParam);
        request.setAttribute("sessionParam",sessionParam);

        response.sendRedirect("result.jsp");
//        getServletContext().getRequestDispatcher("/result.jsp").forward(request,response);
    }
}
