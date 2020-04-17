/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marconivr.gestionemicroblog.service.serviceImpl;

import com.marconivr.gestionemicroblog.domain.Persona;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.marconivr.gestionemicroblog.dao.PersonaDao;
import com.marconivr.gestionemicroblog.service.PersonaService;

/**
 *
 * @author Jonathan Pollinari
 */
@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    PersonaDao personaDao;

    @Override
    public Optional<Persona> getPersonaById(int id) {
        return personaDao.findById(id);
    }

    @Override
    public List<Persona> getPersone() {
        return personaDao.findAll();
    }

    @Override
    public Persona savePersona(Persona p) {
        return personaDao.save(p);
    }

    @Override
    public void deletePersonaById(int idPersona) {
       personaDao.deleteById(idPersona);
    }
    
    

}
