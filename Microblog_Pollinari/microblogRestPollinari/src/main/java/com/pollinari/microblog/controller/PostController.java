package com.pollinari.microblog.controller;

import com.pollinari.microblog.dao.PostDao;
import com.pollinari.microblog.entities.Post;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jpoll
 */

@RestController
@RequestMapping("/posts")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class PostController {
    @Autowired
    PostDao postDao;

    @GetMapping()
    public List<Post> getAllPosts() {
        return (List<Post>) postDao.findAll();
    }

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable Long id) {
        return postDao.findById(id).get();
    }

    @PostMapping
    public void post(@RequestBody Post p) {
        postDao.save(p);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        postDao.deleteById(id);
    }

    /*@GetMapping(params = {"username", "password"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public Post findPost(HttpServletRequest request, @RequestParam("id") String id, @RequestParam("utente") UtenteDao utente) {
        return postDao.findPost(id, utente).get();
    }*/
    
    
}
