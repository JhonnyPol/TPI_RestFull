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
@Table(name = "posts")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @Id
    @Column(name = "idPost")
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    @Getter
    @Setter
    private String titolo;

    @Column
    @Getter
    @Setter
    private String testo;

    @Column
    @Getter
    @Setter
    private String DataOra;
}
