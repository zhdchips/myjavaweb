package com.bjpowernode.javaweb.servlet;

import jakarta.servlet.*;

import java.io.IOException;


public abstract class GenericServlet implements Servlet {

    private ServletConfig config;

    @Override
    public final void init(ServletConfig servletConfig) throws ServletException {
        this.config = servletConfig;

        init();
    }

    public void init() {
        System.out.println("init() execute");
    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    @Override
    public abstract void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException;

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
