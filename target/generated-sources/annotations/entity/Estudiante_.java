package entity;

import entity.ActividadEstudiante;
import entity.Curso;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-25T22:58:26")
@StaticMetamodel(Estudiante.class)
public class Estudiante_ { 

    public static volatile SingularAttribute<Estudiante, String> fechanacimiento;
    public static volatile ListAttribute<Estudiante, ActividadEstudiante> actividadEstudianteList;
    public static volatile SingularAttribute<Estudiante, Integer> id;
    public static volatile SingularAttribute<Estudiante, Curso> cursoId;
    public static volatile SingularAttribute<Estudiante, String> nombre;
    public static volatile SingularAttribute<Estudiante, String> username;

}