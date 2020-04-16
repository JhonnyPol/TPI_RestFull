/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marconivr.gestionemicroblog.controller;


import com.marconivr.gestionemicroblog.domain.Persona;
import java.net.URI;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import com.marconivr.gestionemicroblog.service.PersonaService;

/**
 *
 * @author Jonathan Pollinari
 */
@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    PersonaService personaService;

    @RequestMapping("/hello")
    public String sayHello() {
        return "Hello everyone!";
    }
    
    @RequestMapping(value = "/persone", method = GET)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<JsonResponseBody> getPersone(){
        return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(),personaService.getPersone()));
    }
    
    @RequestMapping(value = "/persone/{id}", method = GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JsonResponseBody> getPersona(@PathVariable(value="id") int id ){
        Optional<Persona> personaOp = personaService.getPersonaById(id);
        if (personaOp.isPresent()) {
          return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(),personaService.getPersonaById(id)));
        }
        else 
          return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new JsonResponseBody(HttpStatus.NOT_FOUND.value(),null));
    }
    
    @RequestMapping(value = "/persone", method = POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<JsonResponseBody> addPersona(HttpServletRequest request, @RequestBody Persona persona){
        Persona p = personaService.savePersona(persona);
        //da migliorare l'implementazione di HATEOS utilizzando il supporto in Spring; Da implementare la validazione dell'oggetto studente in input
      return ResponseEntity.status(HttpStatus.CREATED).header("location",request.getRequestURL().toString() + "/"+ p.getId()).body(new JsonResponseBody(HttpStatus.CREATED.value(),null));
    }
    
    @RequestMapping(value = "/persone/{id}", method = DELETE)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<JsonResponseBody> deletePersona(@PathVariable(value="id") int id){
        Optional<Persona> personaOp = personaService.getPersonaById(id);
        if (personaOp.isPresent()) {
            personaService.deletePersonaById(id);  //se presente, cancello
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new JsonResponseBody(HttpStatus.NO_CONTENT.value(), null));
        }     
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new JsonResponseBody(HttpStatus.NOT_FOUND.value(),"Utente non presente."));      
    }
    
    //----------Definizione JsonResponseBody----------
    @AllArgsConstructor 
    class JsonResponseBody{
        @Getter @Setter
        private int server;
        @Getter @Setter
        private Object response;
    }
    //------------------------------------------------
}
