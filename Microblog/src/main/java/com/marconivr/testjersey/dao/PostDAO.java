/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marconivr.testjersey.dao;

import com.marconivr.testjersey.domain.Post;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jonathan Pollinari
 */
public class PostDAO {

    static Connection conn;
    static Statement stmt = null;
    static ResultSet rs = null;
    static PreparedStatement pstmt = null;

    public List<Post> getPosts() {
        List<Post> posts = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1/microblog?user=root&password=");
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM posts");
            while (rs.next()) {
                Post post = new Post();
                post.setId(rs.getInt("ID"));
                post.setTitolo(rs.getString("Titolo"));
                post.setTesto(rs.getString("Testo"));
                post.setDataOra(rs.getTimestamp("DataOra"));
                posts.add(post);
            }
            stmt.close();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PostDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return posts;
    }
    
    public Post getPost(int ID) {
        Post post = new Post();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1/microblog?user=root&password=");
            pstmt = conn.prepareStatement("SELECT * FROM posts WHERE ID = ?");
            pstmt.setInt(1, ID);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                post.setId(rs.getInt("ID"));
                post.setTitolo(rs.getString("Titolo"));
                post.setTesto(rs.getString("Testo"));
                post.setDataOra(rs.getTimestamp("DataOra"));
            }
            stmt.close();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PostDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return post;
    }
    
    public void insertPost(Post post) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1/microblog?user=root&password=");
            pstmt = conn.prepareStatement("INSERT INTO posts (Titolo, Testo, DataOra) VALUES (?,?, now())");
            pstmt.setString(1, post.getTitolo());
            pstmt.setString(2, post.getTesto());
            pstmt.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PostDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
