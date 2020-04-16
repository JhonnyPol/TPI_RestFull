/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marconivr.gestionemicroblog.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
/**
 *
 * @author Jonathan Pollinari
 */
@Table (name = "persone")
@Entity
@AllArgsConstructor @NoArgsConstructor
public class Persona {
    @Id
    @Column(name = "idPersona")
    @Getter @Setter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Column
    @Getter @Setter
    private String username;
    
    @Column
    @Getter @Setter
    private String password;
    
    @Column
    @Getter @Setter
    private String mail;
}
