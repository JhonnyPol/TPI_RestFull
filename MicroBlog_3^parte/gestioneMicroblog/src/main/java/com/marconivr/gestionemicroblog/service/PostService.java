/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marconivr.gestionemicroblog.service;

import com.marconivr.gestionemicroblog.domain.Post;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Jonathan Pollinari
 */
public interface PostService {
    Optional<Post> getPostById(int id);
    List<Post> getPosts();
    Post savePost(Post p);
    void deletePostById (int idPost);
}
