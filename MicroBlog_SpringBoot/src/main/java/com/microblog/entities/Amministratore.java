package com.microblog.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author jpoll
 */

@Entity
@Data
@Table(name = "amministratori")
public class Amministratore implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    private String cognome;

    @Basic
    private String nome;

    @Basic
    private String username;

    @Basic
    private String password;

}