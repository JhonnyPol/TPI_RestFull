package com.microblog.dao;

import com.microblog.entities.Commento;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author jpoll
 */
public interface CommentoDao extends CrudRepository<Commento, Long> {

    /*@Query(value = "SELECT * FROM commenti c WHERE c.utente_id = ?1 AND c.post_id = ?1 ", nativeQuery = true)
    List<Commento> findCommentoByUtentePost(Long idUtente, Long idPost);*/

}
