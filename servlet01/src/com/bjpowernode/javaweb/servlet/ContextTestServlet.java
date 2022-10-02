package com.bjpowernode.javaweb.servlet;

import jakarta.servlet.*;
import jakarta.servlet.GenericServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ContextTestServlet extends GenericServlet {
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        ServletContext servletContext = this.getServletContext();
        String id = servletContext.getInitParameter("id");
        String name = servletContext.getInitParameter("name");

        writer.print(id + "\t" + name + "<br>");

        String realPath = servletContext.getRealPath("index.html");
        writer.print("realPath: " + realPath + "<br>");

        servletContext.log("我打印的日志信息");


        servletContext.setAttribute(id, name);
        Object attribute = servletContext.getAttribute(id);
        writer.print("通过 context 得到的 name: " + attribute + "<br>");

    }
}
