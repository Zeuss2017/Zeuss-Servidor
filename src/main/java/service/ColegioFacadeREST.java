/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Ciudad;
import entity.Colegio;
import entity.Curso;
import entity.Profesor;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
@Path("colegio")
public class ColegioFacadeREST extends AbstractFacade<Colegio> {

    @PersistenceContext(unitName = "prueba")
    private EntityManager em;

    public ColegioFacadeREST() {
        super(Colegio.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Colegio entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Colegio entity) {
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
    public Colegio find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public List<Colegio> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Colegio> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @GET
    @Path("/ciudades")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Ciudad> ciudades() {
        List<String> aux= em.createNamedQuery("Colegio.findCities", String.class).getResultList();
        List<Ciudad> ciudades=new ArrayList<>();
        for (String s : aux) {
            Ciudad c = new Ciudad();
            c.setNombre(s);
            ciudades.add(c);
        }
        return ciudades;
    }

    @GET
    @Path("/ciudades/{ciudad}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public List<Colegio> colegiosDeCiudad(@PathParam("ciudad") String ciudad) {
        Query q = em.createNamedQuery("Colegio.findByCiudad", Colegio.class);
        q.setParameter("ciudad", ciudad);

        return q.getResultList();
    }

    @GET
    @Path("/cursos/{colegio}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public List<Curso> cursosDeColegio(@PathParam("colegio") Integer colegio) {
        Query q = em.createNamedQuery("Colegio.findById", Colegio.class);
        q.setParameter("id", colegio);
        Colegio c = (Colegio) q.getSingleResult();
        
        List<Profesor> profesores = c.getProfesorList();
        
        List<Curso> cursos = new ArrayList<>();
        for (Profesor p : profesores) {
            List<Curso> curPro=p.getCursoList();
            
            for (Curso curso : curPro) {
                cursos.add(curso);
            }
        }
        
        return cursos;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
