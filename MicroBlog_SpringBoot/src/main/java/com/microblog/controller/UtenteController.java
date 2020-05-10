package com.microblog.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import com.microblog.dao.UtenteDao;
import com.microblog.entities.Utente;
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
@RequestMapping("/amministratori")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class UtenteController {
    @Autowired
    UtenteDao utenteDao;

    @GetMapping()
    public List<Utente> getAllUtenti() {
        return (List<Utente>) utenteDao.findAll();
    }

    @GetMapping("/{id}")
    public Utente getUtenteById(@PathVariable Long id) {
        return utenteDao.findById(id).get();
    }

    @PostMapping
    public void post(@RequestBody Utente u) {
        utenteDao.save(u);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        utenteDao.deleteById(id);
    }

    @GetMapping(params = {"username", "password"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public Utente findUtenteByUsernamePassword(HttpServletRequest request, @RequestParam("username") String username, @RequestParam("password") String password) {
        return utenteDao.findByUsernameAndPassword(username, password).get();
    }
    
}