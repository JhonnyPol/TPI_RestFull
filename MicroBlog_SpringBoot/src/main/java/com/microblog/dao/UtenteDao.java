package com.microblog.dao;

import java.util.Optional;
import com.microblog.entities.Utente;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author jpoll
 */
public interface UtenteDao extends CrudRepository<Utente, Long> {
    Optional<Utente> findByUsernameAndPassword(String username, String password);
    
}