/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marconivr.gestionemicroblog.service;

import com.marconivr.gestionemicroblog.domain.Persona;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Jonathan Pollinari
 */
public interface PersonaService {
    Optional<Persona> getPersonaById(int id);
    List<Persona> getPersone();
    Persona savePersona (Persona p);
    void deletePersonaById (int idPersona);
}
