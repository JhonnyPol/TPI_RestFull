/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marconivr.testjersey.webservice;

/**
 *
 * @author Jonathan Pollinari
 */
import com.marconivr.testjersey.dao.PersonaDAO;
import com.marconivr.testjersey.dao.PostDAO;
import com.marconivr.testjersey.domain.Persona;
import com.marconivr.testjersey.domain.Post;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Questo WebService mi permette di gestire una ipotetica anagrafica di persone
 */
@Path("/posts")
public class PostDataService {

    PostDAO postDAO = new PostDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Post> getPosts() {
        List<Post> posts = new ArrayList<Post>();
        posts.addAll(postDAO.getPosts());
        return posts;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Post getPost(@PathParam("id") String postID) {
        Post p = postDAO.getPost(Integer.parseInt(postID));
        return p;
    }

    /*
	 * Questo metodo consente il salvataggio di nuovi record
	 * a fronte di una chiamata POST 
     */
    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_JSON)
    public void newUser(Post p) throws IOException {
        postDAO.insertPost(p);

    }

}
