/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marconivr.testjersey.webservice;

/**
 *
 * @author Jonathan Pollinari
 */
import com.marconivr.testjersey.dao.PersonaDAO;
import com.marconivr.testjersey.domain.Persona;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Questo WebService mi permette di gestire una ipotetica anagrafica di persone
 */

@Path("/persone")
public class PersDataService {
        
        PersonaDAO personaDAO = new PersonaDAO();
        
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<Persona> getPersone() {
		List<Persona> persone = new ArrayList<Persona>();
		persone.addAll(personaDAO.getPersone());
		return persone; 
	}
        
        @GET
        @Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Persona getPersona(@PathParam("id") String personaID) {
                Persona p = personaDAO.getPersona(Integer.parseInt(personaID));
		return p; 
	}

	/*
	 * Restituisce l'eta media
	*/
	@GET
	@Path("etamedia")
	@Produces(MediaType.TEXT_PLAIN)
	public String getEta() {
		List<Persona> persone = new ArrayList<Persona>();
		persone.addAll(personaDAO.getPersone());
		int toteta = 0;
		for (Persona pers : persone) {
			toteta += pers.getEta();
		}
		int etamedia = toteta / persone.size();
		return Integer.toString(etamedia);
	}
	
	/*
	 * Questo metodo consente il salvataggio di nuovi record
	 * a fronte di una chiamata POST 
	 */
	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_JSON)
	public void newUser(Persona p)
                               
	 throws IOException {
		Persona persona = new Persona(new Integer(p.getId()),p.getNome(),p.getCognome(), p.getEta(),p.getTelefono(),p.getEmail());
		personaDAO.insertPersona(persona);
		// Qui si può eseguire il caricamento su database...
		
	}
		


}
