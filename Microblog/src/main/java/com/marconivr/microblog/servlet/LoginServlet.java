package com.marconivr.microblog.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String password = request.getParameter("password");
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/microblog?user=root&password=");
            Statement stmt = null;
            ResultSet rs = null;
            stmt = conn.createStatement();

            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM users u WHERE u.username LIKE ? "
                    + "AND u.password LIKE ?");
            pstmt.setString(1, name);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                out.println("User logged!");
                out.println("<br>");
                request.getRequestDispatcher("link.html").include(request, response);
            } else {
                out.println("Incorrect Login!");
            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(RegistrationServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
