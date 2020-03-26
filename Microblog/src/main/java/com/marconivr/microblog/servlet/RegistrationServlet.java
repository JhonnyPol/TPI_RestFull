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

public class RegistrationServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        request.getRequestDispatcher("link.html").include(request, response);

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String mail = request.getParameter("mail");

        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/microblog?user=root&password=");
            Statement stmt = null;
            ResultSet rs = null;
            stmt = conn.createStatement();

            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO users (Username, Password, Mail ) VALUES (?,?,?)");
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, mail);
            pstmt.executeUpdate();

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(RegistrationServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
