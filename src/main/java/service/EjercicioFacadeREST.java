/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Curso;
import entity.Ejercicio;
import entity.Respuesta;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
@Path("ejercicio")
public class EjercicioFacadeREST extends AbstractFacade<Ejercicio> {

    @PersistenceContext(unitName = "prueba")
    private EntityManager em;
    
    @EJB
    private ProfesorFacadeREST profesorFacadeREST;
    @EJB
    private ActividadFacadeREST actividadFacadeREST;
    public EjercicioFacadeREST() {
        super(Ejercicio.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Ejercicio entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Ejercicio entity) {
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
    public Ejercicio find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Ejercicio> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Ejercicio> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }
    @GET
    @Path("respuestas/{id}")
    @Produces( MediaType.APPLICATION_JSON)
    public List<Respuesta> enviarRespuestas(@PathParam("id") Integer id) {
        Query q=em.createNamedQuery("Ejercicio.findById",Respuesta.class);
        q.setParameter("id",id);
        Ejercicio ej=(Ejercicio)q.getSingleResult();
        return ej.getRespuestaList();
    }
    @POST
    @Path("create")
    @Consumes({MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON})
    @Transactional
    @Produces({MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON})
    public Integer create2(Ejercicio entity) {
        super.create(entity);
        em.flush();
        System.out.println("ID:  "+ entity.getId());
        return entity.getId();
    }
    @GET
    @Path("profesor/{username}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Ejercicio> profesor(@PathParam("username") String username) {
        Query q=em.createNamedQuery("Ejercicio.findByUsername",Ejercicio.class);
        q.setParameter("username",username);
        return q.getResultList();
    }
    @GET
    @Path("asoProActEj/{idEjercicio}/{username}/{idActividad}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void asoProActEj(@PathParam("idEjercicio") Integer idEjercicio,@PathParam("username") String username,@PathParam("idActividad") Integer idActividad) {
        find(idEjercicio).setProfesorUsername(profesorFacadeREST.find(username));
        find(idEjercicio).setActividadId(actividadFacadeREST.find(idActividad));
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
