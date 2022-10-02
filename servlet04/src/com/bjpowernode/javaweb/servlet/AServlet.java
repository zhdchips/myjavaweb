package com.bjpowernode.javaweb.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String realname = request.getParameter("realname");
        System.out.println("请求中的参数：" + realname);

        request.setAttribute("name", "kk");
        Object name = request.getAttribute("name");
        System.out.println("A getAttribute: " + name);
        System.out.println("==================");
        request.getRequestDispatcher("/b").forward(request, response);

        System.out.println("==================");

        String remoteAddr = request.getRemoteAddr();
        System.out.println("客户端ip地址：" + remoteAddr);

        String contextPath = request.getContextPath();
        System.out.println("应用根目录：" + contextPath);

        String method = request.getMethod();
        System.out.println("请求方式：" + method);

        String requestURI = request.getRequestURI();
        System.out.println("uri：" + requestURI );

        String servletPath = request.getServletPath();
        System.out.println("servletPath：" + servletPath);
    }
}
