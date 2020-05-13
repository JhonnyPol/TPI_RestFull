package com.pollinari.microblog.dao;

import com.pollinari.microblog.entities.Amministratore;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author jpoll
 */
public interface AmministratoreDao extends CrudRepository<Amministratore, Long> {
    Optional<Amministratore> findByUsernameAndPassword(String username, String password);
    
}
