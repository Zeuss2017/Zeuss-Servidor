package entity;

import entity.ActividadEstudiante;
import entity.Ejercicio;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-09-08T22:12:10")
@StaticMetamodel(Actividad.class)
public class Actividad_ { 

    public static volatile SingularAttribute<Actividad, String> descripcion;
    public static volatile SingularAttribute<Actividad, String> objetivo;
    public static volatile ListAttribute<Actividad, ActividadEstudiante> actividadEstudianteList;
    public static volatile ListAttribute<Actividad, Ejercicio> ejercicioList;
    public static volatile SingularAttribute<Actividad, Integer> id;
    public static volatile SingularAttribute<Actividad, String> nombre;

}