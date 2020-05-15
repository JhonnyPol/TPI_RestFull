package com.pollinari.microblog.dao;

import com.pollinari.microblog.entities.Utente;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author jpoll
 */
public interface UtenteDao extends CrudRepository<Utente, Long> {
    Optional<Utente> findByUsernameAndPassword(String username, String password);
    
}