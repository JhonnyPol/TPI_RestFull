package com.marconivr.gestionemicroblog;

import com.marconivr.gestionemicroblog.domain.Persona;
import com.marconivr.gestionemicroblog.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.marconivr.gestionemicroblog.dao.PersonaDao;
import com.marconivr.gestionemicroblog.dao.PostDao;


@SpringBootApplication
public class GestioneMicroBlogApplication implements CommandLineRunner {

    @Autowired
    PersonaDao personaDao;

    @Autowired
    PostDao postDao;

    public static void main(String[] args) {
        SpringApplication.run(GestioneMicroBlogApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        //tutto ciò che verrà inserito qui sarà eseguito prima dell'avvio dell'applicazione Spring Boot

        personaDao.save(new Persona(1, "RossiMario", "123456", "marioreds@gmail.com"));
        personaDao.save(new Persona(2, "LuigiNeri", "0000", "luigineri@gmail.com"));
        personaDao.save(new Persona(3, "FrancoBianchi", "password", "franco.bianchi@gmail.com"));
        personaDao.save(new Persona(4, "AldoNeri", "qwerty", "nerialdo@gmail.com"));
        personaDao.save(new Persona(5, "AndreaVerdi", "ciao", "andreaverdi@gmail.com"));

        postDao.save(new Post(1, "Titolo", "testo...", "2020-05-17 09:47:22"));
        postDao.save(new Post(2, "Titolo", "testo...", "2020-05-17 09:47:22"));
        postDao.save(new Post(3, "Titolo", "testo...", "2020-05-17 09:47:22"));

    }

}
