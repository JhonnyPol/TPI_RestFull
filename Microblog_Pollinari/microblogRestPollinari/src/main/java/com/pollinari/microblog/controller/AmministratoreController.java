package com.pollinari.microblog.controller;

import com.pollinari.microblog.dao.AmministratoreDao;
import com.pollinari.microblog.entities.Amministratore;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
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
public class AmministratoreController {
    @Autowired
    AmministratoreDao amministratoreDao;

    @GetMapping()
    public List<Amministratore> getAllAmministratori() {
        return (List<Amministratore>) amministratoreDao.findAll();
    }

    @GetMapping("/{id}")
    public Amministratore getAmministratoreById(@PathVariable Long id) {
        return amministratoreDao.findById(id).get();
    }

    @PostMapping
    public void post(@RequestBody Amministratore a) {
        amministratoreDao.save(a);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        amministratoreDao.deleteById(id);
    }

    @GetMapping(params = {"username", "password"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public Amministratore findDipendenteByUsernamePassword(HttpServletRequest request, @RequestParam("username") String username, @RequestParam("password") String password) {
        return amministratoreDao.findByUsernameAndPassword(username, password).get();
    }
}
