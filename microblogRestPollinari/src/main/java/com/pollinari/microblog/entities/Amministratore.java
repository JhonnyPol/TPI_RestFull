/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pollinari.microblog.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
/**
 *
 * @author jpoll
 */
@Table (name = "amministratori")
@Entity
@Data
public class Amministratore {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column
    private String cognome;
    
    @Column
    private String nome;
    
    @Column
    private String username;
    
    @Column
    private String password;

}
