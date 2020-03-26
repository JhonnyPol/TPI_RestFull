/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marconivr.testjersey.domain;

/**
 *
 * @author Jonathan Pollinari
 */
import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.codehaus.jackson.annotate.JsonIgnore;

@XmlRootElement
@XmlType(propOrder = { "id", "nome", "cognome", "eta", "telefono", "email"  })
public class Persona {

      
	private int id;
	
	private String nome;

	private String cognome;
	
	private int eta;
	
	private String telefono;	
	
	private String email;
	
	public Persona() {}
	
	public Persona(Integer Id, String Nome, String Cognome, Integer Eta, String Telefono, String Email) {
		this.id = Id;
		this.nome = Nome;
		this.cognome = Cognome;
		this.eta = Eta;
		this.telefono = Telefono;		
		this.email = Email;	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
        
         @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.id);
        hash = 71 * hash + Objects.hashCode(this.nome);
        hash = 71 * hash + Objects.hashCode(this.cognome);
        return hash;
    }

    
    
    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", nome=" + nome + 
                ", cognome=" + cognome + '}';
    }
}