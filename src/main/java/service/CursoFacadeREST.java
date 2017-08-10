/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Curso;
import entity.Profesor;
import java.util.List;
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
@Path("curso")
public class CursoFacadeREST extends AbstractFacade<Curso> {

    @PersistenceContext(unitName = "prueba")
    private EntityManager em;

    public CursoFacadeREST() {
        super(Curso.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Curso entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Curso entity) {
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
    public Curso find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Curso> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Curso> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }
    @GET
    @Path("findByUsername/{username}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Curso> findByUsername(@PathParam("username") String username) {
        
        Query q=em.createNamedQuery("Curso.findByUsername",Curso.class);
        q.setParameter("username",username);
        return q.getResultList();
    }
    
    @POST
    @Path("create")
    @Consumes({MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON})
    @Transactional
    @Produces({MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON})
    public Integer create2(Curso entity) {
       
        super.create(entity);
        em.flush();
        System.out.println("Devuelve el id del curso " + entity.getId());
        return entity.getId();
    }
    
    @GET
    @Path("asociarProCurso/{cursoId}/{username}")
    @Transactional
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void asociarProCurso( @PathParam("cursoId") Integer cursoId, @PathParam("username") String username) {
        Query q = em.createQuery("SELECT p FROM Profesor p WHERE p.username = :username");
        Profesor user = (Profesor) q.setParameter("username", username).getSingleResult();
        Curso c=find(cursoId);
        em.persist(c);
        c.setProfesorUsername(user);
        List<Curso> cursos=user.getCursoList();
        cursos.add(c);
        user.setCursoList(cursos);
        em.persist(user);
        
    }
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
