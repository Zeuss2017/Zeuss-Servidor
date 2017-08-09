/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.Set;
import javax.ws.rs.core.Application;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

/**
 *
 * @author Maria Jose Mendoza
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        
        resources.add(RolesAllowedDynamicFeature.class);
        
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(security.AuthFilter.class);     
        resources.add(security.CorsFilter.class);
        resources.add(service.ActividadEstudianteFacadeREST.class);
        resources.add(service.ActividadFacadeREST.class);
        resources.add(service.AuthService.class);
        resources.add(service.ColegioFacadeREST.class);
        resources.add(service.CursoFacadeREST.class);
        resources.add(service.EjercicioEstudianteFacadeREST.class);
        resources.add(service.EjercicioFacadeREST.class);
        resources.add(service.EstudianteFacadeREST.class);
        resources.add(service.ProfesorFacadeREST.class);
        resources.add(service.RespuestaFacadeREST.class);
    }
}
