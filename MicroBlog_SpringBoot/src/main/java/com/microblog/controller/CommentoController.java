package com.microblog.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import com.microblog.dao.CommentoDao;
import com.microblog.dao.PostDao;
import com.microblog.dao.UtenteDao;
import com.microblog.entities.Commento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jpoll
 */
@RestController
@RequestMapping("/commenti")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class CommentoController {
    @Autowired
    CommentoDao commentoDao;

    @GetMapping()
    public List<Commento> getAllCommenti() {
        return (List<Commento>) commentoDao.findAll();
    }

    @GetMapping("/{id}")
    public Commento getCommentoById(@PathVariable Long id) {
        return commentoDao.findById(id).get();
    }

    @PostMapping
    public void post(@RequestBody Commento c) {
        commentoDao.save(c);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        commentoDao.deleteById(id);
    }

    /*@GetMapping(params = {"username", "password"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public Commento findCommento(HttpServletRequest request, @RequestParam("utente") UtenteDao utente, @RequestParam("post") PostDao post) {
        return commentoDao.findCommento(utente, post).get();
    }*/
    
}
