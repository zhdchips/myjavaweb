package com.bjpowernode.javaweb.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

public class RequestTestServlet extends HttpTestServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        for (String s : parameterMap.keySet()) {
            System.out.println(s + ": " + request.getParameter(s));
        }
        System.out.println("===============");

        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String str = parameterNames.nextElement();
            System.out.println(str);
        }
        System.out.println("===============");
        String usernames = request.getParameter("username");
        String userpwds = request.getParameter("userpwd");
        System.out.println(usernames);
        System.out.println(userpwds);
        String[] interests = request.getParameterValues("interest");
        for (String interest : interests) {
            System.out.println(interest);
        }
    }
}
