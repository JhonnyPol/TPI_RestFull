package com.microblog.dao;

import java.util.Optional;
import com.microblog.entities.Amministratore;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author jpoll
 */
public interface AmministratoreDao extends CrudRepository<Amministratore, Long> {
    Optional<Amministratore> findByUsernameAndPassword(String username, String password);
    
}
