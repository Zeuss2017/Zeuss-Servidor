/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Colegio;
import entity.Profesor;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Maria Jose Mendoza Rincon
 */
@Stateless
@Path("profesor")
public class ProfesorFacadeREST extends AbstractFacade<Profesor> {

    @PersistenceContext(unitName = "prueba")
    private EntityManager em;
    
    @EJB
    private ColegioFacadeREST colegioFacadeRest;
    
    public ProfesorFacadeREST() {
        super(Profesor.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Profesor entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") String id, Profesor entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Profesor find(@PathParam("id") String id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Profesor> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Profesor> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }
  @GET
    @Path("/find-by-name/{userName}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Profesor findByUsername(@PathParam("userName") String userName) {
        // TAREA: Entender qué hace este código
        TypedQuery<Profesor> query = em.createNamedQuery("Profesor.findByUsername", Profesor.class);
        query.setParameter("username", userName);
        List<Profesor> results = query.getResultList();
        if (results.size() == 1) {
            return results.get(0);
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }
    
    @GET
    @Path("/asociarColPro/{idColegio}/{userName}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void asociarColPro(@PathParam("idColegio") Integer idColegio,@PathParam("userName") String userName) throws InterruptedException {
        Colegio c=colegioFacadeRest.find(idColegio);
        Profesor p=find(userName);
        p.setColegioId(c);
    }
    
    @GET
    @Path("/veriUsername/{userName}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String veriUsername( @PathParam("userName") String userName)  {
     
        Profesor p=find(userName);
        int valor=0;
        try{
            p.getUsername();
        }catch (Exception e){
            valor = 1;
        }
    
        return String.valueOf(valor);

    }
    @GET
    @Path("/colegio/{userName}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Colegio Colegio( @PathParam("userName") String userName)  {
          return findByUsername(userName).getColegioId();
    }
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
