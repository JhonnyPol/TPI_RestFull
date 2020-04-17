/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marconivr.gestionemicroblog.service.serviceImpl;

import com.marconivr.gestionemicroblog.domain.Post;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.marconivr.gestionemicroblog.dao.PostDao;
import com.marconivr.gestionemicroblog.service.PostService;

/**
 *
 * @author Jonathan Pollinari
 */
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostDao postDao;

    @Override
    public Optional<Post> getPostById(int id) {
        return postDao.findById(id);
    }

    @Override
    public List<Post> getPosts() {
        return postDao.findAll();
    }

    @Override
    public Post savePost(Post p) {
        return postDao.save(p);
    }

    @Override
    public void deletePostById(int idPost) {
       postDao.deleteById(idPost);
    }
    
    

}