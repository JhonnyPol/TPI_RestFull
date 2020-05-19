package com.pollinari.microblog.dao;

import com.pollinari.microblog.entities.Post;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author jpoll
 */
public interface PostDao extends CrudRepository<Post, Long> {

}
