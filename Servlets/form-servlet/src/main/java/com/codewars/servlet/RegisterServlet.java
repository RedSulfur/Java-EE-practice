package com.codewars.servlet;

import com.codewars.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by sulfur on 19.03.16.
 */

@WebServlet(name = "Register", urlPatterns = {"/registerServlet"})
public class RegisterServlet extends HttpServlet{


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<String>enumList = new LinkedList<>();
        List<String>commList = new LinkedList<>();

        for(Enumeration e = request.getParameterNames(); e.hasMoreElements();) {
            String name = (String) e.nextElement();
            String value = request.getParameter(name);
            enumList.add(value);
        }
        request.setAttribute("enumAttr",enumList);

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String age = request.getParameter("age");

        commList.add(login);
        commList.add(password);
        commList.add(email);
        commList.add(age);
        request.setAttribute("commonAttr", commList);

        User user = new User(login,password,email,age);

        request.setAttribute("user",user);

        getServletContext().getRequestDispatcher("/sample.jsp").forward(request,response);
    }
}
