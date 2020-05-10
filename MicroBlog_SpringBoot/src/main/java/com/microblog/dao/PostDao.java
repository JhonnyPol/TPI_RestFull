package com.microblog.dao;

import com.microblog.entities.Post;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author jpoll
 */
public interface PostDao extends CrudRepository<Post, Long> {

}
