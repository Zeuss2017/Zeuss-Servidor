/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Ciudad;
import entity.Colegio;
import entity.Ejercicio;
import entity.Estudiante;
import entity.Profesor;
import java.util.List;
import javax.ejb.EJB;
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
@Path("estudiante")
public class EstudianteFacadeREST extends AbstractFacade<Estudiante> {

    @PersistenceContext(unitName = "prueba")
    private EntityManager em;

    @EJB
    private CursoFacadeREST cursoFacadeREST;
    
    public EstudianteFacadeREST() {
        super(Estudiante.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Estudiante entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Estudiante entity) {
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
    public Estudiante find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Estudiante> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Estudiante> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @GET
    @Path("findByCurso/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Estudiante> findByCurso(@PathParam("id") Integer id) {
        
        Query q=em.createNamedQuery("Estudiante.findByCurso",Estudiante.class);
        q.setParameter("id",id);
        return q.getResultList();
    }
    
    @GET
    @Path("ejercicios/{id}")
    @Produces( MediaType.APPLICATION_JSON)
    public List<Ejercicio> enviarEjercicios(@PathParam("id") Integer id) {
        Query q=em.createNamedQuery("Estudiante.findById",Estudiante.class);
        q.setParameter("id",id);
        Profesor p=((Estudiante)q.getSingleResult()).getCursoId().getProfesorUsername();
        Query q2=em.createNamedQuery("Ejercicio.findByUsername",Ejercicio.class);
        q2.setParameter("username", p.getUsername());
        return q2.getResultList();
    }
    @GET
    @Path("crear/{nombre}/{username}/{fecha}/{curso}")
    @Produces (MediaType.APPLICATION_JSON)
    public String crear(@PathParam("nombre") String nombre,@PathParam("username") String username,@PathParam("fecha") String fecha,@PathParam("curso") Integer curso) {
        Estudiante e=new Estudiante();
        e.setFechanacimiento(fecha);
        e.setNombre(nombre);
        e.setUsername(username);
        e.setCursoId(cursoFacadeREST.find(curso));
        create(e);
        em.flush();
        return String.valueOf(e.getId());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
