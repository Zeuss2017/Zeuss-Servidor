/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Profesor;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author jpavlich
 */
@Path("auth")
public class AuthService {

    @Context
    private UriInfo context;

    @Context
    HttpServletRequest req;

    @Inject
    ProfesorFacadeREST userStore;

    @POST
    @Path("login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Profesor login(Profesor loginCredentials) {
        Profesor user = userStore.findByUsername(loginCredentials.getUsername());
        if (loginCredentials.getContrasena().equals(user.getContrasena())) {
            HttpSession session = req.getSession();
            session.setAttribute("USER", user);
            user.setCursoList(null);
            user.setEjercicioList(null);
            return user;
        } else {
            logout();
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @GET
    @Path("logout")
    @Produces(MediaType.TEXT_PLAIN)
    public String logout() {
        HttpSession session = req.getSession();
        session.removeAttribute("USER");
        return "Logged out";
    }
    
    @GET
    @Path("logged-username")
    @Produces(MediaType.TEXT_PLAIN)
    public String loggedUsername() {
        HttpSession session = req.getSession();
        final Profesor user = (Profesor) session.getAttribute("USER");
        return user.getUsername();
    }
}
