/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marconivr.testjersey.domain;

import java.sql.Timestamp;
import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Jonathan Pollinari
 */

@XmlRootElement
@XmlType(propOrder = { "Id", "Titolo", "Testo", "DataOra" })
public class Post {
    
    private int Id;
    private String Titolo;
    private String Testo;
    private Timestamp DataOra;

    public Post() {
    }

    public Post(int Id, String Titolo, String Testo, Timestamp DataOra) {
        this.Id = Id;
        this.Titolo = Titolo;
        this.Testo = Testo;
        this.DataOra = DataOra;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getTitolo() {
        return Titolo;
    }

    public void setTitolo(String Titolo) {
        this.Titolo = Titolo;
    }

    public String getTesto() {
        return Testo;
    }

    public void setTesto(String Testo) {
        this.Testo = Testo;
    }

    public Timestamp getDataOra() {
        return DataOra;
    }

    public void setDataOra(Timestamp DataOra) {
        this.DataOra = DataOra;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.Id;
        hash = 31 * hash + Objects.hashCode(this.Titolo);
        hash = 31 * hash + Objects.hashCode(this.Testo);
        hash = 31 * hash + Objects.hashCode(this.DataOra);
        return hash;
    }

    @Override
    public String toString() {
        return "Post{" + "Id=" + Id + ", Titolo=" + Titolo + ", Testo=" + Testo + ", DataOra=" + DataOra + '}';
    }  
    
}
