/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marconivr.gestionemicroblog.dao;

import com.marconivr.gestionemicroblog.domain.Persona;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Jonathan Pollinari
 */
public interface PersonaDao extends JpaRepository<Persona, Integer>{
    Optional<Persona> findById(int id);
    List<Persona> findAll();
}
