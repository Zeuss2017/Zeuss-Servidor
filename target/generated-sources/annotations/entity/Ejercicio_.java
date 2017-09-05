package entity;

import entity.Actividad;
import entity.Profesor;
import entity.Respuesta;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-09-04T18:55:24")
@StaticMetamodel(Ejercicio.class)
public class Ejercicio_ { 

    public static volatile SingularAttribute<Ejercicio, String> enunciado1;
    public static volatile SingularAttribute<Ejercicio, String> escenario;
    public static volatile SingularAttribute<Ejercicio, String> enunciado3;
    public static volatile SingularAttribute<Ejercicio, String> enunciado2;
    public static volatile ListAttribute<Ejercicio, Respuesta> respuestaList;
    public static volatile SingularAttribute<Ejercicio, Integer> id;
    public static volatile SingularAttribute<Ejercicio, Integer> nivel;
    public static volatile SingularAttribute<Ejercicio, Profesor> profesorUsername;
    public static volatile SingularAttribute<Ejercicio, Actividad> actividadId;

}