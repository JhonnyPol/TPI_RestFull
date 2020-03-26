package com.marconivr.microblog.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RecuperaPost extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String result = null;

            Connection conn;
            try {
                Class.forName("com.mysql.jdbc.Driver"); 
                conn = DriverManager.getConnection(
                        "jdbc:mysql://127.0.0.1/microblog?user=root&password=");
                Statement stmt = null;
                ResultSet rs = null;
                stmt = conn.createStatement();
                rs = stmt.executeQuery("SELECT * FROM posts");
                result = "<table border=1>";
                while (rs.next()) {
                    result += ("<tr> <td>" + rs.getString("Titolo") + "</td><td>"
                            + rs.getString("Testo") + "</td><td>"
                            + rs.getObject("DataOra") + "</td></tr>");
                }
                result += "</table>";
                stmt.close();
            }  catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(CreatePostServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
          
            out.println(result);
            
        }
    }

}