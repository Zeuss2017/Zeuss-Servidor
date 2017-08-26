/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.ActividadEstudiante;
import entity.EjercicioEstudiante;
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
@Path("ejercicioestudiante")
public class EjercicioEstudianteFacadeREST extends AbstractFacade<EjercicioEstudiante> {

    @PersistenceContext(unitName = "prueba")
    private EntityManager em;

    public EjercicioEstudianteFacadeREST() {
        super(EjercicioEstudiante.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(EjercicioEstudiante entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, EjercicioEstudiante entity) {
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
    public EjercicioEstudiante find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<EjercicioEstudiante> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<EjercicioEstudiante> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @GET
    @Path("subirEj/{idActividad}/{idEstudiante}/{aciertos}/{errores}/{tiempo}/{consecutivo}/{nivel}")
    @Consumes({MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON})
    @Transactional
    @Produces({MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON})
    public Integer subirEj(@PathParam("idActividad") Integer idActividad, @PathParam("idEstudiante") Integer idEstudiante,
            @PathParam("aciertos") Integer aciertos, @PathParam("errores") Integer errores, @PathParam("consecutivo") Integer consecutivo,
            @PathParam("tiempo") Integer tiempo, @PathParam("nivel") Integer nivel) {
        //Crear la entidad
        EjercicioEstudiante entity = new EjercicioEstudiante();
        entity.setAciertos(aciertos);
        entity.setErrores(errores);
        entity.setTiempo(tiempo);
        entity.setConsecutivo(consecutivo);
        entity.setNivel(nivel);
        //Buscar la actividad estudiante
        Query q = em.createNamedQuery("ActividadEstudiante.findByActEst", ActividadEstudiante.class);
        q.setParameter("idActividad", idActividad);
        q.setParameter("idEstudiante", idEstudiante);
        entity.setActividadEstudianteid((ActividadEstudiante)q.getSingleResult());
        super.create(entity);
        em.flush();

        return entity.getId();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
