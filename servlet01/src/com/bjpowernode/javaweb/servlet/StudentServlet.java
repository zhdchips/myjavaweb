package com.bjpowernode.javaweb.servlet;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Enumeration;

import jakarta.servlet.GenericServlet;

public class StudentServlet extends GenericServlet {
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            ServletConfig config = getServletConfig();
            String servletName = config.getServletName();
            writer.print(servletName + "<br>");

            String url = getInitParameter("url");
            String user = getInitParameter("user");
            String password = getInitParameter("password");

            conn = DriverManager.getConnection(url, user, password);
            Enumeration<String> initParameterNames = this.getInitParameterNames();
            while (initParameterNames.hasMoreElements()) {
                String name = initParameterNames.nextElement();
                writer.print(name + "<br>");
            }

            String sql = "select no, name from t_student;";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                String no = rs.getString("no");
                String name = rs.getString("name");
                writer.print(no + "\t" + name + "<br>");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
