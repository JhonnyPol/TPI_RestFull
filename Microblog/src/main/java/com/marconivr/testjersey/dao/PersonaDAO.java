/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marconivr.testjersey.dao;

/**
 *
 * @author Jonathan Pollinari
 */
import com.marconivr.testjersey.domain.Persona;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PersonaDAO {
        private static final List<Persona> persone = new ArrayList<Persona>();
    
	public PersonaDAO() {
            if (persone.size() == 0) {
                this.addPersone();
              
            }
	}
        
        private List<Persona> addPersone () {
            	Persona persona = new Persona(1, "Mauro", "Rossi", 40, "02/456327819", "mrossi@email.it");
		persone.add(persona);
		
		persona = new Persona(2, "Luca", "Bianchi", 45, "02/918273645", "lbianchi@email.it");
		persone.add(persona);
		
		persona = new Persona(3, "Franco", "Neri", 32, "02/987123546", "fneri@email.it");
		persone.add(persona); 
		
		persona = new Persona(4, "Paolo", "Verdi", 35, "02/129834765", "pverdi@email.it");
		persone.add(persona); 	
                return persone;
        }
        
        public Persona getPersona(int id) {
            return persone.get(id - 1); 
        }
        
        public List<Persona> getPersone () {
              return persone;
        }
        
        public void insertPersona (Persona p) {
            persone.add(p);
        }
        
    
}