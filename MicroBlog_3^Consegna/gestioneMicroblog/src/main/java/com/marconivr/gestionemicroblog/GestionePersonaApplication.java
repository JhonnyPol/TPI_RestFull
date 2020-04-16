package com.marconivr.gestionemicroblog;

import com.marconivr.gestionemicroblog.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.marconivr.gestionemicroblog.dao.PersonaDao;

@SpringBootApplication
public class GestionePersonaApplication implements CommandLineRunner{
    @Autowired 
    PersonaDao personaDao;
    
    public static void main(String[] args) {
	SpringApplication.run(GestionePersonaApplication.class, args);
    }
       
    @Override
    public void run(String... strings) throws Exception {
        //tutto ciò che verrà inserito qui sarà eseguito prima dell'avvio dell'applicazione Spring Boot

        personaDao.save(new Persona(1, "RossiMario", "123456", "marioreds@gmail.com"));
        personaDao.save(new Persona(2, "LuigiNeri", "0000", "luigineri@gmail.com"));
        personaDao.save(new Persona(3, "FrancoBianchi", "password", "franco.bianchi@gmail.com"));
        personaDao.save(new Persona(4, "AldoNeri", "qwerty", "nerialdo@gmail.com"));
        personaDao.save(new Persona(5, "AndreaVerdi", "ciao", "andreaverdi@gmail.com"));

    }

}
