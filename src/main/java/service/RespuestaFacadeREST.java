/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Curso;
import entity.Respuesta;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Maria Jose Mendoza Rincon
 */
@Stateless
@Path("respuesta")
public class RespuestaFacadeREST extends AbstractFacade<Respuesta> {

    @PersistenceContext(unitName = "prueba")
    private EntityManager em;
    @EJB
    private EjercicioFacadeREST ejercicioFacadeREST;
    public RespuestaFacadeREST() {
        super(Respuesta.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Respuesta entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Respuesta entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Respuesta find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Respuesta> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Respuesta> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }
    
    @POST
    @Path("create2/{id}")
    @Consumes({MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON})
    @Transactional
    @Produces({MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON})
    public Integer create2(Respuesta entity,@PathParam("id") Integer id) {
       
        
        super.create(entity);
        em.flush();
        entity.setEjercicioId(ejercicioFacadeREST.find(id));
        System.out.println("Id resp + id ejercicio " + entity.getId()+'+'+entity.getEjercicioId().getId());
        return entity.getId();
    }
    

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
