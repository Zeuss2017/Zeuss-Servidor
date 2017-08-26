package entity;

import entity.Actividad;
import entity.EjercicioEstudiante;
import entity.Estudiante;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-25T22:58:26")
@StaticMetamodel(ActividadEstudiante.class)
public class ActividadEstudiante_ { 

    public static volatile SingularAttribute<ActividadEstudiante, Integer> nivelMaximo;
    public static volatile SingularAttribute<ActividadEstudiante, Estudiante> estudianteId;
    public static volatile SingularAttribute<ActividadEstudiante, Integer> tiempo;
    public static volatile SingularAttribute<ActividadEstudiante, Integer> aciertos;
    public static volatile ListAttribute<ActividadEstudiante, EjercicioEstudiante> ejercicioEstudianteList;
    public static volatile SingularAttribute<ActividadEstudiante, Integer> id;
    public static volatile SingularAttribute<ActividadEstudiante, Integer> completado;
    public static volatile SingularAttribute<ActividadEstudiante, Integer> errores;
    public static volatile SingularAttribute<ActividadEstudiante, Actividad> actividadId;

}