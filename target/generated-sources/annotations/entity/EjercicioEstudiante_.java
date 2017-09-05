package entity;

import entity.ActividadEstudiante;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-09-04T18:55:24")
@StaticMetamodel(EjercicioEstudiante.class)
public class EjercicioEstudiante_ { 

    public static volatile SingularAttribute<EjercicioEstudiante, Integer> consecutivo;
    public static volatile SingularAttribute<EjercicioEstudiante, Integer> tiempo;
    public static volatile SingularAttribute<EjercicioEstudiante, ActividadEstudiante> actividadEstudianteid;
    public static volatile SingularAttribute<EjercicioEstudiante, Integer> aciertos;
    public static volatile SingularAttribute<EjercicioEstudiante, Integer> id;
    public static volatile SingularAttribute<EjercicioEstudiante, Integer> nivel;
    public static volatile SingularAttribute<EjercicioEstudiante, Integer> errores;

}