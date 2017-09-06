/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.ActividadEstudiante;
import entity.Curso;
import entity.PromediosCurso;
import java.util.ArrayList;
import java.util.List;
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
import javax.ejb.EJB;
import javax.persistence.Query;

/**
 *
 * @author Maria Jose Mendoza Rincon
 */
@Stateless
@Path("actividadestudiante")
public class ActividadEstudianteFacadeREST extends AbstractFacade<ActividadEstudiante> {

    @PersistenceContext(unitName = "prueba")
    private EntityManager em;
    @EJB 
    private ActividadFacadeREST actividadFacadeREST;
    @EJB
    private EstudianteFacadeREST estudianteFacadeREST;
    public ActividadEstudianteFacadeREST() {
        super(ActividadEstudiante.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(ActividadEstudiante entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, ActividadEstudiante entity) {
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
    public ActividadEstudiante find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<ActividadEstudiante> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<ActividadEstudiante> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }
    
    @GET
    @Path("subirAct/{idActividad}/{idEstudiante}/{aciertos}/{errores}/{tiempo}/{completado}/{nivelmaximo}")
    @Consumes({MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON})
    @Transactional
    @Produces({MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON})
    public Integer subirAct(@PathParam("idActividad") Integer idActividad,@PathParam("idEstudiante") Integer idEstudiante
    ,@PathParam("aciertos") Integer aciertos,@PathParam("errores") Integer errores,@PathParam("completado") Integer completado,
    @PathParam("tiempo") Integer tiempo,@PathParam("nivelmaximo") Integer nivelmaximo) {
        ActividadEstudiante entity=new ActividadEstudiante();
        entity.setAciertos(aciertos);
        entity.setErrores(errores);
        entity.setTiempo(tiempo);
        entity.setCompletado(completado);
        entity.setNivelMaximo(nivelmaximo);
        
        Query q=em.createNamedQuery("ActividadEstudiante.findByActEst",ActividadEstudiante.class);
        q.setParameter("idActividad", idActividad);
        q.setParameter("idEstudiante", idEstudiante);
        if(q.getResultList().isEmpty()){
            entity.setEstudianteId(estudianteFacadeREST.find(idEstudiante));
            super.create(entity);
            em.flush();
            entity.setActividadId(actividadFacadeREST.find(idActividad));
            
        }
        else{
            ActividadEstudiante a=(ActividadEstudiante) q.getSingleResult();
            
            entity.setId(a.getId());
            entity.setActividadId(actividadFacadeREST.find(idActividad));
            entity.setEstudianteId(estudianteFacadeREST.find(idEstudiante));
            super.edit(entity);
        }
        return entity.getId();
    }
    @GET
    @Path("pedirAct/{idEstudiante}/{idActividad}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public ActividadEstudiante pedirAct(@PathParam("idEstudiante") Integer idEstudiante,@PathParam("idActividad") Integer idActividad) {
        Query q=em.createNamedQuery("ActividadEstudiante.findByActEst",ActividadEstudiante.class);
        q.setParameter("idActividad", idActividad);
        q.setParameter("idEstudiante", idEstudiante);
        return (ActividadEstudiante)q.getSingleResult();
    }
    
    @GET
    @Path("promediosCurso/{idEstudiante}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public PromediosCurso promediosCurso(@PathParam("idEstudiante") Integer idEstudiante) {
        Curso c= estudianteFacadeREST.find(idEstudiante).getCursoId();
        Query q=em.createNamedQuery("ActividadEstudiante.findByCurso",ActividadEstudiante.class);
        q.setParameter("idCurso", c.getId());
        List<ActividadEstudiante> ae=q.getResultList();
        float[] errores = new float[3];
        float[] tiempo = new float[3];
        int[] cant = new int[3];
        
        for (ActividadEstudiante a : ae) {
            if(a.getActividadId().getId()==1){
                errores[0]=errores[0]+a.getErrores();
                tiempo[0]=tiempo[0]+a.getTiempo();
                cant[0]++;
            }
            if(a.getActividadId().getId()==2){
                errores[1]=errores[1]+a.getErrores();
                tiempo[1]=tiempo[1]+a.getTiempo();
                cant[1]++;
            }
            if(a.getActividadId().getId()==3){
                errores[2]=errores[2]+a.getErrores();
                tiempo[2]=tiempo[2]+a.getTiempo();
                cant[2]++;
            }
        }
        PromediosCurso pc=new PromediosCurso();
        
        pc.setErrores1(errores[0]/cant[0]);
        pc.setErrores2(errores[1]/cant[1]);
        pc.setErrores3(errores[2]/cant[2]);
        
        pc.setTiempo1(tiempo[0]/cant[0]);
        pc.setTiempo2(tiempo[1]/cant[1]);
        pc.setTiempo3(tiempo[2]/cant[2]);

        return pc; 
    }
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
